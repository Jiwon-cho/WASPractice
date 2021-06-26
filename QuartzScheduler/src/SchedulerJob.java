import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerJob {
	static SchedulerFactory factory = new StdSchedulerFactory();
	static  Scheduler scheduler;
	
	public static void main(String[] args) throws Exception{
		scheduler = factory.getScheduler();
		simpleTriggerTest();
	}
	public static void simpleTriggerTest() throws SchedulerException {
		JobDetail job = createJobDetail("myJob", "myGroup");
		Trigger trigger = createSimpleTrigger("mySimpleTrigger", "myGroup", 1);
		
		putSchduleJob(job, trigger);
		//스케쥴러 시작
		start();
		//Test Sleep
		testSleep(1000 * 5);
		//스케쥴러 종료
		stop(true);
	}
	
	
	private  static void stop(boolean waitForJobsToComplete) throws SchedulerException {
		scheduler.shutdown(waitForJobsToComplete);
	}

	private static void start() throws SchedulerException {
		scheduler.start();
	}

	private static void putSchduleJob(JobDetail job, Trigger trigger) throws SchedulerException {
		scheduler.scheduleJob(job, trigger);
	}

	private static SimpleTrigger createSimpleTrigger(String triggerName, String triggerGroup, int intervalTime) {
		return TriggerBuilder.newTrigger()
							.withIdentity(triggerName, triggerGroup)
							.withSchedule(SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(intervalTime)
								.repeatForever())
							.build();
	}
	
	private static CronTrigger createCronTrigger(String triggerName, String triggerGroup, String cronTime) throws Exception{
		CronExpression cronExpression = new CronExpression(cronTime);
		return TriggerBuilder.newTrigger()
				.withIdentity(triggerName, triggerGroup)
				.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
				.build();
	}

	private static JobDetail createJobDetail(String jobName, String jobGroup) {
		return JobBuilder.newJob(SimpleJob.class)
						.withIdentity(jobName, jobGroup)
						.build();
	}
	
	private static void testSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class SimpleJob implements Job{
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("test");
	}
}

