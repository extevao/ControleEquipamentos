angular.module('moduloPrincipal').controller('SetoresController', function($scope, $http){
	$scope.setores = [];

	$http.get('api/v1/setor').success(function(data){
		$scope.setores = data;
	}).error(function(erro){
		console.log(erro);
	});
});