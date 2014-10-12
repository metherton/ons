'use strict';

var onsServices = angular.module('onsServices', ['ngResource']);

onsServices.factory('Person', ['$resource',
  function($resource){
    return $resource('/ons-command/rest/persons/:personId', {}, {
      query: {method:'GET', params:{personId:''}, isArray:false}
    });
  }]);

onsServices.factory('Surname', ['$resource',
  function($resource){
	return $resource('/ons-command/rest/surnames/:surnameId', {}, {
		query: {method:'GET', params:{surnameId:''}, isArray:true}
    });
  }]);
