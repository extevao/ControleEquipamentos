angular.module('moduloPrincipal').controller('MarcasController', function($scope, $http){

    $scope.marcas = [];
    $scope.marca = {};
    $scope.mensagem = '';

    $http.get('api/v1/marca').success(function(data){
        $scope.marcas = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $scope.editar = function(marca){
    	 $scope.marca = marca;
    	 
	};
	  $scope.limpar = function(){
    	delete $scope.marca;
    	 
	};		
	
	$scope.submeter = function (){
		 if($scope.formulario.$valid){
		     if($scope.marca.id){
		        $http.put('api/v1/marca', $scope.marca)
		        .success(function(){
		        	delete $scope.marca;
		        	$scope.mensagem = "Marca alterada com sucesso !!";
		        	
		        }).error(function(erro){
		     	   console.log(erro);
		             $scope.mensagem = "Não foi possível alterar os dados da marca !";
		        });
		     }else{
		         $http.post('api/v1/marca', $scope.marca).success(function(){
		             $scope.mensagem ="Marca cadastrada com sucesso !!!";
		              $scope.marcas.push(angular.copy($scope.marca));
		             delete $scope.marca;
		          }).error(function(erro){
		              $scope.mensagem = "Erro ao tentar cadastrar a nova marca";
		         });
		     }
		 }
	};
});