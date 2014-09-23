'use strict';

/* Controllers */

var onsApp = angular.module('onsApp', []);

onsApp.controller('SearchBoxCtrl', function($scope, $http) {
  $http.get('http://localhost:8080/ons-command/rest/').success(function(data) {
    $scope.surnameList = data.surnameList;
    $scope.surnameSelected = "Etherton";
  });
  

});
