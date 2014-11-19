package Ekstra;
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
    public void run (long newDate, String JsonString3){
    	
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
        frmMain.setSize(760, 550); //Set size to 400x400 pixels
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
        pnlCalendar.setBounds(0, 0, 737, 510);
        lblYear.setBounds(60, 479, 80, 20);
        cmbYear.setBounds(222, 479, 80, 20);
        stblCalendar.setBounds(60, 91, 662, 377);
        
        //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        

        SimpleDateFormat date_format = new SimpleDateFormat("dd-M-yyyy"); // Example: 17-Now-14
//        
//        String [] headers = new String[7];
        for (int i=0; i<7; i++){
            String hej = "";
        	Date currentDate = new Date(newDate);
        	String swag = date_format.format(currentDate);
        	headers[i] = swag;
        	newDate +=86400000;
        	
        	mtblCalendar.addColumn(headers[i]);
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
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(14);
      
        //Populate table
        for (int i=d.getRealYear()-100; i<=d.getRealYear()+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar (d.getWeekofYear(), d.getRealYear(), d.getJsonString()); //Refresh calendar
    }
    
    public  void refreshCalendar(int week, int year, String JSonString3){
        //Variables
    	String [] weeks = new String[53];
    		for(int a =0; a<weeks.length; a++){
    			weeks [a] = "Week "+ Integer.toString(a);
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
//		String day =(events.getEvents().get(0).getStart().get(2));
//		String month =(events.getEvents().get(0).getStart().get(1));
//		String år =(events.getEvents().get(0).getStart().get(0));
//		String dato = day+"-"+month+"-"+år;
//		System.out.println(dato);
		
//        Clear table
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        int column = 0;
        int row = 0;
        boolean match = false;
        for (int i=0; i<=90; i++){
        	String day =(events.getEvents().get(i).getStart().get(2));
        	if (day.equals("1")||day.equals("2")||day.equals("3")||day.equals("4")||day.equals("5")||day.equals("6")||day.equals("7")||day.equals("8")||day.equals("9") ){
        		day = ("0"+day);
        	}
        	
    		String år =(events.getEvents().get(i).getStart().get(0));
    		
    		int intMonth =Integer.parseInt(events.getEvents().get(i).getStart().get(1))+1;
    		String month = String.valueOf(intMonth);
    		String dato = day+"-"+month+"-"+år;
    		
    		//0 = år, 1 = måned, 2 = dag, 3 = timer, 4 = minutter
    		
    		String hours =(events.getEvents().get(i).getStart().get(3));
    		String minutes =(events.getEvents().get(i).getStart().get(4));
    		String time = hours + ":"+minutes;
    		
    		

    		
    		if(dato.equals(headers[0])){        		
                 column  = 0;
                 match = true;

    		}
    		if(dato.equals(headers[1])){     		
                column  = 1;
                match = true;

    		}
    		if(dato.equals(headers[2])){
        		
                column  = 2;
                match = true;

    		}
    		if(dato.equals(headers[3])){
        		
                column  = 3;
                match = true;

    		}
    		if(dato.equals(headers[4])){       		
                column  = 4;
                match = true;
    		}
    		
    		if(dato.equals(headers[5])){        		
                column  = 5;
                match = true;
    		}
    		if(dato.equals(headers[6])){
                column  = 6;
                match = true;
    		}
        	
        	
        	if(match == true){
        		
        		if(time.equals("8:00")){
        			row = 0;
        		}
        		if(time.equals("8:55")){
        			row = 0;
        		}
        		if(time.equals("9:50")){
        			row = 1;
        		}
        		if(time.equals("10:45")){
        			row = 2;
        		}
        		if(time.equals("11:40")){
        			row = 2;
        		}
        		if(time.equals("12:35")){
        			row = 3;
        		}
        		if(time.equals("13:30")){
        			row = 3;
        		}
        		if(time.equals("14:25")){
        			row = 4;
        		}
        		
        	
        	System.out.println(events.getEvents().get(i).getDescription()+ "row: "+row+ " column: "+column+ " time: "+time);
            mtblCalendar.setValueAt(events.getEvents().get(i).getDescription(), row, column);
             match = false;
        	}
        }
        
//        //Get first day of month and number of days
//        GregorianCalendar cal = new GregorianCalendar(year, week, 1);
//        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
//        som = cal.get(GregorianCalendar.DAY_OF_MONTH);
//        
//        System.out.println(nod);
//        System.out.println(som);
//        
        //Draw calendar
//        for (int i=1; i<=nod; i++){
//            int row = (i+som-2)/7;;
//            int column  =  (i+som-2)%7;
//            mtblCalendar.setValueAt(i, row, column);
//        }
        
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
    
}