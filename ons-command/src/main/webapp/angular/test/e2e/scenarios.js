'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Ons App', function() {

  describe('Home page view', function() {

    beforeEach(function() {
      browser.get('http://localhost:8080/ons-command');
    });


    it('should display a list of surnames in the search select box', function() {

      var surnameList = element.all(by.repeater('surname in surnameList'));

      expect(surnameList.count()).toBe(2);
    });



  });
});
