import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Order extends BaseEntity {
    @OneToMany
    private List<Product> products;

    private double totalPrice;

    // getters and setters
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}