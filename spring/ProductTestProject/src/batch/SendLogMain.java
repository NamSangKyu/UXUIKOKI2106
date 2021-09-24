package batch;

public class SendLogMain {

	public static void main(String[] args) {
		SendLogCronTrriger trriger = new SendLogCronTrriger("5 * * * * ?", SendLogJob.class);
		trriger.triggerJob();
	}

}
