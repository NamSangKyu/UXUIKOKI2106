import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AutoDatePrintJob  implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//자동으로 일을 할 메서드
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss ");
		System.out.println(sdf.format(date));
	}
}
