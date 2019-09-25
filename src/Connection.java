import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Connection extends Element {

	int[] wsp;
	
	public Connection(int[] _xy, Color c, String _name) {
		super(_xy, c, _name);
		this.wsp = _xy;
	}
	
	void rysuj(Graphics g){
		g.setColor(currentColor);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
	 	g2.drawLine(wsp[0], wsp[1], wsp[2], wsp[3]);
	}

	boolean contains(int x, int y) {
		return false;
	}

	void label(Engine engine, JPanel p) {
	}

}
