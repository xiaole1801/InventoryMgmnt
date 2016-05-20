package models;

import java.util.Date;

public class OSle {
	private String OSleID;
	private String CourierCompany;
	private String PickupPerson;
	private Date PickupTime;
	private String TrackingNum;
	private String InvID;
	private String PackEngID;
	private Date PackTime;
	private String Status;
	private String Remark;

    public OSle() {
    }
    public OSle(String id) {
        this.setOSleID(id);
    }

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
  public String getRemark() {
    return Remark;
  }
  public void setRemark(String remark) {
    Remark = remark;
  }
	
}
