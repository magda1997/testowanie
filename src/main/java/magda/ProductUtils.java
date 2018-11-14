package magda;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductUtils {

    public static Product getProduct() {
        Product product = new Product();
        product.setName("fresh broccoli");
        product.setPrice(new BigDecimal(2.4));
        product.setCategory("fruit");
        product.setCountryOrigin("China");
        product.setExpiration_date(LocalDate.now());
        product.setSearchTags("domestic pastry");
        product.setDescription("frozen");
        return product;
    }

}
