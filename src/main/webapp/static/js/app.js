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
    .when('/empresas', {
        templateUrl: 'partials/empresas.html',
        controller: 'empresasController'
    })
    .when('/fluxoCaixa', {
        templateUrl: 'partials/fluxoCaixa.html',
        controller: 'fluxoCaixaController'
    })
    .when('/contasPagar', {
        templateUrl: 'partials/contasPagar.html',
        controller: 'contasPagarController'
    })
    .when('/contasPagarPagamento', {
        templateUrl: 'partials/contasPagarPagamento.html',
        controller: 'contasPagarController'
    })
    .when('/contasPagarBaixa', {
        templateUrl: 'partials/contasPagarBaixa.html',
        controller: 'contasPagarController'
    })
    .when('/contasPagarForm', {
        templateUrl: 'partials/contasPagarForm.html',
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

.controller('empresasController', function ($scope, $http) {
    $scope.empresas = []; 
	getEmpresaDetails();

	function getEmpresaDetails() {
		$http({
			method : "GET",
			url : 'companies'
		}).then(function successCallback(response) {
			$scope.empresas = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    
})

.controller('fluxoCaixaController', function ($scope) {

})

.controller('contasPagarController2', function ($scope) {
	$scope.contas = [];
	$scope.novaConta = {};
	
	function loadForm(conta) {
		$scope.contaForm.id = conta.id;
		$scope.contaForm.descricao = conta.descricao;
		$scope.contaForm.empresa = conta.empresa;
		$scope.contaForm.dataEmissao = conta.dataEmissao; 
		$scope.contaForm.dataVencimento = conta.dataVencimento;
		$scope.contaForm.valor = conta.valor;
		$scope.contaForm.valorPago = conta.valorPago;  
		$scope.contaForm.saldo = conta.saldo;
		$scope.contaForm.situacao = conta.situacao;			
	}

	function clearForm() {
		$scope.contaForm.id = 0;
		$scope.contaForm.descricao = "";
		$scope.contaForm.empresa = [];
		$scope.contaForm.dataEmissao = new Date();
		$scope.contaForm.dataVencimento = "";
		$scope.contaForm.valor = 0;
		$scope.contaForm.valorPago = 0;  
		$scope.contaForm.saldo = 0;
		$scope.contaForm.situacao = 'A';			
	}

	$scope.criarConta = function() {
		var conta = {
			descricao: $scope.novaConta.descricao,
			vencimento: $scope.novaConta.vencimento,
			valor: $scope.novaConta.valor
		};
		$scope.novoConta = {};
	}
})

.controller('contasPagarController', function ($scope, $location, $http) {
    $scope.empresas = []; 
    $scope.contas = []; 

	getCompaniesDetails();
    getAccountsDetails();

	function getCompaniesDetails() {
		$http({
			method : "GET",
			url : 'companies'
		}).then(function successCallback(response) {
			$scope.empresas = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    

	function getAccountsDetails() {
		$http({
			method : "GET",
			url : 'accounts'
		}).then(function successCallback(response) {
			$scope.contas = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    

	function getAccountsByCompanyDetails(companyId) {
		$http({
			method : "GET",
			url : 'accountsByCompany/' + companyId 
		}).then(function successCallback(response) {
			$scope.contas = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    

    $scope.cancelar = function() {
    	$scope.update = null;
    }

    $scope.adicionarConta = function() {
    	$scope.update = [];
    	$scope.update.dataEmissao = new Date();
    }

    $scope.editarConta = function(conta) {
    	$scope.update = angular.copy(conta);
    }

    $scope.salvarConta = function() {
    	var METHOD = (($scope.update.id) ? 'PUT' : 'POST');
    	$http({
    	    method : METHOD,
    	    url : "account",
    	    data : angular.toJson($scope.update),
    	    headers : {
    	        'Content-Type' : 'application/json'
    	    }
    	}).then(function successCallback(response) {
			$scope.contas = response.data;
		});
    	$scope.update = null;
    }

    $scope.excluirConta = function(conta) {
	    $http({
	    	 method : 'DELETE',
	    	 url : 'account',
	    	 data : angular.toJson($scope.update),
	    	 headers : {
	    		 'Content-Type' : 'application/json'
	    	 }
	    }).then(getAccountsDetails());    
    }

    $scope.pagarConta = function(conta) {
    	$location.path('/contasPagarPagamento')
    }

    $scope.baixarConta = function(conta) {
    	$location.path('/contasPagarBaixa')
    }
    
	$scope.contasPorEmpresa = function(id) {
		if (id == "") {
		    getAccountsDetails();
		} else {
			getAccountsByCompanyDetails(id);
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

.run(function ($rootScope, $location) {
    //Rotas que necessitam do login
    var rotasBloqueadasUsuariosNaoLogados = ['/chat', '/livros'];
    var rotasBloqueadasUsuariosComuns = ['/chat', '/livros'];
    $rootScope.$on('$locationChangeStart', function () { 
    	//iremos chamar essa função sempre que o endereço for alterado
        /*  podemos inserir a logica que quisermos para dar ou não permissão ao usuário.
         Neste caso, vamos usar uma lógica simples. Iremos analisar se o link que o usuário está tentando acessar (location.path())
         está no Array (rotasBloqueadasUsuariosNaoLogados) caso o usuário não esteja logado. Se o usuário estiver logado, iremos
         validar se ele possui permissão para acessar os links no Array de strings 'rotasBloqueadasUsuariosComuns'
         */
        if ($rootScope.usuarioLogado == null && rotasBloqueadasUsuariosNaoLogados.indexOf($location.path()) != -1) {
            $location.path('/acessoNegado');
        } else if ($rootScope.usuarioLogado != null && rotasBloqueadasUsuariosComuns.indexOf($location.path()) != -1 && $rootScope.usuarioLogado.admin == false) {
            $location.path('/acessoNegado')
        }
    });
});