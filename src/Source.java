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

public class Source extends Element {

	int wsp[];
	JFormattedTextField voltageLabel;
	JFormattedTextField currentLabel;
	JLabel nameLabel;
	JLabel voltageName,currentName;
	
	public Source(int[] _xy, Color c, String _name) {
		super(_xy, c, _name);
		this.wsp = _xy;
	}

	@Override
	void rysuj(Graphics g) {
		 Graphics2D g2 = (Graphics2D) g;
	      g2.setColor(currentColor); 
	      g2.setStroke(new BasicStroke(5));
	      g2.drawArc(wsp[0], wsp[1], wsp[2], wsp[3], 0, 360);
	      g2.setStroke(new BasicStroke(3));
	      g2.drawArc(wsp[0]+wsp[3]/6, wsp[1]+wsp[3]/3, wsp[2]/3, wsp[3]/3, 0, 180);
	      g2.drawArc(wsp[0]+wsp[3]/6+wsp[2]/3, wsp[1]+wsp[3]/3, wsp[2]/3, wsp[3]/3,180, 180);
	}

	@Override
	boolean contains(int x, int y) {
		if(x>=wsp[0] && x<=(wsp[0]+wsp[2]) && y<=(wsp[1]+wsp[3]) && y>=wsp[1]){
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
    	
    	voltageName = new JLabel("Voltage :");
    	c.gridx = 0;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 1;
    	p.add(voltageName, c);
    	
    	currentName = new JLabel("Current :");
    	c.gridx = 0;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 2;
    	p.add(currentName, c);
    	
    	
    	/* column 2 */
    	
    	voltageLabel = new JFormattedTextField(engine.presentU);
    	voltageLabel.setColumns(8);
    	voltageLabel.setEditable(false);
    	c.gridx = 1;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 1;
    	p.add(voltageLabel, c);
    	
    	currentLabel = new JFormattedTextField(engine.presentI);
    	currentLabel.setColumns(8);
    	currentLabel.setEditable(false);
    	c.gridx = 1;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 2;
    	p.add(currentLabel, c);
    }
	
	public void setVoltageLabel(double value) {
		this.voltageLabel.setValue(value);
	}
	
	public void setCurrentLabel(double value) {
		this.currentLabel.setValue(value);
	}

}
