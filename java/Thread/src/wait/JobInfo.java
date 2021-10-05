package wait;

public class JobInfo {
	private static JobInfo instance = new JobInfo();
	private String jobInfo;
	
	private JobInfo() {
		jobInfo = null;
	}

	public static JobInfo getInstance() {
		if(instance == null)
			instance = new JobInfo();
		return instance;
	}

	public synchronized void writeJob(String msg) {
		jobInfo = msg;
		notifyAll();
	}

	public synchronized String getJobInfo() throws InterruptedException {
		String msg=null;
		if(jobInfo==null)
			wait();
		
		msg =jobInfo;
		jobInfo = null;
		notify();
		
		return msg;
	}

}




