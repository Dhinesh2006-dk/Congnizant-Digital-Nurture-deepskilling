private static void testAddCountry() {
    try {
        LOGGER.info("Start");
        Country country = new Country();
        country.setCode("JP");
        country.setName("Japan");
        countryService.addCountry(country);
        Country addedCountry =
                countryService.findCountryByCode("JP");
        LOGGER.debug("Country Added: {}", addedCountry);
        LOGGER.info("End");
    } catch (Exception e) {
        LOGGER.error(e.getMessage());
    }
}