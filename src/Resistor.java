import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Resistor extends Element{

	int[] wsp;
	JFormattedTextField voltageLabel;
	JFormattedTextField currentLabel;
	JFormattedTextField resistanceLabel;
	JLabel voltageName,currentName,resistanceName;


	public Resistor(int[] xy,Color c,String _name) {
		super(xy, c, _name);
		this.wsp = xy;
	}
	
    void rysuj(Graphics g) 
    {	
      g.setColor(currentColor); 
      g.fillRect(wsp[0], wsp[1], wsp[2], wsp[3]); 
    }

     boolean contains(int x2, int y2) {
		if(x2>=wsp[0] && x2<=(wsp[0]+wsp[2]) && y2>=wsp[1] && y2<=(wsp[1]+wsp[3])){
			return true;
		}
		else
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
    	resistanceName = new JLabel("Resistance :");
    	c.fill = GridBagConstraints.CENTER;
    	c.weighty = 0.1;
    	c.gridx = 0;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 1;
    	p.add(resistanceName, c);
    	
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
    	resistanceLabel = new JFormattedTextField(engine.resistance);
    	resistanceLabel.setColumns(8);
    	resistanceLabel.setEditable(false);
    	c.gridx = 1;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 1;
    	p.add(resistanceLabel, c);
    	
    	voltageLabel = new JFormattedTextField(engine.presentUR);
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
	
	public void setResistanceLabel(double value) {
		this.resistanceLabel.setValue(value);
	}

}

