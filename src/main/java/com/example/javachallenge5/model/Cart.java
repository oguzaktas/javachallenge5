import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cart extends BaseEntity {
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

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        totalPrice -= product.getPrice();
    }

    public void clearCart() {
        products.clear();
        totalPrice = 0;
    }

    public void checkout() {
        Order order = new Order();
        order.setProducts(products);
        order.setTotalPrice(totalPrice);
        products.clear();
        totalPrice = 0;
    }

    public void cancelOrder(Order order) {
        products.addAll(order.getProducts());
        totalPrice += order.getTotalPrice();
    }

    public void updateOrder(Order order) {
        products.addAll(order.getProducts());
        totalPrice += order.getTotalPrice();
    }

    public void removeOrder(Order order) {
        products.removeAll(order.getProducts());
        totalPrice -= order.getTotalPrice();
    }

    public void updateProduct(Product product) {
        for (Product p : products) {
            if (p.getId().equals(product.getId())) {
                totalPrice -= p.getPrice();
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setStock(product.getStock());
                totalPrice += p.getPrice();
            }
        }
    }

    public void removeProductById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                totalPrice -= p.getPrice();
                products.remove(p);
                break;
            }
        }
    }
}