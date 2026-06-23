private static void testDeleteCountry() {
    try {
        LOGGER.info("Start");
        countryService.deleteCountry("JP");
        LOGGER.debug("Country Deleted Successfully");
        LOGGER.info("End");
    } catch (Exception e) {
        LOGGER.error(e.getMessage());

    }
}