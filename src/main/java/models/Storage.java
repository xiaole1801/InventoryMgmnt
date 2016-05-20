package models;

import java.util.Arrays;

public class Storage {
	private String StorageID;
	private String StorageTag;
	public String getStorageTag() {
		return StorageTag;
	}

	public void setStorageTag(String storageTag) {
		StorageTag = storageTag;
	}
	private String Description;
	private int TotalCapacity;
	private int RemainCapacity;

    public Storage() {
    }

    public Storage(String id) {
        this.setStorageID(id);
    }

	public String getStorageID() {
		return StorageID;
	}

	public void setStorageID(String storageID) {
		StorageID = storageID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getTotalCapacity() {
		return TotalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		TotalCapacity = totalCapacity;
	}

	public int getRemainCapacity() {
		return RemainCapacity;
	}

	public void setRemainCapacity(int remainCapacity) {
		RemainCapacity = remainCapacity;
	}
	public Object[] toArray() {
		return new Object[] {this.StorageID,this.TotalCapacity, this.RemainCapacity,this.Description};
	}
	public Object[] toArray(int colums){
		  Object[] totalObj = new Object[] {this.StorageID, this.StorageTag, this.TotalCapacity, this.RemainCapacity,this.Description};	
//		  return Arrays.copyOfRange(totalObj, 0, colums);
		  return totalObj;
	}
	public String[] getTilte(int colums){
		  String[] totalTitles =new String[]{"Locker ID","Locker Tag", "Total Capacity",  "Remain Capacity", "Description"};
//			return Arrays.copyOfRange(totalTitles, 0, colums);
		  return totalTitles;
	  }
}
