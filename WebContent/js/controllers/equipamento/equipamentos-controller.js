angular.module('moduloPrincipal').controller('EquipamentosController', function($scope, $http){

    $scope.equipamentos = [];
    $scope.filtro = '';

    $http.get('api/v1/equipamento').success(function(data){
        $scope.equipamentos = data;
    }).error(function(erro){
        console.log(erro);
    });

});