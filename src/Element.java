import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Element{

	String name;
	JLabel nameLabel;
	Color colorDefault;
	Color currentColor;
	int[] xy;

	
	public Element(int[] _xy, Color c,String _name){
		this.name=_name;
		this.colorDefault = c;
		this.currentColor = this.colorDefault;
		this.xy=_xy;
	}
	
	abstract void rysuj(Graphics g) ;
    
	abstract void label(Engine engine, JPanel p);
	
	abstract boolean contains(int x, int y);
	
	public void ClearLabel(JPanel p){
		p.removeAll();
    	p.revalidate();
    	p.repaint();
    	nameLabel = new JLabel("<None>");
    	nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
    	p.add(nameLabel);
	}
	
	void Clicked()
    {
    	currentColor=Color.GREEN;
    	
    }
	
	
	
    void resetClicked() { currentColor = colorDefault;}
	
	String GetName(){return name;}
}
