/**
 *
 * @author bethan
 */
public enum Priority {
    RESUSCITATION(0),
    EMERGENCY(120000),
    URGENT(300000),
    STANDARD(600000),
    TRIVIAL(900000);

    public final long maxTime;

    Priority(long maxTime) {
        this.maxTime = maxTime;
    }
}
