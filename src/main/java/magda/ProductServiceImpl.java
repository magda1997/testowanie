package magda;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {

    public List<Product> importProductFromFile(String filename) {
        File file = new File(filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Product> products = new ArrayList<>();
        while (sc.hasNextLine()) {
            String data[] = sc.nextLine().split(",");
            Product product = new Product(Integer.parseInt(data[0]),data[1],new BigDecimal(data[2]), data[3],data[4], LocalDate.parse(data[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),data[6],data[7]);
            products.add(product);
        }
        return products;
    }

    public void enterDataTODataBase(){
        List<Product> products = importProductFromFile("C:\\Users\\Karol\\IdeaProjects\\TestowanieOprogramowania\\src\\main\\resources\\dane.txt");
        ProductService productService = new ProductServiceImpl();
        System.out.println("list="+ products);
        for (int i = 0; i < products.size(); i++) {
            addProduct(products.get(i));
        }
    }

    @Override
    public void addProduct(Product product) {
        new ProductDAOImpl().createProduct(product);
    }

    @Override
    public Product getProductbyId(int productId) {
        return new ProductDAOImpl().readProductbyId(productId);
    }

    @Override
    public void updateProductById(int productId, String name, BigDecimal price) {
        new ProductDAOImpl().updateProductById(productId, name,price);
    }

    @Override
    public void deleteProductById(Integer employeeId) {
        new ProductDAOImpl().deleteProductById(employeeId);
    }

}

