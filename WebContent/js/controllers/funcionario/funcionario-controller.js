angular.module('moduloPrincipal').controller('funcionarioController', function($scope, $http, $routeParams) {

        $scope.funcionario = {};
        $scope.mensagem = '';
        
        console.log($routeParams.usuarioId);
        if($routeParams.funcionarioId) {
            $http.get('api/v1/funcionario/' + $routeParams.usuarioId)
            .success(function(data) {
                $scope.funcionario = data[0];
            })
            .error(function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter o funcionário';
            });
        }
        

});