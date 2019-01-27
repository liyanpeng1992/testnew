import java.util.Calendar;
import java.util.Date;

public class TestTime {
	public static void main(String[] args) {
		Calendar calEnd = Calendar.getInstance();
		calEnd.set(2018,0,1);
		System.out.println(calEnd.getTime());
		calEnd.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calEnd.getTime());
	}

}
