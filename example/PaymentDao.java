public class PaymentDao {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);

    private final Session session;

    public PaymentDao(Session session) {
        this.session = session;
    }

    /**
     * Saves the given {@link Payment} in the database.
     *
     * @param payment the {@link Payment} to save
     * @throws HibernateException if an error occurs while saving the payment
     */
    public void save(Payment payment) {

    }

    /**
     * Updates the given Payment object in the database.
     *
     * @param payment The Payment object to be updated.
     * @throws HibernateException If an error occurs while updating the payment.
     */
    public void update(Payment payment) {
    }

    /**
     * Retrives the {@link Payment} from the database transactionally.
     *
     * @param paymentId the {@link Payment} to update
     * @throws HibernateException if an error occurs while saving the payment
     */
    public Payment get(String id) {
    }

    /**
     * Deletes the given {@link Payment} to the database.
     *
     * @param payment the {@link Payment} to update
     * @throws HibernateException if an error occurs while saving the payment
     */
    public void delete(Payment payment) {
    }
}