import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product addStock(Long id, int stock) {
        Product product = getProduct(id);
        product.addStock(stock);
        return updateProduct(product);
    }

    public Product removeStock(Long id, int stock) {
        Product product = getProduct(id);
        product.removeStock(stock);
        return updateProduct(product);
    }

    public Product sellProduct(Long id, int quantity) {
        Product product = getProduct(id);
        product.sell(quantity);
        return updateProduct(product);
    }

    public Product cancelSellProduct(Long id, int quantity) {
        Product product = getProduct(id);
        product.cancelSell(quantity);
        return updateProduct(product);
    }

    public Product updateStock(Long id, int quantity) {
        Product product = getProduct(id);
        product.updateStock(quantity);
        return updateProduct(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product p = getProduct(id);
        p.updateProduct(product);
        return updateProduct(p);
    }

    public Product updateProduct(Long id, String name, double price, int stock) {
        Product product = getProduct(id);
        product.updateProduct(name, price, stock);
        return updateProduct(product);
    }

    public Product updateProduct(Long id, String name) {
        Product product = getProduct(id);
        product.updateProduct(name);
        return updateProduct(product);
    }

    public Product updateProduct(Long id, double price) {
        Product product = getProduct(id);
        product.updateProduct(price);
        return updateProduct(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAvailableProducts() {
        return productRepository.findAll().stream().filter(Product::isAvailable).collect(Collectors.toList());
    }

    public List<Product> getAvailableProducts(int quantity) {
        return productRepository.findAll().stream().filter(p -> p.isAvailable(quantity)).collect(Collectors.toList());
    }

    public List<Product> getUnavailableProducts() {
        return productRepository.findAll().stream().filter(p -> !p.isAvailable()).collect(Collectors.toList());
    }

    public List<Product> getUnavailableProducts(int quantity) {
        return productRepository.findAll().stream().filter(p -> !p.isAvailable(quantity)).collect(Collectors.toList());
    }

    public List<Product> getProductsByPrice(double price) {
        return productRepository.findAll().stream().filter(p -> p.getPrice() == price).collect(Collectors.toList());
    }

    public List<Product> getProductsByPrice(double minPrice, double maxPrice) {
        return productRepository.findAll().stream().filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findAll().stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    }

    public List<Product> getProductsByNameContaining(String name) {
        return productRepository.findAll().stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());
    }

    public List<Product> getProductsByStock(int stock) {
        return productRepository.findAll().stream().filter(p -> p.getStock() == stock).collect(Collectors.toList());
    }

    public List<Product> getProductsByStock(int minStock, int maxStock) {
        return productRepository.findAll().stream().filter(p -> p.getStock() >= minStock && p.getStock() <= maxStock).collect(Collectors.toList());
    }

    public List<Product> getProductsByStockLessThan(int stock) {
        return productRepository.findAll().stream().filter(p -> p.getStock() < stock).collect(Collectors.toList());
    }

    public List<Product> getProductsByStockGreaterThan(int stock) {
        return productRepository.findAll().stream().filter(p -> p.getStock() > stock).collect(Collectors.toList());
    }

    public List<Product> getProductsByStockBetween(int minStock, int maxStock) {
        return productRepository.findAll().stream().filter(p -> p.getStock() >= minStock && p.getStock() <= maxStock).collect(Collectors.toList());
    }

    // other necessary methods
}