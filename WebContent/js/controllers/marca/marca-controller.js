angular.module('moduloPrincipal').controller('MarcaController', function($scope, $http, $routeParams) {

        $scope.marca = {};
        $scope.mensagem = '';
        
        

        if($routeParams.marcaId) {
            $http.get('api/v1/marca/' + $routeParams.marcaId)
            .success(function(data) {
                $scope.marca = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter a Marca';
            });
        }
    
        $scope.submeter = function(){
            if($scope.formulario.$valid){
                if($scope.marca.id){
                   $http.put('api/v1/marca', $scope.marca)
                   .success(function(){
                        $scope.mensagem = "Marca alterada com sucesso !!!";
                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar a marca !!!";
                   });
                }else{
                    $http.post('api/v1/marca', $scope.marca).success(function(){
                        $scope.mensagem ="Marca cadastrada com sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar a Marca do equipamento";
                    });
                }
            }
        	
        };
        

});