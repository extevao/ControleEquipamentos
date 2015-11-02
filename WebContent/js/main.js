angular.module('moduloPrincipal', ['ngRoute'])
.config(function($routeProvider) {
	/* Categoria */
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
	/* Equipamento */
	$routeProvider.when('/equipamento', {
		templateUrl: 'partials/equipamento/principal-equipamentos.html',
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
	$routeProvider.when('/equipamento/relatorio/equipamento-categoria', {
		templateUrl: 'partials/relatorio/equipamento/relatorio-equipamentos-categoria.html',
		controller: 'EquipamentosCategoriaController'
	});
	/* Estado */
	$routeProvider.when('/estado', {
		templateUrl: 'partials/estado/principal-estados.html',
		controller: 'EstadosController'
	});	
	/* Funcionário */	
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
	/* Manutenção */
	$routeProvider.when('/manutencao', {
		templateUrl: 'partials/manutencao/principal-manutencoes.html',
		controller: 'ManutencoesController'
	});	
	$routeProvider.when('/manutencao/new', {
		templateUrl: 'partials/manutencao/formulario-manutencao.html',
		controller: 'ManutencaoController'
	});	
	$routeProvider.when('/manutencao/edit/:manutencaoId', {
		templateUrl: 'partials/manutencao/formulario-manutencao.html',
		controller: 'ManutencaoController'
	});	
	/* Marca */
	$routeProvider.when('/marca', {
		templateUrl: 'partials/marca/principal-marca.html',
		controller: 'MarcasController'
	});	
	/* Principal */
	$routeProvider.when('/index', {
		templateUrl: 'partials/principal/principal.html',
		controller: 'PrincipalController'
	});
	/* Requisito */
	$routeProvider.when('/requisito', {
		templateUrl: 'partials/requisito/principal-requisitos.html',
		controller: 'RequisitosController'
	});
	$routeProvider.when('/requisito/new', {
		templateUrl: 'partials/requisito/formulario-requisito.html',
		controller: 'RequisitoController'
	});	
	$routeProvider.when('/requisito/edit/:requisitoId', {
		templateUrl: 'partials/requisito/formulario-requisito.html',
		controller: 'RequisitoController'
	});
	/* Setor */
	$routeProvider.when('/setor', {
		templateUrl: 'partials/setor/principal-setores.html',
		controller: 'SetoresController',
	});		
	$routeProvider.when('/setor/new', {
		templateUrl: 'partials/setor/formulario-setor.html',
		controller: 'SetorController'
	});	
	$routeProvider.when('/setor/edit/:setorId', {
		templateUrl: 'partials/setor/formulario-setor.html',
		controller: 'SetorController'
	});	
	/* Status */
	$routeProvider.when('/status', {
		templateUrl: 'partials/status/principal-status.html',
		controller: 'StatusController'
	});
	/* Usuário */
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
	/* Padrão */
	$routeProvider.otherwise({ redirectTo: '/index'});

});