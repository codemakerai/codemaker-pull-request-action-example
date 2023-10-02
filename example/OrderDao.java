package ai.codemaker.demo.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {

    private final Session session;

    private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);

    /**
     * Constructor for OrderDao class.
     *
     * @param session The session to be used for the OrderDao.
     */
    public OrderDao(Session session) {
        this.session = session;
    }

    /**
     * Saves the given {@link Order} in the database.
     *
     * @param order the {@link Order} to save
     * @throws NullPointerException If the order object is null.
     * @throws HibernateException if an error occurs while saving the order
     */
    public void save(Order order) {
        checkNotNull(order, "Order cannot be null");
        
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            logger.info("Order saved successfully");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error occurred while saving order", e);
            throw e;
        }
    }

    /**
     * Updates the given Order object in the database.
     *
     * @param order The Order object to be updated.
     * @throws NullPointerException If the order object is null.
     * @throws HibernateException If an error occurs while updating the order.
     */
    public void update(Order order) {
        checkNotNull(order, "Order object cannot be null");

        try {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            logger.error("Error occurred while updating order: " + e.getMessage());
            session.getTransaction().rollback();
            throw e;
        }
    }

    /**
     * Retrives the {@link Order} from the database transactionally.
     *
     * @param orderId the {@link Order} to update
     * @throws NullPointerException If the orderId is null.
     * @throws HibernateException if an error occurs while saving the order
     */
    public void get(String orderId) {
        checkNotNull(orderId, "orderId cannot be null");

        try {
            session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            session.getTransaction().commit();
            return order;
        } catch (HibernateException e) {
            logger.error("Error retrieving order from database", e);
            throw e;
        }
    }

    /**
     * Deletes the given order from the database.
     *
     * @param order the order to be deleted
     * @throws NullPointerException if the order is null
     * @throws HibernateException if an error occurs while deleting the order
     */
    public void delete(Order order) {
        checkNotNull(order, "Order cannot be null");

        try {
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            logger.error("Error occurred while deleting order: {}", e.getMessage());
            session.getTransaction().rollback();
            throw e;
        }
    }
}
