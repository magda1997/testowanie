package magda;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class AppTest 
{
    @Test
    public void CRUDTest()
    {
        Product testProduct = new Product("testName", new BigDecimal(1), "testCategory", "testCountry", LocalDate.now(), "testTags", "testDescription");
        Product testInvalidProduct = null;

        ProductDAOImpl productDAO = new ProductDAOImpl();

        int id = -1;
        id = productDAO.createProduct(testInvalidProduct);
        assertEquals(id, -1);

        id = -1;
        id = productDAO.createProduct(testProduct);                   //test metody createProduct z poprawnymi danymi
        assertTrue(id != -1);

        Product productFromDB = null;
        productFromDB = productDAO.readProductById(id);               //test metody readProductbyId dla id istniejacego obiektu
        assertNotNull(productFromDB);

        productFromDB = productDAO.readProductById(-1);     //test metody readProductbyId dla id nieistniejacego obiektu
        assertNull(productFromDB);

        productDAO.deleteProductById(id);                             //test metody deleteProductById dla istniejacego obiektu
        productFromDB = productDAO.readProductById(id);
        assertNull(productFromDB);

        productDAO.deleteProductById(-1);                   //test metody deleteProductById dla nieistniejacego obiektu
    }
}
