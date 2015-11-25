angular.module('moduloPrincipal').controller('SetorRequisitoController', function($scope, $http){

    $scope.setores = [];
    $scope.setorRequisito = [];
    $scope.teste = {};
    
    console.log("teste");
    $http.get('api/v1/setor').success(function(data){
        $scope.setores = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $http.get('api/v1/setor/requisito').success(function(data){
    	$scope.setorRequisito = data;	
    }).error(function(erro){
        console.log(erro);
    });
      
     
    $scope.verifica = function(setor){
    	$scope.teste = $scope.setorRequisito.filter(function (elemento){
			  return elemento.setor == setor.nome;
		});
    	if($scope.teste.length	){
    		return true;
    	}else{
    		return false;
    	}
	  	
    };
    
    
});