'use strict';

gestionApp.controller("addStudentController", function($scope,$http) {
	
	console.log("******* inscriptionController CALLEd **********");
	$scope.student={};
	$scope.errors=null;
	$scope.mode={value:"form"};
	$scope.exception={message:null};
	
	$scope.saveStudent = function(){
		$http.post("studentsResource/students",$scope.student)
		.success(function(data) {
			if(!data.hasErrors){
				$scope.student = data;
				$scope.errors = null;
				$scope.mode.value="confirm";
			}else{
				$scope.errors = data;
			}
			
		})
		.error(function(data) {
			$scope.exception.message = data.message;
		});
	};
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

