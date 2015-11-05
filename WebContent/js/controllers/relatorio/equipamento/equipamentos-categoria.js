angular.module('moduloPrincipal').controller('EquipamentosCategoriaController', function($scope, $http){

    $scope.categorias = [];
    $scope.equipamentocategoria = [];
    $scope.teste = {};

    $http.get('api/v1/categoria').success(function(data){
        $scope.categorias = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $http.get('api/v1/relatorio/equipamento-categoria').success(function(data){
        $scope.equipamentocategoria = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    
    
    
    $scope.verificaId = function(categoria){
    	$scope.teste = $scope.equipamentocategoria.filter(function (elemento){
			  return elemento.idCategoria == categoria.id ;
		});
    	 return true;
    };
    
    
});