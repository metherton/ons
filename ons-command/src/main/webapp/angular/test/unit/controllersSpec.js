'use strict';

/* jasmine specs for controllers go here */
describe('SearchBoxCtrl controllers', function() {

  describe('SearchBoxCtrl', function(){
    var scope, ctrl, $httpBackend;

    beforeEach(module('onsApp'));
    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('http://localhost:8080/ons-command/rest/').
          respond({surnameList:[{entityId:'1',surname:'Etherton'},{entityId:'2',surname:'Wilkinson'}]});

      scope = $rootScope.$new();
      ctrl = $controller('SearchBoxCtrl', {$scope: scope});
    }));


    it('should create surnameList model with 2 surnames fetched from xhr', function() {
      expect(scope.surnameList).toBeUndefined();
      $httpBackend.flush();

      expect(scope.surnameList).toEqual([{entityId:'1',surname:'Etherton'},{entityId:'2',surname:'Wilkinson'}]);
    });
    
  });
});
