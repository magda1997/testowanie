package magda;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static magda.ProductUtils.getProduct;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    private ProductDAOImpl productDAO = new ProductDAOImpl();

    @Test
    public void CRUDTest() {
        assertTrue(true);
        Product testProduct = new Product("testName", new BigDecimal(1), "testCategory", "testCountry", LocalDate.now(), "testTags", "testDescription");
//        Product testInvalidProduct = null;
//        ProductDAOImpl productDAO = new ProductDAOImpl();
       int id = -1;
//        id = productDAO.createProduct(testInvalidProduct);
//        assertEquals(id, -1);
        id = -1;
        id = productDAO.createProduct(testProduct);                   //test metody createProduct z poprawnymi danymi
        assertTrue(id != -1);
        Product productFromDB = null;
        productFromDB = productDAO.readProductById(id);               //test metody readProductById dla id istniejacego obiektu
        assertNotNull(productFromDB);
        productFromDB = productDAO.readProductById(-1);     //test metody readProductById dla id nieistniejacego obiektu
        assertNull(productFromDB);
        productDAO.deleteProductById(id);                             //test metody deleteProductById dla istniejacego obiektu
        productFromDB = productDAO.readProductById(id);
        assertNull(productFromDB);
        productDAO.deleteProductById(-1);                   //test metody deleteProductById dla nieistniejacego obiektu
    }


    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class) // w tym tescie oczekuje ze wyrzuci mi exception
    public void when_PutWrongIdWhenDelete_Then_GetException() {
        //given
        Integer id = productDAO.createProduct(getProduct());
        //when
        productDAO.deleteProductById(id+1);

    }

    @Test() // w tym tescie oczekuje ze wyrzuci mi exception
    public void when_PutTrueIdWhenDelete_Then_GetException() {
        //given
        Integer id = productDAO.createProduct(getProduct());
        //when
        productDAO.deleteProductById(id);
    }

    @Test
    public void when_ProductNull_Then_GiveIndexMinusOne(){
        Product testInvalidProduct = null;
        ProductDAOImpl productDAO = new ProductDAOImpl();
        int id = -1;
        id = productDAO.createProduct(testInvalidProduct);
        assertEquals(id, -1);
    }

}

