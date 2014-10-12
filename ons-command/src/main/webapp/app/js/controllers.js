'use strict';

/* Controllers */

var onsControllers = angular.module('onsControllers', []);

onsControllers.controller('PersonListCtrl', ['$scope', 'Person',
	function($scope, Person) {
		$scope.addPersonForm = Person.query();
	//	$scope.personDetails = $scope.addPersonForm.personDetails;
		$scope.add = function(newFirstName) {
		//	var addedSurname = new Surname({entityId: 1});
			$scope.addedPerson = new Person({firstName: newFirstName, surname: {entityId : 1}, birthDate: -299984400000});
		//	$scope.addedPerson.surname = addedSurname;
//			$scope.addedPerson.firstName = newFirstName;
//			$scope.addedPerson.surname = new Surname({surname: newSurname});
			$scope.addedPerson.$save(function (person, headers) {
				$scope.persons = Person.query();
				$scope.addedPerson.firstName = '';
				//$scope.addedPerson.surname = '';
			}); 
		};			
		
    }]);

onsControllers.controller('SurnameListCtrl', ['$scope', 'Surname',
	function($scope, Surname) {
		$scope.surnames = Surname.query();
		
		$scope.add = function(newSurname) {
			$scope.addedSurname = new Surname({surname: newSurname});
			$scope.addedSurname.$save(function (surname, headers) {
				$scope.surnames = Surname.query();
				$scope.newSurname = '';
			}); 
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

