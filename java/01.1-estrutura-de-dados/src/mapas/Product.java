package mapas;

public class Product {

    private Integer id;
    private String name;
    double price;

    public Product(Integer id, String name, double price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
