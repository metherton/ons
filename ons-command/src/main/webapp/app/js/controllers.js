'use strict';

/* Controllers */

var onsControllers = angular.module('onsControllers', []);

onsControllers.controller('PersonListCtrl', ['$scope', '$http',
	function($scope, $http) {
		$http.get('/ons-command/rest/persons').success(function(data) {
		$scope.persons = data;	
        });
}])

onsControllers.controller('PersonDetailCtrl', ['$scope', '$routeParams', '$http',
  function($scope, $routeParams, $http) {
    $http.get('/ons-command/rest/persons/' + $routeParams.personId).success(function(data) {
      $scope.person = data;
    });

}]);

