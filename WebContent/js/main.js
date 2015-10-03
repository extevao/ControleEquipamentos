angular.module('moduloPrincipal', ['ngRoute'])
.config(function($routeProvider) {

	$routeProvider.when('/funcionario', {
		templateUrl: 'partials/funcionario/principal-funcionario.html',
		controller: 'funcionariosController'
	});	
	$routeProvider.when('/funcionario/new', {
		templateUrl: 'partials/funcionario/formulario-funcionario.html',
		controller: 'funcionarioController'
	});	
	$routeProvider.when('/usuario/edit/:funcionarioId', {
		templateUrl: 'partials/funcionario/formulario-funcionario.html',
		controller: 'funcionarioController'
	});	
	
	$routeProvider.otherwise({ redirectTo: '/index'});

});