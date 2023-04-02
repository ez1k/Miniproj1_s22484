import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    static List<Product> list = new ArrayList<>();
    int id;
    private String name;
    private double cost;
    private String expiring_date;

    public Product (int id, String name, double cost, String expiring_date)
    {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.expiring_date = expiring_date;
        list.add(this);
    }
    public Product (int id, String name, float cost)
    {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.expiring_date = "";
        list.add(this);
    }
    public Product ()
    {
        this.name = "";
        this.cost = 0;
        this.expiring_date = "";
    }

    @Override
    public String toString() {
        return "nazwa: "+ name + "\ncena: " + cost + "\ndata ważności "+ expiring_date;
    }
    public void SetName(String name)
    {
        this.name = name;
    }
    public void SetCost(Float cost)
    {
        this.cost = cost;
    }
    public void SetExpiringDate(String expiring_date)
    {
        this.expiring_date = expiring_date;
    }
    public static void Create_Products()
    {
        list.add(new Product(0,"Parówki",  2.99,"2025-12-01"));
    }
}
