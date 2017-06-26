var gestionApp = angular.module('gestionApp', ['ui.router','ngResource']);


gestionApp.config(['$stateProvider','$urlRouterProvider',function ($stateProvider,$urlRouterProvider) {
	
	
	
	  $stateProvider.state('addStudent', { // state for showing all movies
	    url: '/addStudent',
	    templateUrl: 'app/views/addStudent.html',
	    controller: 'addStudentController'
	  }).
       state('students', { // state for showing all students
		    url: '/students',
		    templateUrl: 'app/views/students.html',
		    controller: 'studentsListController'
	 })
	 .
	 state('studentDetails', { // state for showing student details
		    url: '/students/:id',
		    templateUrl: 'app/views/studentDetails.html',
		    controller: 'studentDetailController'
	 });
	
	$urlRouterProvider.otherwise('/index');
}]);
