'use strict';

/* App Module */

var onsApp = angular.module('onsApp', ['ngRoute', 'onsControllers', 'onsServices']);

onsApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/ons-command/rest/persons', {
        templateUrl: 'partials/personList.html',
        controller: 'PersonListCtrl'
      }).
      when('/ons-command/rest/persons/:personId', {
          templateUrl: 'partials/personDetails.html',
          controller: 'PersonDetailsCtrl'
        }). 
      when('/ons-command/rest/surnames', {
          templateUrl: 'partials/surnameList.html',
          controller: 'SurnameListCtrl'
        }).        
      otherwise({
        redirectTo: '/ons-command/rest/persons'
      });
  }]);
