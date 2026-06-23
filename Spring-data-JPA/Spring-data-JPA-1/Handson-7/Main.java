public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(
                        OrmLearnApplication.class,
                        args);
        countryService =
                context.getBean(
                        CountryService.class);
        testAddCountry();
    }
}
