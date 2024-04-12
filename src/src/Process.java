/**
 * contendrá los datos del proceso.
 * Notar que esta clase debe implementar la interfaz comparable.
 * De esta forma se sabrá cual proceso debe ser atendido antes,
 * dependiendo de su prioridad (calculada de acuerdo al valor “nice” del proceso)
 */

 package src;

 public class Process implements Comparable<Process> {
     private String processName;
     private String userName;
     private int niceValue;
 
     public Process(String processName, String userName, int niceValue) {
         this.processName = processName;
         this.userName = userName;
         this.niceValue = niceValue;
     }
 
     public String getProcessName() {
         return processName;
     }
 
     public void setProcessName(String processName) {
         this.processName = processName;
     }
 
     public String getUserName() {
         return userName;
     }
 
     public void setUserName(String userName) {
         this.userName = userName;
     }
 
     public int getNiceValue() {
         return niceValue;
     }
 
     public void setNiceValue(int niceValue) {
         this.niceValue = niceValue;
     }
 
     @Override
     public int compareTo(Process other) {
         return Integer.compare(this.niceValue, other.niceValue);
     }
 
     @Override
     public String toString() {
         return "Process{" +
                 "processName='" + processName + '\'' +
                 ", userName='" + userName + '\'' +
                 ", niceValue=" + niceValue +
                 '}';
     }
 }
 
