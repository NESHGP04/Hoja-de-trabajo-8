/**
 * MAIN
 */

import java.util.*;

public class ChichicasteLinux {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n<<CHICHICASTELINUX>>");
        System.out.println("Elija si quiere ordenar con Heap(1) o Priority Queue(2)");
        int opc = sc.nextInt();

        IAttendProcess attendProcess = FactoryAttends.getAttendingProcess(opc);
        attendProcess.readProcesses("procesos.txt");
        attendProcess.attendProcess();
        
        sc.close();
    }
}



