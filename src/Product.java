import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private static List<Product> products = new ArrayList<>();
    private int id;
    private String name;
    private double netto;
    private double cost;
    private String expiring_date;
    private Category category;
    private double VAT;

    public Product(int id, String name, double cost, double netto, String expiring_date, Category category)
    {
        this.id = id;
        this.name = name;
        this.netto = netto;
        this.cost = cost;
        this.expiring_date = expiring_date;
        this.category = category;
        this.VAT = 0.23;
        products.add(this);
    }
    public Product(int id, String name, double cost, double netto, Category category)
    {
        this.id = id;
        this.name = name;
        this.netto = netto;
        this.cost = cost;
        this.expiring_date = "no date";
        this.category = category;
        this.VAT = 0.23;
        products.add(this);
    }
    public Product ()
    {
        this.VAT = 0.23;
        products.add(this);
    }

    public static void Serialize(ObjectOutputStream out) throws IOException {
        out.writeObject(products);
    }
    public static void Deserialize(ObjectInputStream in) throws IOException, ClassNotFoundException {
        products = (ArrayList<Product>) in.readObject();
    }

    @Override
    public String toString() {
        return "id: "+ id + " name: "+ name +  " netto: " + netto +" cost of goods: " + cost + " VAT: " + VAT + " expiring date: "+ expiring_date + " | " + this.category.toString();
    }
    public void SetName(String name)
    {
        this.name = name;
    }
    public void SetCost(double cost)
    {
        this.cost = cost;
    }
    public void SetExpiringDate(String expiring_date)
    {
        this.expiring_date = expiring_date;
    }
    public void SetId(int nextInt) {this.id = id;
    }

    public void SetNetto(double nextFloat) {this.netto = netto;
    }
    public double Brutto()
    {
        return netto + VAT;
    }
    public double margin()
    {
        return netto - cost;
    }
    public static void Create_Products()
    {
        new Product(0,"sausages",  1, 7.50, "2025-12-01", new Category("food", "meat products", 1));
        new Product(1,"sausages",  1, 6.50, "2025-12-01", new Category("food", "meat products", 1));
    }
    public static void Print_Products()
    {
       products.forEach((p) -> System.out.println(p.toString()));
    }



}
