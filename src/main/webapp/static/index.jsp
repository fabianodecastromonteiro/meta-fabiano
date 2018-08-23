<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="icon" href="img/favicon.ico"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<link rel="stylesheet" href="css/app.css">
		<link rel="stylesheet" href="css/style.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
		<script src="http://code.angularjs.org/1.4.8/angular-route.js"></script>
		<script src="js/app.js"></script>
		<script src="js/angular-locale_pt-br.js"></script>
		<script src="js/rw-money-mask.min.js"></script>
	</head>
	<body ng-app="myApp" ng-cloak>
		<div ng-controller="pageController">
			<header>
				<ul>
					<li class="active"><a href="#/home">Home</a></li>
					<li><a href="#/usuarios">Usuários</a></li>
					<li ng-show="$root.usuarioLogado != null"><a href="#/empresas">Lojas</a></li>
					<li ng-show="$root.usuarioLogado.admin == true"><a href="#/fluxoCaixa">Fluxo de Caixa</a></li>
					<!-- 
					<li ng-show="$root.usuarioLogado.admin == true"><a href="#/contasPagar">Contas a pagar</a></li>
					-->
					<li><a href="#/pedidos">Pedidos</a></li>
					<li ng-hide="$root.usuarioLogado != null" style="float:right"><a href="#/login">Login</a></li>
					<li ng-show="$root.usuarioLogado != null" style="float:right"><a ng-click="logout()">Logout</a></li>
				</ul>
			</header>
			<div class="conteudo" ng-view></div>
	    </div>
	</body>
</html>