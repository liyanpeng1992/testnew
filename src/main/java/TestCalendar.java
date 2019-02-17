import java.util.Calendar;
import java.util.Date;

public class TestCalendar {

    public static void main(String[] args) {

        int storageCycle =7;

        //获取当前日期并把时间设置为0时0分1秒
        Calendar calendar = Calendar.getInstance();


        System.out.println(calendar.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, -storageCycle);


        calendar.clear();
        calendar.set(Calendar.YEAR, 2018);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();



        System.out.println(calendar.getTime());
        System.out.println("Done");
    }

}
