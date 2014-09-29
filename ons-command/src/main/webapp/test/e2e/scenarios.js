'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Ons App', function() {

  it('should redirect index.html to index.html#/ons-command/rest/persons', function() {
    browser.get('app/index.html');
    browser.getLocationAbsUrl().then(function(url) {
        expect(url.split('#')[1]).toBe('/ons-command/rest/persons');
      });
  });

  describe('Etherton Person list view', function() {
	  beforeEach(function() {
	      browser.get('app/index.html#/ons-command/rest/persons');
	  }); 
  }); 
  
  describe('Person detail view', function() {
	    beforeEach(function() {
	      browser.get('http://localhost:8080/ons-command/app/index.html#/ons-command/rest/persons/1');
	    });
	    it('should display person with id 1 page', function() {
	      expect(element(by.binding('personDetails.person.firstName')).getText()).toBe('mark');
	    });
	});   

});
