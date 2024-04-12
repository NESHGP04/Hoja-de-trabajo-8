import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.File;

public class AttendProcessWithPriorityQueueTest {
    private AttendProcessWithPriorityQueue attendProcessWithPriorityQueue;
    private String filename = "testProcesos.txt";

    @Before
    public void setUp() throws IOException {
        attendProcessWithPriorityQueue = new AttendProcessWithPriorityQueue();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("testProcess1,user1,-5\n");
        writer.write("testProcess2,user2,0\n");
        writer.write("testProcess3,user3,10\n");
        writer.close();
    }

    @Test
    public void testAttendProcess() {
        attendProcessWithPriorityQueue.readProcesses(filename);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        attendProcessWithPriorityQueue.attendProcess();

        String[] lines = outContent.toString().split(System.lineSeparator());
        
        // The actual line count should match the number of processes in the test file.
        Assert.assertEquals("Should have attended 3 processes", 3, lines.length);
        
        // If there's a specific order you expect, you'll have to modify this assertion.
        // For example, if you know the specific order, you can test for it explicitly.
        // Example: Assert.assertEquals("Expected first line of output", "expected output", lines[0]);
    }

    @After
    public void tearDown() {
        new File(filename).delete();
    }
}