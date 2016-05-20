/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zhangle
 */
public class TableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    
    private Object[][] data;
    private String[] columns;
    private Object[][] backupData;
    public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}
    
    public TableModel(Object[][] content, String[] title){
        this.data = content;
        this.columns = title;
        backupData = content;
    }

    public Object[][] getBackupData() {
		return backupData;
	}

	public void setBackupData(Object[][] backupData) {
		this.backupData = backupData;
	}

	public int getColumnCount() {
          return columns.length;
    }
  
    @Override public String getColumnName(int column) {
          return columns[column];
    }

    public int getRowCount() {
          return data.length;
    }
    
    public void removeRow(int rowIndex){
    	System.err.println("remove "+rowIndex+" line");
    	
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
          return data[rowIndex][columnIndex];
    }
    
}
