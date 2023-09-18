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
    public void update(Payment payment) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(payment);
            transaction.commit();
            logger.info("Payment updated successfully");
        } catch (Exception e) {
            logger.error("Failed to update payment: " + e.getMessage());
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
   * Retrieves the payment from the database.
   *
   * @return payment the payment or null
   */
    public void delete(Payment payment) {
        try {
            session.delete(payment);
        } catch (HibernateException e) {
            logger.error("Error occurred while deleting Payment with id {}: {}", payment.getId(), e.getMessage());
            throw new RuntimeException("Error occurred while deleting Payment with id " + payment.getId(), e);
        }
    }

  /**
   * Deletes the payment from the database.
   *
   * @param payment payment to save
   */
  public void delete(Payment payment) {
  }
}