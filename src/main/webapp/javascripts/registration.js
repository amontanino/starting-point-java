angular.module('registrationApp', [])
    .controller('registrationController', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {

        
        var id = getURLParameter('id');
        
        var title = getURLParameter('title');
        $scope.courseName = title;

        $scope.registration = {
            first_name: '',
            last_name: '',
            email: '',
            course_id: id
        };

        function getURLParameter(name) {
            return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [, ""])[1].replace(/\+/g, '%20')) || null
        }

        $scope.register = function ()
        {
            $http.post('/api/attendants', $scope.registration)
                .success(function () { alert('Richiesta iscrizione inviata'); })
                .error(function () { alert('Richiesta iscrizione errata'); });
        }

    }]);

