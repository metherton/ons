'use strict';

var onsServices = angular.module('onsServices', ['ngResource']);

onsServices.factory('personService', ['$resource',
  function($resource){
    return $resource('http://localhost:8080/ons-command/rest/persons/:personId', {}, {
      query: {method:'GET', params:{personId:''}, isArray:false}
    });
  }]);

onsServices.factory('Surname', ['$resource',
  function($resource){
	return $resource('http://localhost:8080/ons-command/rest/surnames/:surnameId', {}, {
		query: {method:'GET', params:{surnameId:''}, isArray:true}
    });
  }]);
