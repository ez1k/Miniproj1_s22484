import java.io.*;
import java.util.Scanner;

public class Main {

    private static File file = new File("data.txt");
    private static boolean breakflag = false;
    public static void main(String[] args) {
        menu();

    }
    private static void menu()
    {
        Scanner scanner = new Scanner(System.in);
        while (!breakflag)
        {
            System.out.println("1) Create categories");
            System.out.println("2) Create products");
            System.out.println("3) Show categories");
            System.out.println("4) Show products");
            System.out.println("5) Simple save - coding");
            System.out.println("6) Save - serialization");
            System.out.println("7) Simple loading - decoding");
            System.out.println("8) Loading - deserialization");
            System.out.println("0) Finish");

            int option = scanner.nextInt();

            switch (option){
                case 1:


                    break;
                case 2:
                    Product.Create_Products();
                    break;
                case 3:

                    break;
                case 4:
                    Product.Print_Products();
                    break;
                default:
                    breakflag = true;
                    break;
            }
        }
    }
    private static void saveSimple()
    {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            Product.
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
