
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Color;
import java.awt.Font;


public class Chart{
	
	 public XYSeries series;
	 public int range;
	 public JFreeChart chart;
	 NumberAxis domainAxis;
     NumberAxis rangeAxis;
     XYPlot plotCluster;
     XYPlot plot ;
     XYSplineRenderer renderer ;
     XYSeriesCollection dataset;
     ValueAxis axis;
     //static int licznik=0;
     boolean resizeRange=true;

	public Chart(String valueTitle) 
		 {
		    setDataset("Napiêcie","t[s]",valueTitle, 10);
		 }

	public void setTitle(String title)
		{
			Font f = new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12);
		    chart.setTitle(new org.jfree.chart.title.TextTitle(title,f));
		}

	//add another value and if size is greater than range of chart delete first on the left
	public void update(double a, double b)
		{	
			series.add(a, b);
			if (series.isEmpty() && series.getItems().size()>range)
		    	series.remove(0);
		}	
	
	
	public void setDataset(String name, String xAxisName, String yAxisName, int _range)
		{
		    dataset = new XYSeriesCollection();
		    series = new XYSeries("MyGraph",false,true);
		    dataset.addSeries(series);
		  

		    chart = ChartFactory.createXYLineChart(name,xAxisName,yAxisName,(XYDataset) dataset, PlotOrientation.VERTICAL,false,true,false);
		    setTitle(name);

		    
		    plot = (XYPlot) chart.getPlot();
		
		    renderer = new XYSplineRenderer();
		    renderer.setSeriesLinesVisible(0, true);
		    renderer.setSeriesShapesVisible(0, false);
				
		    plot.setDomainZeroBaselineVisible(false);
		    plot.setBackgroundPaint (Color.black);
		    plot.setDomainMinorGridlinesVisible(false);
		
		    plot.setRangeGridlinesVisible(true);
		    plot.setDomainCrosshairVisible(true);
		    plot.setDomainGridlinesVisible(true);
		    plot.addDomainMarker(new ValueMarker(0));
		    plot.getRenderer().setSeriesPaint(0, new Color(20,255,51));
		    
		    ValueAxis axis = plot.getDomainAxis();
		    axis.setFixedAutoRange(_range);	
		}
	

	public ValueAxis getAxis() {
		return axis;
	}

	public void setDomainAxis(double d) {
		this.plot.getDomainAxis().setFixedAutoRange(d);
	}
	
	public void setRangeAxis(double min,double max) {
		this.plot.getRangeAxis().setRange(min, max);
	}

}
