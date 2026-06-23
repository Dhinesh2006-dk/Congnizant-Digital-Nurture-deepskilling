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
                SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testSearchCountry();
        testSearchCountrySorted();
        testCountriesStartingWith();
    }
    private static void testSearchCountry() {
        LOGGER.info("Countries containing 'ou'");
        List<Country> countries =
                countryService.searchCountry("ou");
        countries.forEach(System.out::println);
    }
    private static void testSearchCountrySorted() {
        LOGGER.info("Countries containing 'ou' sorted");
        List<Country> countries =
                countryService.searchCountrySorted("ou");
        countries.forEach(System.out::println);
    }
    private static void testCountriesStartingWith() {
        LOGGER.info("Countries starting with Z");
        List<Country> countries =
                countryService.getCountriesStartingWith("Z");
        countries.forEach(System.out::println);
    }
}