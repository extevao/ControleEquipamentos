angular.module('moduloPrincipal').controller('FuncionariosController', function($scope, $http){

    $scope.funcionarios = [];
    $scope.filtro = '';

    $http.get('api/v1/funcionario').success(function(data){
        $scope.funcionarios = data;
    }).error(function(erro){
        console.log(erro);
    });

});