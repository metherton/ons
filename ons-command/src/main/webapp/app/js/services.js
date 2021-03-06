'use strict';

var onsServices = angular.module('onsServices', ['ngResource']);

onsServices.factory('personService', ['$resource',
  function($resource){
    return $resource('http://localhost:8080/ons-command/rest/persons/:personId', {}, {
      query: {method:'GET', params:{personId:'persons'}, isArray:false}
    });
  }]);

onsServices.factory('surnameService', ['$resource',
  function($resource){
	return $resource('http://localhost:8080/ons-command/rest/surnames/:surnameId', {}, {
		query: {method:'GET', params:{surnameId:''}, isArray:true}
    });
  }]);
