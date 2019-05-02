package events;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


//Run Driver to initiate program
public class Driver {
	public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
	
	private static void createAndShowGUI() {
		//Establish MainFrame
        MainFrame f = new MainFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        //Create MainPanel for image display and ControlPanel for control and text display
        MainPanel MP = new MainPanel(new Mandelbrot(new Dimension(300,300)));
        SidePanel SP = new SidePanel(new Julia(new Dimension(300,300)));
        ControlPanel CP = new ControlPanel();
        Model model = new Model();
        Intercom2 ic= new Intercom2();
        
        CP.setModel(model);
        MP.setModel(model,ic);
        SP.setModel(model,ic);


        //Set flow layout
        f.getContentPane().setLayout(new FlowLayout());
        
        f.add(MP);
        f.add(SP);
        f.add(CP);
        
        //Establish dimension of 500X500 for ManeFrame
        f.setSize(1000,500);
        f.setVisible(true);
    } 
}
