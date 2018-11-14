package magda;

        import java.math.BigDecimal;

public interface ProductDAO {
    // tu jest crud add= cereate
    //
    Integer createProduct(Product product);
    Product readProductById(int productId);
    void updateProductById(int productId, String name, BigDecimal price);
    void  deleteProductById(Integer productId);
}
