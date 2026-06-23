private static void testUpdateCountry() {
    try {
        LOGGER.info("Start");
        countryService.updateCountry(
                "IN",
                "India Updated");
        Country country =
                countryService.findCountryByCode("IN");
        LOGGER.debug("Updated Country={}", country);
        LOGGER.info("End");
    } catch (Exception e) {
        LOGGER.error(e.getMessage());
    }
}