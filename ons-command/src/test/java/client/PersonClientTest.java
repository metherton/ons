package client;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.martinetherton.ons.command.rest.PersonsForm;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.Surname;

import java.util.List;

public class PersonClientTest {

	
	/**
	 * server URL ending with the servlet mapping on which the application can be reached.
	 */
	private static final String BASE_URL = "http://localhost:8080/ons-command/rest";
	
	private RestTemplate restTemplate = new RestTemplate();
		
	@Test
	public void getPersonDetails() {
		String url = BASE_URL + "/persons/{personId}";
		PersonDetails personDetails = restTemplate.getForObject(url, PersonDetails.class, 3);
		assertEquals("samuel", personDetails.getPerson().getFirstName());
	}

	@Test
	public void getSurname() {
		String url = BASE_URL + "/surnames/{surnameId}";
		Surname person = restTemplate.getForObject(url, Surname.class, 1); 
		assertEquals("etherton", person.getSurname());
	}

    @Test
    public void getAddPersonForm() {
        String url = BASE_URL + "/persons";
        Object personsForm = restTemplate.getForObject(url, PersonsForm.class);
 //       assertEquals(personsForm.getSurnames().size(), Matchers.is(Matchers.greaterThan(0)));
    }

}
