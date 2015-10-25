angular.module('moduloPrincipal').controller('FuncionarioController', function($scope, $http, $routeParams) {

        $scope.funcionario = {};
        $scope.mensagem = '';
        
        

        if($routeParams.funcionarioId) {
            $http.get('api/v1/funcionario/' + $routeParams.funcionarioId)
            .success(function(data) {
                $scope.funcionario = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter o funcionário';
            });
        }
    
        $scope.submeter = function(){
            if($scope.formulario.$valid){
                if($scope.funcionario.id){
                   $http.put('api/v1/funcionario', $scope.funcionario)
                   .success(function(){
                	   	delete $scope.funcionario;
                        $scope.mensagem = "Dados alterados com Sucesso !!!";
                   }).error(function(erro){
                	   console.log($scope.funcionario);
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/funcionario', $scope.funcionario).success(function(){
                    	delete $scope.funcionario;
                    	$scope.mensagem ="Sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro  post!!!";
                    });
                }
            }
        	
        };
        
        $scope.submeterxx = function(){
            if($scope.formulario.$valid){
                if($scope.funcionario.id){
                   $http.put('api/v1/funcionario', $scope.funcionario)
                   .success(function(){
                        delete $scope.funcionario;
                        $scope.mensagem = "Dados alterados com Sucesso !!!";
                   }).error(function(erro){
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/funcionario', $scope.funcionario).success(function(){
                        $scope.mensagem ="Sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro  post!!!";
                    });
                }
            }
        	
        };

});