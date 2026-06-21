import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagement {

    // Linear Search
    public static Book linearSearch(
            Book[] books,
            String title) {

        for(Book book : books) {

            if(book.title.equalsIgnoreCase(title)) {

                return book;
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(
            Book[] books,
            String title) {

        int left = 0;
        int right = books.length - 1;

        while(left <= right) {

            int mid = (left + right) / 2;

            int result =
                    books[mid].title.compareToIgnoreCase(title);

            if(result == 0) {

                return books[mid];
            }

            if(result < 0) {

                left = mid + 1;
            }
            else {

                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {

            new Book(
                    101,
                    "Java Programming",
                    "James Gosling"),

            new Book(
                    102,
                    "Data Structures",
                    "Mark Allen"),

            new Book(
                    103,
                    "Operating Systems",
                    "Galvin"),

            new Book(
                    104,
                    "Computer Networks",
                    "Tanenbaum"),

            new Book(
                    105,
                    "Database Systems",
                    "Elmasri")
        };

        System.out.println(
                "Linear Search:");

        System.out.println(
                linearSearch(
                        books,
                        "Operating Systems"));



        Arrays.sort(
                books,
                Comparator.comparing(
                        b -> b.title));



        System.out.println();

        System.out.println(
                "Binary Search:");

        System.out.println(
                binarySearch(
                        books,
                        "Operating Systems"));
    }
}
