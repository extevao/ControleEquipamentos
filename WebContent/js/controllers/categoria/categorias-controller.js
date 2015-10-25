angular.module('moduloPrincipal').controller('CategoriasController', function($scope, $http){

    $scope.categorias = [];
    $scope.filtro = '';
    $scope.categoria = {};
    $scope.mensagem = '';

    $http.get('api/v1/categoria').success(function(data){
        $scope.categorias = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $scope.editar = function(categoria){
    	 $scope.categoria = categoria;
    	 
	};	
	
	$scope.submeter = function (categoria){
		 if($scope.formulario.$valid){
		     if($scope.categoria.id){
		        $http.put('api/v1/categoria', $scope.categoria)
		        .success(function(){
		        	delete $scope.categoria;
		        	$scope.mensagem = "Categoria alterada com sucesso !!";
		        	
		        }).error(function(erro){
		     	   console.log(erro);
		             $scope.mensagem = "Não foi possível alterar os dados da Categoria !";
		        });
		     }else{
		         $http.post('api/v1/categoria', $scope.categoria).success(function(){
		             $scope.mensagem ="Categoria cadastrada com sucesso !!!";
		             $scope.categorias.push(categoria);
		             delete $scope.categoria;
		          }).error(function(erro){
		              $scope.mensagem = "Erro ao tentar cadastrar a nova categoria";
		         });
		     }
		 }
	};
});