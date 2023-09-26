public class PaymentDao {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);

    private final Session session;

    public PaymentDao(Session session) {
        this.session = session;
    }

    /**
     * Saves payment in the database.
     * @param payment the payment to save
     * @throws IllegalArgumentException if payment is null
     */
    public void save(Payment payment) {

    }

    /**
     * Updates payment in the database
     * @param payment
     */
    public void update(Payment payment) {
    }

    public Payment get(String id) {
    }

    public void delete(Payment payment) {
    }
}