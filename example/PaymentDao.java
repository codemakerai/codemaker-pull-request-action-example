public class PaymentDao {

  private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);

  private final Session session;
  
  public PaymentDao(Session session) {
      this.session = session;
  }

    public void save(Payment payment) {
        if(payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        
        try {
            session.beginTransaction();
            session.save(payment);
            session.getTransaction().commit();
            logger.info("Payment saved successfully.");
        } catch (Exception e) {
            logger.error("Failed to save payment: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }

  public void update(Payment payment) {
  }

  public Payment get(String id) {
  }

  public void delete(Payment payment) {
  }
}
