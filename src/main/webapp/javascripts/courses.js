angular.module('coursesApp', [])
    .controller('coursesController', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {

        //$scope.callService = function ()
        //{

        //"{\"title\": \"test corso\", \"description\": \"corso che parla di JAVA\",\"teacher\": \"docente\", \"price\": \"120euro\", \"date\":\"23/11/2015\"}";
        // Call web service


        function elaborateResult(result) {
            $scope.listOfCourses = result;
        }

    //    $http.get('/helloworld').success(fucn)

        var result = [{
            title: 'test corso',
            description: 'corso che parla di JAVA',
            teacher: 'docente',
            price: '10,00 euro',
            date: '23/11/2015',
        }];

        elaborateResult(result);
        //}



    }]);
