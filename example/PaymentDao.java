public class PaymentDao {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);
    
    private final Session session;

    public PaymentDao(Session session) {
        this.session = session;
    }

    /**
     * Persists the payment in the database.
     *
     * @param payment payment to save
     * @throws IllegalArgumentException if payment is null
     */
    public void save(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        
        try {
            session.beginTransaction();
            session.save(payment);
            session.getTransaction().commit();
            logger.info("Payment saved successfully");
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Failed to save payment", e);
            throw new RuntimeException("Failed to save payment", e);
        }
    }

    /**
     * Updates the payment in the database.
     *
     * @param payment payment to save
     */
    public void update(Payment payment) {
    }

    /**
     * Deletes the payment from the database.
     *
     * @param payment payment to save
     */
    public void delete(Payment payment) {
    }
}
