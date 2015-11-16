angular.module('moduloPrincipal').controller('GeralManutencaoMarcaController', function($scope, $http){

    $scope.marcas = [];
    $scope.estatisticaManutencoes = [];
    $scope.teste = {};

    $http.get('api/v1/marca').success(function(data){
        $scope.marcas = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $http.get('api/v1/manutencoes/qtd/equipamento/marca').success(function(data){
    	$scope.estatisticaManutencoes = data;	
    }).error(function(erro){
        console.log(erro);
    });
      
     
    $scope.verifica = function(marca){
    	$scope.teste = $scope.estatisticaManutencoes.filter(function (elemento){
			  return elemento.idMarca == marca.id;
		});
    	
	  	if($scope.teste.some(function(elemento){
	  		return elemento.qtdManutencao == 0
	  	})){
	  		return false;
	  	}else{
	  		return true;
	  	}
    };
    
    
});