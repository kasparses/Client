package Ekstra;




import Ekstra.CellBorder;
import Ekstra.LinesBorder;
import Ekstra.BorderCellRenderer;
import TCPClient.TCPClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.awt.*;  

import JsonClasses.DailyUpdate;
import JsonClasses.Login;
import JsonClasses.SaveNote;

import javax.swing.*;  
import javax.swing.table.*;  
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.border.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarTest{
	
    static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext;
    JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    DefaultTableModel mtblCalendar; //Table model
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
    private static JLabel lblQuote;
    private static JLabel lblAuthor;
    private static JLabel lblTopic;
    private static JLabel lblDesc1;
    private static JLabel lblPicture1;
    private static JLabel lblCelsius1;
    private static JLabel lblDate1;
    private static JLabel lblDesc2;
    private static JLabel lblPicture2;
    private static JLabel lblCelsius2;
    private static JLabel lblDate2;
    private static JLabel lblDesc3;
    private static JLabel lblPicture3;
    private static JLabel lblCelsius3;
    private static JLabel lblDate3;
    private static JLabel lblDesc4;
    private static JLabel lblPicture4;
    private static JLabel lblCelsius4;
    private static JLabel lblDate4;
    private static JLabel lblDesc5;
    private static JLabel lblPicture5;
    private static JLabel lblCelsius5;
    private static JLabel lblDate5;
    private static JLabel lblDesc6;
    private static JLabel lblPicture6;
    private static JLabel lblCelsius6;
    private static JLabel lblDate6;
    private static JLabel lblDesc7;
    private static JLabel lblPicture7;
    private static JLabel lblCelsius7;
    private static JLabel lblDate7;
    private static JLabel label_14;
    
    data d = new data();
    String [] headers = new String[7];
    int notes [][] = new int [20][7];
    ArrayList<Event> lcs = new ArrayList<Event>();
    ArrayList<CalendarData> lcs2 = new ArrayList<CalendarData>();
    boolean updated = false;
    Gson gson = new GsonBuilder().create();
    TCPClient tcp = new TCPClient();
	SaveNote SN = new SaveNote();
    private JButton btnGetNote;
    private JButton btnAddNote;
    private JTextField txtNotetext;
    private JLabel lblSelectCalendar;
    private JComboBox comboBox_Calendar;
   
    /**
     * @wbp.parser.entryPoint
     */
    public void run (long newDate, String JsonString3, String JsonString5){
//    	tblCalendar.setShowHorizontalLines(false);
    	
    	
    	
    	d.setJsonString(JsonString3);
    	d.setNewDate(newDate);
    	d.setJsonString5(JsonString5);
    	
        //Look and feel
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
       
        
        //Prepare frame
        frmMain = new JFrame ("Gestionnaire de clients"); //Create frame
        frmMain.setSize(1366, 768); //Set size to 400x400 pixels
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
        lblMonth.setBounds(590, 25, 405, 25);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        btnNext = new JButton ("Next");
        btnNext.addActionListener(new btnNext_Action());
        btnPrev = new JButton ("Prev");
        
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        pnlCalendar.add(btnPrev);
        btnPrev.setBounds(349, 25, 80, 25);
        pnlCalendar.add(btnNext);
        btnNext.setBounds(917, 25, 94, 25);
        pnlCalendar.add(stblCalendar);
        
        //Set bounds
        pnlCalendar.setBounds(0, 0, 1360, 739);
        lblYear.setBounds(317, 479, 80, 20);
        cmbYear.setBounds(479, 479, 80, 20);
        stblCalendar.setBounds(349, 91, 662, 377);
        
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
//        tblCalendar.setColumnSelectionAllowed(true);
//        tblCalendar.setRowSelectionAllowed(true);
//        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        tblCalendar.setCellSelectionEnabled(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(38);
        
        lblMonday = new JLabel("Monday");
        lblMonday.setBounds(379, 66, 38, 14);
        pnlCalendar.add(lblMonday);
        
        lblTuesday = new JLabel("Tuesday");
        lblTuesday.setBounds(472, 66, 41, 14);
        pnlCalendar.add(lblTuesday);
        
        lblWenseday = new JLabel("Wednseday");
        lblWenseday.setBounds(557, 66, 57, 14);
        pnlCalendar.add(lblWenseday);
        
        lblThuesday = new JLabel("Thursday");
        lblThuesday.setBounds(659, 66, 45, 14);
        pnlCalendar.add(lblThuesday);
        
        lblFriday = new JLabel("Friday");
        lblFriday.setBounds(759, 66, 30, 14);
        pnlCalendar.add(lblFriday);
        
        lblSaturday = new JLabel("Saturday");
        lblSaturday.setBounds(848, 66, 44, 14);
        pnlCalendar.add(lblSaturday);
        
        lblSunday = new JLabel("Sunday");
        lblSunday.setBounds(942, 66, 36, 14);
        pnlCalendar.add(lblSunday);
        
        label = new JLabel("8:00");
        label.setBounds(317, 116, 22, 14);
        pnlCalendar.add(label);
        
        label_1 = new JLabel("9:00");
        label_1.setBounds(317, 141, 22, 14);
        pnlCalendar.add(label_1);
        
        label_2 = new JLabel("10:00");
        label_2.setBounds(311, 166, 28, 14);
        pnlCalendar.add(label_2);
        
        label_3 = new JLabel("11:00");
        label_3.setBounds(311, 191, 28, 14);
        pnlCalendar.add(label_3);
        
        label_4 = new JLabel("12:00");
        label_4.setBounds(311, 216, 28, 14);
        pnlCalendar.add(label_4);
        
        label_5 = new JLabel("13:00");
        label_5.setBounds(311, 241, 28, 14);
        pnlCalendar.add(label_5);
        
        label_6 = new JLabel("14:00");
        label_6.setBounds(311, 266, 28, 14);
        pnlCalendar.add(label_6);
        
        label_7 = new JLabel("15:00");
        label_7.setBounds(311, 291, 28, 14);
        pnlCalendar.add(label_7);
        
        label_8 = new JLabel("16:00");
        label_8.setBounds(311, 316, 28, 14);
        pnlCalendar.add(label_8);
        
        label_9 = new JLabel("17:00");
        label_9.setBounds(311, 341, 28, 14);
        pnlCalendar.add(label_9);
        
        label_10 = new JLabel("18:00");
        label_10.setBounds(311, 366, 28, 14);
        pnlCalendar.add(label_10);
        
        label_11 = new JLabel("19:00");
        label_11.setBounds(311, 391, 28, 14);
        pnlCalendar.add(label_11);
        
        label_12 = new JLabel("20:00");
        label_12.setBounds(311, 416, 28, 14);
        pnlCalendar.add(label_12);
        
        label_13 = new JLabel("21:00");
        label_13.setBounds(311, 441, 28, 14);
        pnlCalendar.add(label_13);
        
        lblQuote = new JLabel("");
        lblQuote.setBounds(613, 479, 518, 25);
        pnlCalendar.add(lblQuote);
        
        lblAuthor = new JLabel("");
        lblAuthor.setBounds(613, 503, 145, 20);
        pnlCalendar.add(lblAuthor);
        
        
        lblTopic = new JLabel("");
        lblTopic.setBounds(759, 503, 154, 20);
        pnlCalendar.add(lblTopic);
        
        //1th day weather
        lblPicture1 = new JLabel("");
        lblPicture1.setBounds(60, 589, 164, 124);
        pnlCalendar.add(lblPicture1);
        
        lblCelsius1 = new JLabel("");
        lblCelsius1.setBounds(60, 557, 164, 14);
        pnlCalendar.add(lblCelsius1);
        
        lblDate1 = new JLabel("");
        lblDate1.setBounds(60, 543, 164, 14);
        pnlCalendar.add(lblDate1);
        
        lblDesc1 = new JLabel("");
        lblDesc1.setBounds(60, 571, 164, 14);
        pnlCalendar.add(lblDesc1);
        
        //2th day weather
        lblPicture2 = new JLabel("");
        lblPicture2.setBounds(234, 589, 164, 124);
        pnlCalendar.add(lblPicture2);
        
        lblCelsius2 = new JLabel("");
        lblCelsius2.setBounds(234, 557, 163, 14);
        pnlCalendar.add(lblCelsius2);
        
        lblDate2 = new JLabel("");
        lblDate2.setBounds(234, 543, 163, 14);
        pnlCalendar.add(lblDate2);
        
        lblDesc2 = new JLabel("");
        lblDesc2.setBounds(234, 571, 163, 14);
        pnlCalendar.add(lblDesc2);
        
        //3th day weather
        lblPicture3 = new JLabel("");
        lblPicture3.setBounds(408, 589, 164, 124);
        pnlCalendar.add(lblPicture3);
        
        lblCelsius3 = new JLabel("");
        lblCelsius3.setBounds(408, 557, 164, 14);
        pnlCalendar.add(lblCelsius3);
        
        lblDate3 = new JLabel("");
        lblDate3.setBounds(408, 543, 164, 14);
        pnlCalendar.add(lblDate3);
        
        lblDesc3 = new JLabel("");
        lblDesc3.setBounds(408, 571, 164, 14);
        pnlCalendar.add(lblDesc3);
        
        //4th day weather
        lblPicture4 = new JLabel("");
        lblPicture4.setBounds(582, 589, 164, 124);
        pnlCalendar.add(lblPicture4);
        
        lblCelsius4 = new JLabel("");
        lblCelsius4.setBounds(582, 557, 164, 14);
        pnlCalendar.add(lblCelsius4);
        
        lblDate4 = new JLabel("");
        lblDate4.setBounds(582, 543, 164, 14);
        pnlCalendar.add(lblDate4);
        
        lblDesc4 = new JLabel("");
        lblDesc4.setBounds(582, 571, 164, 14);
        pnlCalendar.add(lblDesc4);
        
        //5th day weather
        lblPicture5 = new JLabel("");
        lblPicture5.setBounds(756, 589, 164, 124);
        pnlCalendar.add(lblPicture5);
        
        lblCelsius5 = new JLabel("");
        lblCelsius5.setBounds(756, 557, 166, 14);
        pnlCalendar.add(lblCelsius5);
        
        lblDate5 = new JLabel("");
        lblDate5.setBounds(756, 543, 166, 14);
        pnlCalendar.add(lblDate5);
        
        lblDesc5 = new JLabel("");
        lblDesc5.setBounds(756, 571, 166, 14);
        pnlCalendar.add(lblDesc5);
        
        //6th day weather
        lblPicture6 = new JLabel("");
        lblPicture6.setBounds(930, 589, 164, 124);
        pnlCalendar.add(lblPicture6);
        
        lblCelsius6 = new JLabel("");
        lblCelsius6.setBounds(930, 557, 164, 14);
        pnlCalendar.add(lblCelsius6);
        
        lblDate6 = new JLabel("");
        lblDate6.setBounds(930, 543, 164, 14);
        pnlCalendar.add(lblDate6);
        
        lblDesc6 = new JLabel("");
        lblDesc6.setBounds(930, 571, 164, 14);
        pnlCalendar.add(lblDesc6);
        
        //7th day weather
        lblPicture7 = new JLabel("");
        lblPicture7.setBounds(1104, 589, 164, 124);
        pnlCalendar.add(lblPicture7);
        
        lblCelsius7 = new JLabel("");
        lblCelsius7.setBounds(1104, 557, 164, 14);
        pnlCalendar.add(lblCelsius7);
        
        lblDate7 = new JLabel("");
        lblDate7.setBounds(1104, 543, 164, 14);
        pnlCalendar.add(lblDate7);
        
        lblDesc7 = new JLabel("");
        lblDesc7.setBounds(1104, 571, 164, 14);
        pnlCalendar.add(lblDesc7);
        
        label_14 = new JLabel("________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        label_14.setBounds(30, 515, 1302, 14);
        pnlCalendar.add(label_14);
        
        btnGetNote = new JButton("Show note for selected event");
        btnGetNote.setEnabled(true);
        btnGetNote.setBounds(1050, 91, 175, 23);
        pnlCalendar.add(btnGetNote);
        btnGetNote.addActionListener(new btnGetNote());
        
        btnAddNote = new JButton("Add note to selected event");
        btnAddNote.setEnabled(true);
        btnAddNote.setBounds(1050, 125, 175, 23);
        pnlCalendar.add(btnAddNote);
        
        txtNotetext = new JTextField();
        txtNotetext.setText("NoteText");
        txtNotetext.setBounds(1050, 163, 86, 20);
        pnlCalendar.add(txtNotetext);
        txtNotetext.setColumns(10);
        
        lblSelectCalendar = new JLabel("Select Calendar");
        lblSelectCalendar.setBounds(171, 66, 75, 14);
        pnlCalendar.add(lblSelectCalendar);
        
        comboBox_Calendar = new JComboBox();
        comboBox_Calendar.setBounds(171, 100, 110, 20);
        pnlCalendar.add(comboBox_Calendar);
        btnAddNote.addActionListener(new btnAddNote());
        
        
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(20);
        
        Color gridColor = UIManager.getColor("Table.gridColor");  
        TableColumnModel model = tblCalendar.getColumnModel();  
        
//        for(int b = 0; b < tblCalendar.getColumnCount(); b++)  
//        {  
//            TableColumn col = model.getColumn(b);  
//            col.setCellRenderer(new CustomRenderer(gridColor));  
//        }  
        
       

        
        
      
        //Populate table
        for (int c=d.getRealYear()-100; c<=d.getRealYear()+100; c++){
            cmbYear.addItem(String.valueOf(c));
        }
        
        //Refresh calendar
        refreshCalendar (d.getWeekofYear(), d.getRealYear(), d.getJsonString(), d.getJsonString5()); //Refresh calendar
    }
    
    
    
    public  void refreshCalendar(int week, int year, String JSonString3, String JsonString5){
    	
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
        lblMonth.setBounds(683-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        //s�tter quote, author og topic
        lblQuote.setText("''"+Logic.Logic.Quote+"''");
        lblAuthor.setText("By: "+Logic.Logic.Author);
        lblTopic.setText("Topic: "+Logic.Logic.Topic);
        
        //s�tter beskrivelser til dag 1
        lblDate1.setText(Logic.Logic.Date1);
        lblCelsius1.setText(Logic.Logic.Celsius1+" Celsius.");
        lblDesc1.setText("Weather: "+Logic.Logic.Desc1);
        //s�tter billeder til dag 1
        if(Logic.Logic.Desc1.equals("broken clouds")){
        	lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
        } else if(Logic.Logic.Desc1.equals("few clouds")){
        	lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
        } else if(Logic.Logic.Desc1.equals("light rain")){
        	lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
        } else if(Logic.Logic.Desc1.equals("sky is clear")){
        	lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
        } else if(Logic.Logic.Desc1.equals("light snow")){
        	lblPicture1.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
        }
        
      //s�tter beskrivelser til dag 2
        lblDate2.setText(Logic.Logic.Date2);
        lblCelsius2.setText(Logic.Logic.Celsius2+" Celsius.");
        lblDesc2.setText("Weather: "+Logic.Logic.Desc2);
        //s�tter billeder til dag 2
        if(Logic.Logic.Desc2.equals("broken clouds")){
        	lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
        } else if(Logic.Logic.Desc2.equals("few clouds")){
        	lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
        } else if(Logic.Logic.Desc2.equals("light rain")){
        	lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
        } else if(Logic.Logic.Desc2.equals("sky is clear")){
        	lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
        } else if(Logic.Logic.Desc2.equals("light snow")){
        	lblPicture2.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
        }
        
      //s�tter beskrivelser til dag 3
        lblDate3.setText(Logic.Logic.Date3);
        lblCelsius3.setText(Logic.Logic.Celsius3+" Celsius.");
        lblDesc3.setText("Weather: "+Logic.Logic.Desc3);
        //s�tter billeder til dag 3
        if(Logic.Logic.Desc3.equals("broken clouds")){
        	lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
        } else if(Logic.Logic.Desc3.equals("few clouds")){
        	lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
        } else if(Logic.Logic.Desc3.equals("light rain")){
        	lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
        } else if(Logic.Logic.Desc3.equals("sky is clear")){
        	lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
        } else if(Logic.Logic.Desc3.equals("light snow")){
        	lblPicture3.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
        }
        
      //s�tter beskrivelser til dag 4
        lblDate4.setText(Logic.Logic.Date4);
        lblCelsius4.setText(Logic.Logic.Celsius4+" Celsius.");
        lblDesc4.setText("Weather: "+Logic.Logic.Desc4);
        //s�tter billeder til dag 4
        if(Logic.Logic.Desc4.equals("broken clouds")){
        	lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
        } else if(Logic.Logic.Desc4.equals("few clouds")){
        	lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
        } else if(Logic.Logic.Desc4.equals("light rain")){
        	lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
        } else if(Logic.Logic.Desc4.equals("sky is clear")){
        	lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
        } else if(Logic.Logic.Desc4.equals("light snow")){
        	lblPicture4.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
        }
        
      //s�tter beskrivelser til dag 5
        lblDate5.setText(Logic.Logic.Date5);
        lblCelsius5.setText(Logic.Logic.Celsius5+" Celsius.");
        lblDesc5.setText("Weather: "+Logic.Logic.Desc5);
        //s�tter billeder til dag 5
        if(Logic.Logic.Desc5.equals("broken clouds")){
        	lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
        } else if(Logic.Logic.Desc5.equals("few clouds")){
        	lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
        } else if(Logic.Logic.Desc5.equals("light rain")){
        	lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
        } else if(Logic.Logic.Desc5.equals("sky is clear")){
        	lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
        } else if(Logic.Logic.Desc5.equals("light snow")){
        	lblPicture5.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
        }
        
      //s�tter beskrivelser til dag 6
        lblDate6.setText(Logic.Logic.Date6);
        lblCelsius6.setText(Logic.Logic.Celsius6+" Celsius.");
        lblDesc6.setText("Weather: "+Logic.Logic.Desc6);
        //s�tter billeder til dag 6
        if(Logic.Logic.Desc6.equals("broken clouds")){
        	lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
        } else if(Logic.Logic.Desc6.equals("few clouds")){
        	lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
        } else if(Logic.Logic.Desc6.equals("light rain")){
        	lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
        } else if(Logic.Logic.Desc6.equals("sky is clear")){
        	lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
        } else if(Logic.Logic.Desc6.equals("light snow")){
        	lblPicture6.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
        }
        
        //s�tter beskrivelser til dag 7
        lblDate7.setText(Logic.Logic.Date7);
        lblCelsius7.setText(Logic.Logic.Celsius7+" Celsius.");
        lblDesc7.setText("Weather: "+Logic.Logic.Desc7);
        //s�tter billeder til dag 7
        if(Logic.Logic.Desc7.equals("broken clouds")){
        	lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/broken clouds.png")));
        } else if(Logic.Logic.Desc7.equals("few clouds")){
        	lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/few clouds.png")));
        } else if(Logic.Logic.Desc7.equals("light rain")){
        	lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light rain.png")));
        } else if(Logic.Logic.Desc7.equals("sky is clear")){
        	lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/sky is clear.png")));
        } else if(Logic.Logic.Desc7.equals("light snow")){
        	lblPicture7.setIcon(new ImageIcon(CalendarTest.class.getResource("/Images/light snow.png")));
        }
        
        Gson gson = new GsonBuilder().create();
        
        
//        channelSearchEnum[] enums = gson.fromJson(yourJson, channelSearchEnum[].class);
        
        if(updated ==false){
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(JSonString3).getAsJsonArray();

       

        for(JsonElement obj : jArray )
        {
        	Event cse = gson.fromJson( obj , Event.class);
            lcs.add(cse);
            
   
        }
        updated = true;
        }

        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(JsonString5).getAsJsonArray();

        for(JsonElement obj : jArray )
        {
        	CalendarData cse = gson.fromJson( obj , CalendarData.class);
            lcs2.add(cse);
            
   
        }
        System.out.println("hej"+ lcs2.get(0).getName());
        
        String [] startCalendarTime = new String[17];
        startCalendarTime[0] = "08:00";
        startCalendarTime[1] = "08:55";
        startCalendarTime[2] = "09:50";
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
        startCalendarTime[15] = "21:45";
        startCalendarTime[16] = "22:40";
        
        
        String [] endCalendarTime = new String[17];
        endCalendarTime[0] = "08:00";
        endCalendarTime[1] = "08:45";
        endCalendarTime[2] = "09:40";
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
        startCalendarTime[15] = "21:35";
        startCalendarTime[16] = "22:30";
        
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

        tblCalendar.setDefaultRenderer(Object.class, new BorderCellRenderer());
        tblCalendar.setShowGrid(false);
        
        boolean isTop,isLeft,isBottom,isRight;

        int[] rows    = new int[20];
        
        for(int �1 = 0; �1<rows.length; �1++){
      	  rows[�1] = �1;
        }
        
        int[] columns = new int[7];
        for(int ab1 = 0; ab1<columns.length; ab1++){
      	  columns[ab1] = ab1;
        }
        
        
        for(int i = 0; i<columns.length; i++){
      	
        }
        for(int a = 0; a<rows.length; a++){
      	  
        }
        
        int rowMax    = rows.length;
        int columnMax = columns.length;
         
        for (int i=0;i<rowMax;i++) {
          int row1 = rows[i];
          isTop    = (i == 0       )? true: false;
          isBottom = (i == rowMax-1)? true: false;
           
          for (int j=0;j<columnMax;j++) {
            int column1 = columns[j];
            isLeft  = (j == 0          )? true: false;
            isRight = (j == columnMax-1)? true: false;
             

            MyData myData = (MyData)null;

            Color color = UIManager.getColor("Table.gridColor");
           
            if (myData == null) {
              myData = new MyData("", new LinesBorder(color,0));
            }
            LinesBorder border = (LinesBorder)myData.getBorder();
            
            Insets insets = new Insets(1,1,1,1);
            insets.top    = 1;    
            insets.left   = 1;     
            insets.bottom = 1;    
            insets.right  = 1; 
            
            
           boolean isReplace = true;
              Insets tmp = new Insets(0,0,0,0);
              if (isTop)    tmp.top    = Math.max(tmp.top    ,insets.top);
              if (isLeft)   tmp.left   = Math.max(tmp.left   ,insets.left);
              if (isBottom) tmp.bottom = Math.max(tmp.bottom ,insets.bottom);
              if (isRight)  tmp.right  = Math.max(tmp.right  ,insets.right);
              border.append(insets, isReplace);

              
             
              mtblCalendar.setValueAt(myData, row1, column1);
          }
        }
        tblCalendar.clearSelection();
        tblCalendar.revalidate();
        tblCalendar.repaint();
        

        for (int g=0; g<=lcs.size(); g++){
        
        	
        	String dateStart =lcs.get(g).getStart().get(0);
        	String dateEnd = lcs.get(g).getEnd().get(0);
        	
      
        	String daySplitEnd [] = dateEnd.split("");
        	String daySplit [] = dateStart.split("");

        	for (int i = 0; i<daySplit.length; i++){
        	
        	}
        	
        	String day = daySplit[9]+ daySplit[10];
        	String month = daySplit[6]+ daySplit[7];
        	String �r = daySplit[1]+daySplit[2]+daySplit[3]+daySplit[4];
        	String dato = day+"-"+month+"-"+�r;
    

    		String startHours =daySplit[11]+daySplit[12];
    		String startMinutes =daySplit[14]+daySplit[15];
    		String startTime = startHours + ":"+startMinutes;
    		
    		String endHours =daySplitEnd[11]+daySplitEnd[12];
    		String endMinutes =daySplitEnd[14]+daySplitEnd[15];
    		String endTime = endHours + ":"+endMinutes;

    		for (int h = 0; h<headers.length; h++){
    			if(dato.equals(headers[h])){        		
    				column  = h;
    				match = true;

    			}
    		}
    		

    		if(match == true){
    			match = false;
    			

    			for (int st=0; st<startCalendarTime.length; st++){ //st = startTime
    				if (startTime.equals(startCalendarTime[st])){
    					startRow = st;
    					

    				}
    			}
    			for (int et=0; et<endCalendarTime.length; et++){  //et = endTime
    				if (endTime.equals(endCalendarTime[et])){
    					endRow = et;
    					

    				}
    			}
    			for (int k = startRow; k<endRow; k++){
    				
    				tblCalendar.setIntercellSpacing(new Dimension(0,0));
       
        			  boolean isTop1,isLeft1,isBottom1,isRight1; 		       

        		      int rowLength1 = endRow-startRow;
        		      
        		      int[] rows1    = new int[rowLength1];
        		      
        		      for(int �1 = 0; �1<rows1.length; �1++){
        		    	  rows1[�1] = startRow+�1;
        		      }
        		      
        		      int[] columns1 = new int[1];
        		      
        		      for(int ab1 = 0; ab1<columns1.length; ab1++){
        		    	  columns1[ab1] = column;
        		      }
        		      
        		      int rowMax1    = rows1.length;
        		      int columnMax1 = columns1.length;
        		      
        		      for (int i1=0;i1<rowMax1;i1++) {
        		        int rowb1 = rows1[i1];
        		        
        		        String value = "";
            			if(i1==0){
            				value = lcs.get(g).getDescription();
            			}
            			if(i1>0){
            				value = "";
            			}
        		        isTop1    = (i1 == 0       )? true: false;
        		        isBottom1 = (i1 == rowMax1-1)? true: false;
        		         
        		        for (int j1=0;j1<columnMax1;j1++) {
        		          int columnb1 = columns1[j1];
        		          isLeft1  = (j1 == 0          )? true: false;
        		          isRight1 = (j1 == columnMax1-1)? true: false;
        		          
        		          Color color1 = UIManager.getColor("Table.gridColor");


        		          MyData myData = (MyData)null;  

        		            myData = new MyData(value, new LinesBorder(color1,0));
        		         
 
        		              Insets insets = new Insets(1,1,1,1);
        		              insets.top    = 1;     
        		              insets.left   = 1;     
        		              insets.bottom = 1;     
        		              insets.right  = 1;     
        		                       
        		          LinesBorder border = (LinesBorder)myData.getBorder();
        		          
        		     boolean isReplace = true;
        		            Insets tmp = new Insets(0,0,0,0);
        		            if (isTop1)    tmp.top    = Math.max(tmp.top    ,insets.top);
        		            if (isLeft1)   tmp.left   = Math.max(tmp.left   ,insets.left);
        		            if (isBottom1) tmp.bottom = Math.max(tmp.bottom ,insets.bottom);
        		            if (isRight1)  tmp.right  = Math.max(tmp.right  ,insets.right);
        		            border.append(tmp, isReplace);
        		            
        		            
        		            notes [rowb1][columnb1] = g;
        		            mtblCalendar.setValueAt(myData, rowb1, columnb1);
        		            
//        		            mtblCalendar.setValueAt(mtblCalendar.getValueAt(k, column), rowb1, columnb1);
        		        }
        		      }
        		      tblCalendar.clearSelection();
        		      tblCalendar.revalidate();
        		      tblCalendar.repaint();
    			
    			
    			
    			}
    		}
        }
        

        //Apply renderers
//        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
//     class tblCalendarRenderer extends DefaultTableCellRenderer{
//        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
//            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
//            if (column == 5 || column == 6){ //Week-end
//                setBackground(new Color(255, 220, 220));
//            }
//            else{ //Week
//                setBackground(new Color(255, 255, 255));
//            }
//            if (value != null){
//                if (Integer.parseInt(value.toString()) == d.getRealDay() && d.getCurrentMonth() == d.getRealMonth() && d.getCurrentYear() == d.getRealYear()){ //Today
//                    setBackground(new Color(220, 220, 255));
//                }
//            }
//            setBorder(null);
//            setForeground(Color.black);
//            return this;
//        }
//    }
    
     class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (d.getWeekofYear() == 1){ //Back one year
            	
            	d.setWeekofYear(52);            	
            	d.setNewDate(d.getNewDate()-604800000);
            	frmMain.dispose();
            	run(d.getNewDate(), d.getJsonString(),d.getJsonString5());
            	
            }
            else{ //Back one week

            	d.setWeekofYear(d.getWeekofYear()-1);
            	d.setNewDate(d.getNewDate()-604800000);	
            	frmMain.dispose();
            	run(d.getNewDate(), d.getJsonString(),d.getJsonString5());
            	
            }
            refreshCalendar(d.getWeekofYear(), d.getCurrentYear(),d.getJsonString(),d.getJsonString5());
        }
    }
     class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (d.getWeekofYear() == 52){ //Foward one year
            	
            	d.setWeekofYear(1);          
            	d.setNewDate(d.getNewDate()+604800000);
            	frmMain.dispose();
            	run(d.getNewDate(),d.getJsonString(),d.getJsonString5());
            	
            }
            else{ //Foward one month
            	d.setWeekofYear(d.getWeekofYear()+1);
            	d.setNewDate(d.getNewDate()+604800000); //604800000 is the number of milliseconds in a week
            	
            	frmMain.dispose();
            	run(d.getNewDate(), d.getJsonString(),d.getJsonString5());
            }
            refreshCalendar(d.getWeekofYear(), d.getCurrentYear(), d.getJsonString(),d.getJsonString5());
        }
    }
     class btnGetNote implements ActionListener{
         public void actionPerformed (ActionEvent e){
             
        	 int rowIndex = tblCalendar.getSelectedRow();
             int colIndex = tblCalendar.getSelectedColumn();
             int selection = notes[rowIndex][colIndex];
            
             JOptionPane.showMessageDialog(null, lcs.get(selection).getNote()
						, lcs.get(selection).getDescription(),JOptionPane.PLAIN_MESSAGE);
             
         }
     }
     class btnAddNote implements ActionListener{
         public void actionPerformed (ActionEvent e){
        	 
        	 int rowIndex = tblCalendar.getSelectedRow();
             int colIndex = tblCalendar.getSelectedColumn();
             int selection = notes[rowIndex][colIndex];
             int superID = selection+1;
             
             
             
            SN.setSuperID(superID);
            SN.setNote(txtNotetext.getText());
            
           
				try {
					 String JsonString=tcp.bla(SN);
					 SaveNote SN = gson.fromJson(JsonString, SaveNote.class);
					 lcs.get(selection).setNote(txtNotetext.getText());
					 
					 System.out.println(SN.getAnswer());
					 JOptionPane.showMessageDialog(null, SN.getAnswer()
								, "Note",JOptionPane.PLAIN_MESSAGE);
				} catch (UnknownHostException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
            
				 
             
             
         }
     }
     class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                d.setCurrentYear(Integer.parseInt(b));
                refreshCalendar(d.getWeekofYear(), d.getCurrentYear(), d.getJsonString(),d.getJsonString5());
            }
        }
    }
     

     public JTextField getTxtNotetext() {
		return txtNotetext;
	}



	public void setTxtNotetext(JTextField txtNotetext) {
		this.txtNotetext = txtNotetext;
	}

	class MyData implements CellBorder {
    	    private Border border;
    	    private Object obj;
    	     
    	    public MyData(Object obj, Border border) {
    	      this.obj    = obj;
    	      this.border = border;
    	    }
    	     
    	    public void setObject(Object obj) {
    	      this.obj = obj;
    	    }   
    	    public String toString() {
    	      return obj.toString();
    	    }
    	     
    	    // CellBorder  
    	    public void setBorder(Border border) {
    	      this.border = border;
    	    }  
    	    public Border getBorder() {
    	      return border;
    	    }
    	    public void setBorder(Border border, int row, int col) {}
    	    public Border getBorder(int row, int col) { return null; }
    	  }
}