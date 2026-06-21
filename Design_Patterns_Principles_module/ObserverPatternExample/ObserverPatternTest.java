public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();
        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);
        stockMarket.setStockPrice(3000);
        System.out.println();
        stockMarket.setStockPrice(3500);
    }
}
