import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Engine implements ActionListener {

	double voltage,frequency,current,resistance,inductance,capacitance;
	double presentUR, presentUL, presentUC,presentU, presentF, presentR, presentL, presentC;
	double presentI;
	String acDc, circuit;
	double time=0;
	Timer t;
	
	public Engine(String _circuit,double  _frequency,double  _current,double  _resistance,double  _inductance,double  _capacitance) {

		this.frequency = _frequency;
		this.current = _current;
		this.resistance = _resistance;
		this.inductance = _inductance;
		this.capacitance = _capacitance;
		this.circuit = _circuit;
	
		if(this.circuit=="LC") LC();
		if(this.circuit=="RC")  RC();
		if(this.circuit=="RL")  RL();
		if(this.circuit=="RLC")  RLC();

	}
	
	void RLC(){
		presentI = this.current*Math.sin(this.frequency/(2*Math.PI)*time);
		presentUR = this.resistance*this.current*Math.sin(this.frequency/(2*Math.PI)*time);
		presentUL = (this.frequency/(2*Math.PI))*this.current*Math.sin(this.frequency/(2*Math.PI)*time+Math.PI/2);
		presentUC = (1/((this.frequency/(2*Math.PI))*this.capacitance))*this.current*Math.sin(this.frequency/(2*Math.PI)*time-Math.PI/2);
		presentU = presentUR+presentUL+presentUC;
	}
	
	void RL(){
		presentI = this.current*Math.sin(this.frequency/(2*Math.PI)*time);
		presentUR = this.resistance*this.current*Math.sin(this.frequency/(2*Math.PI)*time);
		presentUL = (this.frequency/(2*Math.PI))*this.current*Math.sin(this.frequency/(2*Math.PI)*time+Math.PI/2);	
		presentU = presentUR+presentUL;
	}
	
	void RC(){
		presentI = this.current*Math.sin(this.frequency/(2*Math.PI)*time);
		presentUR = this.resistance*this.current*Math.sin(this.frequency/(2*Math.PI)*time);
		presentUC = (1/((this.frequency/(2*Math.PI))*this.capacitance))*this.current*Math.sin(this.frequency/(2*Math.PI)*time-Math.PI/2);
		presentU = presentUR+presentUC;
	}
	
	void LC(){
		presentI = this.current*Math.sin(this.frequency/(2*Math.PI)*time);
		presentUL = (this.frequency/(2*Math.PI))*this.current*Math.sin(this.frequency/(2*Math.PI)*time+Math.PI/2);
		presentUC = (1/((this.frequency/(2*Math.PI))*this.capacitance))*this.current*Math.sin(this.frequency/(2*Math.PI)*time-Math.PI/2);
		presentU = presentUL+presentUC;
	}


	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		
	}	
}
