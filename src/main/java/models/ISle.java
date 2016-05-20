package models;

import java.util.Date;

public class ISle {
	private String ISleID;
	private String CourierCompany;
	private String DeliveryPerson;
	private String TrackingNum;
	private Date ReceiptTime;
	private String TransferEngID;
	private Date TransferTime;
	private String Status;
	private String Remark;

    public ISle() {
    }
    public ISle(String id) {
        this.ISleID = id;
    }
    
	public String getISleID() {
		return ISleID;
	}

	public void setISleID(String iSleID) {
		ISleID = iSleID;
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

	public String getTransferEngID() {
		return TransferEngID;
	}

	public void setTransferEngID(String transferEngID) {
		TransferEngID = transferEngID;
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
	
	public String getRemark() {
    return Remark;
  }
  public void setRemark(String remark) {
    Remark = remark;
  }
  public Object[] toArray() {
	  return new Object[] {this.ISleID, this.CourierCompany, this.DeliveryPerson,this.TrackingNum, this.ReceiptTime, this.TransferEngID,this.TransferTime, this.Status};	
	}
	
}
