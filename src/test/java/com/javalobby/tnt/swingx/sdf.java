//package com.javalobby.tnt.swingx;
//
//
//import java.awt.Color;
//import org.jdesktop.swingx.decorator.PainterHighlighter;
//
//import javax.swing.*;
//import javax.swing.table.AbstractTableModel;
//
//import org.jdesktop.swingx.JXTable;
//import org.jdesktop.swingx.decorator.*;
//
// 
//public class sdf {
// 
//	private static String[] data = { "This is the 1st String", "String 2", "Another String",
//			"The Final String" };
// 
//	private static String[] columns = { "Name", "Length", "Upper-case" };
// 
//	public static void main(String[] args) {
//		JXTable table = new JXTable(new SampleTableModel());
//		setLookAndFeel();
//		configureHighlighters(table);
//		configureFilters(table);
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(new JScrollPane(table));
//		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//	}
// 
//	private static void configureFilters(JXTable table) {
//		Filter[] filterArray = { new PatternFilter("(.*1st.*)|(.*Final.*)", 0, 0) };
//		FilterPipeline filters = new FilterPipeline(filterArray);
//		table.setFilters(filters);
//	}
// 
//	/**
//	 * @param table
//	 */
//	private static void configureHighlighters(JXTable table) {
//		HighlighterPipeline highlighters = new HighlighterPipeline();
//		highlighters.addHighlighter(new AlternateRowHighlighter());
//		PatternHighlighter pattern = new PatternHighlighter();
//		pattern.setPattern(".*Final.*", 0);
//		pattern.setBackground(Color.BLUE);
//		pattern.setForeground(Color.WHITE);
//		highlighters.addHighlighter(pattern);
//		table.setHighlighters(highlighters);
//	}
// 
//	private static void setLookAndFeel() {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		}
//		catch(Exception e) {
//		}
//	}
// 
//	private static class SampleTableModel extends AbstractTableModel {
// 
//		public int getColumnCount() {
//			return columns.length;
//		}
// 
//		@Override public String getColumnName(int column) {
//			return columns[column];
//		}
// 
//		public int getRowCount() {
//			return data.length;
//		}
// 
//		public Object getValueAt(int rowIndex, int columnIndex) {
//			String theData = data[rowIndex];
//			Object result = null;
//			switch (columnIndex) {
//			case 1:
//				result = theData.length(); // auto-boxing.
//				break;
//			case 2:
//				result = theData.toUpperCase();
//				break;
//			default:
//				result = theData;
//			}
// 
//			return result;
//		}
//	}
// 
//}