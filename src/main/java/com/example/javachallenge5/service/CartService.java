import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public Cart checkoutCart(Long cartId) {
        Cart cart = getCart(cartId);
        cart.checkout();
        return saveCart(cart);
    }

    public Cart cancelOrder(Long cartId, Order order) {
        Cart cart = getCart(cartId);
        cart.cancelOrder(order);
        return saveCart(cart);
    }

    public Cart updateOrder(Long cartId, Order order) {
        Cart cart = getCart(cartId);
        cart.updateOrder(order);
        return saveCart(cart);
    }

    public Cart removeOrder(Long cartId, Order order) {
        Cart cart = getCart(cartId);
        cart.removeOrder(order);
        return saveCart(cart);
    }

    public Cart updateProduct(Long cartId, Product product) {
        Cart cart = getCart(cartId);
        cart.updateProduct(product);
        return saveCart(cart);
    }

    public Cart removeProductById(Long cartId, Long id) {
        Cart cart = getCart(cartId);
        cart.removeProductById(id);
        return saveCart(cart);
    }

    public Cart addProductToCart(Long cartId, Product product) {
        Cart cart = getCart(cartId);
        cart.addProduct(product);
        return saveCart(cart);
    }

    public Cart removeProductFromCart(Long cartId, Product product) {
        Cart cart = getCart(cartId);
        cart.removeProduct(product);
        return saveCart(cart);
    }

    public Cart cancelOrder(Long cartId, Order order) {
        Cart cart = getCart(cartId);
        cart.cancelOrder(order);
        return saveCart(cart);
    }

    // other necessary methods
}