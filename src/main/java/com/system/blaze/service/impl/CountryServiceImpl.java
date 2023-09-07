package com.system.blaze.service.impl;

import com.system.blaze.customException.InvalidCountryException;
import com.system.blaze.customException.SanctionedCountryException;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.CountryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {

    @Value("${blaze.sanctionedCountries}")
    private Set<String> sanctionedCountries;

    public void check(RiskRequest riskRequest) {
        checkSendingCountry(riskRequest.getCustomer().getAddress().getCountry());
        checkReceivingCountry(riskRequest.getReceiver().getAddress().getCountry());
    }

    private void checkSendingCountry(String country) {
        checkValidCountry("Sender", country);
    }

    private void checkReceivingCountry(String country) {
        checkValidCountry("Receiver", country);

        sanctionedCountries.forEach(sanctionedCountry -> {
            if (sanctionedCountry.equalsIgnoreCase(country)) {
                throw new SanctionedCountryException("Cannot send money to "
                        + new Locale("", country.toUpperCase()).getDisplayCountry()
                        + " (" + country + ") due to sanctions");
            }
        });
    }


    /**
     *
     * See list of ISO 3166 country codes for valid country codes
     * <a href="https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes">...</a>
     * @param countryType could be sender or receiver country
     * @param country passed in from rest api
     */
    private void checkValidCountry(String countryType, String country) {
        Set<String> countries = Set.of(Locale.getISOCountries());
        if (!countries.contains(country.toUpperCase())) {
            throw new InvalidCountryException(countryType + " country " + country + " is not a valid country code");
        }
    }
}
