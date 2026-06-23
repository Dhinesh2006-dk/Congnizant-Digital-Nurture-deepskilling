package com.cognizant.ormlearn;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(
                        OrmLearnApplication.class,
                        args);
        countryService =
                context.getBean(
                        CountryService.class);
        testGetCountry();
        testAddCountry();
        testUpdateCountry();
        testSearchCountry();
        testDeleteCountry();
    }
    private static void testGetCountry() {
        LOGGER.info("----- Get Country -----");
        Country country =
                countryService.getCountry("IN");
        LOGGER.debug("Country={}", country);
    }
    private static void testAddCountry() {
        LOGGER.info("----- Add Country -----");
        Country country = new Country();
        country.setCode("XX");
        country.setName("Test Country");
        countryService.addCountry(country);
        LOGGER.debug("Country Added");
    }

    private static void testUpdateCountry() {
        LOGGER.info("----- Update Country -----");
        Country country =
                countryService.getCountry("IN");
        country.setName("India Updated");
        countryService.updateCountry(country);
        LOGGER.debug("Country Updated");
    }
    private static void testSearchCountry() {
        LOGGER.info("----- Search Country -----");
        List<Country> countries =
                countryService.searchCountries("Uni");
        LOGGER.debug("Countries={}", countries);
    }
    private static void testDeleteCountry() {
        LOGGER.info("----- Delete Country -----");
        countryService.deleteCountry("XX");
        LOGGER.debug("Country Deleted");
    }
}