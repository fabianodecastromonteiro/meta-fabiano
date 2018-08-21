<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="icon" href="img/favicon.ico"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<link rel="stylesheet" href="css/app.css">
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body ng-app="myApp" ng-cloak>
		<div ng-controller="pageController">
			<header>
				<ul>
					<li class="active"><a href="#/home">Home</a></li>
					<li><a href="#/fichas">Lista de fichas</a></li>
					<li><a href="#/fichas">Lista de Animais</a></li>
				</ul>
			</header>
			<div class="conteudo" ng-view></div>
	    </div>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
		<script src="http://code.angularjs.org/1.4.8/angular-route.js"></script>
    	<script src="http://code.angularjs.org/1.4.8/angular-resource.js"></script>
    	<script src="js/angular-locale_pt-br.js"></script>
		<script src="js/app.js"></script>
	</body>
</html>