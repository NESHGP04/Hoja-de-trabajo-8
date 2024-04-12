import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AttendProcessWithPriorityQueueTest {

    @Test
    public void testAttendProcess() throws IOException {
        // Crear un archivo de prueba con algunos procesos
        File file = new File("testProcesses.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Process1,User1,10\n");
        bw.write("Process2,User2,5\n");
        bw.write("Process3,User3,15\n");
        bw.close();

        // Crear una instancia de AttendProcessWithPriorityQueue y leer los procesos desde el archivo
        AttendProcessWithPriorityQueue apwpq = new AttendProcessWithPriorityQueue();
        apwpq.readProcesses("testProcesses.txt");
        apwpq.attendProcess();
    }
}
