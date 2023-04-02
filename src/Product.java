import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    List<Product> list = new ArrayList<>();
    private String name;
    private float cost;
    private String expiring_date;

    public Product (String name, float cost, String expiring_date)
    {
        this.name = name;
        this.cost = cost;
        this.expiring_date = expiring_date;
        list.add(this);
    }
    public Product (String name, float cost)
    {
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
}
