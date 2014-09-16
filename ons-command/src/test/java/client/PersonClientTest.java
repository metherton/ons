package client;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.Surname;

public class PersonClientTest {

	
	/**
	 * server URL ending with the servlet mapping on which the application can be reached.
	 */
	private static final String BASE_URL = "http://localhost:8080/ons-command/app";
	
	private RestTemplate restTemplate = new RestTemplate();
		
	@Test
	@Ignore
	public void getPerson() {
		String url = BASE_URL + "/persons/{personId}";
		Person person = restTemplate.getForObject(url, Person.class, 1); 
		assertEquals("Mark", person.getFirstName());
	}

	@Test
	@Ignore
	public void getSurname() {
		String url = BASE_URL + "/surnames/{surnameId}";
		Surname person = restTemplate.getForObject(url, Surname.class, 1); 
		assertEquals("Etherton", person.getSurname());
	}	
	
}
