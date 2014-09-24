'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Ons App', function() {

  describe('Home page view', function() {

    beforeEach(function() {
      browser.get('http://localhost:8080/ons-command');
    });


    it('should contain a first name and surname text boxes, and a search button', function() {

      var surnameList = element.all(by.repeater('surname in surnameList'));
      var n = element(by.model('firstName'));
      n.sendKeys("eesdfdsfdfsdfsdfsdfsdfsdfsdf");

    });



  });
});
