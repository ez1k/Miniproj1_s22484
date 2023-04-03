import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    static List<Product> products = new ArrayList<>();
    int id;
    private String name;
    private double cost;
    private double netto;
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

    @Override
    public String toString() {
        return "id: "+ id + "\nname: "+ name +  "\nnetto:" + netto +"\ncost of goods: " + cost + "\nVAT: " + VAT + "\nexpiring date "+ expiring_date + this.category.toString() + "\n";
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
    public static void writeList(DataOutputStream outputStream)
    {
        try {
            outputStream.writeInt(products.size());
            for (Product p: products) {
                p.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void write(DataOutputStream outputStream)
    {
        try {
            outputStream.writeUTF(name);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void read(DataInputStream inputStream)
    {
        try {
            inputStream.readUTF();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
