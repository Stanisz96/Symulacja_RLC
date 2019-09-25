import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.geom.Arc2D;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inductor extends Element{

	int [] j;
	Arc2D.Double[] array_temp;
	
	JFormattedTextField voltageLabel;
	JFormattedTextField currentLabel;
	JLabel nameLabel;
	JFormattedTextField inductanceLabel;
	JLabel voltageName,currentName,inductanceName;
	

	public Inductor(int[] i, Color c, String _name) 
	{
		super (i,c,_name);
		this.j = i;
		array_temp = new Arc2D.Double[3];
		for(int k=0;k<array_temp.length;k++)
		{
			array_temp[k]= new Arc2D.Double(j[0]+k*j[2], j[1], j[2], j[3], j[4], j[5], Arc2D.OPEN); 
		}
	
	}
	
	void rysuj(Graphics g) 
    {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
        g2.setColor(currentColor); 
        for(int k=0;k<array_temp.length;k++)
		{
        	g2.draw(array_temp[k]);
		}
    }
	
	public boolean contains(int x2, int y2){
		if(x2>=j[0] && x2<=(j[0]+array_temp.length*j[2]) && y2<=(j[1]+j[3]) && y2>=j[1]){
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
    	inductanceName = new JLabel("Inductance :");
    	c.fill = GridBagConstraints.CENTER;
    	c.weighty = 0.1;
    	c.gridx = 0;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 1;
    	p.add(inductanceName, c);
    	
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
    	inductanceLabel = new JFormattedTextField(engine.inductance);
    	inductanceLabel.setColumns(8);
    	inductanceLabel.setEditable(false);
    	c.gridx = 1;
    	c.weightx = 0.5;
    	c.gridwidth = 1;
    	c.gridy = 1;
    	p.add(inductanceLabel, c);
    	
    	voltageLabel = new JFormattedTextField(engine.presentUL);
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
