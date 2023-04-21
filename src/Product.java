import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private static List<Product> products = new ArrayList<>();
    private static final double VAT = 0.23;

    private int id;
    private String name;
    private double netto;
    private double cost;
    private String expiring_date;
    private Category category;

    public Product(int id, String name, double cost, double netto, String expiring_date, Category category) {
        this.id = id;
        this.name = name;
        this.netto = netto;
        this.cost = cost;
        this.expiring_date = expiring_date;
        this.category = category;
        products.add(this);
    }

    public Product(int id, String name, double cost, double netto, Category category) {
        this.id = id;
        this.name = name;
        this.netto = netto;
        this.cost = cost;
        this.expiring_date = "no date";
        this.category = category;
        products.add(this);
    }

    public Product() {
        products.add(this);
    }

    public static void serialize(ObjectOutputStream out) throws IOException {
        out.writeObject(products);
    }

    public static void deserialize(ObjectInputStream in) throws IOException, ClassNotFoundException {
        products = (ArrayList<Product>) in.readObject();
    }

    @Override
    public String toString() {
        String format = " id: %s name: %s netto: %s cost of goods: %s VAT: %s expiring date: %s | %s ";
        return String.format(format, id, name, netto, cost, VAT, expiring_date, category.toString());
    }


    private double Brutto() {
        return netto + VAT;
    }

    public double margin() {
        return netto - cost;
    }

    public double margin(double VAT) {
        return (netto - cost) * 1 - VAT;
    }

    public static void createProducts() {
        new Product(0, "sausages", 1, 7.50, "2025-12-01", new Category("food", "meat products", 1));
        new Product(1, "sausages", 1, 6.50, "2025-12-01", new Category("food", "meat products", 1));
        new Product(2, "brown rice", 1, 7.50, new Category("food", "Rice products", 1));
        new Product(3, "rice", 1, 6.50, new Category("food", "Rice products", 1));
        new Product(4, "american bread", 1, 7.50, "2025-12-01", new Category("food", "breads", 1));
        new Product(5, "Limppu", 1, 6.50, "2025-12-01", new Category("food", "breads", 1));
    }

    public static void printProducts() {
        products.forEach((p) -> System.out.println(p.toString()));
    }


}
