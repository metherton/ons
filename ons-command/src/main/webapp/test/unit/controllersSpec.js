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
  beforeEach(module('onsServices'));

  describe('PersonListCtrl', function(){
    var scope, ctrl, $httpBackend;

    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('/ons-command/rest/persons').
          respond({personDetails : [{person: {surname:'Etherton',firstName:'Mark', birthDate: 2}}, {person : {surname:'Etherton',firstName:'Samuel', birthDate: 1}}]});

      scope = $rootScope.$new();
      ctrl = $controller('PersonListCtrl', {$scope: scope});
    }));


    it('should create "persons" model with 2 persons fetched from xhr', function() {
  //    expect(scope.addPersonForm).toEqualData({personDetails : []});
      $httpBackend.flush(); 

      expect(scope.addPersonForm).toEqualData(
    		  {personDetails : [{person: {surname:'Etherton',firstName:'Mark', birthDate: 2}}, {person : {surname:'Etherton',firstName:'Samuel', birthDate: 1}}]});

      expect(scope.orderProp).toBe('person.birthDate');
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
	      expect(scope.personDetails).toEqualData({});
	      $httpBackend.flush();

	      expect(scope.personDetails).toEqualData(person1DetailsData());
	    });
	  });  
  
  describe('SurnameListCtrl', function(){
	    var scope, ctrl, $httpBackend;

	    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
	      $httpBackend = _$httpBackend_;
	      $httpBackend.expectGET('/ons-command/rest/surnames').
	          respond([{entityId:1,surname:'etherton'},{entityId:2, surname:'wilkinson'}]);
	      
	      scope = $rootScope.$new();
	      ctrl = $controller('SurnameListCtrl', {$scope: scope});
	    }));


	    it('should create "surnames" model with 2 surnames fetched from xhr', function() {
	      expect(scope.surnames).toEqualData([]);
	      $httpBackend.flush(); 

	      expect(scope.surnames).toEqualData(
	    		  [{entityId:1,surname:'etherton'},{entityId:2, surname:'wilkinson'}]);
	    });

	  }); 
  
  describe('SurnameDetailsCtrl', function(){
	    var scope, $httpBackend, ctrl,
	        surnameDetails = function() {
	          return {surname: 'etherton'}
	        };


	    beforeEach(inject(function(_$httpBackend_, $rootScope, $routeParams, $controller) {
	      $httpBackend = _$httpBackend_;
	      $httpBackend.expectGET('/ons-command/rest/surnames/1').respond(surnameDetails());

	      $routeParams.surnameId = 1;
	      scope = $rootScope.$new();
	      ctrl = $controller('SurnameDetailsCtrl', {$scope: scope});
	    }));


	    it('should fetch surname detail', function() {
	      expect(scope.surname).toEqualData({});
	      $httpBackend.flush();

	      expect(scope.surname).toEqualData(surnameDetails());
	    });
	  });   
  
  
});
