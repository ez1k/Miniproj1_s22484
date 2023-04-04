import java.io.*;
import java.util.Scanner;

public class Main {

    private static File file = new File("data");
    private static File serializablefile = new File("data1");
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
                    Category.Create_Categories();
                    break;
                case 2:
                    Product.Create_Products();
                    break;
                case 3:
                    Category.Print_Categories();
                    break;
                case 4:
                    Product.Print_Products();
                    break;
                case 5:
                    SaveSimple();
                    break;
                case 6:
                    serializeObjects();
                    break;
                case 7:
                    LoadSimple();
                    break;
                case 8:
                    deserializeObjects();
                    break;
                default:
                    breakflag = true;
                    break;
            }
        }
    }
    private static void SaveSimple()
    {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            Category.writeList(dataOutputStream);
            dataOutputStream.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private static void LoadSimple()
    {
        try {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            Category.ReadList(dataInputStream);
            dataInputStream.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private static void serializeObjects() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(serializablefile));
            Product.Serialize(out);
            out.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private static void deserializeObjects() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(serializablefile));
            Product.Deserialize(in);
            in.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
