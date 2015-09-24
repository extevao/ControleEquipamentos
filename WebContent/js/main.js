angular.module('controleEquipamentos', ['ngRoute'])
.config(function($routeProvider) {

	$routeProvider.when('/index', {
		templateUrl: 'partials/principal-usuarios.html',
		controller: 'usuariosController'
	});	
	$routeProvider.when('/usuario/new', {
		templateUrl: 'partials/cadastro-usuario.html',
		controller: 'usuarioController'
	});	
	$routeProvider.when('/usuario/editar', {
		templateUrl: 'partials/em-construcao.html'
	});	
	
	$routeProvider.otherwise({ redirectTo: '/index'});

});