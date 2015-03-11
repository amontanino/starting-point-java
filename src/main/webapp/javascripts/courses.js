angular.module('coursesApp', [])
    .controller('coursesController', ['$scope', '$rootScope', '$http', '$window', function ($scope, $rootScope, $http, $window) {

		var contactEmail = 'info.fittizia@gmail.com';
        function elaborateResult(result) {
            $scope.listOfCourses = result;
        }

       $http.get('/helloworld').success(function(data){
       elaborateResult(data);
       })

       $scope.redirectToRegisterForm = function (idCorso, title) {
           $window.location = 'registration.html?id=' + idCorso + '&title=' + title;
       }
    }]);
