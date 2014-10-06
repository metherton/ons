'use strict';

/* Controllers */

var onsControllers = angular.module('onsControllers', []);

onsControllers.controller('PersonListCtrl', ['$scope', 'Person',
	function($scope, Person) {
		$scope.persons = Person.query();
    }]);

onsControllers.controller('SurnameListCtrl', ['$scope', 'Surname',
	function($scope, Surname) {
		$scope.surnames = Surname.query();
    
		$scope.add = function(newSurname) {
			
			//var surname = new Surname();
			$scope.clickedName = newSurname;
			Surname.save({entityId: 12121, surname: newSurname});
		};
	}]);    
    
onsControllers.controller('PersonDetailsCtrl', ['$scope', '$routeParams', 'Person',
  function($scope, $routeParams, Person) {
      $scope.personDetails = Person.get({personId: $routeParams.personId});
   }]);

onsControllers.controller('SurnameDetailsCtrl', ['$scope', '$routeParams', 'Surname',
  function($scope, $routeParams, Surname) {
	$scope.surname = Surname.get({surnameId: $routeParams.surnameId});
  }]);

