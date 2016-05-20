package models;

import java.util.Arrays;
import java.util.Date;

public class InvUserView {
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

  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    Description = description;
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

  public String getCheckInEngUserName() {
    return CheckInEngUserName;
  }

  public void setCheckInEngUserName(String checkInEngUserName) {
    CheckInEngUserName = checkInEngUserName;
  }

  public String getCheckOutEngUserName() {
    return CheckOutEngUserName;
  }

  public void setCheckOutEngUserName(String checkOutEngUserName) {
    CheckOutEngUserName = checkOutEngUserName;
  }

  public String getCreatEngUserName() {
    return CreatEngUserName;
  }

  public void setCreatEngUserName(String creatEngUserName) {
    CreatEngUserName = creatEngUserName;
  }

//  public String getProjectManagerUserName() {
//    return ProjectManagerUserName;
//  }
//
//  public void setProjectManagerUserName(String projectManagerUserName) {
//    ProjectManagerUserName = projectManagerUserName;
//  }

  public String getStorageTag() {
    return StorageTag;
  }

  public void setStorageTag(String storageTag) {
    StorageTag = storageTag;
  }

  public Object[] toArray() {
    return new Object[] { this.InvID, this.ISleID, this.OSleID, this.CreatTime, this.CreatEngUserName, this.ProjectNum, this.ProjectManageID, this.ClientProductNum, this.CheckInEngUserName,
        this.CheckInTime, this.CheckOutEngUserName, this.CheckOutTime, this.StorageID, this.Description, this.RADAR, this.SystemSN, this.ConfigNum, this.Vendor, this.ProjectStatus,
        this.SecurityStatus, this.StorageStatus, this.VerificationStatus };
  }

  public Object[] toCheckInArray() {
    return new Object[] { this.InvID, this.CreatEngUserName, this.ProjectNum, this.CheckInEngUserName, this.CheckInTime, this.StorageTag };
  }

  public String[] getCheckInTilte() {
    String[] totalTitles = new String[] { "Inventory ID", "Create Engineer Name", "Project Number", "Checkin Engineer Name", "Checkin Time", "Locker Tag" };
    return totalTitles;
  }

  public Object[] toCheckOutArray() {
    return new Object[] { this.InvID, this.CreatEngUserName, this.ProjectNum, this.CheckOutEngUserName, this.CheckOutTime, };
  }

  public String[] getCheckOutTilte() {
    String[] totalTitles = new String[] { "Inventory ID", "Create Engineer Name", "Project Number", "Checkout Engineer Name", "Checkout Time", };
    return totalTitles;
  }

//  public Object[] toArray(int colums) {
//    Object[] totalObj = new Object[] { this.InvID, this.ISleID, this.OSleID, this.CreatTime, this.CreatEngUserName, this.ProjectNum, this.ProjectManagerUserName, this.ClientProductNum,
//        this.CheckInEngUserName, this.CheckInTime, this.CheckOutEngUserName, this.CheckOutTime, this.StorageID, this.Description, this.RADAR, this.SystemSN, this.ConfigNum, this.Vendor,
//        this.ProjectStatus, this.SecurityStatus, this.StorageStatus, this.VerificationStatus };
//    return Arrays.copyOfRange(totalObj, 0, colums);
//  }
//
//  public String[] getTilte(int colums) {
//    String[] totalTitles = new String[] { "Inventory ID", "ISleID", "OSleID", "Create Time", "Create Engineer Name", "Project Number", "Project Mananger Name", "Client Project Number",
//        "Checkin Engineer Name", "Checkin Time", "Checkout Engineer Name", "Checkout Time", "Storage ID", "Description", "RADAR", "System SN", "Configure Number", "Vendor", "Poject Status",
//        "Security Status", "Storage Status", "Verification Status" };
//    return Arrays.copyOfRange(totalTitles, 0, colums);
//  }
  public Object[] toArray(int level) {
    Object[] totalObj = null;
    switch (level) {
    case 0:
      totalObj = new Object[] { this.InvID, this.ISleID, this.OSleID, this.CreatTime, this.CreatEngUserName};
      break;
    default:
      totalObj = new Object[] { this.InvID, this.ISleID, this.OSleID, this.CreatTime, this.CreatEngUserName, this.ProjectNum, this.ProjectManageID,  this.ClientProductNum,
          this.CheckInEngUserName, this.CheckInTime, this.CheckOutEngUserName, this.CheckOutTime, this.StorageTag, this.Description, this.RADAR, this.SystemSN, this.ConfigNum, this.Vendor,
          this.ProjectStatus, this.SecurityStatus, this.StorageStatus, this.VerificationStatus };
      break;
    }
//    return Arrays.copyOfRange(totalObj, 0, colums);
    return totalObj;
  }

  public String[] getTilte(int level) {
    String[] totalTitles = null;
    switch (level) {
    case 0:
      totalTitles = new String[] { "Inventory ID", "Shipping In ID", "Shipping Out ID", "Create Time", "Create Engineer Name" };
      break;
    default:
      totalTitles = new String[] { "Inventory ID", "ISleID", "OSleID", "Create Time", "Create Engineer Name", "Project Number", "Project Manager Name", "Client Project Number",
          "Checkin Engineer Name", "Checkin Time", "Checkout Engineer Name", "Checkout Time", "Locker", "Description", "RADAR", "System SN", "Configure Number", "Vendor", "Poject Status",
          "Security Status", "Storage Status", "Verification Status" };
      break;
    }
//    return Arrays.copyOfRange(totalTitles, 0, colums);
    return totalTitles;
  }
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
  private String CheckInEngUserName;
  private String CheckOutEngUserName;
  private String CreatEngUserName;
//  private String ProjectManagerUserName;
  private String StorageTag;

}
