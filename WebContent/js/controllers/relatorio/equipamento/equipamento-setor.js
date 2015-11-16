angular.module('moduloPrincipal').controller('EquipamentosSetorController', function($scope, $http){

    $scope.setores = [];
    $scope.equipamentosSetor = [];
    $scope.teste = {};

    $http.get('api/v1/setor').success(function(data){
        $scope.setores = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $http.get('api/v1/relatorio/equipamentos/setor').success(function(data){
        $scope.equipamentosSetor = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    
    
    
    $scope.verifica = function(setor){
    	$scope.teste = $scope.equipamentosSetor.filter(function (elemento){
			  return elemento.idSetor == setor.id ;
		});
    	if($scope.teste.length	){
    		return true;
    	}else{
    	return false;
    	}
    };
    
    
});