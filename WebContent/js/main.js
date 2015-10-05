angular.module('moduloPrincipal', ['ngRoute'])
.config(function($routeProvider) {
	$routeProvider.when('/index', {
		templateUrl: 'partials/principal/principal.html',
	});
	
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
	
	$routeProvider.when('/usuario', {
		templateUrl: 'partials/usuario/principal-usuarios.html',
		controller: 'UsuariosController'
	});	
	$routeProvider.when('/usuario/new', {
		templateUrl: 'partials/usuario/formulario-usuario.html',
		controller: 'UsuarioController'
		
	});	
	$routeProvider.when('/usuario/edit/:usuarioId', {
		templateUrl: 'partials/usuario/formulario-usuario.html',
		controller: 'UsuarioController'
	});	
	
	
	$routeProvider.otherwise({ redirectTo: '/index'});

});