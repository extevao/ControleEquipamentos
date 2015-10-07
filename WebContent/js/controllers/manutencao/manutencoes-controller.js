angular.module('moduloPrincipal').controller('ManutencoesController', function($scope, $http){

    $scope.manutencoes = [];
    $scope.filtro = '';

    $http.get('api/v1/manutencao').success(function(data){
        $scope.manutencoes = data;
    }).error(function(erro){
        console.log(erro);
    });

});