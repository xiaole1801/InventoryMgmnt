package util;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Calendar;

import models.AlarmInfo;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import db.HibernateUtil;

public class BackgroundTasks{
	private static Scheduler sched1;
	private static Scheduler sched2;
	private AlarmInfo alarm;
	
	
	public void start(){
		alarm = (AlarmInfo)HibernateUtil.findById(AlarmInfo.class, "warn");
		if (alarm ==null)
			return;

		try {
			if (sched1!=null)
				stop();
			SchedulerFactory sf1 = new StdSchedulerFactory();
			SchedulerFactory sf2 = new StdSchedulerFactory();
			sched1 = sf1.getScheduler();
			sched2 = sf2.getScheduler();
			
			schedulerStart();
		} catch (Exception e) {
			stop();

		}
	}
	
	public void stop(){
		try {
			sched1.shutdown(true);
			sched2.shutdown(true);
		} catch (SchedulerException e) {
		}
	}
	
	private void schedulerStart() throws Exception{
		
		JobDetail job1 = newJob(CheckInvStatusJob.class).withIdentity("job1", "group1").build();

        Calendar cal = Calendar.getInstance();
        cal.setTime(alarm.getAlarmTime());//date 换成已经已知的Date对象


        System.out.println(alarm.getAlarmTime()+"  "+cal.get(Calendar.SECOND)+"  "+cal.get(Calendar.MINUTE));
		
        String timerule = cal.get(Calendar.SECOND)+" "+cal.get(Calendar.MINUTE)+" "+cal.get(Calendar.HOUR_OF_DAY)+" ? * MON-FRI";
        System.out.println(timerule);
		Trigger trigger1 = newTrigger().withIdentity("trigger1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule(timerule)).build();

		sched1.scheduleJob(job1, trigger1);
		sched1.start();

		
		JobDetail job2 = newJob(ClearInvStatusJob.class).withIdentity("job2", "group2").build();

		Trigger trigger2 = newTrigger().withIdentity("trigger2", "group2")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0 8 ? * MON-FRI")).build();

		sched2.scheduleJob(job2, trigger2);
		sched2.start();
	}
}