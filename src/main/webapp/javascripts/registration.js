angular.module('registrationApp', [])
    .controller('registrationController', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {

        
        var id = getURLParameter('id');
        
        var title = getURLParameter('title');
        $scope.courseName = title;

        $scope.registration = {
            name: '',
            surname: '',
            email: '',
            idCorso: id
        };

        function getURLParameter(name) {
            return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [, ""])[1].replace(/\+/g, '%20')) || null
        }

        $scope.register = function ()
        {
            //$http.post('', $scope.registration)
            //    .success(function () { })
            //    .error(function () { });
        }

    }]);

