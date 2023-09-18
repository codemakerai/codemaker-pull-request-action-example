public class PaymentDao {

  private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);

  private final Session session;
  
  public PaymentDao(Session session) {
      this.session = session;
  }

  public void save(Payment payment) {
  }

  public void update(Payment payment) {
  }

  public Payment get(String id) {
  }

  public void delete(Payment payment) {
  }
}
