angular.module('moduloPrincipal').controller('FuncionariosController', function($scope, $http){

    $scope.funcionarios = [];
    $scope.filtro = '';
    
    $http.get('api/v1/funcionario').success(function(bryan){
        $scope.funcionarios = bryan;
    }).error(function(erro){
        console.log(erro);
    });

});