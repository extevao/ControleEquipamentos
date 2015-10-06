angular.module('moduloPrincipal').controller('CategoriaController', function($scope, $http, $routeParams) {

        $scope.categoria = {};
        $scope.mensagem = '';
        
        

        if($routeParams.categoriaId) {
            $http.get('api/v1/categoria/' + $routeParams.categoriaId)
            .success(function(data) {
                $scope.categoria = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter a categoria';
            });
        }
    
        $scope.submeter = function(){
            if($scope.formulario.$valid){
                if($scope.categoria.id){
                   $http.put('api/v1/categoria', $scope.categoria)
                   .success(function(){
                        $scope.mensagem = "Dados alterados com Sucesso !!!";
                   }).error(function(erro){
                	   console.log(erro);
                        $scope.mensagem = "Não foi possível alterar os dados !!!";
                   });
                }else{
                    $http.post('api/v1/categoria', $scope.categoria).success(function(){
                        $scope.mensagem ="Categoria cadastrada com sucesso !!!";
                     }).error(function(erro){
                         $scope.mensagem = "Erro ao tentar gravar a categoria";
                    });
                }
            }
        	
        };
        

});