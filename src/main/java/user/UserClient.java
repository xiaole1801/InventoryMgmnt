package user;

import init.main;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import ui.model.TableModel;
import models.ISle;
import models.ISleUserView;
import models.InvInfo;
import models.InvUserView;
import models.OSle;
import models.OSleUserView;
import models.Storage;
import models.User;
import db.HibernateUtil;
  
  public class UserClient {
	  private String userId;
	  private String userName;
	  private String password;
	  private int userLevel;
	  
     public String getUserName() {
		  
		  return userName;
	  }
	  
	  
	  public UserClient(String userName, String password){
		  this.userName = userName;
		  this.password = password;
	  }
	  
	  public boolean validateUser(){
		  userId = getUserID();
		  if (userId == null){
			  return false;
		  }
		  return true;
	  }
  
  
  public String getUserID() {
	  String sqlStr = "select * from inv.USER where USERNAME = '"+userName+"' and PASSWORD = '"+password+"'";
	  List<User> userIDSet = (List<User>)HibernateUtil.queryBySql(User.class, sqlStr);
//	  List<String> userIDSet = (List<String>)HibernateUtil.queryBySql(userObj, sqlStr);
      return userIDSet.size() != 0 ? userIDSet.get(0).getUserID():null;	  
  }
  
  public String getUser() {
    String sqlStr = "select * from inv.USER where USERNAME = '"+userName+"' and PASSWORD = '"+password+"'";
    List<User> userIDSet = (List<User>)HibernateUtil.queryBySql(User.class, sqlStr);
//    List<String> userIDSet = (List<String>)HibernateUtil.queryBySql(userObj, sqlStr);
      return userIDSet.size() != 0 ? userIDSet.get(0).getName():null;   
  }
  
  public int getUserLevel() {
	  String sqlStr = "select * from inv.USER where USERNAME = '"+userName+"'  and PASSWORD = '"+password+"'";
	  List<User> userIDSet = (List<User>)HibernateUtil.queryBySql(User.class, sqlStr);
      this.userLevel = userIDSet.size() != 0 ? userIDSet.get(0).getLevel():0;	  
      return this.userLevel;
  }
  
  @SuppressWarnings("unchecked")
  public List<ISleUserView> getISleUserInfo (){
	  String sqlStr = "select * from inv.isle_view order by RECEIPTTIME DESC";
	  return HibernateUtil.queryBySql(ISleUserView.class, sqlStr);
  }
  
  @SuppressWarnings("unchecked")
  public List<OSleUserView> getOSleUserInfo (){
	  String sqlStr = "select * from inv.osle_view order by PICKUPTIME DESC";
	  return HibernateUtil.queryBySql(OSleUserView.class, sqlStr);
  }
  
  @SuppressWarnings("unchecked")
  public List<InvUserView> getInvUserInfo (){
	  String sqlStr = "select * from inv.inv_view order by CREATTIME DESC";
	  return HibernateUtil.queryBySql(InvUserView.class, sqlStr);
  }
  public List<InvUserView> getInvUserInfo (String sql){
    String sqlStr = "select * from inv.inv_view where "+sql+" order by CREATTIME DESC";
    System.err.println(sqlStr);
    return HibernateUtil.queryBySql(InvUserView.class, sqlStr);
  }
  
  
  
  @SuppressWarnings("unchecked")
  public List<Storage> getStorageInfo (){
	  String sqlStr = "select * from inv.storage";
	  return HibernateUtil.queryBySql(Storage.class, sqlStr);
  }
  
  @SuppressWarnings("unchecked")
  public List<User> getUserInfo (){
    String sqlStr = null;
    if (this.userLevel == 3)
      sqlStr = "select * from inv.user";
    else      
	    sqlStr = "select * from inv.user where USERNAME = '"+userName+"' and PASSWORD = '"+password+"'";
	  return HibernateUtil.queryBySql(User.class, sqlStr);
  }
  
  public Object[][] getISleUserInfo (int columnNum){
	  List<ISleUserView> lt = getISleUserInfo();
	  return listToStringArray(lt,columnNum, "models.ISleUserView" );
  }
  
  
  public Object[][] getOSleUserInfo (int columnNum){
	  List<OSleUserView> lt = getOSleUserInfo();
	  return listToStringArray(lt,columnNum, "models.OSleUserView" );
  }
  
  public Object[][] getInvUserInfo (int columnNum){
	  List<InvUserView> lt = getInvUserInfo();
	  return listToStringArray(lt,columnNum, "models.InvUserView" );
  }
  
  public Object[][] getStorageInfo (int columnNum){
	  List<Storage> lt = getStorageInfo();
	  return listToStringArray(lt,columnNum, "models.Storage" );
  }
  
  public Object[][] getUserInfo (int columnNum){
	  List<User> lt = getUserInfo();
	  return listToStringArray(lt,columnNum, "models.User" );
  }
  
  public List query(Object obj, String sqlStr) {
	  return HibernateUtil.queryBySql(OSle.class, sqlStr);
  }
  
  public TableModel getISleUserInfoTM (int columnNum){
	  List<ISleUserView> lt = getISleUserInfo();
	  return getTableModel(lt,columnNum, "models.ISleUserView" );
  }
  
  public TableModel getOSleUserInfoTM (int columnNum){
	  List<OSleUserView> lt = getOSleUserInfo();
	  return getTableModel(lt,columnNum, "models.OSleUserView" );
  }
  public TableModel getInvInfoTM (int columnNum){
	  List<InvUserView> lt = getInvUserInfo();
	  return getTableModel(lt,columnNum, "models.InvUserView" );
  }
  
  public TableModel getInvInfoTM (int columnNum, String sqlStr){
    List<InvUserView> lt = getInvUserInfo(sqlStr);
    return getTableModel(lt,columnNum, "models.InvUserView" );
  }
  
  public TableModel getUserInfoTM (int columnNum){
	  List<User> lt = getUserInfo();
	  return getTableModel(lt,columnNum, "models.User" );
  }
  
  public TableModel getStorageTM (int columnNum){
	  List<Storage> lt = getStorageInfo();
	  return getTableModel(lt,columnNum, "models.Storage" );
  }
  
  

  Object[][] listToStringArray(List<?> isl, int columnNum, String className){
	  Object[] rowData = null;
	  Object[][] tableModalContent = null;
	  if (isl != null) {
		  rowData = isl.toArray();
		  tableModalContent = new Object[rowData.length][columnNum];
		  Method method;
		  try {
			  method = Class.forName(className).getMethod("toArray");
			  for (int i = 0; i < rowData.length; i++) {
				  tableModalContent[i] = (Object[]) (method.invoke(rowData[i]));
			  }
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  return tableModalContent;
  }
  
  
  TableModel getTableModel(List<?> isl, int columnNum, String className) {
	  Object[] rowData = null;
	  Object[][] tableModalContent =null;
	  String[] columns =null;
	  Object obj =null;
	  int allColumns = 0;
	  if (isl != null) {
		  rowData = isl.toArray();
		  tableModalContent = new Object[rowData.length][];
		  Method toArrayMethod, getTitleMethod, getAllNumMethod;
		  
		  try {
			  getAllNumMethod = Class.forName(className).getMethod("toArray");
			  toArrayMethod = Class.forName(className).getMethod("toArray", int.class);
			  getTitleMethod = Class.forName(className).getMethod("getTilte", int.class);
			  obj = Class.forName(className).newInstance();
			  for (int i = 0; i < rowData.length; i++) {
				  tableModalContent[i] = (Object[]) (toArrayMethod.invoke(rowData[i], this.userLevel));
			  }
			  columns = (String[])getTitleMethod.invoke(obj, this.userLevel);
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
	  }
	  TableModel tm = new TableModel(tableModalContent,columns);
	  return tm;
	  
  }
  //------BEGIN------verify checkIn and checkOut------------BEGIN-------//
  
  public DefaultTableModel getInvCheckTM (String methodName){
	  List<InvUserView> lt = null;
	  if(methodName.equals("Out")){
		  lt = getInvUserCheckOutInfo();
	  }else{
		  lt = getInvUserCheckInInfo();
	  }
	  return getTableModel(lt, methodName,new Object[]{"Verified"} );
  }
  
  @SuppressWarnings("unchecked")
  public List<InvUserView> getInvUserCheckInInfo (){
	  String sqlStr = "select * from inv.inv_view where StorageStatus = 'checked in' and VerificationStatus = 'unverified' order by CREATTIME DESC";
	  return HibernateUtil.queryBySql(InvUserView.class, sqlStr);
  }
  
  @SuppressWarnings("unchecked")
  public List<InvUserView> getInvUserCheckOutInfo (){
	  String sqlStr = "select * from inv.inv_view where StorageStatus = 'checked out'  and VerificationStatus = 'unverified' and CheckOutEngID = '"+main.client.getUserID()+"' order by CREATTIME DESC";
	  return HibernateUtil.queryBySql(InvUserView.class, sqlStr);
  }
  
  DefaultTableModel getTableModel(List<?> isl, String methodName, Object[] newObjArray) {
	  Object[] rowData = null;
	  Object[][] tableModalContent =null;
	  String[] columns =null;
	  Object obj =null;
	  String[] newTitles = null;
	  if (isl != null) {
		  rowData = isl.toArray();
		  tableModalContent = new Object[rowData.length][];
		  Method toArrayMethod, getTitleMethod;
		  
		  try {
			  toArrayMethod = Class.forName("models.InvUserView").getMethod("toCheck"+methodName+"Array");
			  getTitleMethod = Class.forName("models.InvUserView").getMethod("getCheck"+methodName+"Tilte");
			  obj = Class.forName("models.InvUserView").newInstance();
			  for (int i = 0; i < rowData.length; i++) {
				  Object[] tmpArray = (Object[]) (toArrayMethod.invoke(rowData[i]));
				  tableModalContent[i] = Arrays.copyOf(tmpArray, tmpArray.length+newObjArray.length);
				  System.arraycopy(newObjArray, 0, tableModalContent[i], tmpArray.length, newObjArray.length);
			  }
			  columns = (String[])getTitleMethod.invoke(obj);
			  String[] tmpTileArray = new String[newObjArray.length];
			  for (int i = 0; i < tmpTileArray.length; i++) {
				tmpTileArray[i] = "";
			  }
			  newTitles = Arrays.copyOf(columns, columns.length+newObjArray.length);
			  System.arraycopy(tmpTileArray, 0, newTitles, columns.length, tmpTileArray.length);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  DefaultTableModel tm = new DefaultTableModel(tableModalContent,newTitles);
	  return tm;
  }
  
//-------END----------verfiy checkIn and checkOut--------------END-----//
  
  
//  DefaultTableModel getTableModel(List<?> isl, int columnNum, String className, Object[] newObjArray) {
//	  Object[] rowData = null;
//	  Object[][] tableModalContent =null;
//	  String[] columns =null;
//	  Object obj =null;
//	  String[] newTitles = null;
//	  int allColumns = 0;
//	  if (isl != null) {
//		  rowData = isl.toArray();
//		  tableModalContent = new Object[rowData.length][];
//		  Method toArrayMethod, getTitleMethod, getAllNumMethod;
//		  
//		  try {
//			  getAllNumMethod = Class.forName(className).getMethod("toArray", null);
//			  toArrayMethod = Class.forName(className).getMethod("toArray", int.class);
//			  getTitleMethod = Class.forName(className).getMethod("getTilte", int.class);
//			  obj = Class.forName(className).newInstance();
//			  if(columnNum == 0){
//				  allColumns = ((Object[])getAllNumMethod.invoke(obj, null)).length+newObjArray.length;
//			  }else{
//				  allColumns = columnNum+newObjArray.length;
//			  }
//			  for (int i = 0; i < rowData.length; i++) {
////				  tableModalContent[i] = (Object[]) (toArrayMethod.invoke(rowData[i], allColumns));
//				  Object[] tmpArray = (Object[]) (toArrayMethod.invoke(rowData[i], allColumns));
//				  tableModalContent[i] = Arrays.copyOf(tmpArray, tmpArray.length+newObjArray.length);
//				  System.arraycopy(newObjArray, 0, tableModalContent[i], tmpArray.length, newObjArray.length);
//			  }
//			  columns = (String[])getTitleMethod.invoke(obj, allColumns);
//			  String[] tmpTileArray = new String[newObjArray.length];
//			  for (int i = 0; i < tmpTileArray.length; i++) {
//				  tmpTileArray[i] = "";
//			  }
//			  newTitles = Arrays.copyOf(columns, columns.length+newObjArray.length);
//			  System.arraycopy(tmpTileArray, 0, newTitles, columns.length, tmpTileArray.length);
//		  } catch (Exception e) {
//			  // TODO Auto-generated catch block
//			  e.printStackTrace();
//		  }
//	  }
//	  DefaultTableModel tm = new DefaultTableModel(tableModalContent,newTitles);
//	  return tm;
//	  
//  }
  
  
}
  
