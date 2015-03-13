angular.module('listAttendantsApp', [])
    .controller('listAttendantsController', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {

$http.get('/api/attendants').success(function(data){
	var coursesAttendants = {};
	for (var i = 0; i < data.length; i ++){
		if (coursesAttendants[data[i].course_id] === undefined) { 
			coursesAttendants[data[i].course_id] = {count: data[i].num_attendants,data: [data[i]]}; 
		} else {
			coursesAttendants[data[i].course_id].data.push(data[i]); 
			coursesAttendants[data[i].course_id].count += data[i].num_attendants;
		}
	}
	$scope.listOfAttendants = [coursesAttendants];
       }).error(function (data, status) { alert(data); });

	$http.get('/helloworld').success(function(data){
		$scope.courseList = [];
if(data.length > 0){
  		$scope.incorrectlySelected = { label: data[0].title, value: data[0].title };
		for(var i = 0;  i < data.length; i++)
			$scope.courseList.push({ label: data[i].title, value : data[i].title });
}
	});

    }]);
