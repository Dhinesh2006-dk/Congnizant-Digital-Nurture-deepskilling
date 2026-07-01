package com.cognizant.springlearn.controller;

import java.util.List;

import com.cognizant.springlearn.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "country.xml");

        List<Country> countries =
                (List<Country>) context.getBean(
                        "countryList");

        LOGGER.debug("Countries : {}", countries);

        LOGGER.info("END");

        return countries;
    }
}
