import java.util.Calendar;
import java.util.Date;

public class Date4 {
	public static void main(String[] args) {
		Date date = new Date(1);
		System.out.println(date);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(1);
		System.out.println(cal.getTime());
		
		
	}
}
