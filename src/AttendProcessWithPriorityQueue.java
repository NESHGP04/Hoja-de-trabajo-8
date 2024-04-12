/**
 * MAIN
 */

   

 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.Comparator;
 import java.util.PriorityQueue;
 
 public class AttendProcessWithPriorityQueue implements IAttendProcess {
    private PriorityQueue<Process> processQueue;

    public AttendProcessWithPriorityQueue() {
        Comparator<Process> priorityComparator = (p1, p2) -> Integer.compare(p1.getNiceValue(), p2.getNiceValue());
        this.processQueue = new PriorityQueue<>(priorityComparator);
    }

    
    /** 
     * @param filename
     */
    @Override
    public void readProcesses(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String processName = parts[0];
                String userName = parts[1];
                int niceValue = Integer.parseInt(parts[2]);
                Process process = new Process(processName, userName, niceValue);
                processQueue.add(process); // Add the Process object to the queue
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
 
    @Override
    public void attendProcess() {
        while (!processQueue.isEmpty()) {
            Process process = processQueue.poll(); // This should retrieve and remove the head of the queue
            if (process != null) {
                int calculatedPriority = 20 + process.getNiceValue();
                calculatedPriority+=100;
                System.out.println(process.getProcessName() + "," + process.getUserName() + "," + process.getNiceValue() + ",PR=" + calculatedPriority);
            }
        }
    }
 }
 



