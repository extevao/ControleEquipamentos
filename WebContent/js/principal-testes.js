angular.module('moduloPrincipalParaTestes', ['ngResource']);
	angular.module('moduloPrincipalParaTestes').controller('moduloPrincipalControle', function($scope, $http, $resource){
		$scope.lista = [];
		$scope.mensagem = '';
		$scope.usuario = {};
		
		
		var recursoUsuario = $resource('api/v1/usuario');
		
		$scope.editar = function(usuario){
			$scope.usuario = usuario;
		};
		$scope.limpar = function(){
			delete $scope.usuario;
		};
		$scope.salvar = function(usuario){
			$scope.lista.push(angular.copy(usuario));
			$scope.mensagem = "Itens salvos";
			delete $scope.usuario;
		};
		
		recursoUsuario.query(function(data){
			$scope.lista = data;
		}),function(erro){
			console.log(erro);
		};
		

});