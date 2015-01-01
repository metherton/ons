package client;

import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.Surname;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/**
 * Created by martin on 25/11/14.
 */
public class LocationClientTest {

    private static final String BASE_URL = "http://localhost:8080/ons-command/rest";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    @Ignore
    public void getLocations() {
        String url = BASE_URL + "/locations";
        Location[] locations = restTemplate.getForObject(url, Location[].class);
        assertEquals("Sheffield", locations[0].getCity());
    }

}
