/**
 * MAIN
 */

  

public class ChichicasteLinux {

    public static void main(String[] args) {
        AttendProcessWithHeap system = new AttendProcessWithHeap();
        AttendProcessWithPriorityQueue system2 = new AttendProcessWithPriorityQueue();
        system.readProcesses("procesos.txt"); 
        system.attendProcess(); 

        system2.readProcesses("procesos.txt");
        system2.attendProcess(); 
    }
}



