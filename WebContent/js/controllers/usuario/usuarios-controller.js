angular.module('moduloPrincipal').controller('UsuariosController', function($scope, $http){

    $scope.usuarios = [];
    $scope.filtro = '';

    $http.get('api/v1/usuario').success(function(data){
        $scope.usuarios = data;
    }).error(function(erro){
        console.log(erro);
    });

});