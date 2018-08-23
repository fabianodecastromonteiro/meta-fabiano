var dataSistema = new Date();

angular.module('myApp', ['ngRoute', 'rw.moneymask'])

.config(function ($routeProvider, $locationProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'partials/home.html',
        controller: 'homeController'
    })
    .when('/login', {
        templateUrl: 'partials/login.html',
        controller: 'loginController'
    })
    .when('/usuarios', {
        templateUrl: 'partials/usuarios.html',
        controller: 'usuariosController'
    })
    .when('/pedidos', {
        templateUrl: 'partials/pedidos.html',
        controller: 'pedidosController'
    })
    .when('/acessoNegado', {
        templateUrl: 'partials/acessoNegado.html',
        controller: 'acessoNegadoController'
        })
    .otherwise({ 
        redirectTo: '/home'
    });
})

.controller('pageController', function ($scope, usuariosService) {
    $scope.logout = function(){
        usuariosService.logout();
    }
})

.controller('homeController', function ($scope) {

})

.controller('loginController', function ($scope, usuariosService) {
    $scope.logar = function(usuario){
        usuariosService.validaLogin(usuario);
    }
})

.controller('usuariosController', function ($scope, $http) {
    $scope.usuarios = []; 
	getUsuarioDetails();

	function getUsuarioDetails() {
		$http({
			method : "GET",
			url : 'users'
		}).then(function successCallback(response) {
			$scope.usuarios = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    
})

.controller('pedidosController', function ($scope, $location, $http) {
    $scope.pedidos = []; 
	getOrdersDetails();

	function getOrdersDetails() {
		$http({
			method : "GET",
			url : 'orders'
		}).then(function successCallback(response) {
			$scope.pedidos = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    

    $scope.cancelar = function() {
    	$scope.update = null;
    }

    $scope.adicionarPedido = function() {
    	$scope.update = [];
    	$scope.update.dtCadastro = new Date();
    }

    $scope.editarPedido = function(pedido) {
    	$scope.update = angular.copy(pedido);
    }

    $scope.salvarPedido = function(update) {
       	alert(update);
       	var METHOD = ((update.id) ? 'PUT' : 'POST');
    	$http({
    	    method : METHOD,
    	    url : "order",
    	    data : angular.toJson($scope.update),
    	    headers : {
    	        'Content-Type' : 'application/json'
    	    }
    	}).then(function successCallback(response) {
			$scope.pedidos = response.data;
		});
    	$scope.update = null;
    }

    $scope.excluirPedido = function(pedido) {
	    $http({
	    	 method : 'DELETE',
	    	 url : 'order',
	    	 data : angular.toJson($scope.update),
	    	 headers : {
	    		 'Content-Type' : 'application/json'
	    	 }
	    }).then(getOrderDetails());    
    }

    $scope.pesquisarPedidos = function(id) {
    	if (id != null) {
			$http({
				method : "GET",
				url : 'ordersById?id=' + id,
		    	headers : {
		    		'Content-Type' : 'application/json'
		    	}
			}).then(function successCallback(response) {
				$scope.pedidos = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
    	}	
	}    

})

.controller('acessoNegadoController', function ($scope) {
    
})

.service('usuariosService', function ($rootScope, $location, $http) {
    this.validaLogin = function(usuario) {
		$http({
			method : "POST",
			url : 'login',
			data : angular.toJson(usuario)
		}).then(function successCallback(response) {
            $rootScope.usuarioLogado = response.data;
            $location.path('/home')
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
    }
    this.logout = function() {
        $rootScope.usuarioLogado = null;
        $location.path('/home')
    }
})

.directive('expand', function () {
	function link(scope, element, attrs) {
		scope.$on('onExpandAll', function (event, args) {
			scope.expanded = args.expanded;
		});
	}
    return {
    	link: link
	};
})

.run(function ($rootScope, $location) {
    var rotasBloqueadasUsuariosNaoLogados = ['/chat', '/livros'];
    var rotasBloqueadasUsuariosComuns = ['/chat', '/livros'];
    $rootScope.$on('$locationChangeStart', function () { 
        if ($rootScope.usuarioLogado == null && rotasBloqueadasUsuariosNaoLogados.indexOf($location.path()) != -1) {
            $location.path('/acessoNegado');
        } else if ($rootScope.usuarioLogado != null && rotasBloqueadasUsuariosComuns.indexOf($location.path()) != -1 && $rootScope.usuarioLogado.admin == false) {
            $location.path('/acessoNegado')
        }
    });
});