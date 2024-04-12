/**
 * MAIN
 */

package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class AttendProcessWithHeap implements IAttendProcess{
    private HeapUsingIterativeBinaryTree<Integer, Process> processHeap;

    public AttendProcessWithHeap() {
        Comparator<Integer> priorityComparator = new ComparadorNumeros<>();
        this.processHeap = new HeapUsingIterativeBinaryTree<>(priorityComparator);
    }

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
                processHeap.Insert(niceValue, process);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    @Override
    public void attendProcess() {
        while (!processHeap.isEmpty()) {
            Process process = processHeap.remove();
            if (process != null) {
                int calculatedPriority = 20 + process.getNiceValue(); // PR = 20 + NI
                calculatedPriority += 100;
                System.out.println(process.getProcessName() + "," + process.getUserName() + "," + process.getNiceValue() + ",PR=" + calculatedPriority);
            }
        }
    }
}



