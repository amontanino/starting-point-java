angular.module('coursesApp', [])
    .controller('coursesController', ['$scope', '$rootScope', '$http', '$window', function ($scope, $rootScope, $http, $window) {

		var contactEmail = 'info.fittizia@gmail.com';
        function elaborateResult(result) {
            $scope.listOfCourses = result;
        }

       $http.get('/helloworld').success(function(data){
       elaborateResult(data);
       })

	   $scope.sendEmail = function(subject) {
			var link = "mailto:"+ contactEmail
					 + "?subject=" + escape(subject); 

			$window.location.href = link;
		 };
	   
    }]);
