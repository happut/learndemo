import org.quartz.CronExpression;

import java.text.ParseException;
import java.util.Date;

public class Test3 {
    public static void main(String[] args) throws ParseException {
        CronExpression cronExpression = new CronExpression("0 */10 * * * ?");

        Date d = new Date();
        for (int i = 0; i < 5; i++) {
            d = cronExpression.getNextValidTimeAfter(d);
            System.out.println(d);
        }



    }
}
