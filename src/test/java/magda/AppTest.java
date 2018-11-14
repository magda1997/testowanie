package magda;

import static magda.ProductUtils.getProduct;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }



    @Test
    public void when_PutWrongIdWhenDelete_Then_GetException(){
        new ProductDAOImpl().createProduct(getProduct());



    }

}
