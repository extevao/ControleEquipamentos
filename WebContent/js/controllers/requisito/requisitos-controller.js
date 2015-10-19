angular.module('moduloPrincipal').controller('RequisitosController', function($scope, $http){

    $scope.requisitos = [];
    $scope.filtro = '';

    $http.get('api/v1/requisito').success(function(data){
        $scope.requisitos = data;
    }).error(function(erro){
        console.log(erro);
    });

});