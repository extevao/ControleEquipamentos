angular.module('moduloPrincipal').controller('ManutencaoController', function($scope, $http, $routeParams) {

        $scope.manutencao = {};
        $scope.equipamentos = {};
        $scope.manutencoes = {};
        $scope.mensagem = '';
        
        $http.get('api/v1/equipamento')
        .success(function(data) {
            $scope.equipamentos = data;
        })
        .error(function(erro) {
            console.log(erro);
            $scope.mensagem = 'Não foi possível obter o equipamento.';
        });
        
        
        $scope.teste = function (){
        	 $http.get('api/v1/manutencoes/equipamento/' + $scope.manutencao.idEquipamento)
             .success(function(data) {
                 $scope.manutencoes = data;
                 console.log($scope.manutencoes);
             })
             .error(function(erro) {
                 console.log(erro);
                 $scope.mensagem = 'Não foi possível obter o equipamento.';
             });
        	 existeManutencao();
        	
        };
        
        function existeManutencao(){
        	console.log("chego aqui !!!!");

        

        };
        
        if($routeParams.manutencaoId) {
            $http.get('api/v1/manutencao/' + $routeParams.manutencaoId)
            .success(function(data) {
                $scope.manutencao = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter a manutenção.';
            });
        }
    
        $scope.submeter = function(){
            if($scope.formulario.$valid){
                if($scope.manutencao.id){
                   $http.put('api/v1/manutencao', $scope.manutencao)
                   .success(function(){
                	   delete $scope.manutencao;
                       $scope.mensagem = "Dados alterados com Sucesso !!!";
                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/manutencao', $scope.manutencao).success(function(){
                        delete $scope.manutencao;
                    	$scope.mensagem ="Manutenção cadastrada com sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar a manutenção";
                    });
                }
            }
        	
        };
        

});