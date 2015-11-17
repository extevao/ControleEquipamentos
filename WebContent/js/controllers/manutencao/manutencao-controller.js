angular.module('moduloPrincipal').controller('ManutencaoController', function($scope, $http, $routeParams) {

    $scope.manutencao = {};
    $scope.equipamentos = {};
    $scope.manutencoes = {};
    $scope.mensagem = '';
    $scope.alerta = '';
    
    $http.get('api/v1/equipamento')
    .success(function(data) {
        $scope.equipamentos = data;
    })
    .error(function(erro) {
        console.log(erro);
        $scope.mensagem = 'Não foi possível obter o equipamento.';
    });
    
    
    $scope.teste = function (){
    	 $http.get('api/v1/manutencoes/equipamento/' + $scope.manutencao.idEquipamento)
         .success(function(data) {
             $scope.manutencoes = data;
             console.log($scope.manutencoes);
         })
         .error(function(erro) {
             console.log(erro);
             $scope.mensagem = 'Não foi possível obter o equipamento.';
         });
    	    	
    };
    

    
    if($routeParams.manutencaoId) {
        $http.get('api/v1/manutencao/' + $routeParams.manutencaoId)
        .success(function(data) {
            $scope.manutencao = data[0];
        })
        .error(function(erro) {
            console.log(erro);
            $scope.mensagem = 'Não foi possível obter a manutenção.';
        });
    }

    $scope.submeter = function(manutencao){
        if($scope.formulario.$valid & validaData(manutencao.dataInicio, manutencao.dataFim)){
            if(manutencao.id){
               $http.put('api/v1/manutencao', manutencao)
               .success(function(){
            	   delete $scope.manutencao;
                   $scope.mensagem = "Dados alterados com Sucesso !!!";
               }).error(function(erro){
            	   console.log(erro);
                    $scope.mensagem = "Não foi possível alterar os dados !!!";
               });
            }else{
                $http.post('api/v1/manutencao', manutencao).success(function(){
                    delete $scope.manutencao;
                	$scope.mensagem ="Manutenção cadastrada com sucesso !!!";
                 }).error(function(erro){
                     $scope.mensagem = "Erro ao tentar gravar a manutenção";
                });
            }
        }
    	
    };
    
      
    function validaData(dataI, dataF){
    	var exp = /^((0[1-9]|[12]\d)\/(0[1-9]|1[0-2])|30\/(0[13-9]|1[0-2])|31\/(0[13578]|1[02]))\/\d{4}$/;
    	delete $scope.alerta;
    	if(exp.test(dataI) & exp.test(dataF)){
			return dataMaior(dataI, dataF);
			
    	}else{
    		 $scope.alerta ="Data inválida";
    		 return false;
    	}
	};
    
    function dataMaior(dataI, dataF){
    	var dateIArray = dataI.split("/");
    	var dateFArray = dataF.split("/");
    	if(dateFArray[0] >= dateIArray[0] & dateFArray[1] >= dateIArray[1] & dateFArray[2] >= dateIArray[2]){
       		return true;
    	}else{
    		$scope.alerta ="Data final menor que a data inicial.";
    		return false;
    	}
    };
        

});