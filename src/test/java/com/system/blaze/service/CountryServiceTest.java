package com.system.blaze.service;

import com.system.blaze.customException.InvalidCountryException;
import com.system.blaze.customException.SanctionedCountryException;
import com.system.blaze.parsingModel.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CountryServiceTest {

    @Value("${blaze.sanctionedCountries}")
    private Set<String> sanctionedCountries;

    @Autowired
    private CountryService countryService;

    @Test
    public void when_valid_country_no_sanctions_then_check_does_not_throw() {
        RiskRequest riskRequest = getRiskRequestInstance("CA", "CA");

        assertDoesNotThrow(() -> countryService.check(riskRequest));
    }

    @Test
    public void when_invalid_sender_country_then_check_throws_InvalidCountryException() {
        RiskRequest riskRequest = getRiskRequestInstance("ZZ", "CA");

        Exception e = assertThrows(InvalidCountryException.class, () -> countryService.check(riskRequest));

        assertEquals("Sender country ZZ is not a valid country code", e.getMessage());
    }

    @Test
    public void when_invalid_receiver_country_then_check_throws_InvalidCountryException() {
        RiskRequest riskRequest = getRiskRequestInstance("CA", "ZZ");

        Exception e = assertThrows(InvalidCountryException.class, () -> countryService.check(riskRequest));

        assertEquals("Receiver country ZZ is not a valid country code", e.getMessage());
    }

    @Test
    public void when_sanctioned_receiving_country_then_check_throws_SanctionedCountryException() {
        if (!sanctionedCountries.isEmpty()) {
            String sanctionedCountry = sanctionedCountries.iterator().next();
            RiskRequest riskRequest = getRiskRequestInstance("CA", sanctionedCountry);

            Exception e = assertThrows(SanctionedCountryException.class, () -> countryService.check(riskRequest));

            String expected = "Cannot send money to "
                    + new Locale("", sanctionedCountry.toUpperCase()).getDisplayCountry()
                    + " (" + sanctionedCountry + ") due to sanctions";
            assertEquals(expected, e.getMessage());
        }
    }

    private RiskRequest getRiskRequestInstance(String senderCountry, String receiverCountry) {
        Customer customer = new Customer(new Name(), new Address(senderCountry));
        Receiver receiver = new Receiver(new Name(), new Address(receiverCountry));
        PaymentDetails paymentDetails = new PaymentDetails();

        return new RiskRequest(customer, receiver, paymentDetails);
    }
}
