package com.cognizant.ormlearn;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
@SpringBootApplication
public class OrmLearnApplication {
    private static StockRepository stockRepository;
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                SpringApplication.run(
                        OrmLearnApplication.class, args);
        stockRepository =
                context.getBean(StockRepository.class);
        testFacebookSeptember();
        testGooglePriceAbove1250();
        testTop3Volume();
        testNetflixLowest();
    }
    private static void testFacebookSeptember() throws Exception {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");
        List<Stock> stocks =
                stockRepository.findByCodeAndDateBetween(
                        "FB",
                        sdf.parse("2019-09-01"),
                        sdf.parse("2019-09-30"));
        stocks.forEach(System.out::println);
    }
    private static void testGooglePriceAbove1250() {
        List<Stock> stocks =
                stockRepository.findByCodeAndCloseGreaterThan(
                        "GOOGL", 1250);
        stocks.forEach(System.out::println);
    }
    private static void testTop3Volume() {
        List<Stock> stocks =
                stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(System.out::println);
    }
    private static void testNetflixLowest() {
        List<Stock> stocks =
                stockRepository.findTop3ByCodeOrderByCloseAsc(
                        "NFLX");
        stocks.forEach(System.out::println);
    }
}