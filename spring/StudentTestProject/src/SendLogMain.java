

public class SendLogMain {

	public static void main(String[] args) {
		SendLogCronTrriger trriger = new SendLogCronTrriger("0 0 0 1/1 * ? *", SendLogJob.class);
		trriger.triggerJob();
	}

}
