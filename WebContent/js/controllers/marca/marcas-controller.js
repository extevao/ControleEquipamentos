angular.module('moduloPrincipal').controller('MarcasController', function($scope, $http){

    $scope.marcas = [];
    $scope.mensagem = '';

    $http.get('api/v1/marca').success(function(data){
        $scope.marcas = data;
    }).error(function(erro){
        console.log(erro);
    });
    
});