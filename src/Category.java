import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
    private String name;
    private String subcategoryname;
    private int category_code;
    private static List<Category> categories = new ArrayList<>();

    public Category(String name, String subcategoryname, int category_code) {
        this.name = name;
        this.subcategoryname = subcategoryname;
        this.category_code = category_code;
        boolean duplicate = false;
        for (Category c : categories) {
            if (c.name.equals(name) & c.subcategoryname.equals(subcategoryname) & c.category_code == category_code) {
                duplicate = true;
                break;
            }

        }
        if (!duplicate) {
            categories.add(this);
        }

    }

    public Category() {
        this.name = "";
        this.subcategoryname = "";
        this.category_code = 0;
        categories.add(this);
    }

    @Override
    public String toString() {
        return "Category{" + " name: " + name + " subcategory: " + subcategoryname + " code: " + category_code + '}';
    }

    public static void printCategories() {
        for (Category c : categories
        ) {
            System.out.println(c.toString());
        }
    }

    public static void createCategories() {
        new Category("food", "meat products", 1);
        new Category("clothes", "t-shirts", 1);
        new Category("shoes", "Athletic shoes", 1);
        new Category("shoes", "Fictional footwear", 1);
    }

    public static void writeList(DataOutputStream outputStream) {
        try {
            outputStream.writeInt(categories.size());
            for (Category p : categories) {
                p.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readList(DataInputStream dataInputStream) throws IOException {
        Category category;
        int obj = dataInputStream.readInt();
        categories.clear();
        for (int i = 0; i < obj; i++) {
            category = new Category();
            category.read(dataInputStream);
        }
    }

    private void write(DataOutputStream outputStream) throws IOException {
        outputStream.writeUTF(name);
        outputStream.writeUTF(subcategoryname);
        outputStream.writeInt(category_code);
    }

    private void read(DataInputStream inputStream) throws IOException {
        name = inputStream.readUTF();
        subcategoryname = inputStream.readUTF();
        category_code = inputStream.readInt();
    }

    public static void serialize(ObjectOutputStream out) throws IOException {
        out.writeObject(categories);
    }

    public static void deserialize(ObjectInputStream in) throws IOException, ClassNotFoundException {
        categories = (ArrayList<Category>) in.readObject();
    }
}
