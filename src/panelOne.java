import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelOne extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel label1 = new JLabel("Wyswietla parametry obiektu");
	public List<Element> elements;
	
    public panelOne() {             
  		 elements = new ArrayList<Element>();
    } 

    @Override
    protected void paintComponent(Graphics g) {
 
        super.paintComponent(g);
       for(Element el: elements) el.rysuj(g);
    }
    public void setRLC()
    {
    	ClearElements();
    	elements.add(new Resistor(new int[] {90,60,70,40}, Color.BLACK,"Resistor"));
    	elements.add(new Connection(new int[] {160,80,200,80}, Color.BLACK,"line"));
    	elements.add(new Inductor(new int[] {200, 50, 30, 60, 0, 180},Color.BLACK, "Inductor"));
    	elements.add(new Connection(new int[] {295,80,330,80}, Color.BLACK,"line"));
    	elements.add(new Capacitor(new int[] {330,80}, Color.BLACK, "Capacitor"));
    	elements.add(new Connection(new int[] {390,80,420,80}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {420,80,420,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {420,280,280,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {220,280,60,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {60,280,60,80}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {60,80,90,80}, Color.BLACK,"line"));
    	elements.add(new Source(new int[] {220,250,60,60}, Color.BLACK,"Source"));
    	repaint();

    }
    public void setLC()
    {
 
    	ClearElements();
    	elements.add(new Connection(new int[] {120,80,160,80}, Color.BLACK,"line"));
    	elements.add(new Inductor(new int[] {160, 50, 30, 60, 0, 180},Color.BLACK, "Inductor"));
    	elements.add(new Connection(new int[] {255,80,310,80}, Color.BLACK,"line"));
    	elements.add(new Capacitor(new int[] {310,80}, Color.BLACK, "Capacitor"));
    	elements.add(new Connection(new int[] {370,80,420,80}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {420,80,420,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {420,280,280,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {220,280,60,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {60,280,60,80}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {60,80,120,80}, Color.BLACK,"line"));
    	elements.add(new Source(new int[] {220,250,60,60}, Color.BLACK,"source"));
    	repaint();

    }
    public void setRC()
    {
    	ClearElements();
    	elements.add(new Connection(new int[] {120,80,160,80}, Color.BLACK,"line"));
    	elements.add(new Resistor(new int[] {160,60,70,40}, Color.BLACK,"Resistor"));
    	elements.add(new Connection(new int[] {230,80,300,80}, Color.BLACK,"line"));
    	elements.add(new Capacitor(new int[] {300,80}, Color.BLACK, "Capacitor"));
    	elements.add(new Connection(new int[] {360,80,420,80}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {420,80,420,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {420,280,280,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {220,280,60,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {60,280,60,80}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {60,80,120,80}, Color.BLACK,"line"));
    	elements.add(new Source(new int[] {220,250,60,60}, Color.BLACK,"Source"));
    	repaint();
    }
    
    public void setRL()
    {
    	ClearElements();
    	elements.add(new Connection(new int[] {120,80,160,80}, Color.BLACK,"line"));
    	elements.add(new Inductor(new int[] {160, 50, 30, 60, 0, 180},Color.BLACK, "Inductor"));
    	elements.add(new Connection(new int[] {255,80,300,80}, Color.BLACK,"line"));
    	elements.add(new Resistor(new int[] {300,60,70,40}, Color.RED,"Resistor"));
    	elements.add(new Connection(new int[] {370,80,420,80}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {420,80,420,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {420,280,280,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {220,280,60,280}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {60,280,60,80}, Color.BLACK,"line"));
    	elements.add(new Connection(new int[] {60,80,120,80}, Color.BLACK,"line"));
    	elements.add(new Source(new int[] {220,250,60,60}, Color.BLACK,"Source"));

    	repaint();
    }
    
    public void BurstClick(Element el)
    {
    	el.Clicked();
    	repaint();
    }
    public void BurstResetClick(Element el)
    {
    	el.resetClicked();
    	repaint();
    }
    
	void ClearElements()
	{
		elements.clear();
	}
	
	void ConnectElements(Graphics g,int x1,int y1,int x2,int y2){
 		g.drawLine(x1, y1, x2, y2);
 	}

	public List<Element> GetElements() {
		return elements;
	}

}
