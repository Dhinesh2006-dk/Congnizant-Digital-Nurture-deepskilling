package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @GetMapping
    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                (List<Country>) context.getBean("countryList");

        LOGGER.debug("Countries : {}", countries);

        LOGGER.info("END");

        return countries;
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {

        LOGGER.info("START");

        LOGGER.debug("Country : {}", country);

        LOGGER.info("END");

        return country;
    }
}
