package magda;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.math.BigDecimal;

public class ProductDAOImpl implements ProductDAO {


    @Override
    public Integer createProduct(Product product) {
        if(product == null)
            return -1;
        try (Session session = Connection.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(product);
            System.out.println("Product is created  with Id::" + id);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Product readProductById(int productId) {
        Product product = null;
        try (Session session = Connection.getSessionFactory().openSession()) {

            product = session.get(Product.class, productId);
            if (product != null) {
                return product;
            } else {
                System.out.println("Product doesn't exist with provideded Id..");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProductById(int employeeId, String name, BigDecimal price) {
        try (Session session = Connection.getSessionFactory().openSession()) {

            Product product = session.get(Product.class, employeeId);
            if (product != null) {
                product.setName(name);
                product.setPrice(price);
                session.beginTransaction();
                session.update(product);
                session.getTransaction().commit();
            } else {
                System.out.println("Product doesn't exist with provideded Id..");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProductById(Integer productId) {

        try (Session session = Connection.getSessionFactory().openSession()) {
            Product pr = session.get(Product.class, productId);
            if (pr != null) {
                session.beginTransaction();

                session.delete(pr);
                session.getTransaction().commit();
            } else {
                throw new IllegalArgumentException("Product not exist with provided id.");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

}