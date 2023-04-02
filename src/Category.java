import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product>products = new ArrayList<>();

    private List<Category>Categories = new ArrayList<>();
    public Category(String name, List<Product> products)
    {
        this.name = name;
        this.products = products;
        Categories.add(this);
    }
}
