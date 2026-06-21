public class QuickSortDemo {

    static void quickSort(Order[] orders,
                          int low,
                          int high) {

        if(low < high) {

            int pi = partition(orders, low, high);

            quickSort(orders, low, pi-1);
            quickSort(orders, pi+1, high);
        }
    }

    static int partition(Order[] orders,
                         int low,
                         int high) {

        double pivot = orders[high].totalPrice;

        int i = low - 1;

        for(int j=low;j<high;j++) {

            if(orders[j].totalPrice < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;

        return i+1;
    }

    public static void main(String[] args) {

        Order[] orders = {

            new Order(101,"Alice",5000),
            new Order(102,"Bob",2000),
            new Order(103,"Charlie",8000),
            new Order(104,"David",1000)
        };

        quickSort(orders,0,orders.length-1);

        System.out.println("Quick Sort:");

        for(Order order : orders) {
            System.out.println(order);
        }
    }
}
