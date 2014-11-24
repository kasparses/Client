package Ekstra;



import java.awt.*;  

import javax.swing.*;  
import javax.swing.table.*;  
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarTest{
	
    static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
//    static int realYear, realMonth, realDay, currentYear, currentMonth, dayofWeek, weekofYear;
    private static JLabel lblMonday;
    private static JLabel lblTuesday;
    private static JLabel lblWenseday;
    private static JLabel lblThuesday;
    private static JLabel lblFriday;
    private static JLabel lblSaturday;
    private static JLabel lblSunday;
    private static JLabel label;
    private static JLabel label_1;
    private static JLabel label_2;
    private static JLabel label_3;
    private static JLabel label_4;
    private static JLabel label_5;
    private static JLabel label_6;
    private static JLabel label_7;
    private static JLabel label_8;
    private static JLabel label_9;
    private static JLabel label_10;
    private static JLabel label_11;
    private static JLabel label_12;
    private static JLabel label_13;
    data d = new data();
    String [] headers = new String[7];
    private JLabel lblQuote;
    private JLabel lblAuthor;
    private JLabel lblTopic;
    /**
     * @wbp.parser.entryPoint
     */
    public void run (long newDate, String JsonString3){
//    	tblCalendar.setShowHorizontalLines(false);
    	
    	
    	
    	d.setJsonString(JsonString3);
    	d.setNewDate(newDate);
    	
        //Look and feel
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
       
        
        //Prepare frame
        frmMain = new JFrame ("Gestionnaire de clients"); //Create frame
        frmMain.setSize(823, 559); //Set size to 400x400 pixels
        pane = frmMain.getContentPane(); //Get content pane
        pane.setLayout(null); //Apply null layout
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked
        lblYear = new JLabel ("Change year:");
        cmbYear = new JComboBox();
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        
        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        cmbYear.addActionListener(new cmbYear_Action());
       
        
        //Add controls to pane
        pane.add(pnlCalendar);
        
        //Create controls
        lblMonth = new JLabel ("January");
        pnlCalendar.add(lblMonth);
        lblMonth.setBounds(160, 25, 405, 25);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        btnNext = new JButton ("Next");
        btnNext.addActionListener(new btnNext_Action());
        btnPrev = new JButton ("Prev");
        
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        pnlCalendar.add(btnPrev);
        btnPrev.setBounds(60, 25, 80, 25);
        pnlCalendar.add(btnNext);
        btnNext.setBounds(628, 25, 94, 25);
        pnlCalendar.add(stblCalendar);
        
        //Set bounds
        pnlCalendar.setBounds(0, 0, 807, 508);
        lblYear.setBounds(60, 479, 80, 20);
        cmbYear.setBounds(222, 479, 80, 20);
        stblCalendar.setBounds(60, 91, 662, 377);
        
        //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        

        SimpleDateFormat date_format = new SimpleDateFormat("dd-M-yyyy"); // Example: 17-Now-14
//        
//        String [] headers = new String[7];
        for (int a=0; a<7; a++){
            String hej = "";
        	Date currentDate = new Date(newDate);
        	String swag = date_format.format(currentDate);
        	headers[a] = swag;
        	newDate +=86400000;
        	
        	mtblCalendar.addColumn(headers[a]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(38);
        
        lblMonday = new JLabel("Monday");
        lblMonday.setBounds(90, 66, 38, 14);
        pnlCalendar.add(lblMonday);
        
        lblTuesday = new JLabel("Tuesday");
        lblTuesday.setBounds(183, 66, 41, 14);
        pnlCalendar.add(lblTuesday);
        
        lblWenseday = new JLabel("Wednseday");
        lblWenseday.setBounds(268, 66, 57, 14);
        pnlCalendar.add(lblWenseday);
        
        lblThuesday = new JLabel("Thursday");
        lblThuesday.setBounds(370, 66, 45, 14);
        pnlCalendar.add(lblThuesday);
        
        lblFriday = new JLabel("Friday");
        lblFriday.setBounds(470, 66, 30, 14);
        pnlCalendar.add(lblFriday);
        
        lblSaturday = new JLabel("Saturday");
        lblSaturday.setBounds(559, 66, 44, 14);
        pnlCalendar.add(lblSaturday);
        
        lblSunday = new JLabel("Sunday");
        lblSunday.setBounds(653, 66, 36, 14);
        pnlCalendar.add(lblSunday);
        
        label = new JLabel("8:00");
        label.setBounds(28, 118, 22, 14);
        pnlCalendar.add(label);
        
        label_1 = new JLabel("9:00");
        label_1.setBounds(28, 143, 22, 14);
        pnlCalendar.add(label_1);
        
        label_2 = new JLabel("10:00");
        label_2.setBounds(22, 168, 28, 14);
        pnlCalendar.add(label_2);
        
        label_3 = new JLabel("11:00");
        label_3.setBounds(22, 193, 28, 14);
        pnlCalendar.add(label_3);
        
        label_4 = new JLabel("12:00");
        label_4.setBounds(22, 218, 28, 14);
        pnlCalendar.add(label_4);
        
        label_5 = new JLabel("13:00");
        label_5.setBounds(22, 243, 28, 14);
        pnlCalendar.add(label_5);
        
        label_6 = new JLabel("14:00");
        label_6.setBounds(22, 268, 28, 14);
        pnlCalendar.add(label_6);
        
        label_7 = new JLabel("15:00");
        label_7.setBounds(22, 293, 28, 14);
        pnlCalendar.add(label_7);
        
        label_8 = new JLabel("16:00");
        label_8.setBounds(22, 318, 28, 14);
        pnlCalendar.add(label_8);
        
        label_9 = new JLabel("17:00");
        label_9.setBounds(22, 343, 28, 14);
        pnlCalendar.add(label_9);
        
        label_10 = new JLabel("18:00");
        label_10.setBounds(22, 368, 28, 14);
        pnlCalendar.add(label_10);
        
        label_11 = new JLabel("19:00");
        label_11.setBounds(22, 393, 28, 14);
        pnlCalendar.add(label_11);
        
        label_12 = new JLabel("20:00");
        label_12.setBounds(22, 418, 28, 14);
        pnlCalendar.add(label_12);
        
        label_13 = new JLabel("21:00");
        label_13.setBounds(22, 443, 28, 14);
        pnlCalendar.add(label_13);
        
        lblQuote = new JLabel("New label");
        lblQuote.setBounds(171, 11, 46, 14);
        pnlCalendar.add(lblQuote);
        
        lblAuthor = new JLabel("Author");
        lblAuthor.setBounds(171, 36, 46, 14);
        pnlCalendar.add(lblAuthor);
        
        
        lblTopic = new JLabel("Topic");
        lblTopic.setBounds(559, 11, 46, 14);
        pnlCalendar.add(lblTopic);
        
        
        
        
        
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(14);
        
        Color gridColor = UIManager.getColor("Table.gridColor");  
        TableColumnModel model = tblCalendar.getColumnModel();  
        for(int b = 0; b < tblCalendar.getColumnCount(); b++)  
        {  
            TableColumn col = model.getColumn(b);  
            col.setCellRenderer(new CustomRenderer(gridColor));  
        }  
        
       

        
        
      
        //Populate table
        for (int c=d.getRealYear()-100; c<=d.getRealYear()+100; c++){
            cmbYear.addItem(String.valueOf(c));
        }
        
        //Refresh calendar
        refreshCalendar (d.getWeekofYear(), d.getRealYear(), d.getJsonString()); //Refresh calendar
    }
    
    public  void refreshCalendar(int week, int year, String JSonString3){
        //Variables
    	String [] weeks = new String[53];
    		for(int d =0; d<weeks.length; d++){
    			weeks [d] = "Week "+ Integer.toString(d);
    		}
        int nod, som; //Number Of Days, Start Of Month
        
        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (week == 1 && year <= d.getRealYear()-10){btnPrev.setEnabled(false);} //Too early
        if (week == 52 && year >= d.getRealYear()+100){btnNext.setEnabled(false);} //Too late
        lblMonth.setText(weeks[week]); //Refresh the month label (at the top)
        lblMonth.setBounds(380-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        Gson gson = new GsonBuilder().create();
        Events events = gson.fromJson(JSonString3, Events.class);

		
        String [] startCalendarTime = new String[15];
        startCalendarTime[0] = "8:00";
        startCalendarTime[1] = "8:55";
        startCalendarTime[2] = "9:50";
        startCalendarTime[3] = "10:45";
        startCalendarTime[4] = "11:40";
        startCalendarTime[5] = "12:35";
        startCalendarTime[6] = "13:30";
        startCalendarTime[7] = "14:25";
        startCalendarTime[8] = "15:20";
        startCalendarTime[9] = "16:15";
        startCalendarTime[10] = "17:10";
        startCalendarTime[11] = "18:05";
        startCalendarTime[12] = "19:00";
        startCalendarTime[13] = "19:55";
        startCalendarTime[14] = "20:50";
        
        String [] endCalendarTime = new String[15];
        endCalendarTime[0] = "8:00";
        endCalendarTime[1] = "8:45";
        endCalendarTime[2] = "9:40";
        endCalendarTime[3] = "10:35";
        endCalendarTime[4] = "11:30";
        endCalendarTime[5] = "12:25";
        endCalendarTime[6] = "13:20";
        endCalendarTime[7] = "14:15";
        endCalendarTime[8] = "15:10";
        endCalendarTime[9] = "16:05";
        endCalendarTime[10] = "17:00";
        endCalendarTime[11] = "17:55";
        endCalendarTime[12] = "18:50";
        endCalendarTime[13] = "19:45";
        endCalendarTime[14] = "20:40";
        
//      Clear table
        for (int e=0; e<6; e++){
            for (int f=0; f<7; f++){
                mtblCalendar.setValueAt(null, e, f);
            }
        }
        
        int column = 0;
        int row = 0;
        int startRow = 0;
        int endRow = 0;
        boolean match = false;
      
        for (int g=0; g<=90; g++){
        	String day =(events.getEvents().get(g).getStart().get(2));
        	if (day.equals("1")||day.equals("2")||day.equals("3")||day.equals("4")||day.equals("5")||day.equals("6")||day.equals("7")||day.equals("8")||day.equals("9") ){
        		day = ("0"+day);
        	}
        	
    		String �r =(events.getEvents().get(g).getStart().get(0));
    		
    		int intMonth =Integer.parseInt(events.getEvents().get(g).getStart().get(1))+1;
    		String month = String.valueOf(intMonth);
    		String dato = day+"-"+month+"-"+�r;

    		//0 = �r, 1 = m�ned, 2 = dag, 3 = timer, 4 = minutter

    		String startHours =(events.getEvents().get(g).getStart().get(3));
    		String startMinutes =(events.getEvents().get(g).getStart().get(4));
    		String startTime = startHours + ":"+startMinutes;
    		
    		String endHours =(events.getEvents().get(g).getEnd().get(3));
    		String endMinutes =(events.getEvents().get(g).getEnd().get(4));
    		String endTime = endHours + ":"+endMinutes;

    		for (int h = 0; h<headers.length; h++){
    			if(dato.equals(headers[h])){        		
    				column  = h;
    				match = true;

    			}
    		}
    		
    		//lav et array hvor jeg starter ved start row og slutter ved slutrow og derefter laver startRow ++

    		if(match == true){
    			match = false;
    			System.out.println();
    			
    			System.out.println("startTime: "+startTime);
    			System.out.println("endTime: "+ endTime);

    			for (int st=0; st<startCalendarTime.length; st++){ //st = startTime
    				if (startTime.equals(startCalendarTime[st])){
    					startRow = st;
    					System.out.println("startRow: "+startRow);

    				}
    			}
    			for (int et=0; et<endCalendarTime.length; et++){  //et = endTime
    				if (endTime.equals(endCalendarTime[et])){
    					endRow = et;
    					System.out.println("endRow: "+endRow);

    				}
    			}
    			for (int k = startRow; k<endRow; k++){
    				System.out.println("k: "+k);
    				System.out.println("startDate: "+startRow);
    			if(endRow-startRow >1){
    				
    				 tblCalendar.setShowGrid(false);  
    			        tblCalendar.setIntercellSpacing(new Dimension(0,0));  
    			        // remove line between item 18 and item 22  
    			        // get reference to renderer for column index 1  
    			        DefaultTableCellRenderer renderer =  
    			                (DefaultTableCellRenderer)tblCalendar.getCellRenderer(0,column);  
    			        // remove border top for item 22 [at row = 5, col = 1]  
    			        ((CustomRenderer)renderer).eraseBorder(startRow+1,column);  
    			        
    				
    			}
    			if(k ==startRow){
    				System.out.println(events.getEvents().get(g).getDescription()+ "row: "+startRow+ " column: "+column+ " time: "+startTime);
        			mtblCalendar.setValueAt(events.getEvents().get(g).getDescription(), k, column);
    				
    			}else{
    				
        			
    			}
    			
    			
    			}
    		}
        }


        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
     class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 5 || column == 6){ //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else{ //Week
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == d.getRealDay() && d.getCurrentMonth() == d.getRealMonth() && d.getCurrentYear() == d.getRealYear()){ //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
     class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (d.getWeekofYear() == 1){ //Back one year
            	
            	d.setWeekofYear(52);            	
            	d.setNewDate(d.getNewDate()-604800000);
            	frmMain.dispose();
            	run(d.getNewDate(), d.getJsonString());
            	
            }
            else{ //Back one week

            	d.setWeekofYear(d.getWeekofYear()-1);
            	d.setNewDate(d.getNewDate()-604800000);	
            	frmMain.dispose();
            	run(d.getNewDate(), d.getJsonString());
            	
            }
            refreshCalendar(d.getWeekofYear(), d.getCurrentYear(),d.getJsonString());
        }
    }
     class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (d.getWeekofYear() == 52){ //Foward one year
            	
            	d.setWeekofYear(1);          
            	d.setNewDate(d.getNewDate()+604800000);
            	frmMain.dispose();
            	run(d.getNewDate(),d.getJsonString());
            	
            }
            else{ //Foward one month
            	d.setWeekofYear(d.getWeekofYear()+1);
            	d.setNewDate(d.getNewDate()+604800000); //604800000 is the number of milliseconds in a week
            	frmMain.dispose();
            	run(d.getNewDate(), d.getJsonString());
            }
            refreshCalendar(d.getWeekofYear(), d.getCurrentYear(), d.getJsonString());
        }
    }
     class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                d.setCurrentYear(Integer.parseInt(b));
                refreshCalendar(d.getWeekofYear(), d.getCurrentYear(), d.getJsonString());
            }
        }
    }
     class CustomRenderer extends DefaultTableCellRenderer  
     {  
         Color gridColor;  
         int clearRow, clearCol;  
        
         public CustomRenderer(Color color)  
         {  
             gridColor = color;  
             clearRow = clearCol = -1;  
         }  
         public Component getTableCellRendererComponent(JTable table,  
                                                        Object value,  
                                                        boolean isSelected,  
                                                        boolean hasFocus,  
                                                        int row,  
                                                        int column)  
         {  
             Color color = Color.black;  
             if(hasFocus)  
                 color = Color.blue;  
             else if(isSelected)  
                 color = Color.orange;  
             setForeground(color);  
             setHorizontalAlignment(JLabel.CENTER);  
             Color bgColor = getBackground();  
             if(clearRow == row && clearCol == column) //  t  l  b  r  
                 setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, gridColor));  
             else  
                 setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, gridColor));  
             setText((String)value);  
             return this;  
         }  
        
         /** 
          * remove top of border for the component at (row, col) 
          */  
         public void eraseBorder(int row, int col)  
         {  
             clearRow = row;  
             clearCol = col;  
         }  
     } 
     
}