package util;

import java.util.List;

import mail.MailSenderInfo;
import mail.SimpleMailSender;
import models.InvInfo;
import models.User;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import db.HibernateUtil;
import models.AlarmInfo;

public class CheckInvStatusJob implements Job {



	@SuppressWarnings("unchecked")
    public void execute(JobExecutionContext context)
        throws JobExecutionException {
		System.out.println("  checked ");
		String sqlStr = "select * from inv.InvInfo where VerificationStatus = 'unverified'";
		AlarmInfo alarm = (AlarmInfo)HibernateUtil.findById(AlarmInfo.class, "warn");
		if (alarm ==null)
			return;
		
		System.out.println("  checked ");
		List<InvInfo> invlist= HibernateUtil.queryBySql(InvInfo.class, sqlStr);	
		if (invlist.size()>0) {
			
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost("smtp.163.com");
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			  
			// 邮箱用户名
			mailInfo.setUserName("inventory_info@163.com");
			// 邮箱密码
			mailInfo.setPassword("20150703");
			// 发件人邮箱
			mailInfo.setFromAddress("inventory_info@163.com");
			// 收件人邮箱
			mailInfo.setToAddress(alarm.getDesMailAdd());
			// 邮件标题
			mailInfo.setSubject("Some items lost!");
			// 邮件内容
			StringBuffer buffer = new StringBuffer();
			buffer.append("the following items have not been verified today:");
			for(int i =0; i<invlist.size();i++) {
				User user = (User)HibernateUtil.findById(User.class, invlist.get(i).getCheckOutEngID());
				buffer.append("itme"+i+": "+invlist.get(i).getInvID()+"   "+user.getName());
			}
			mailInfo.setContent(buffer.toString());
			
			// 发送html格式
			SimpleMailSender.sendHtmlMail(mailInfo);
			System.out.println("邮件发送完毕");
		}				
	}

}