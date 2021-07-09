import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date5 {

	public static void main(String[] args) {
		Calendar login = Calendar.getInstance();
		login.add(Calendar.MINUTE, 10);
		System.out.println(login.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-EEEE HH:mm:ss");
		System.out.println(sdf.format(login.getTime()));
	}

}
