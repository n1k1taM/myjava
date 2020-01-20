package by.etc.introdaction.classes;

public class ExampleOperationWithTime {
    public static void main(String[] args) {

        OperationsWithTime time=new OperationsWithTime(23,55,58);
        time.showTime();
        time.addHours(2);
        time.showTime();
        time.addSeconds(2);
        time.showTime();
        time.addSeconds(250);
        time.showTime();

        OperationsWithTime time2= new OperationsWithTime(5,2,3);
        time2.showTime();
        time2.subtractSeconds(64);
        time2.showTime();
    }
}
