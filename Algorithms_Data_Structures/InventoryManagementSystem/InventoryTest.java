public class InventoryTest
{
    public static void main(String[] args)
    {
        InventoryManager manager =
                new InventoryManager();

        Product p1 =
                new Product(
                        101,
                        "Laptop",
                        50,
                        50000);

        Product p2 =
                new Product(
                        102,
                        "Mobile",
                        100,
                        20000);

        manager.addProduct(p1);
        manager.addProduct(p2);

        System.out.println();

        manager.displayProducts();

        System.out.println();

        manager.updateProduct(
                101,
                "Gaming Laptop",
                40,
                70000);

        System.out.println();

        manager.displayProducts();

        System.out.println();

        manager.deleteProduct(102);

        System.out.println();

        manager.displayProducts();
    }
}
