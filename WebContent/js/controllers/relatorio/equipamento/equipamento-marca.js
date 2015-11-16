angular.module('moduloPrincipal').controller('EquipamentosMarcaController', function($scope, $http){

    $scope.marcas = [];
    $scope.equipamentosMarca = [];
    $scope.teste = {};

    $http.get('api/v1/marca').success(function(data){
        $scope.marcas = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $http.get('api/v1/relatorio/equipamentos/marca').success(function(data){
        $scope.equipamentosMarca = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    
    
    
    $scope.verifica = function(marca){
    	$scope.teste = $scope.equipamentosMarca.filter(function (elemento){
    		return elemento.marca == marca.id ;
		});
    	if($scope.teste.length	){
    		return true;
    	}else{
    		return false;
    	}
    };
    
    
});