angular.module('moduloPrincipal').controller('EstadoController', function($scope, $http, $routeParams) {

        $scope.estado = {};
        $scope.mensagem = '';
        
        

        if($routeParams.estadoId) {
            $http.get('api/v1/estado/' + $routeParams.estadoId)
            .success(function(data) {
                $scope.estado = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter a estado';
            });
        }
    
        $scope.submeter = function(){
            if($scope.formulario.$valid){
                if($scope.estado.id){
                   $http.put('api/v1/estado', $scope.estado)
                   .success(function(){
                        $scope.mensagem = "Dados do estado alterados com Sucesso !!!";
                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/estado', $scope.estado).success(function(){
                        $scope.mensagem ="Situação cadastrada com sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar o estado do equipamento";
                    });
                }
            }
        	
        };
        

});