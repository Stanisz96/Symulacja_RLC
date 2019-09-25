import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Capacitor extends Element {

	int[] wsp;
	JFormattedTextField voltageLabel;
	JFormattedTextField currentLabel;
	JLabel nameLabel;
	JFormattedTextField capacitanceLabel;
	JLabel voltageName,currentName,capacitanceName;
	
	public Capacitor(int[] _xy, Color c, String _name) {
		super(_xy, c, _name);
		this.wsp = _xy;
	}

	void rysuj(Graphics g) 
    {	
	 Graphics2D g2 = (Graphics2D) g;
      g2.setColor(currentColor); 
      g2.drawLine(wsp[0], wsp[1], wsp[0]+20, wsp[1]);
    
	  g2.setStroke(new BasicStroke(8));
	  g2.drawLine(wsp[0]+20, wsp[1]-20, wsp[0]+20, wsp[1]+20);
	  g2.drawLine(wsp[0]+40, wsp[1]-20, wsp[0]+40, wsp[1]+20);
	  g2.setStroke(new BasicStroke(5));
	  g.drawLine(wsp[0]+40, wsp[1], wsp[0]+60, wsp[1]);
    }
	
	
	@Override
	boolean contains(int x, int y) {
		if(x>=wsp[0] && x<=wsp[0]+60 && y>=wsp[1]-20 && y<=wsp[1]+20) return true;
		return false;
	}
	
	void label(Engine engine, JPanel p){
    	p.removeAll();
    	p.revalidate();
    	p.repaint();
    	p.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	
    	nameLabel = new JLabel(GetName());
    	nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
    	c.fill = GridBagConstraints.NORTH;
    	c.gridx = 0;
    	c.weighty = 0.1;
    	c.gridy = 0;
    	c.gridwidth = 2;
    	p.add(nameLabel, c);
    	
    	/*column 1 */
    	capacitanceName = new JLabel("Capacitance :");
    	c.fill = GridBagConstraints.CENTER;
    	c.weighty = 0.1;
    	c.gridx = 0;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 1;
    	p.add(capacitanceName, c);
    	
    	voltageName = new JLabel("Voltage :");
    	c.gridx = 0;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 2;
    	p.add(voltageName, c);
    	
    	currentName = new JLabel("Current :");
    	c.gridx = 0;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 3;
    	p.add(currentName, c);
    	
    	
    	/* column 2 */
    	capacitanceLabel = new JFormattedTextField(engine.capacitance);
    	capacitanceLabel.setColumns(8);
    	capacitanceLabel.setEditable(false);
    	c.gridx = 1;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 1;
    	p.add(capacitanceLabel, c);
    	
    	voltageLabel = new JFormattedTextField(engine.presentUC);
    	voltageLabel.setColumns(8);
    	voltageLabel.setEditable(false);
    	c.gridx = 1;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 2;
    	p.add(voltageLabel, c);
    	
    	currentLabel = new JFormattedTextField(engine.presentI);
    	currentLabel.setColumns(8);
    	currentLabel.setEditable(false);
    	c.gridx = 1;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 3;
    	p.add(currentLabel, c);
    }
	
	public void setVoltageLabel(double value) {
		this.voltageLabel.setValue(value);
	}
	
	public void setCurrentLabel(double value) {
		this.currentLabel.setValue(value);
	}

}
