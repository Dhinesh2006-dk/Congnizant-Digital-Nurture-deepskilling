package com.cognizant.ormlearn.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Transactional
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {
        Optional<Country> result =
                countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException(
                    "Country Not Found");
        }
        return result.get();
    }
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    @Transactional
    public void updateCountry(String code, String name)
            throws CountryNotFoundException {
        Optional<Country> result =
                countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException(
                    "Country Not Found");
        }
        Country country = result.get();
        country.setName(name);
        countryRepository.save(country);
    }
}