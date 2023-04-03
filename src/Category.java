public class Category {
    private String name;
    private String subcategoryname;
    private int category_code;

    public Category(String name, String subcategoryname, int category_code)
    {
        this.name = name;
        this.subcategoryname = subcategoryname;
        this.category_code = category_code;
    }
    public Category()
    {
        this.name = "";
        this.subcategoryname = "";
        this.category_code = 0;
    }

    @Override
    public String toString() {
        return "\nCategory{" +
                "\nname: " + name +
                "\nsubcategoryname: " + subcategoryname +
                "\ncategory_code: " + category_code +
                '}';
    }
}
