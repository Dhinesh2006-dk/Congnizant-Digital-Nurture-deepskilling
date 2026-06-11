public class Test
{
    public static void main(String[] args)
    {
        Logger log1 = Logger.getInstance();

        Logger log2 = Logger.getInstance();

        log1.log("Application Started");

        log2.log("User Logged In");

        System.out.println(log1 == log2);
    }
}
