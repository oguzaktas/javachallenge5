import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity {
    private String name;
    private double price;
    private int stock;

    // getters and setters
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addStock(int stock) {
        this.stock += stock;
    }

    public void removeStock(int stock) {
        this.stock -= stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }

    public void sell(int quantity) {
        if (isAvailable(quantity)) {
            stock -= quantity;
        } else {
            throw new RuntimeException("Product not available");
        }
    }

    public void cancelSell(int quantity) {
        stock += quantity;
    }

    public void updateStock(int quantity) {
        stock += quantity;
    }

    public void updateProduct(Product product) {
        name = product.getName();
        price = product.getPrice();
        stock = product.getStock();
    }

    public void updateProduct(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void updateProduct(String name) {
        this.name = name;
    }

    public void updateProduct(double price) {
        this.price = price;
    }

    public void updateProduct(int stock) {
        this.stock = stock;
    }

    // other necessary methods
}