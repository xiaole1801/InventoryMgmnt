package models;

import java.util.Arrays;
import java.util.Date;

public class OSleUserView {
	public String getOSleID() {
		return OSleID;
	}
	public void setOSleID(String oSleID) {
		OSleID = oSleID;
	}
	public String getCourierCompany() {
		return CourierCompany;
	}
	public void setCourierCompany(String courierCompany) {
		CourierCompany = courierCompany;
	}
	public String getPickupPerson() {
		return PickupPerson;
	}
	public void setPickupPerson(String pickupPerson) {
		PickupPerson = pickupPerson;
	}
	public Date getPickupTime() {
		return PickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		PickupTime = pickupTime;
	}
	public String getTrackingNum() {
		return TrackingNum;
	}
	public void setTrackingNum(String trackingNum) {
		TrackingNum = trackingNum;
	}
	public String getInvID() {
		return InvID;
	}
	public void setInvID(String invID) {
		InvID = invID;
	}
	public String getPackEngID() {
		return PackEngID;
	}
	public void setPackEngID(String packEngID) {
		PackEngID = packEngID;
	}
	public Date getPackTime() {
		return PackTime;
	}
	public void setPackTime(Date packTime) {
		PackTime = packTime;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getRemark() {
    return Remark;
  }
  public void setRemark(String remark) {
    Remark = remark;
  }
	public Object[] toArray(){
		  return new Object[] {this.OSleID, this.UserName, this.UserID, this.PickupPerson,
				               this.CourierCompany, this.PickupTime, this.TrackingNum,
				               this.InvID, this.PackEngID, this.PackTime,this.Status};	
	}
	
	public Object[] toArray(int colums){
		  Object[] totalObj = new Object[] {this.OSleID, this.UserName, this.PackEngID, this.PackTime, this.PickupPerson, this.PickupTime,
	               this.CourierCompany,  this.TrackingNum,
	               this.Status};		
//		  return Arrays.copyOfRange(totalObj, 0, colums);
		  return totalObj;
	}
	public String[] getTilte(int colums){
		  String[] totalTitles =new String[]{"OSleID", "Pack Engineer",  "Pack Person ID", "Pack Time", "Pick Up Person", "Pick Up Time", "Express Company",
		               "Tracking Number", "Status"};
//			return Arrays.copyOfRange(totalTitles, 0, colums);
		  return totalTitles;
	}
	
	private String OSleID;
	private String CourierCompany;
	private String PickupPerson;
	private Date PickupTime;
	private String TrackingNum;
	private String InvID;
	private String PackEngID;
	private Date PackTime;
	private String Status;
	private String UserID;
	private String UserName;
	private String Remark;
  
}
