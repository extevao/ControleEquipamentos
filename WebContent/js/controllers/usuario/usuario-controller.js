angular.module('controleEquipamentos').controller('UsuarioController', function($scope, $http, $routeParams) {

        $scope.usuario = {};
        $scope.mensagem = '';
        
        console.log($routeParams.usuarioId);
        if($routeParams.usuarioId) {
            $http.get('api/v1/usuario/' + $routeParams.usuarioId)
            .success(function(usuario) {
                $scope.usuario = usuario[0];
                console.log($scope.usuario);
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter a foto';
            });
        }
        

});