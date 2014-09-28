'use strict';

/* jasmine specs for controllers go here */
describe('Ons controllers', function() {

  beforeEach(function(){
    this.addMatchers({
      toEqualData: function(expected) {
        return angular.equals(this.actual, expected);
      }
    });
  });

  beforeEach(module('onsApp'));

  describe('PersonListCtrl', function(){
    var scope, ctrl, $httpBackend;

    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('/ons-command/rest/persons').
          respond([{surname:'Etherton',firstName:'Mark'},{surname:'Etherton',firstName:'Samuel'}]);

      scope = $rootScope.$new();
      ctrl = $controller('PersonListCtrl', {$scope: scope});
    }));


    it('should create "persons" model with 2 persons fetched from xhr', function() {
      expect(scope.persons).toBeUndefined();
      $httpBackend.flush(); 

      expect(scope.persons).toEqualData(
    		  [{surname:'Etherton',firstName:'Mark'},{surname:'Etherton',firstName:'Samuel'}]);
    });

  });

  describe('PersonDetailsCtrl', function(){
	    var scope, $httpBackend, ctrl,
	        person1DetailsData = function() {
	          return {firstName: 'Martin'}
	        };


	    beforeEach(inject(function(_$httpBackend_, $rootScope, $routeParams, $controller) {
	      $httpBackend = _$httpBackend_;
	      $httpBackend.expectGET('/ons-command/rest/persons/1').respond(person1DetailsData());

	      $routeParams.personId = 1;
	      scope = $rootScope.$new();
	      ctrl = $controller('PersonDetailsCtrl', {$scope: scope});
	    }));


	    it('should fetch person detail', function() {
	      expect(scope.personDetails).toBeUndefined();
	      $httpBackend.flush();

	      expect(scope.personDetails).toEqual(person1DetailsData());
	    });
	  });  
  
  
});
