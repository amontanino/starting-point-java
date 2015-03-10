angular.module('coursesManagementApp', [])
    .controller('coursesManagementController', ['$scope', '$rootScope', '$http', '$window', function ($scope, $rootScope, $http, $window) {

        $scope.course = {
            id: '',
            title: '',
            description: '',
            teacher: '',
            price: '',
            startDate: '',
            length: ''
        }

        $scope.addCourse = function ()
        {
            alert('Hai aggiunto il corso ' + $scope.course.title);
        }
		
    }]);
