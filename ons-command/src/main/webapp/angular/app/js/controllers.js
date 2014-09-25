'use strict';

/* Controllers */

var onsControllers = angular.module('onsControllers', []);


onsControllers.controller('HomePageCtrl', function($scope, $http) {
  $http.get('/ons-command/rest/').success(function(data) {
    $scope.surnameList = data.surnameList;
  });
  
  $scope.search = function() {
	  $http.get('/ons-command/rest/search/surname/' + $scope.surname).success(function(data) {
		  $scope.persons = data;
	  });
  }
  
});

onsControllers.controller('SearchCtrl', function($scope, $http) {
	  $scope.search = function() {
		  alert("in search");
		  $http.get('/ons-command/rest/search/surname/' + $selectedSurname).success(function(data) {
			  
			    $scope.persons = data;
		  });
	  }
	  
	  $scope.persons = $scope.persons;
});


