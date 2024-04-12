import org.junit.Test;
import static org.junit.Assert.*;

public class ProcessTest {
    
    @Test
    public void testProcessComparisons() {
        Process p1 = new Process("process1", "user1", 10);
        Process p2 = new Process("process2", "user2", 20);
        Process p3 = new Process("process3", "user3", 10);
        
        assertTrue("p1 should be less than p2", p1.compareTo(p2) < 0);
        assertTrue("p2 should be greater than p1", p2.compareTo(p1) > 0);
        assertEquals("p1 and p3 should be equal", 0, p1.compareTo(p3));
    }
    
    @Test
    public void testGettersAndSetters() {
        Process p = new Process("initialName", "initialUser", 5);
        
        // Test getters
        assertEquals("initialName", p.getProcessName());
        assertEquals("initialUser", p.getUserName());
        assertEquals(5, p.getNiceValue());
        
        // Test setters
        p.setProcessName("newName");
        p.setUserName("newUser");
        p.setNiceValue(15);
        
        // Test getters after setting new values
        assertEquals("newName", p.getProcessName());
        assertEquals("newUser", p.getUserName());
        assertEquals(15, p.getNiceValue());
    }
    
    @Test
    public void testToString() {
        Process p = new Process("myProcess", "myUser", 10);
        String expectedString = "Process{processName='myProcess', userName='myUser', niceValue=10}";
        assertEquals(expectedString, p.toString());
    }
}
