

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SendLogCronTrriger {
	private String timer;//크론식
	private Class<? extends Job> job;
	private Scheduler scheduler;

	public SendLogCronTrriger(String timer, Class<? extends Job> job) {
		this.timer = timer;
		this.job = job;
	}
	//스케줄러에 등록
	public void triggerJob() {
		SchedulerFactory factory;
		
		JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(job.getName(), "group").build();
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group").
				withSchedule(CronScheduleBuilder.cronSchedule(timer)).build();
		
		factory = new  StdSchedulerFactory();
		try {
			scheduler = factory.getScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, cronTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
				
	}
	
}










