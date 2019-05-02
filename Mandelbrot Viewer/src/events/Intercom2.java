package events;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;


//adapted from https://stackoverflow.com/questions/16566590/passing-data-between-jpanels
//this is a class that acts as a mediator between the main panel and the control panel. 
//when a value is changed in the control panel, the corresponding class is called in the Model class
//when the model class is called, the property change is fired and the main panel responds via the property change listener
//there are three main properties which are changed: grid status, iteration value, and system type

public class Intercom2 {
	public static final String IMNUMC = "ImNum";
	private SwingPropertyChangeSupport pcSupport = 
	         new SwingPropertyChangeSupport(this);
	private ImNum Center;
   

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public ImNum JuliaCVal() {
      return Center;
   }

   public void setJuliaVal(ImNum gd) {
      ImNum oldValue = this.Center;
      ImNum newValue = gd;

      this.Center = gd;
      pcSupport.firePropertyChange(IMNUMC, oldValue, newValue);
   }

   }
