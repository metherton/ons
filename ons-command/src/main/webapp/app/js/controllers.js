'use strict';

/* Controllers */

var onsControllers = angular.module('onsControllers', []);

onsControllers.controller('PersonListCtrl', ['$scope', 'Person',
	function($scope, Person) {
		$scope.persons = Person.query();
		
		$scope.add = function(newFirstName) {
			//alert('add person');
			$scope.addedPerson = new Person({firstName: newFirstName});
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
      $scope.person = Person.get({personId: $routeParams.personId});
   }]);

onsControllers.controller('SurnameDetailsCtrl', ['$scope', '$routeParams', 'Surname',
  function($scope, $routeParams, Surname) {
	$scope.surname = Surname.get({surnameId: $routeParams.surnameId});
  }]);

