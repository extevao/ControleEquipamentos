angular.module('controleEquipamentos', ['ngRoute'])
.config(function($routeProvider) {

	$routeProvider.when('/usuario', {
		templateUrl: 'partials/usuario/principal-usuarios.html',
		controller: 'usuariosController'
	});	
	$routeProvider.when('/usuario/new', {
		templateUrl: 'partials/usuario/formulario-usuario.html',
		controller: 'UsuarioController'
	});	
	$routeProvider.when('/usuario/edit/:usuarioId', {
		templateUrl: 'partials/usuario/formulario-usuario.html',
		controller: 'UsuarioController'
	});	
	
	$routeProvider.otherwise({ redirectTo: '/usuario'});

});