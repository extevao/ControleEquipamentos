angular.module('moduloPrincipal').controller('SetorController', function($scope, $http, $routeParams) {

        $scope.setor = {};
        $scope.mensagem = '';
        

        if($routeParams.setorId) {
            $http.get('api/v1/setor/' + $routeParams.setorId)
            .success(function(data) {
                $scope.setor = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter o setor.';
            });
        }
    
        $scope.submeter = function(){
            if($scope.formulario.$valid){
                if($scope.setor.id){
                   $http.put('api/v1/setor', $scope.requisito)
                   .success(function(){
                        $scope.mensagem = "Dados alterados com Sucesso !!!";
                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/setor', $scope.setor).success(function(){
                        $scope.mensagem ="Novo setor cadastrado com sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar o novo setor";
                    });
                }
            }
        	
        };
        

});