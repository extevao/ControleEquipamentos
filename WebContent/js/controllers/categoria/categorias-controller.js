angular.module('moduloPrincipal').controller('CategoriasController', function($scope, $http){

    $scope.categorias = [];
    $scope.categoria = {};
    $scope.mensagem = '';
    $scope.eu = '';
    
    $http.get('api/v1/categoria').success(function(data){
        $scope.categorias = data;
    }).error(function(erro){
        console.log(erro);
    });
    
    $scope.editar = function(categoria){
    	 $scope.categoria = categoria;
    	 
	};
	
	$scope.limpar = function(){
    	delete $scope.categoria;
    	delete $scope.existe;
	 	delete $scope.mensagem;
    	 
	};		
	
	$scope.submeter = function (categoria){
		
		 if($scope.formulario.$valid){
		     if(categoria.id){
		        $http.put('api/v1/categoria', categoria)
		        .success(function(){
		        	delete $scope.categoria;
		        	$scope.mensagem = "Categoria alterada com sucesso !";
		        	
		        }).error(function(erro){
		     	   console.log(erro);
		             $scope.mensagem = "Não foi possível alterar os dados da Categoria !";
		        });
		     }else{
		    	 if(existeCategoria(categoria)){
			         $http.post('api/v1/categoria', categoria).success(function(){
			             $scope.mensagem ="Categoria cadastrada com sucesso !!!";
			              $scope.categorias.push(angular.copy(categoria));
			             delete $scope.categoria;
			          }).error(function(erro){
			              $scope.mensagem = "Erro ao tentar cadastrar a nova categoria";
			         });
		    	 }
		     }
		     
		 }
	};
	
	
	 function existeCategoria(categoria){
		delete $scope.mensagem; 
		delete $scope.eu;
				
		var existe = $scope.categorias.filter(function (elemento){
			   return elemento.nome == categoria.nome;
		});
		
		if(existe.length){
			$scope.eu = "Já existe a categoria "+ categoria.nome +" cadastrada.";
			return false;
		}else{
			return true;
		}
			
	};
		
});