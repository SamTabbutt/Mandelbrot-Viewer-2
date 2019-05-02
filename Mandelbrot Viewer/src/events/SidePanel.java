package events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class SidePanel extends MainPanel{
	
	private static final long serialVersionUID = 1L;

	public SidePanel(FractalS m) {
		super(m);
		
	}
	
	 //called when mouse is unclicked, maintains bounds of drawn ractangle and establishes
    //ComplexPlane extremes based on what is entered
    public void updateMandBounds(int x, int y){
    	double[] minvals = mb.getPlane().getPlaneValue(ss.getX(), ss.getY()+ss.getHeight());
    	double[] maxvals = mb.getPlane().getPlaneValue(ss.getX()+ss.getWidth(), ss.getY());
    	double iMin = maxvals[1];
    	double iMax = minvals[1];
    	double rMin = minvals[0];
    	double rMax = maxvals[0];
    	double zoom = 3/(rMax-rMin);
    	model.printToTextBox("Current Jul zoom: " +zoom);
    	mb.updateBounds(iMin,iMax,rMin,rMax);
    	repaint();
    }

	//sets model to interact with the control panel
	public void setModel(Model model1, Intercom2 ic2) {
		model = model1;
	      model.addPropertyChangeListener(new PropertyChangeListener() {

	         @Override
	         public void propertyChange(PropertyChangeEvent pcEvt) {
	            if (Model.SystemTYPE.equals(pcEvt.getPropertyName())) {
	               int ind = (int) pcEvt.getNewValue();
	               systemIndex = ind;
	            } else if (Model.Grid.equals(pcEvt.getPropertyName())) {
	               boolean gd = (boolean) pcEvt.getNewValue();
	               showGrid = gd;
	               setGridStatus(gd);
	            } else if(Model.Iter.equals(pcEvt.getPropertyName())) {
	               int iter  = (int) pcEvt.getNewValue();
	              Iterate = iter;
	               mb.setIterationLevel(Iterate);
	               repaint();
	            }else if (Model.resetJulZoom.equals(pcEvt.getPropertyName())) {
		               boolean resetJul = (boolean) pcEvt.getNewValue();
		               mb.updateBounds(-2,2,-2,2);
		               repaint();
	            }
	         }
	      });
	      
	      ic = ic2;
	      ic.addPropertyChangeListener(new PropertyChangeListener() {

		         @Override
		         public void propertyChange(PropertyChangeEvent pcEvt) {
		            if (ic.IMNUMC.equals(pcEvt.getPropertyName())) {
		               ImNum ind = (ImNum) pcEvt.getNewValue();
		               mb.SetCVal(ind);
		               repaint();
		            }}
		      });
	      
	      
	   }
}