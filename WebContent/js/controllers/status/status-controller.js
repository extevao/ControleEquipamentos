angular.module('moduloPrincipal').controller('StatusController', function($scope, $http){

    $scope.listaStatus = [];
    $scope.statuss = {};
    $scope.mensagem = '';

    $http.get('api/v1/status').success(function(data){
        $scope.listaStatus = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $scope.editar = function(statuss){
    	 $scope.statuss = statuss;
    	 
	};
	  $scope.limpar = function(){
    	delete $scope.statuss;
    	 
	};		
	
	$scope.submeter = function (){
		 if($scope.formulario.$valid){
		     if($scope.statuss.id){
		        $http.put('api/v1/status', $scope.statuss)
		        .success(function(){
		        	delete $scope.statuss;
		        	$scope.mensagem = "Status alterado com sucesso !!";
		        	
		        }).error(function(erro){
		     	   console.log(erro);
		             $scope.mensagem = "Não foi possível alterar o status !";
		        });
		     }else{
		         $http.post('api/v1/status', $scope.statuss).success(function(){
		             $scope.mensagem ="Status cadastrada com sucesso !!!";
		              $scope.listaStatus.push(angular.copy($scope.statuss));
		             delete $scope.statuss;
		          }).error(function(erro){
		              $scope.mensagem = "Erro ao tentar cadastrar a nova statuss";
		         });
		     }
		 }
	};
});