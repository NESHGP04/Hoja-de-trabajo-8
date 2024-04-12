public class FactoryAttends {
    
    public static final int HEAP_TYPE = 1;
    public static final int PRIORITY_QUEUE = 2;

    public static IAttendProcess getAttendingProcess(int fomarType){
        switch (fomarType) {
            case HEAP_TYPE:
                return new AttendProcessWithHeap();

            case PRIORITY_QUEUE:
                return new AttendProcessWithPriorityQueue();
            default:
                return new AttendProcessWithHeap();
        }
    }
}
