'use strict';

/* Controllers */

var onsControllers = angular.module('onsControllers', []);

onsControllers.controller('PersonListCtrl', ['$scope', 'Person',
	function($scope, Person) {
		$scope.hideAddForm = false;
		$scope.showAddPerson = function() {
			$scope.hideAddForm = !$scope.hideAddForm;
		}
		
		$scope.addPersonForm = Person.query();
		$scope.orderProp = 'person.birthDate';	
		$scope.add = function(addedPerson) {
			alert(addedPerson.fatherId);
			alert(addedPerson.motherId);
			alert(addedPerson.gender);
			$scope.addedPerson = new Person({firstName: addedPerson.firstName, 
											 surname: {entityId : addedPerson.surname.entityId}, 
											 birthDate: addedPerson.birthDate,
											 fatherId: parseInt(addedPerson.fatherId),
											 motherId: parseInt(addedPerson.motherId),
											 gender: parseInt(addedPerson.gender)
											});
			$scope.addedPerson.$save(function (person, headers) {	
				$scope.addPersonForm = Person.query();
				$scope.addedPerson.firstName = '';
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

