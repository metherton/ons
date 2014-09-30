'use strict';

/* Controllers */

var onsControllers = angular.module('onsControllers', []);

onsControllers.controller('PersonListCtrl', ['$scope', 'Person',
	function($scope, Person) {
		$scope.persons = Person.query();
    }])

onsControllers.controller('PersonDetailsCtrl', ['$scope', '$routeParams', 'Person',
  function($scope, $routeParams, Person) {
      $scope.personDetails = Person.get({personId: $routeParams.personId});
   }]);

