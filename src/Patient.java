/**
 *
 * @author bethan
 */
public class Patient {
    private final int patientID;
    private final Priority priority;
    private final long arrivalTime;
    private boolean treated;
    private long treatmentTime;

    public Patient(int patientID, Priority priority, long arrivalTime) {
        this.patientID = patientID;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.treated = false;
    }

    public int getPatientID() {
        return patientID;
    }

    public Priority getPriority() {
        return priority;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public boolean isTreated() {
        return treated;
    }

    public void setTreated(boolean treated) {
        this.treated = treated;
    }

    public long getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(long treatmentTime) {
        this.treatmentTime = treatmentTime;
    }
}
