/**
 * contendrá los datos del proceso.
 * Notar que esta clase debe implementar la interfaz comparable.
 * De esta forma se sabrá cual proceso debe ser atendido antes,
 * dependiendo de su prioridad (calculada de acuerdo al valor “nice” del proceso)
 */

   

 public class Process implements Comparable<Process> {
     private String processName;
     private String userName;
     private int niceValue;
 
     public Process(String processName, String userName, int niceValue) {
         this.processName = processName;
         this.userName = userName;
         this.niceValue = niceValue;
     }
 
     
     /** 
      * @return String
      */
     public String getProcessName() {
         return processName;
     }
 
     
     /** 
      * @param processName
      */
     public void setProcessName(String processName) {
         this.processName = processName;
     }
 
     
     /** 
      * @return String
      */
     public String getUserName() {
         return userName;
     }
 
     
     /** 
      * @param userName
      */
     public void setUserName(String userName) {
         this.userName = userName;
     }
 
     
     /** 
      * @return int
      */
     public int getNiceValue() {
         return niceValue;
     }
 
     
     /** 
      * @param niceValue
      */
     public void setNiceValue(int niceValue) {
         this.niceValue = niceValue;
     }
 
     
     /** 
      * @param other
      * @return int
      */
     @Override
     public int compareTo(Process other) {
         return Integer.compare(this.niceValue, other.niceValue);
     }
 
     
     /** 
      * @return String
      */
     @Override
     public String toString() {
         return "Process{" +
                 "processName='" + processName + '\'' +
                 ", userName='" + userName + '\'' +
                 ", niceValue=" + niceValue +
                 '}';
     }
 }
 
