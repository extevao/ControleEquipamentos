angular.module('moduloPrincipal').controller('RequisitoController', function($scope, $http, $routeParams) {

        $scope.requisito = {};
        $scope.mensagem = '';
        

        if($routeParams.requisitoId) {
            $http.get('api/v1/requisito/' + $routeParams.requisitoId)
            .success(function(data) {
                $scope.requisito = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter o requisito.';
            });
        }
    
        $scope.submeter = function(){
            if($scope.formulario.$valid){
                if($scope.requisito.id){
                   $http.put('api/v1/requisito', $scope.requisito)
                   .success(function(){
                        delete $scope.requisito;
                        $scope.mensagem = "Dados do requisito alterados com sucesso !!!";
                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar os dados do requisito!!!";
                   });
                }else{
                    $http.post('api/v1/requisito', $scope.requisito).success(function(){
                        delete $scope.requisito;
                        $scope.mensagem ="Novo requisito cadastrado com sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar o novo requisito";
                    });
                }
            }
        	
        };
        

});