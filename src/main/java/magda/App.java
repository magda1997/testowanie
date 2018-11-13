package magda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        //    productDAO.importProductFromFile("C:\\Users\\Karol\\IdeaProjects\\TestowanieOprogramowania1\\TestowanieOprogramowania\\src\\main\\resources\\dane.txt");
        //List<Product> products = productDAO.importProductFromFile("C:\\Users\\Karol\\IdeaProjects\\TestowanieOprogramowania1\\TestowanieOprogramowania\\src\\main\\resources\\dane.txt");
        ProductService productService = new ProductServiceImpl();
        ProductServiceImpl productServiceImpl = new ProductServiceImpl();
        //productServiceImpl.enterDataTODataBase(); // czyta z pliku i zapisuje do bazy

        createProduct(productService);
        getProductbyId(productService);
        updateProductById(productService);
        deleteProductById(productService);
    }

    private static void createProduct(ProductService productService) {
        productService.addProduct(getProduct());
    }

    private static void deleteProductById(ProductService productService) {
        productService.deleteProductById(2);
    }

    private static void updateProductById(ProductService productService) {
        productService.updateProductById(10, "broccoli", new BigDecimal(1.3));
    }

    private static void getProductbyId(ProductService productService) {
        Product product = productService.getProductById(1);
        System.out.println(product);
    }

    private static Product getProduct() {
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



