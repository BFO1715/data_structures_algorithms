/**
 *
 * @author bethan
 */
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class HospitalQueue {

    // Method to generate a report of the number of patients for each priority in the queue.
    public static Map<Priority, Integer> getQueueReport(List<Patient> patients) {
        Map<Priority, Integer> report = new EnumMap<>(Priority.class);
        
        for (Priority priority : Priority.values()) {
            report.put(priority, 0);
        }
        
        for (Patient patient : patients) {
            Priority priority = patient.getPriority();
            report.put(priority, report.get(priority) + 1);
        }
        
        return report;
    }

    // Method to determine the next patient to be treated based on the given rules.
    public static Patient getNextPatient(List<Patient> patients, long currentTime) {
        patients.sort(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                boolean p1Overdue = p1.getArrivalTime() + p1.getPriority().maxTime < currentTime;
                boolean p2Overdue = p2.getArrivalTime() + p2.getPriority().maxTime < currentTime;
                
                if (p1Overdue && p2Overdue) {
                    if (p1.getPriority() == p2.getPriority()) {
                        return Long.compare(p1.getArrivalTime(), p2.getArrivalTime());
                    }
                    return p1.getPriority().compareTo(p2.getPriority());
                }
                
                if (p1Overdue) {
                    return -1;
                }
                
                if (p2Overdue) {
                    return 1;
                }
                
                if (p1.getPriority() == p2.getPriority()) {
                    return Long.compare(p1.getArrivalTime(), p2.getArrivalTime());
                }
                
                return p1.getPriority().compareTo(p2.getPriority());
            }
        });
        
        return patients.get(0);
    }

    // Method to calculate the percentage of patients seen on time, excluding those requiring resuscitation.
    public static double pctSeenOntime(List<Patient> patients) {
        int totalPatients = 0;
        int seenOnTime = 0;

        for (Patient patient : patients) {
            if (patient.getPriority() == Priority.RESUSCITATION) {
                continue;
            }
            totalPatients++;
            if (patient.getTreatmentTime() <= patient.getArrivalTime() + patient.getPriority().maxTime) {
                seenOnTime++;
            }
        }

        return totalPatients == 0 ? 0 : (double) seenOnTime / totalPatients * 100;
    }

    // Method to calculate the average overwait time for treated patients, excluding those requiring resuscitation.
    public static double avgOverwaitTime(List<Patient> patients) {
        int count = 0;
        long totalOverwaitTime = 0;

        for (Patient patient : patients) {
            if (patient.getPriority() == Priority.RESUSCITATION) {
                continue;
            }
            long overwaitTime = patient.getTreatmentTime() - (patient.getArrivalTime() + patient.getPriority().maxTime);
            if (overwaitTime > 0) {
                totalOverwaitTime += overwaitTime;
                count++;
            }
        }

        return count == 0 ? 0 : (double) totalOverwaitTime / count / 60000; // converting milliseconds to minutes
    }
}
