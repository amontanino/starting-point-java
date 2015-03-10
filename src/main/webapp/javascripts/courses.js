angular.module('coursesApp', [])
    .controller('coursesController', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {

        function elaborateResult(result) {
            $scope.listOfCourses = result;
        }

       $http.get('/helloworld').success(function(data){
       elaborateResult(data);
       })

    }]);
