import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataEntry extends JFrame implements ActionListener, Cloneable {

	public JLabel label[] = new JLabel[7];
	public JTextField text[] = new JTextField[7];
	public JPanel panel[] = new JPanel[14];
	Double voltage,frequency,current,resistance,inductance,capacitance;
	String acDc;
	String circuit;
	boolean arg=false;
	boolean _startCondition = false, _chartCondition=false;
	public Engine engine;
	
	private static final long serialVersionUID = 1L;
	
	public DataEntry(String chooseCircuit, panelOne panelone) throws HeadlessException{
		
		this.circuit = chooseCircuit;
		
		setSize(400,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(new GridLayout(8, 1));
		
		
		String[] stringParameters = {"Napięcie [V]", "Rodzaj napięcia", "Częstotliwość [Hz]", "Natężenie prądu [A]", "Opór Rezystora [Ω]", "Inducyjność Cewki", "Pojemność Kondensatora"};
        LinkedList<String> listParameters = new LinkedList<String>();
		for(String x: stringParameters)	listParameters.add(x);
		for(int i=0;i<listParameters.size()*2;i++){
			panel[i]= new JPanel();
			panel[i].setBorder(BorderFactory.createEtchedBorder());
			add(panel[i]);
		}
		
		for(int i=0;i<listParameters.size();i++)
		{
			label[i] = new JLabel (listParameters.get(i));
			label[i].setBorder(BorderFactory.createEmptyBorder(12,0,0,0)); 
			text[i] = new JTextField("");
			
			text[i].setDocument (new JTextFieldLimit(8));
			text[i].setPreferredSize(new Dimension(150,40));		
		}
		for(int i=0,j=0, k=0; i<listParameters.size()*2;i++){
			if (i%2==0){
				panel[i].add(label[j]);
				j++;
			}
			if(i%2==1){
				panel[i].add(text[k]);
				k++;
			}
		}
		
		//which parameter is blocked
		text[1].setEditable(false);
		text[0].setEditable(false);
		if(circuit=="LC") text[4].setEditable(false);
		if(circuit=="RC") text[5].setEditable(false);
		if(circuit=="RL") text[6].setEditable(false);
		


		JButton ok = new JButton("Akceptuj");
		add(ok);
		ok.addActionListener(this);
		JButton no = new JButton("Anuluj");
		add(no);
		no.addActionListener(this);
		
		no.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		dispose(); //Destroy the JFrame object
        	}});
		ok.addActionListener(new ActionListener(){
        	

			public void actionPerformed(ActionEvent e){
        		try{
        		frequency = Double.parseDouble(text[2].getText())*40;
        		current = Double.parseDouble(text[3].getText());
        		if(circuit!="LC") resistance = Double.parseDouble(text[4].getText());
        		else resistance = (double) 0;
        		if(circuit!="RC") inductance = Double.parseDouble(text[5].getText());
        		else inductance = (double) 0;
        		if(circuit!="RL") capacitance = Double.parseDouble(text[6].getText());
        		else capacitance = (double) 0;
        		arg = true;
        		}
        		catch(NumberFormatException a){
        			arg = false;
        			JOptionPane.showMessageDialog(rootPane, "Nie wypełniono wszystkich pól, albo podano niewłaściwy format danych","Błąd", JOptionPane.ERROR_MESSAGE);
        		}
        		if(arg){
        		
        		engine = new Engine(circuit,frequency,current,resistance,inductance,capacitance);
        		setVisible(false);
        		
        		if(circuit=="LC") panelone.setLC();
        		if(circuit=="RC")  panelone.setRC();
        		if(circuit=="RL")  panelone.setRL();
        		if(circuit=="RLC")  panelone.setRLC();
        		
        		}
        		_chartCondition = true;
        		_startCondition = true;	
        	}});
		 
	}
	
	 public double  getEngine(Engine e, String parametr){
		 if(parametr=="I") return e.presentI;
		 if(parametr=="UR") return e.presentUR;
		 if(parametr=="UL") return e.presentUL;
		 if(parametr=="UC") return e.presentUC;
		 if(parametr=="U") return e.presentU;
		 if(parametr=="time") return e.time;
		 if(parametr=="frequency") return e.frequency;
		 else return 0;
	 }
	


	public boolean is_startCondition() {
		return _startCondition;
	}
	public boolean is_chartCondition() {
		return _chartCondition;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
	
	}
}
