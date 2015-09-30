angular.module('moduloPrincipalParaTestes', ['ngResource']);
	angular.module('moduloPrincipalParaTestes').controller('moduloPrincipalControle', function($scope, $http, $resource){
		$scope.lista = null;
		$scope.mensagem = '';
		$scope.usuario = {};
		
		
		var recursoUsuario = $resource('api/v1/usuario/1');
		
		
		recursoUsuario.query(function(data){
			$scope.usuario = data[0];
			console.log($scope.usuario);
		}),function(erro){
			console.log(erro);
		};
		

});