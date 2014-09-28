'use strict';

/* App Module */

var onsApp = angular.module('onsApp', ['ngRoute', 'onsControllers']);

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
      otherwise({
        redirectTo: '/ons-command/rest/persons'
      });
  }]);
