angular.module('listAttendantsApp', [])
    .controller('listAttendantsController', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {

$http.get('/api/attendants').success(function(data){
       $scope.listOfAttendants = data;
       }).error(function (data, status) { alert(data); });

    }]);

