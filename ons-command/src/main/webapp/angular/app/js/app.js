'use strict';

/* App Module */

var onsApp = angular.module('onsApp', ['ngRoute', 'onsControllers']);

onsApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/ons-command/rest/', {
        templateUrl: 'partials/search.html',
        controller: 'HomePageCtrl'
      }).
      when('/ons-command/rest/search/surname/:name', {
        templateUrl: 'partials/searchResults.html',
        controller: 'SearchCtrl'
      }).
      otherwise({
        redirectTo: '/ons-command/rest/'
      });
  }]);
