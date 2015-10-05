angular.module('moduloPrincipal').controller('UsuarioController', function($scope, $http, $routeParams) {

        $scope.usuario = [];
        $scope.mensagem = '';
        
        $scope.submeter = function() {
        	$http.post('api/v1/usuario', $scope.usuario)
            .success(function() {
                $scope.usuario = {};
                $scope.mensagem = 'Usuário cadastrado no sistema com sucesso.';
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível cadastrar a usuário.';
           });

           
        };

});