'use strict';

var onsServices = angular.module('onsServices', ['ngResource']);

onsServices.factory('Search', ['$resource',
  function($resource){
    return $resource('phones/:phoneId.json', {}, {
      query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
    });
  }]);