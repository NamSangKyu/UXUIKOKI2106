
public class StartScheduler {

	public static void main(String[] args) {
		TestCronTrigger trigger = new TestCronTrigger("0 0/1 * * 1/1 ? *", AutoDatePrintJob.class);
		trigger.triggerJob();
	}

}
