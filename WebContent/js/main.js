angular.module('moduloPrincipal', ['ngRoute'])
.config(function($routeProvider) {
	$routeProvider.when('/index', {
		templateUrl: 'partials/principal/principal.html',
	});
	$routeProvider.when('/categoria', {
		templateUrl: 'partials/categoria/principal-categorias.html',
		controller: 'CategoriasController'
	});	
	$routeProvider.when('/categoria/new', {
		templateUrl: 'partials/categoria/formulario-categoria.html',
		controller: 'CategoriaController'
	});	
	$routeProvider.when('/categoria/edit/:categoriaId', {
		templateUrl: 'partials/categoria/formulario-categoria.html',
		controller: 'CategoriaController'
	});	
	
	$routeProvider.when('/equipamento', {
		templateUrl: 'partials/equipamento/principal-equipamento.html',
		controller: 'EquipamentosController'
	});	
	$routeProvider.when('/equipamento/new', {
		templateUrl: 'partials/equipamento/formulario-equipamento.html',
		controller: 'EquipamentoController'
	});	
	$routeProvider.when('/equipamento/edit/:equipamentoId', {
		templateUrl: 'partials/equipamento/formulario-equipamento.html',
		controller: 'EquipamentoController'
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
	

	$routeProvider.when('/manutencao', {
		templateUrl: 'partials/manutencao/principal-manutencoes.html'
	});	
	$routeProvider.when('/manutencao/new', {
		templateUrl: 'partials/manutencao/formulario-manutencao.html'
		
	});	
	$routeProvider.when('/manutencao/edit/:manutencaoId', {
		templateUrl: 'partials/usuario/formulario-manutencao.html'
	});	
	
	
	$routeProvider.when('/setor', {
		templateUrl: 'partials/setor/principal-setores.html'
	});	
	$routeProvider.when('/setor/new', {
		templateUrl: 'partials/setor/formulario-setor.html'
		
	});	
	$routeProvider.when('/setor/edit/:setorId', {
		templateUrl: 'partials/setor/formulario-setor.html'
	});	
	
	$routeProvider.otherwise({ redirectTo: '/index'});

});