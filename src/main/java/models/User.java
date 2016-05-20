package models;

import java.util.Arrays;

public class User {
	private String UserID;
	private String UserName;
	private String Password;
	private String Name;
	private int Level;

    public User() {
    }
    public User(String id) {
        this.UserID = id;
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
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public Object[] toArray(){
		return new Object[] {this.UserID,this.Name, this.UserName, this.Level};
	}
	public Object[] toArray(int colums){
		  Object[] totalObj = new Object[] {this.UserID,this.Name, this.UserName, this.Level};	
//		  return Arrays.copyOfRange(totalObj, 0, colums);
		  return totalObj;
	}
	public String[] getTilte(int colums){
		  String[] totalTitles =new String[]{"User ID", "Name",  "User Name", "User Role"};
//			return Arrays.copyOfRange(totalTitles, 0, colums);
		  return totalTitles;
	}
}
