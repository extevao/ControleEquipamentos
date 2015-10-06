angular.module('moduloPrincipal').controller('UsuarioController', function($scope, $http, $routeParams) {

        $scope.usuario = {};
        $scope.mensagem = '';
       
        if($routeParams.usuarioId) {
            $http.get('api/v1/usuario/' + $routeParams.usuarioId)
            .success(function(data) {
              $scope.usuario = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter o usuário'
            });
        }
        
      
        
        $scope.submeter = function() {

            if ($scope.formulario.$valid) {

                if($routeParams.usuarioId) {

                    $http.put('api/v1/usuario', $scope.usuario)
                    .success(function() {
                        $scope.mensagem = 'Usuário alterado com sucesso.';

                    })
                    .error(function(erro) {
                        console.log(erro);
                        $scope.mensagem = 'Não foi possível alterar os dados do usuário.';
                    });

                } else {                
                    $http.post('api/v1/usuario', $scope.usuario)
                    .success(function() {
       
                        $scope.mensagem = 'Novo usuário cadastrado no sistema com sucesso';
                    })
                    .error(function(erro) {
                        console.log(erro);
                        $scope.mensagem = 'Não foi possível cadastrar o usuário';
                    });
                }
            }
        };

});