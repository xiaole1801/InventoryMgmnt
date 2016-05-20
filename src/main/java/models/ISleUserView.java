package models;

import java.util.Arrays;
import java.util.Date;

public class ISleUserView {
	    public ISleUserView(){
	    	
	    }
		public String getISleID() {
			return ISleID;
		}
		public void setISleID(String iSleID) {
			ISleID = iSleID;
		}
		public String getTransferEngID() {
			return TransferEngID;
		}
		public void setTransferEngID(String transferEngID) {
			TransferEngID = transferEngID;
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
		public String getCourierCompany() {
			return CourierCompany;
		}
		public void setCourierCompany(String courierCompany) {
			CourierCompany = courierCompany;
		}
		public String getDeliveryPerson() {
			return DeliveryPerson;
		}
		public void setDeliveryPerson(String deliveryPerson) {
			DeliveryPerson = deliveryPerson;
		}
		public String getTrackingNum() {
			return TrackingNum;
		}
		public void setTrackingNum(String trackingNum) {
			TrackingNum = trackingNum;
		}
		public Date getReceiptTime() {
			return ReceiptTime;
		}
		public void setReceiptTime(Date receiptTime) {
			ReceiptTime = receiptTime;
		}
		public Date getTransferTime() {
			return TransferTime;
		}
		public void setTransferTime(Date transferTime) {
			TransferTime = transferTime;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
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
			  return new Object[] {this.ISleID, this.UserName, this.UserID, this.TransferEngID,
					               this.CourierCompany, this.DeliveryPerson, this.TrackingNum,
					               this.ReceiptTime, this.TransferTime, this.Status};	
		}
		
		public Object[] toArray(int colums){
			  Object[] totalObj = new Object[] {this.ISleID,  this.TransferEngID, this.UserName,
		               this.CourierCompany, this.DeliveryPerson, this.TrackingNum,
		               this.ReceiptTime, this.TransferTime, this.Status};	
//			  return Arrays.copyOfRange(totalObj, 0, colums);
			  return totalObj;
		}
		public String[] getTilte(int colums){
			String[] totalTitles =  new String[]{"ISleID",  "Transfer Engineer ID", "Transfer Engineer Name", "Express Company",
		              "Delivery Person", "Tracking Number", "Receipt Time", "Transfer Time", "Status"};
//	         return Arrays.copyOfRange(totalTitles, 0, colums);
			return totalTitles;
	    }
		private String ISleID;
		private String TransferEngID;
		private String UserID;
		private String UserName;
		private String CourierCompany;
		private String DeliveryPerson;
		private String TrackingNum;
		private Date ReceiptTime;
		private Date TransferTime;
		private String Status;
		private String Remark;

}
