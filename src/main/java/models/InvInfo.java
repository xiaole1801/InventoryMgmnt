package models;

import java.util.Date;

public class InvInfo {
	private String InvID;
	private String ProjectNum;
	private String ProjectManageID;
	private String ClientProductNum;
    private String CreatEngID;
    private Date CreatTime;
    private String CheckInEngID;
    private Date CheckInTime;
    private String StorageID;
    private String CheckOutEngID;
    private Date CheckOutTime;
    private String ISleID;
    private String OSleID;
    private String Description;
    private String RADAR;
    private String SystemSN;
    private String ConfigNum;
    private String Vendor;
    private String ProjectStatus;
    private String SecurityStatus;
    private String StorageStatus;
    private String VerificationStatus;
 
    public InvInfo() {
    }
    public InvInfo(String id) {
        this.setInvID(id);
    }

	public String getInvID() {
		return InvID;
	}

	public void setInvID(String invID) {
		InvID = invID;
	}

	public String getProjectNum() {
		return ProjectNum;
	}

	public void setProjectNum(String projectNum) {
		ProjectNum = projectNum;
	}

	public String getProjectManageID() {
		return ProjectManageID;
	}

	public void setProjectManageID(String projectManageID) {
		ProjectManageID = projectManageID;
	}

	public String getClientProductNum() {
		return ClientProductNum;
	}

	public void setClientProductNum(String clientProductNum) {
		ClientProductNum = clientProductNum;
	}

	public String getCreatEngID() {
		return CreatEngID;
	}

	public void setCreatEngID(String creatEngID) {
		CreatEngID = creatEngID;
	}

	public Date getCreatTime() {
		return CreatTime;
	}

	public void setCreatTime(Date creatTime) {
		CreatTime = creatTime;
	}

	public String getCheckInEngID() {
		return CheckInEngID;
	}

	public void setCheckInEngID(String checkInEngID) {
		CheckInEngID = checkInEngID;
	}

	public Date getCheckInTime() {
		return CheckInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		CheckInTime = checkInTime;
	}

	public String getStorageID() {
		return StorageID;
	}

	public void setStorageID(String storageID) {
		StorageID = storageID;
	}

	public String getCheckOutEngID() {
		return CheckOutEngID;
	}

	public void setCheckOutEngID(String checkOutEngID) {
		CheckOutEngID = checkOutEngID;
	}

	public Date getCheckOutTime() {
		return CheckOutTime;
	}

	public void setCheckOutTime(Date checkOutTime) {
		CheckOutTime = checkOutTime;
	}

	public String getISleID() {
		return ISleID;
	}

	public void setISleID(String iSleID) {
		ISleID = iSleID;
	}

	public String getOSleID() {
		return OSleID;
	}

	public void setOSleID(String oSleID) {
		OSleID = oSleID;
	}


	public String getRADAR() {
		return RADAR;
	}

	public void setRADAR(String rADAR) {
		RADAR = rADAR;
	}

	public String getSystemSN() {
		return SystemSN;
	}

	public void setSystemSN(String systemSN) {
		SystemSN = systemSN;
	}

	public String getConfigNum() {
		return ConfigNum;
	}

	public void setConfigNum(String configNum) {
		ConfigNum = configNum;
	}

	public String getVendor() {
		return Vendor;
	}

	public void setVendor(String vendor) {
		Vendor = vendor;
	}

	public String getProjectStatus() {
		return ProjectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		ProjectStatus = projectStatus;
	}

	public String getSecurityStatus() {
		return SecurityStatus;
	}

	public void setSecurityStatus(String securityStatus) {
		SecurityStatus = securityStatus;
	}

	public String getStorageStatus() {
		return StorageStatus;
	}

	public void setStorageStatus(String storageStatus) {
		StorageStatus = storageStatus;
	}

	public String getVerificationStatus() {
		return VerificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		VerificationStatus = verificationStatus;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
    
}
