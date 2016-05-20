package util;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOper {
	public static Object[][] filter(Object[][] data, String key, int columns) {
		if (data == null){
			data = new Object[1][columns];
			for (int i = 0; i < columns; i++) {
				data[0][i] = null;
			}
			return data;
		}
    	List<Object[]> showList = new ArrayList<Object[]>();
    	for (int i = 0; i < data.length; i++) {
			if (isExsited(data[i], key)) {
				showList.add(data[i]);
			}
		}
    	Object[][] tmpData = new Object[showList.size()][columns];
    	for (int i = 0; i < showList.size(); i++) {
    		tmpData[i] = showList.get(i);
		}
    	return tmpData;
    	
    }
    
    private static boolean isExsited(Object[] objArray, String key){
    	for (int i = 0; i < objArray.length; i++) {
    		if(objArray[i] == null) {
    			continue;
    		}
			if (objArray[i].toString().toLowerCase().contains(key.toLowerCase())){
				return true;
			}
		}
    	return false;
    }

}
