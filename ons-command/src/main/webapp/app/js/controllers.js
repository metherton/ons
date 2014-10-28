	'use strict';

/* Controllers */

var onsControllers = angular.module('onsControllers', ['ngAnimate']);

onsControllers.controller('PersonListCtrl', ['$scope', 'Person', '$route',
	function($scope, Person, $route) {
		$scope.hideAddForm = false;
        $scope.childCount = 0;
		$scope.showAddPerson = function() {
			$scope.hideAddForm = !$scope.hideAddForm;
		}
		
		$scope.nav = function(id) {
			window.document.location = ('#/ons-command/rest/persons/' + id);
		}

        $scope.$watch('childCount', function(newValue, oldValue) {
            console.log('childCount changed to ' + newValue);
        });

		$scope.addPersonForm = Person.query();
		$scope.orderProp = 'person.birthDate';	
		$scope.add = function() {
//			$scope.addedPerson = new Person({firstName: addedPerson.firstName,
//											 surname: {entityId : addedPerson.surname.entityId},
//											 birthDate: addedPerson.birthDate,
//											 fatherId: parseInt(addedPerson.fatherId),
//											 motherId: parseInt(addedPerson.motherId),
//											 gender: parseInt(addedPerson.gender)
//											});
//			$scope.addedPerson.$save(function (person, headers) {
//				$scope.addPersonForm = Person.query();
//				$scope.addedPerson.firstName = '';
//			});

            Person.save($scope.addedPerson).$promise.then($route.reload);
            $scope.addedPerson = {};
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

