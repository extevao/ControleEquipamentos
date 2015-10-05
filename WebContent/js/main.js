angular.module('moduloPrincipal', ['ngRoute'])
.config(function($routeProvider) {

	$routeProvider.when('/funcionario', {
		templateUrl: 'partials/funcionario/principal-funcionarios.html',
		controller: 'FuncionariosController'
	});	
	$routeProvider.when('/funcionario/new', {
		templateUrl: 'partials/funcionario/formulario-funcionario.html',
		controller: 'FuncionarioController'
	});	
	$routeProvider.when('/funcionario/edit/:funcionarioId', {
		templateUrl: 'partials/funcionario/formulario-funcionario.html',
		controller: 'FuncionarioController'
	});	
	
	$routeProvider.otherwise({ redirectTo: '/index'});

});