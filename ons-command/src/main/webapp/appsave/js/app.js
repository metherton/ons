'use strict';

/* App Module */

var onsApp = angular.module('onsApp', [
  'ngRoute',
  'phonecatAnimations',
  'onsControllers',
  'phonecatFilters',
  'onsServices'
]);

onsApp.config(['$routeProvider',
  function($routeProvider) {
	alert('in route');
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
