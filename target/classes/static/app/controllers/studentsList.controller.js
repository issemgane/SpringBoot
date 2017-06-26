'use strict';

gestionApp.controller("studentsListController", function($scope,$http,appService) {
	
	console.log("******* studentsListController CALLEd **********");
	
	$scope.pageStudents=null;
	$scope.currentPage=0;
	$scope.size=5;
	$scope.totalPages;
	$scope.idToDelete;
	
	
	$scope.getStudentsPage = function(){
		
		appService.getItem({param1: $scope.currentPage,param2: $scope.size,resource: 'studentsResource', path: 'students'}, function (result, headers) {
            $scope.pageStudents = result;
			$scope.totalPages = result.totalPages;
            
        });
		/*$http({
			  method: 'GET',
			  url: 'studentsResource/students/'+$scope.currentPage+"/"+$scope.size
			}).then(function successCallback(response) {
				
			    // this callback will be called asynchronously
			    // when the response is available
				$scope.pageStudents = response.data;
				$scope.totalPages = response.data.totalPages;
				
			  }, function errorCallback(response) {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
			  });*/
		
	};
	
	
	$scope.getStudentsPage();
	
	
	$scope.getNumber = function(num) {
	    return new Array(num);   
	}
	
	
	$scope.getOnePage = function(page){
		console.log("getOnePage CALLED");
		
		if(page>0){
			$scope.currentPage = page;
			$scope.getStudentsPage();
		}
		
	};
	
	
	$scope.getItem = function(id){
		console.log("getItem() CALLED");
		$scope.idToDelete=id;
	};
	
	$scope.deleteItem = function(page){
		console.log("deleteItem() CALLED");
		$http({
			  method: 'DELETE',
			  url: 'studentsResource/students/'+$scope.idToDelete
			  
			}).then(function successCallback(response) {
				
				$scope.currentPage = page;
				$scope.getStudentsPage();
				
			  }, function errorCallback(response) {
	
		});
		
		$('#deleteModal').modal('hide');
	};
	
	
	
});




/*$http.get('https://api.github.com/users/peterbe/gists')
.then(function(response) {
  $scope.gists = response.data;
})
.catch(function(response) {
  console.error('Gists error', response.status, response.data);
})
.finally(function() {
  console.log("finally finished gists");
});
*/
















