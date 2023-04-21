import java.io.*;
import java.util.Scanner;

public class Main {

    private static final File file = new File("data");
    private static final File serializablefile = new File("data1");
    private static boolean breakflag = false;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (!breakflag) {
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

            switch (option) {
                case 1 -> Category.createCategories();
                case 2 -> Product.createProducts();
                case 3 -> Category.printCategories();
                case 4 -> Product.printProducts();
                case 5 -> SaveSimple();
                case 6 -> serializeObjects();
                case 7 -> LoadSimple();
                case 8 -> deserializeObjects();
                default -> breakflag = true;
            }
        }
    }

    private static void SaveSimple() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            Category.writeList(dataOutputStream);
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void LoadSimple() {
        try {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            Category.readList(dataInputStream);
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serializeObjects() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(serializablefile));
            Product.serialize(out);
            Category.serialize(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeObjects() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(serializablefile));
            Product.deserialize(in);
            Category.deserialize(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
