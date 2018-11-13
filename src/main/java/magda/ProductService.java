package magda;

import java.math.BigDecimal;

public interface ProductService {
    void addProduct(Product product);
    Product getProductById(int productId);
    void updateProductById(int productId,String name, BigDecimal price);
    void deleteProductById(Integer productId);
}
