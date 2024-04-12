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

public class AttendProcessWithHeapTest {
    private AttendProcessWithHeap attendProcessWithHeap;
    private String filename = "testProcesos.txt";

    @Before
    public void setUp() throws IOException {
        attendProcessWithHeap = new AttendProcessWithHeap();

        // Create a test file with test processes
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("testProcess1,user1,-5\n");
        writer.write("testProcess2,user2,0\n");
        writer.write("testProcess3,user3,10\n");
        writer.close();
    }

    @Test
    public void testAttendProcess() {
        // Read the processes from the file
        attendProcessWithHeap.readProcesses(filename);

        // Capture the standard output to verify the process attendance order
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Attend to the processes
        attendProcessWithHeap.attendProcess();

        // Convert the captured output to a string and split it by new lines
        String[] lines = outContent.toString().split(System.lineSeparator());

        // Verify that the processes were attended to and the output has the expected number of lines
        Assert.assertEquals("Three processes should have been attended", 3, lines.length);

        // Example of checking the correct order and output format
        // The expected order should be based on the 'nice' values of your processes
        Assert.assertTrue("The process with the lowest nice value should be attended first", lines[0].contains("testProcess1,user1,-5,PR=95"));
        Assert.assertTrue("The process with the default nice value should be attended second", lines[1].contains("testProcess2,user2,0,PR=120"));
        Assert.assertTrue("The process with the highest nice value should be attended last", lines[2].contains("testProcess3,user3,10,PR=130"));
    }

    @After
    public void tearDown() {
        // Delete the test file
        new File(filename).delete();
        // Reset the standard output to prevent side effects in other tests
        System.setOut(System.out);
    }
}
