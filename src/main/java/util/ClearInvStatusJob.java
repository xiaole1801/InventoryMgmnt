package util;

import java.util.List;

import models.InvInfo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import db.HibernateUtil;

public class ClearInvStatusJob implements Job {

    @SuppressWarnings("unchecked")
	public void execute(JobExecutionContext context)
        throws JobExecutionException {
		String sqlStr = "select * from inv.InvInfo";
		List<InvInfo> invlist= HibernateUtil.queryBySql(InvInfo.class, sqlStr);	
		if (invlist.size()>0)
		{
			for(int i =0; i<invlist.size();i++)
			{
				invlist.get(i).setVerificationStatus("unverified");
				HibernateUtil.update(invlist.get(i));				
			}			
		}   	
        System.out.println("clear inv status");
        
    }
}