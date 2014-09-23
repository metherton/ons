'use strict';

/* Controllers */

var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('PhoneListCtrl', function($scope, $http) {
  $http.get('http://localhost:8080/ons-command/rest/persons/1').success(function(data) {
    $scope.persons = data;
  });

});
