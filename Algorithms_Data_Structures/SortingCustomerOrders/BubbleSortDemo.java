public class BubbleSortDemo {

    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for(int i=0;i<n-1;i++) {

            for(int j=0;j<n-i-1;j++) {

                if(orders[j].totalPrice >
                   orders[j+1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Order[] orders = {

            new Order(101,"Alice",5000),
            new Order(102,"Bob",2000),
            new Order(103,"Charlie",8000),
            new Order(104,"David",1000)
        };

        bubbleSort(orders);

        System.out.println("Bubble Sort:");

        for(Order order : orders) {
            System.out.println(order);
        }
    }
}
