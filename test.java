import java.time.LocalDate;

public class test {

    public static void main(String[] args) {
        LocalDate testDate = LocalDate.now();
        Calendar test = new Calendar();
        test.addEvent(testDate, "teste1");
        test.addEvent(testDate, "teste2");
        test.addEvent(testDate, "teste3");
        test.removeOneString(testDate);
        System.out.println(test.hasEvents(testDate));
        System.out.print(test.getEvents(testDate).toString());
    }

}
