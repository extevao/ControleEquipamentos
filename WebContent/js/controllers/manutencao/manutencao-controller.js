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
                   $scope.mensagem = "Dados da manutenção alterados com sucesso !!!";
               }).error(function(erro){
            	   console.log(erro);
                    $scope.mensagem = "Não foi possível alterar os dados da manutenção!!!";
               });
            }else{
                $http.post('api/v1/manutencao', manutencao).success(function(){
                    delete $scope.manutencao;
                	$scope.mensagem ="Manutenção cadastrada com sucesso !!!";
                 }).error(function(erro){
                     $scope.mensagem = "Erro ao tentar cadastrar a manutenção";
                });
            }
        }
    	
    };
    
      
    function validaData(dataI, dataF){
    	delete $scope.alerta;

    		
    		
    	if(dataFimExis(dataF)){
    	        	
    		return dataMaior(dataI, dataF);
    			
    
    	}
    	return true;
    	
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
        
   function dataInicioExis(dataI){
	   if(dataI == "" | dataI == undefined | dataI == null){
		 return false;
	   }
	   return true;
   };
   function dataFimExis(dataF){
	   if(dataF == "" | dataF == undefined | dataF == null){
		 return false;
	   }
	   return true;
   };

});