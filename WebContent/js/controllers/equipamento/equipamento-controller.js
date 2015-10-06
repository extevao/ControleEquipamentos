angular.module('moduloPrincipal').controller('EquipamentoController', function($scope, $http, $routeParams) {

        $scope.equipamento = {};
        $scope.mensagem = '';
        
        

        if($routeParams.equipamentoId) {
            $http.get('api/v1/equipamento/' + $routeParams.equipamentoId)
            .success(function(data) {
                $scope.equipamento = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter o equipamento.';
            });
        }
    
        $scope.submeterx = function(){
            if($scope.formulario.$valid){
                if($scope.equipamento.id){
                   $http.put('api/v1/equipamento', $scope.equipamento)
                   .success(function(){
                        $scope.mensagem = "Dados alterados com Sucesso !!!";
                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/equipamento', $scope.equipamento).success(function(){
                        $scope.mensagem ="Equipamento cadastrada com sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar o equipamento";
                    });
                }
            }
        	
        };
        

});