angular.module('moduloPrincipal').controller('CategoriasController', function($scope, $http){

    $scope.categorias = [];
    $scope.categoria = {};
    $scope.mensagem = '';
    $scope.existe= '';
    
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
	
	$scope.existeCategoria = function (categoria){
		delete $scope.existe;
		delete $scope.mensagem;
		
		var existe = $scope.categorias.filter(function (elemento){
			   return elemento.nome == categoria.nome;
		});
		
		if(existe.length){
			$scope.existe = "Já existe uma categoria cadastrada com esse nome";
			
			return true;
		}else{
			$scope.mensagem = "Cadastrado";
			return false;
		}
		
	};
	
	$scope.submeter = function (categoria){
		
		 if($scope.formulario.$valid){
		     if($scope.categoria.id){
		        $http.put('api/v1/categoria', categoria)
		        .success(function(){
		        	delete $scope.categoria;
		        	$scope.mensagem = "Categoria alterada com sucesso !!";
		        	
		        }).error(function(erro){
		     	   console.log(erro);
		             $scope.mensagem = "Não foi possível alterar os dados da Categoria !";
		        });
		     }else{
		         $http.post('api/v1/categoria', categoria).success(function(){
		             $scope.mensagem ="Categoria cadastrada com sucesso !!!";
		              $scope.categorias.push(angular.copy(categoria));
		             delete $scope.categoria;
		          }).error(function(erro){
		              $scope.mensagem = "Erro ao tentar cadastrar a nova categoria";
		         });
		     }
		     
		 }
	};
});