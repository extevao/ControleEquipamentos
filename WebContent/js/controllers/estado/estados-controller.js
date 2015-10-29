angular.module('moduloPrincipal').controller('EstadosController', function($scope, $http){

    $scope.estados = [];
    $scope.mensagem = '';
    $scope.estado = null;
    
    $http.get('api/v1/estado').success(function(data){
        $scope.estados = data;
    }).error(function(erro){
        console.log(erro);
    });
    
	
	$scope.editar = function(estado){
		$scope.estado = estado;
	};		
	$scope.salvar = function(){
		$scope.estados.push($scope.estado);
		$scope.estado = null;
	};
	  $scope.limpar = function(){
	    	delete $scope.estado;    	 
	};
	
    $scope.submeter = function(){
        if($scope.formulario.$valid){
            if($scope.estado.id){
               $http.put('api/v1/estado', $scope.estado)
               .success(function(){
            		delete $scope.estado;
                    $scope.mensagem = "Dados alterados com Sucesso !!!";
               }).error(function(erro){
            	   console.log(erro);
                    $scope.mensagem = "Não foi possível alterar os dados !!!";
               });
            }else{
                $http.post('api/v1/estado', $scope.estado).success(function(){
                    $scope.estados.push(angular.copy($scope.estado));
                    delete $scope.estado;
                    $scope.mensagem ="Estado cadastrado com sucesso !!!";
                 }).error(function(erro){
                     $scope.mensagem = "Erro ao tentar gravar o estado do equipamento";
                });
            }
        }
    };
    
});