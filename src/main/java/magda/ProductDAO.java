package magda;

import java.math.BigDecimal;

public interface ProductDAO {
// tu jest crud add= cereate
    //
        public abstract void createProduct(Product product);
        public abstract Product readProductbyId(int productId);
        public abstract void updateProductById(int productId, String name, BigDecimal price);
        public abstract void  deleteProductById(Integer productId);
    }
