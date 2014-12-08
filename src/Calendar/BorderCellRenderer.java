package Calendar;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

/**
 * The purpose of this class is to edit the graphical content of the JTable in the CalendarTest class. 
 * For example this class sets the background colour of specific cells and columns depending on the content of the cells and columns.
 */
public class BorderCellRenderer extends JLabel

implements TableCellRenderer {
	String CurrentDay;
	String CurrentMonth;
	protected Border noFocusBorder;
	protected Border columnBorder;
	Data d = new Data();
	CalendarTest CT = new CalendarTest();
	public BorderCellRenderer() {
		noFocusBorder = new EmptyBorder(1, 2, 1, 2);
		setOpaque(true);

	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(table.getBackground());
		}


	
		// Changes the background colour on column 5 and 6
		if (column == 5 || column == 6){ //Week-end
			setBackground(new Color(255, 215, 216));
		}
		else{ //Week
			setBackground(new Color(255, 255, 255));
		}

		if(d.getRealDay() <= 10) {
			CurrentDay = "0"+d.getRealDay();
		} else {
			CurrentDay = ""+d.getRealDay();
		}

		if((d.getCurrentMonth()+1) <=10){
			CurrentMonth = "0"+(d.getCurrentMonth()+1);
		} else {
			CurrentMonth = ""+(d.getCurrentMonth()+1);
		}

		//Changes the background colour on the column belonging to today plus column 5 and 6.
		for(int x=0; x<7; x++){
			if(CalendarTest.headers[x].equals(CurrentDay+"-"+CurrentMonth+"-"+d.getCurrentYear())){
				if(((d.getRealDay()+6)%7) == column){
					setBackground(new Color(234, 234, 245));
				} else if(column == 5 || column == 6) { 
					setBackground(new Color(255, 215, 216));
				} else {
					setBackground(new Color(255, 255, 255));
				}
			}
		}

		//Changes the background colour on the different courses from CBS.
		for(int i=0; i<CalendarTest.columnRows.size(); i++){
			if(row == CalendarTest.columnRows.get(i).getRow() && column == CalendarTest.columnRows.get(i).getColumn()){
				if(CalendarTest.columnRows.get(i).getDescription().equals("Ledelse af IS - forandring, innovation og viden (LA)") || CalendarTest.columnRows.get(i).getDescription().equals("Ledelse af IS - forandring, innovation og viden (XB)")){
					setBackground(new Color(255,0,0));
				} else if(CalendarTest.columnRows.get(i).getDescription().equals("Virksomhedens økonomiske styring (3) (LA)")){
					setBackground(new Color(0,0,250));
				}else if(CalendarTest.columnRows.get(i).getDescription().equals("Makroøkonomi (XB)") || CalendarTest.columnRows.get(i).getDescription().equals("Makroøkonomi (LA)")){
					setBackground(new Color(0,250,0));
				}else if(CalendarTest.columnRows.get(i).getDescription().equals("Distribuerede systemer (LA)")){
					setBackground(new Color(250,250,0));
				} 
			}

		}


		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		setFont(table.getFont());

		if (hasFocus) {
			setBorder( UIManager.getBorder("Table.focusCellHighlightBorder") );
			if (table.isCellEditable(row, column)) {
				setForeground( UIManager.getColor("Table.focusCellForeground") );
				setBackground( UIManager.getColor("Table.focusCellBackground") );
			}
		} else {
			if (value instanceof CellBorder) {
				Border border = ((CellBorder)value).getBorder();
				setBorder(border);
			} else {
				if (columnBorder != null) {
					setBorder(columnBorder);
				} else {
					setBorder(noFocusBorder);
				}
			}
		}
		setText((value == null) ? "" : value.toString());       
		return this;
	}

	public void setColumnBorder(Border border) {
		columnBorder = border;

	}

	public Border getColumnBorder() {
		return columnBorder;
	}

}