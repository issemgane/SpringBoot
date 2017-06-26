gestionApp.controller("homeController", function($scope,$http) {
	
	console.log("******* homeController CALLEd **********");
	
	$scope.menu=["Iscription","Etudiants","Utilisateur","Logout"];
	$scope.selectedMenu=null;
	
	$scope.selectItem= function(item){
		$scope.selectedMenu = item;
	};

});