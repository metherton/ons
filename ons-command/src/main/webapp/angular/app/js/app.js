'use strict';

/* App Module */

var onsApp = angular.module('onsApp', ['ngRoute', 'onsControllers']);

onsApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/ons-command/rest/persons', {
        templateUrl: 'angular/app/partials/personList.html',
        controller: 'PersonListCtrl'
      }).
      when('/ons-command/rest/persons/:personId', {
          templateUrl: 'angular/app/partials/person-detail.html',
          controller: 'PersonDetailCtrl'
        }).      
      otherwise({
        redirectTo: '/ons-command/rest/persons'
      });
  }]);
