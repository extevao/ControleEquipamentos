angular.module('controleEquipamentos').controller('usuariosController', function($scope, $http){

    $scope.usuarios = [];
    $scope.filtro = '';

    $http.get('api/v1/usuario').success(function(retorno){
        $scope.usuarios = retorno;
    }).error(function(erro){
        console.log(erro);
    });

});