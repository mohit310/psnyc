package org.psnyc.core.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.BeforeClass;
import org.junit.Test;
import org.psnyc.data.Contact;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.psnyc.core.FixtureHelpers.fixture;


/**
 * Created by mohit on 8/23/14.
 */
public class ContactUsTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void serializesToJSON() throws Exception {
        final Contact contact = new Contact("Mohit","Keswani","mk@mk.com","Testing data is good");
        assertThat(MAPPER.writeValueAsString(contact))
                .isEqualTo(fixture("fixtures/contact.json"));
    }

    @Test
    public void contactValidationTest() {
        final Contact contact = new Contact("M","K","mk@mk.com","Testing data is good");
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate( contact );
        assertThat(constraintViolations).hasSize(2);
    }




}
