package Ekstra;

import java.awt.*;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
  
/**
 * @version 1.0 03/06/99
 */
public class BorderCellRenderer extends JLabel

    implements TableCellRenderer {
  protected Border noFocusBorder;
  protected Border columnBorder;
  data d = new data();
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
    
    
  //Ændre baggrundsfarve på column 5 og 6 (altså 6 og 7)
    if (column == 5 || column == 6){ //Week-end
	      setBackground(new Color(255, 215, 216));
	    }
	    else{ //Week
	      setBackground(new Color(255, 255, 255));
	    }
   
    
    //Ændre baggrundsfarve på column tilhørende til dagen i dag + column 5 og 6 (altså 6 og 7)
//    for(int x=0; x<7; x++){
//    	if(CalendarTest.headers[x].equals("0"+d.getRealDay()+"-"+(d.getCurrentMonth()+1)+"-"+d.getCurrentYear())){
        	if(d.getDayofWeek()+1 == column){
        		System.out.println("dayofweek: "+d.getDayofWeek());
        		System.out.println("dayofweek2: "+d.getDayofweek2());
        		System.out.println("column: "+column);
    			setBackground(new Color(234, 234, 245));
        	} else if(column == 5 || column == 6) { 
        		setBackground(new Color(255, 215, 216));
    	    } else {
    	    	setBackground(new Color(255, 255, 255));
    	    }
//    	}
//    }

    
   
    //Ændre baggrundsfarve på de forskellige fag fra CBS
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

//  for(int i=0; i<CalendarTest.columnRows.size(); i++){
//  	if(row == CalendarTest.columnRows.get(i).getRow() && column == CalendarTest.columnRows.get(i).getColumn()){
//  		setBackground(new Color(255,220,220));
//  		
//  	}
//  }
    
//    if (row ==d.getRow() && column ==d.getColumn() ){
//    	setBackground(new Color(255,220,220));
//    	
//    }
//    if (row ==3 && column ==1 ){
//    	setBackground(new Color(255,220,220));
//    	
//    }
    
    
    
    
    
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