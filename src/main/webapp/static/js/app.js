var dataSistema = new Date();

angular.module('myApp', ['ngRoute', 'ngResource'])

.config(function ($routeProvider, $locationProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'partials/home.html',
        controller: 'homeController'
    })
    .when('/fichas', {
        templateUrl: 'partials/fichas.html',
        controller: 'fichasController'
    })
    .when('/animais', {
        templateUrl: 'partials/animais.html',
        controller: 'animaisController'
    })
    .when('/contasPagar', {
        templateUrl: 'partials/contasPagar.html',
        controller: 'contasPagarController'
    })
    .when('/acessoNegado', {
        templateUrl: 'partials/acessoNegado.html',
        controller: 'acessoNegadoController'
        })
    .otherwise({ 
        redirectTo: '/home'
    });
})

.controller('pageController', function ($scope) {})

.controller('homeController', function ($scope) {})

.controller('fichasController', function ($scope, $location, $http) {
    $scope.fichas = []; 
	getFormsDetails();

	function getFormsDetails() {
		$http({
			method : "GET",
			url : 'forms'
		}).then(function successCallback(response) {
			$scope.fichas = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    

    $scope.cancelar = function() {
    	$scope.update = null;
    }

    $scope.adicionarFicha = function() {
    	$scope.update = [];
    	$scope.update.dtCadastro = new Date();
    }

    $scope.editarFicha = function(ficha) {
    	$scope.update = angular.copy(ficha);
    }

    $scope.salvarFicha = function(update) {
       	alert(update);
       	var METHOD = ((update.id) ? 'PUT' : 'POST');
    	$http({
    	    method : METHOD,
    	    url : "form",
    	    data : angular.toJson($scope.update),
    	    headers : {
    	        'Content-Type' : 'application/json'
    	    }
    	}).then(function successCallback(response) {
			$scope.fichas = response.data;
		});
    	$scope.update = null;
    }

    $scope.excluirFicha = function(ficha) {
	    $http({
	    	 method : 'DELETE',
	    	 url : 'form',
	    	 data : angular.toJson($scope.update),
	    	 headers : {
	    		 'Content-Type' : 'application/json'
	    	 }
	    }).then(getAccountsDetails());    
    }

    $scope.pesquisarFichas = function(id) {
    	if (id != null) {
			$http({
				method : "GET",
				url : 'formsById?id=' + id,
		    	headers : {
		    		'Content-Type' : 'application/json'
		    	}
			}).then(function successCallback(response) {
				$scope.fichas = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
    	}	
	}    

    $scope.pesquisarFichas2 = function(filter) {
    	if (filter != null) {
			$http({
				method : "GET",
				url : 'formsById',
		    	 data : angular.toJson(filter),
		    	 headers : {
		    		 'Content-Type' : 'application/json'
		    	 }
			}).then(function successCallback(response) {
				$scope.fichas = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
    	}	
	}    

})

.controller('animaisController', function ($scope, $location, $http) {
    $scope.animais = []; 
	getAnimalsDetails();

	function getAnimalsDetails() {
		$http({
			method : "GET",
			url : 'animalsByIdFicha?idficha=' + idFicha 
		}).then(function successCallback(response) {
			$scope.fichas = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    

    $scope.cancelar = function() {
    	$scope.update = null;
    }

    $scope.adicionarFicha = function() {
    	$scope.update = [];
    	$scope.update.dtCadastro = new Date();
    }

    $scope.editarFicha = function(ficha) {
    	$scope.update = angular.copy(ficha);
    }

    $scope.salvarFicha = function(update) {
       	alert(update);
       	var METHOD = ((update.id) ? 'PUT' : 'POST');
    	$http({
    	    method : METHOD,
    	    url : "form",
    	    data : angular.toJson($scope.update),
    	    headers : {
    	        'Content-Type' : 'application/json'
    	    }
    	}).then(function successCallback(response) {
			$scope.fichas = response.data;
		});
    	$scope.update = null;
    }

    $scope.excluirFicha = function(ficha) {
	    $http({
	    	 method : 'DELETE',
	    	 url : 'form',
	    	 data : angular.toJson($scope.update),
	    	 headers : {
	    		 'Content-Type' : 'application/json'
	    	 }
	    }).then(getAccountsDetails());    
    }

    $scope.pesquisarFichas = function(id) {
    	if (id != null) {
			$http({
				method : "GET",
				url : 'formsById?id=' + id,
		    	headers : {
		    		'Content-Type' : 'application/json'
		    	}
			}).then(function successCallback(response) {
				$scope.fichas = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
    	}	
	}    

    $scope.pesquisarFichas2 = function(filter) {
    	if (filter != null) {
			$http({
				method : "GET",
				url : 'formsById',
		    	 data : angular.toJson(filter),
		    	 headers : {
		    		 'Content-Type' : 'application/json'
		    	 }
			}).then(function successCallback(response) {
				$scope.fichas = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
    	}	
	}    

})

.controller('acessoNegadoController', function ($scope) {})

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
    var rotasBloqueadasUsuariosNaoLogados = [];
    var rotasBloqueadasUsuariosComuns = [];
    $rootScope.$on('$locationChangeStart', function () { 
        if ($rootScope.usuarioLogado == null && rotasBloqueadasUsuariosNaoLogados.indexOf($location.path()) != -1) {
            $location.path('/acessoNegado');
        } else if ($rootScope.usuarioLogado != null && rotasBloqueadasUsuariosComuns.indexOf($location.path()) != -1 && $rootScope.usuarioLogado.admin == false) {
            $location.path('/acessoNegado')
        }
    });
});