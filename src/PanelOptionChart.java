import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;

public class PanelOptionChart implements ChangeListener{

	static Color currentColor =  Color.BLACK;
	static Color currentColor2 =  Color.GREEN;
	static JButton button;
    static JColorChooser colorChooser;
    static JDialog dialog;
    static SpinnerListModel spinnerList, spinnerList2;
    
    
	public static void addBox(JPanel panel, GridBagConstraints gbc, String title, Chart chart){
		JLabel name = new JLabel(title);
		name.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(name,gbc);
		
		
		//HORIZONTAL
		JLabel hAxis = new JLabel("Horizontal Axis");
		hAxis.setBorder(BorderFactory.createEtchedBorder());
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panel.add(hAxis,gbc);
		
		
		JLabel Scale1 = new JLabel("Scale");
		Scale1.setBorder(BorderFactory.createEtchedBorder());
		gbc.weightx = 0.25;
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		panel.add(Scale1,gbc);
		
		
		String scaleString[] = {"1μs/Div","10μs/Div","100μs/Div","1ms/Div","10ms/Div","100ms/Div","1s/Div","10s/Div","100s/Div"};
		spinnerList = new SpinnerListModel(scaleString);
		JSpinner spinnerPane = new JSpinner(spinnerList);
		spinnerPane.setEditor(new JSpinner.DefaultEditor(spinnerPane));
		setSelectedIndex(spinnerPane, spinnerList.getList(), 6);
		gbc.weightx = 0.25;
		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		panel.add(spinnerPane,gbc);
		
		
		JLabel position1 = new JLabel("Position");
		position1.setBorder(BorderFactory.createEtchedBorder());
		gbc.weightx = 0.25;
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		panel.add(position1,gbc);
		 
		
		JTextField text2 = new JTextField("0");
		text2.setEnabled(false);
		gbc.weightx = 0.25;
		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		panel.add(text2,gbc);
		
		
		JLabel colorChart1 = new JLabel("Color Line");
		colorChart1.setBorder(BorderFactory.createEtchedBorder());
		gbc.weightx = 0.25;
		gbc.weighty = 0.1;
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panel.add(colorChart1,gbc);
		
		
		JButton text3 = new JButton("Choose color");
		text3.setBackground(new Color(205, 209, 242));
		text3.setForeground(Color.BLACK);
		text3.setFocusPainted(false);
		gbc.weightx = 0.25;
		gbc.gridy = 4;
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		panel.add(text3,gbc);

		
		JLabel colorBackground1 = new JLabel("Color Background");
		colorBackground1.setBorder(BorderFactory.createEtchedBorder());
		gbc.weightx = 0.25;
		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panel.add(colorBackground1,gbc);
		
		
		JButton text4 = new JButton("Choose color");
		text4.setBackground(new Color(205, 209, 242));
		text4.setForeground(Color.BLACK);
		text4.setFocusPainted(false);
		//text4.setFont(new Font("Tahoma", Font.BOLD, 12));
		gbc.weightx = 0.25;
		gbc.gridy = 5;
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		panel.add(text4,gbc);
		
		
		
		//VERTICAL
		JLabel vAxis = new JLabel("Vertical Axis");
		vAxis.setBorder(BorderFactory.createEtchedBorder());
		gbc.gridy = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		panel.add(vAxis,gbc);
		
		
		JLabel Scale2 = new JLabel("Scale");
		Scale2.setBorder(BorderFactory.createEtchedBorder());
		gbc.weightx = 0.25;
		gbc.gridy = 2;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		panel.add(Scale2,gbc);
		
		
		String scaleString2[] = {"1μV/Div","10μV/Div","100μV/Div","1mV/Div","10mV/Div","100mV/Div","1V/Div","10V/Div","100V/Div","1kV/Div","10kV/Div","100kV/Div","1MV/Div","10MV/Div"};
		spinnerList2 = new SpinnerListModel(scaleString2);
		JSpinner spinnerPane2 = new JSpinner(spinnerList2);
		spinnerPane2.setEditor(new JSpinner.DefaultEditor(spinnerPane2));
		setSelectedIndex(spinnerPane2, spinnerList2.getList(), 5);
		gbc.weightx = 0.25;
		gbc.gridy = 2;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		panel.add(spinnerPane2,gbc);
		
		
		JLabel position2 = new JLabel("Position");
		position2.setBorder(BorderFactory.createEtchedBorder());
		gbc.weightx = 0.25;
		gbc.gridy = 3;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		panel.add(position2,gbc);
		
		JTextField text6 = new JTextField("0");
		text6.setEnabled(false);
		gbc.weightx = 0.25;
		gbc.gridy = 3;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		panel.add(text6,gbc);
		
		
		/***********************************/
		/**        ACTION LISTENERS       **/
		/***********************************/
		
		//CHOOSE LINE COLOR
		
		text3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				colorChooser = new JColorChooser();
		        dialog = JColorChooser.createDialog(button,"Pick a Color",true,colorChooser,
		        		new ActionListener(){
		        			public void actionPerformed(ActionEvent arg0) {
		        				  currentColor2 = colorChooser.getColor();
							      chart.plot.getRenderer().setSeriesPaint(0, currentColor2);
				   		          }}, null);
		        dialog.setVisible(true);	
		}});
		
		//CHOOSE BACKGROUND COLOR
		
		text4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				colorChooser = new JColorChooser();
		        dialog = JColorChooser.createDialog(button,"Pick a Color",true,colorChooser,
		        		new ActionListener(){
		        			public void actionPerformed(ActionEvent arg0) {
		        				  currentColor = colorChooser.getColor();
							      chart.plot.setBackgroundPaint(currentColor);
				   		          }}, null);
		        dialog.setVisible(true);	
		}});
		
		
		//CHOOSE SCALE DOMAIN AND RANGE
		
		JComponent comp = spinnerPane.getEditor();
	    JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
	    DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
	    formatter.setCommitsOnValidEdit(true);
	    spinnerPane.addChangeListener(new ChangeListener() {

	        @Override
	        public void stateChanged(ChangeEvent e) {

	        	int n=-6;
	        	for(int i=0;i<scaleString.length;i++){
	        		if(spinnerPane.getValue()==scaleString[i]) chart.setDomainAxis(Math.pow(10, n+1));
	        		n+=1;	
	        	}
	        }
	    });
	    
	    
	    spinnerPane2.addChangeListener(new ChangeListener() {

	        public void stateChanged(ChangeEvent e) {
	        	int n=-6;
	        	for(int i=0;i<scaleString2.length;i++){
	        		if(spinnerPane2.getValue()==scaleString2[i])
	        			chart.setRangeAxis(Math.min(2*Math.pow(10, n), 2*Math.pow(10, n)*-1),Math.max(2*Math.pow(10, n), 2*Math.pow(10, n)*-1));
	        			n+=1;
	        		
	        	}
	        }
	    });
		
	}


	@Override
	public void stateChanged(ChangeEvent arg0) {
		
	}

	public int getSelectedIndex(JSpinner spinner, List<?> values) {
	    int index=0;
	    for(Object o :values) {
	        if(o.equals(spinner.getValue()))
	            return index;
	        index++;
	    }
	    return -1;
	}
	public static void setSelectedIndex(JSpinner spinner, List<?> values, int index) {
	    spinner.setValue(values.get(index));
	}

	
}
