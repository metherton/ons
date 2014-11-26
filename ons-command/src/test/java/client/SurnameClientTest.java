package client;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.martinetherton.ons.model.PersonDetails;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.martinetherton.ons.model.Surname;

import static org.junit.Assert.assertEquals;

public class SurnameClientTest {

	private static final String BASE_URL = "http://localhost:8080/ons-command/rest";
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	@Ignore
	public void createSurname() {
		String url = BASE_URL + "/surnames";
		// use a unique number to avoid conflicts
		Date date = new Date();
		Surname surname = new Surname(date.toString());
		URI newSurnameLocation = restTemplate.postForLocation(url, surname);
		Surname retrievedSurname = restTemplate.getForObject(newSurnameLocation, Surname.class);
		Assert.assertEquals(surname.getSurname(), retrievedSurname.getSurname());
		Assert.assertNotNull(retrievedSurname.getEntityId());
	}

    @Test
    public void getSurnames() {
        String url = BASE_URL + "/surnames";
        Surname[] surnames = restTemplate.getForObject(url, Surname[].class);
        assertEquals("etherton", surnames[0].getSurname());
    }


}
