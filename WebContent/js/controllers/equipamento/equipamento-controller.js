angular.module('moduloPrincipal').controller('EquipamentoController', function($scope, $http, $routeParams, $location) {

        $scope.equipamento = {};
        $scope.mensagem = '';
        $scope.manutencoes_equipamento = {};
        $scope.visualizar = false;
             

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
  
        $scope.submeter = function(){
            if($scope.formulario.$valid){
                if($scope.equipamento.id){
                   $http.put('api/v1/equipamento', $scope.equipamento)
                   .success(function(){
                		
                        $scope.mensagem = "Dados alterados com Sucesso !!!";
                        $location.path("/equipamento");

                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/equipamento', $scope.equipamento).success(function(){
                    	
                    	$scope.mensagem ="Equipamento cadastrado com sucesso !!!";
                        $location.path("/equipamento");
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar o equipamento";
                    });
                }
            }
        	
        };
        $scope.mostrar = function(){
        	 $scope.visualizar = !$scope.visualizar ;
        };
        
        $scope.listarManutencao = function(equipamento){
        	 $http.get('api/v1/manutencoes/equipamento/' + equipamento.id)
             .success(function(data) {
            	 $scope.manutencoes_equipamento = data;
             })
             .error(function(erro) {
                 console.log(erro);
                 $scope.mensagem = 'Não foi possível obter a lista de manutenções do equipamento.';
             });
        };

        

});