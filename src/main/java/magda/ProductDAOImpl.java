package magda;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.postgresql.jdbc4.Jdbc4Connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAOImpl implements ProductDAO {


    @Override
    public void createProduct(Product product) {

        try (Session session = Connection.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(product);
            System.out.println("Product is created  with Id::" + id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product readProductbyId(int productId) {
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
                System.out.println("Product doesn't exist with provideded Id..");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

}