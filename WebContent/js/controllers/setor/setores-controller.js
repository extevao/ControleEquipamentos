angular.module('moduloPrincipal').controller('SetoresController', function($scope, $http){

    $scope.setores = [];
    $scope.setor = {};
    $scope.mensagem = '';

    $http.get('api/v1/setor').success(function(data){
        $scope.setores = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $scope.editar = function(setor){
    	 $scope.setor = setor;
	};

	$scope.limpar = function(){
    	delete $scope.setor;	 
	};		
	
	$scope.submeter = function (){
		 if($scope.formulario.$valid){
		     if($scope.setor.id){
		        $http.put('api/v1/setor', $scope.setor)
		        .success(function(){
		        	delete $scope.setor;
		        	$scope.mensagem = "Setor alterado com sucesso !!";
		        	
		        }).error(function(erro){
		     	   console.log(erro);
		             $scope.mensagem = "Não foi possível alterar os dados do setor !";
		        });
		     }else{
		         $http.post('api/v1/setor', $scope.setor).success(function(){
		             $scope.mensagem ="Setor cadastrado com sucesso !!!";
		              $scope.setors.push(angular.copy($scope.setor));
		             delete $scope.setor;
		          }).error(function(erro){
		              $scope.mensagem = "Erro ao tentar cadastrar o novo setor.";
		         });
		     }
		 }
	};
});