import java.util.Calendar;

public class Date3 {

	public static void main(String[] args) {
		//D-Day 계산
		Calendar today = Calendar.getInstance();
		Calendar endOfDay = Calendar.getInstance();
		endOfDay.set(Calendar.MONTH, 11);//12월 설정
		endOfDay.set(Calendar.DAY_OF_MONTH, 31);//31일 설정
		long diff = endOfDay.getTimeInMillis() - today.getTimeInMillis(); 
		System.out.println(diff / (1000 * 60 * 60 * 24));
		
	}

}
