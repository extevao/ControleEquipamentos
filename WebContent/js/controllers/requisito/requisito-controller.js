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
                        $scope.mensagem = "Dados alterados com Sucesso !!!";
                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/requisito', $scope.requisito).success(function(){
                        $scope.mensagem ="Novo requisito cadastrado com sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar o novo requisito";
                    });
                }
            }
        	
        };
        

});