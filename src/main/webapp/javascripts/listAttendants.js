angular.module('listAttendantsApp', [])
    .controller('listAttendantsController', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {

        $http.get('/api/attendants')
               .success(function (data) {
                   $scope.listOfAttendants = data;
               })
               .error(function () { alert('Richiesta iscrizione errata'); });

    }]);

