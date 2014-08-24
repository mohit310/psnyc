package org.psnyc.core.resource;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.psnyc.core.resource.us.ContactUsResource;
import org.psnyc.data.Contact;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by mohit on 8/23/14.
 */
public class ContactUsResourceTest {

    private Client client;
    private final Contact contact = new Contact("mk", "mk", "mk@mk.com", "this is good data");
    private final ContactUsResource resource = new ContactUsResource();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ContactUsResource())
            .build();

    @Before
    public void setup() {
        client = new Client();
    }

    @Test
    public void testContactUs() {
        try {
            Response response = resource.saveContactUsInfo(contact);
            assertEquals(response.getStatus(),200);
        } catch (Exception e) {

        }
    }

}
