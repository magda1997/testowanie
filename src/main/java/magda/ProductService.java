package magda;

import java.math.BigDecimal;

public interface ProductService {
    public abstract void addProduct(Product product);
    public abstract Product getProductbyId(int productId);
    public abstract void updateProductById(int productId,String name, BigDecimal price);
    public abstract void deleteProductById(Integer productId);
}
