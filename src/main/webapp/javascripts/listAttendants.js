angular.module('listAttendantsApp', [])
    .controller('listAttendantsController', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
	var req = {
	method : 'GET',
	url : '/api/attendants',
	headers : { 'Content-Type' : 'application/json'}
	}
        $http(req)
               .success(function (data) {
                   $scope.listOfAttendants = data;
               })
               .error(function () { alert('Errore'); });

    }]);

