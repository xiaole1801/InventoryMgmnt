package models;

import java.util.Date;

public class AlarmInfo {
	private String UsageID;
	private String desMailAdd;
	private Date alarmTime;
	public String getDesMailAdd() {
		return desMailAdd;
	}
	public void setDesMailAdd(String desMailAdd) {
		this.desMailAdd = desMailAdd;
	}
	public Date getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getUsageID() {
		return UsageID;
	}
	public void setUsageID(String usageID) {
		UsageID = usageID;
	}

}
