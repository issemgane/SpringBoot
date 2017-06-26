'use strict';

gestionApp.controller("studentDetailController", function($scope,$http,$stateParams) {
	
	console.log("******* studentDetailController CALLEd **********");
	$scope.student={};
	$scope.errors=null;
	
	
	$http.get("studentsResource/students/"+$stateParams.id)
		.success(function(data) {
		  console.log("data is : "+data)
			$scope.student = data;
			
		})
		.error(function(data) {
			
		});
	
});

/*gestionApp.controller('inscriptionController', ['$scope', function ($scope, appService) {
 console.log("******* inscriptionController with Service CALLED **********");
	 $scope.saveStudent = function()
	 {
	     eFormsService.query({resource:'studentResource',path:'students'},function(result,headers){
	    console.log("Hey Ali rawTreeData in: "+$scope.rawTreeData.length);
	   
	 });
	
	 };
}]);*/

