angular.module('controleEquipamentos').controller('usuarioController', function($scope, $http) {

        $scope.usuario = {};
        $scope.mensagem = '';
        $scope.submeter = function() {
	    	if ($scope.formulario.$valid) {
	            $http.post('api/v1/usuario', $scope.usuario).success(function() {
	            	$scope.usuario = {};
	            	$scope.mensagem ='Usuário adicionado com sucesso';
	            }).error(function(erro) {
	            	$scope.mensagem ='Não foi possível cadastrar o novo usuário';
	            })
	    	}
	    };
	    
});