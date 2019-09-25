import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartPanel;

public class mainFrame  extends  JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Panel1 ->board Panel2 ->upper chart Panel3-> bottom chart Panel4->wartosci Panel5->konf. wyk1 Panel6->kon.wyk2.
	
	public JPanel panel1, panel4;
	public JLabel label1;
	public float realTime;
	Timer t;
	Chart chart1;
	Chart chart2;
	ChartPanel chartPanel1;
	ChartPanel chartPanel2;
	String lastClicked;
	String previousClicked;
	DataEntry window;
	public static boolean monitorState = false;
	int licznik=0;
	public boolean startCondition=false;
	public boolean	preCondition=false;
	public boolean chartCondition=false;
	BufferedImage image;

	
	Element checkElement;
	
	double valueChart1,valueChart2,time=(float) 1;


	public mainFrame() throws HeadlessException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,640);

		//Create menu
		JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200, 20));
        
        //Add menu
        String[] stringMenu = {"Plik", "Edytuj", "Uklad", "Opcje", "Pomoc"};
        LinkedList<String> listMenu = new LinkedList<String>();
		for(String x: stringMenu)	listMenu.add(x);
		JMenu[] menu = new JMenu[listMenu.size()];
		for(int i=0;i<listMenu.size();i++)	menu[i] = new JMenu(listMenu.get(i));
		for(int i=0;i<listMenu.size();i++)	menuBar.add(menu[i]);
        		
		//Add elements to menu
		String[] stringMenuItem = {"Zapisz plik", "Zapisz plik jako...", "Wczytaj plik", "Kopiuj", "Wklej", "Wytnij", "Powieksz obraz", "Pomniejsz obraz", "Uklad RLC", "Uklad RC", "Uklad LC", "Start", "Stop", "Wyglad interfejsu", "Instrukcja obslugi", "Linki do opisu obiektow", "Uklad RL"}; 
		LinkedList<String> listMenuItem = new LinkedList<String>();
		for(String x: stringMenuItem)	listMenuItem.add(x);
		JMenuItem[] menuItem = new JMenuItem[listMenuItem.size()];
		for(int i=0;i<listMenuItem.size();i++)	menuItem[i] = new JMenuItem(listMenuItem.get(i));
		
		//Add menuItems to menu
		for(int i=0;i<3;i++)	menu[0].add(menuItem[i]);
		for(int i=3;i<8;i++)	menu[1].add(menuItem[i]);
		for(int i=8;i<11;i++)	menu[2].add(menuItem[i]);
		for(int i=11;i<14;i++)	menu[3].add(menuItem[i]);
		for(int i=14;i<16;i++)	menu[4].add(menuItem[i]);
		menu[2].add(menuItem[16]);
			 
		//Add menu bar
		setJMenuBar(menuBar);
		
		
		//Becouse i didnt do everything i want
		for(int i=2;i<8;i++) menuItem[i].setEnabled(false);
		 menuItem[13].setEnabled(false);
		 menuItem[14].setEnabled(false);
		 menuItem[15].setEnabled(false);
		 menuItem[0].setEnabled(false);
		 
		 
		//Main Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		add(mainPanel);		
		
		//Main panel up
		JPanel panelup = new JPanel();
		panelup.setPreferredSize(new Dimension (980,500));
		panelup.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
		panelup.setLayout(new BoxLayout(panelup, BoxLayout.X_AXIS));
		mainPanel.add(panelup);
		
		//Main panel down
		JPanel paneldown = new JPanel();
		paneldown.setPreferredSize(new Dimension (980,180));
		paneldown.setLayout(new BoxLayout(paneldown, BoxLayout.X_AXIS));
		mainPanel.add(paneldown);		
		
		//Panel 1
		panelOne panel1 = new panelOne();
		panel1.setBackground(Color.white);
		panel1.setPreferredSize(new Dimension (270,400));
		panel1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 1, Color.BLACK));
		panelup.add(panel1);
		
		
		menuItem[8].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		t.stop();
        		window = new DataEntry("RLC",panel1);
        		preCondition = true;
        	}});
		menuItem[9].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		t.stop();
        		window = new DataEntry("RC",panel1);  
        		preCondition = true;
        	}});
		menuItem[10].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		t.stop();
        		window = new DataEntry("LC",panel1);
        		preCondition = true;
        	}});
		menuItem[16].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		t.stop();
        		window = new DataEntry("RL",panel1);
        		preCondition = true;
        	}});
			
		
		//Panel up right
		JPanel panelright = new JPanel();
		panelright.setLayout(new BoxLayout(panelright, BoxLayout.Y_AXIS));
		panelup.add(panelright);
		
		//Panel chart1

		chart1 = new Chart("U[V]");
		chart1.setTitle(" ");
		chartPanel1 = new ChartPanel(chart1.chart);
		chartPanel1.setPreferredSize(new Dimension(200,200));
		panelright.add(chartPanel1);
		chartPanel1.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 2, Color.BLACK));
		
		/************/
		t=new Timer(1, this);
		/************/
		
		
		menuItem[11].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent action){ 
        		if(preCondition) {
        			startCondition = window.is_startCondition();
        			chartCondition = window.is_chartCondition();
        		}
        		if(startCondition){
        			if(chartCondition){
        			chart1.series.clear();
        			chart2.series.clear();
        			}

        			t.start();
        			chartCondition = false;
        			preCondition = false;
        		}
        		else{
        			JOptionPane.showMessageDialog(rootPane, "Nie wybrano uk³adu","B³¹d", JOptionPane.ERROR_MESSAGE);
        		}
        	}});
		menuItem[12].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
       			t.stop();
        	}});
		
		
		//Panel chart2
		chart2 = new Chart("I[A]");
		chart2.setTitle("Intensity");
		chartPanel2 = new ChartPanel(chart2.chart);
		chartPanel2.setPreferredSize(new Dimension(200,200));
		panelright.add(chartPanel2);
		chartPanel2.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 2, Color.BLACK));

		
		//Panel 4
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.white);
		panel4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 1, Color.BLACK));
		panel4.setPreferredSize(new Dimension (200,180));
		paneldown.add(panel4);			
		
		//Panel 5
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.white);
		panel5.setLayout(new GridBagLayout());
		panel5.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
		panel5.setPreferredSize(new Dimension (390,180));
		GridBagConstraints a = new GridBagConstraints();
		a.gridwidth = GridBagConstraints.FIRST_LINE_START;
		paneldown.add(panel5,a);
		
		//Panel 6
		JPanel panel6 = new JPanel();
		panel6.setBackground(Color.white);
		panel6.setLayout(new GridBagLayout());
		panel6.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 2, Color.BLACK));
		panel6.setPreferredSize(new Dimension (390,180));
		GridBagConstraints b = new GridBagConstraints();
		b.gridwidth = GridBagConstraints.FIRST_LINE_START;
		paneldown.add(panel6,b);
		
		
		//********************************
		
		
		//PANEL 1
		panel1.addMouseListener(new MouseAdapter() {
			//variable check if some object was clicked
			
            public void mousePressed(MouseEvent e) {
            	 int x=e.getX();int y=e.getY();
            	 boolean matchObject=false;
                 for(Element el: panel1.elements) 
                 {
                	  if(el.contains(x,y)){
                		  el.label(window.engine, panel4);            		  	
	                		 matchObject = true; 
	                		 checkElement = el;
	                		 previousClicked = lastClicked;
	                		 lastClicked = el.GetName();
	                		 panel1.BurstClick(el);
	                	 	}
                	  
                 }
                 
                 if (!matchObject)
                 {
                	 for(Element el: panel1.elements) 
                     {
                    	 if (el.GetName()==lastClicked)
                    	 {
                    		el.ClearLabel(panel4);
                    		panel1.BurstResetClick(el);
                    	 }	 
                     }
                 }
                 else if(lastClicked!=previousClicked)
                 {
                	 for(Element el: panel1.elements) 
                     {
                    	 if (el.GetName()==previousClicked)
                    	 {
                    		panel1.BurstResetClick(el);
                    	 }	 
                     }
                 }
            }});


		
		//PANEL 5
		PanelOptionChart.addBox(panel5, a, "Chart 1", chart1);
		
		
		//PANEL 6
		PanelOptionChart.addBox(panel6, b, "Chart 2", chart2);
		
		
		
		//SAVE
		
		ActionListener Save = new ActionListener() {
				
			public void actionPerformed(ActionEvent e) {
				t.stop();
				Object[] options = {"Chart 1","Chart 2"};
				int n = JOptionPane.showOptionDialog(null,
					    "What Chart would you like to choose ", null,
					    JOptionPane.YES_NO_CANCEL_OPTION,
					    JOptionPane.QUESTION_MESSAGE,
					    null,
					    options,
					    null);
				System.out.println(n);
				if(n==0) image=chart1.chart.createBufferedImage( 600,400);
				if(n==1) image=chart2.chart.createBufferedImage( 600,400);
				
				JFileChooser saveChooser = new JFileChooser();
				int result = saveChooser.showSaveDialog(null);
				
				if(result==JFileChooser.APPROVE_OPTION){
					try{
			            saveToFile(image, saveChooser.getSelectedFile().getAbsolutePath()+".jpg");
			           }catch(Exception ok){
			           ok.printStackTrace();
			         }
				}
				else {
					return;
				}
			}};
		
		menuItem[1].addActionListener(Save);
		
	}
	
	
	public static void saveToFile(BufferedImage img, String filePath)
		    throws FileNotFoundException, IOException
		    {

		        File outputfile = new File(filePath);
		    ImageIO.write(img, "png", outputfile);
		    }
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {		
		realTime= (float)window.getEngine(window.engine, "time");
		valueChart1 = (float) window.getEngine(window.engine, setElementDataChart(checkElement, chart1));
		valueChart2 = (float) window.getEngine(window.engine, "I");
		chart1.update(realTime,valueChart1);
		chartPanel1.repaint();
		chart2.update(realTime,valueChart2);
		chartPanel2.repaint();	
		window.engine.time+=(1/window.getEngine(window.engine, "frequency"));
		
		
		if(window.engine.time==0){
			window.engine.presentI = window.engine.current;
			window.engine.presentUR = 0.0;
			window.engine.presentUL = 0.0;
			window.engine.presentUC = 0.0;
			window.engine.presentU = 0.0;
		}
		else{
			if(window.engine.circuit=="LC") window.engine.LC();
			if(window.engine.circuit=="RC")  window.engine.RC();
			if(window.engine.circuit=="RL")  window.engine.RL();
			if(window.engine.circuit=="RLC")  window.engine.RLC();
		}
		
		/*** SET CURRENT VALUE ***/
		
		if(checkElement instanceof Resistor ){
		((Resistor) checkElement).setVoltageLabel(window.engine.presentUR);
		((Resistor) checkElement).setCurrentLabel(window.engine.presentI);
		}
		else if(checkElement instanceof Source ){
		((Source) checkElement).setVoltageLabel(window.engine.presentU);
		((Source) checkElement).setCurrentLabel(window.engine.presentI);
		}
		else if(checkElement instanceof Inductor ){
		((Inductor) checkElement).setVoltageLabel(window.engine.presentUL);
		((Inductor) checkElement).setCurrentLabel(window.engine.presentI);
		}
		else if(checkElement instanceof Capacitor ){
		((Capacitor) checkElement).setVoltageLabel(window.engine.presentUC);
		((Capacitor) checkElement).setCurrentLabel(window.engine.presentI);
		}
		
	}
	
	public String setElementDataChart(Element el, Chart chart){
		if(el instanceof Resistor ) {
			chart.setTitle("Resistor Voltage");
			return "UR";
		}
		else if(el instanceof Source ) {
			chart.setTitle("Source Voltage");
			return "U";
		}
		else if(el instanceof Inductor ) {
			chart.setTitle("Inductor Voltage");
			return "UL";
		}
		else if(el instanceof Capacitor ) {
			chart.setTitle("Capacitor Voltage");
			return "UC";
		}
		else return lastClicked;	
	}
}
