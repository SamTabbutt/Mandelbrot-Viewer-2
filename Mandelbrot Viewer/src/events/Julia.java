package events;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class Julia implements FractalS{
	CompPlane P;
    
    int[][] intSet;
    
    Dimension dim;
    ImNum c;
	CompPlane currentPlane;
	double power;
	int pixMult;
	int Iterations;	
	
	public Julia(Dimension d) {
		power = 2;
		dim=d;
		pixMult = 100000;
		Iterations = 100;
		currentPlane = new CompPlane(0,-2,2,d.getWidth(),d.getHeight());
		c = new ImNum(.035,.4);
		intSet = makeFract(d);

	}
	
	
	//when a new zoom frame is established, this class is called and recreates the mandelbrot
	//set under the new frame conditions.
	public void updateBounds(double iMin,double iMax, double rMin, double rMax) {
		currentPlane = new CompPlane(iMin,iMax,rMin,rMax,dim.getWidth(),dim.getHeight());
		intSet = makeFract(dim);
	}
	
	
	public void makeIcon(Graphics g) {	
		 for ( int r = 1; r < dim.width; r++ ) {
	          for ( int i = 1; i < dim.height; i++ ) {
	        	  //im.setRGB(r, i, intSet[r][i]);
	        	g.setColor(Color.getColor("n",intSet[r][i]));
	       		g.fillRect(r,i, dim.width, dim.height);
	          }}
		// ImageIcon ii = new ImageIcon(im);
		// return ii;
	}

	//this method is really all that is going on here. 
	//the mandelbrot set is an evaluation of the slope of the orbit at each point in the 
	//complex plane. We have established a plane which we are viewing from, and a resolution
	//based on the width and height of the image we are viewing. 
	public int[][] makeFract(Dimension d) {
		int h = currentPlane.plane.length;
		int w = currentPlane.plane[0].length;
		int[][] init = new int[w][h];
		for(int r=0;r<h;r++) {
			for(int i=0;i<w;i++) {
				Orbit temp = new Orbit(currentPlane.plane[r][i],power,Iterations,c);
				init[r][i]=(int) (temp.diverge)*pixMult;
			}
		}	
		return init;
	}

	public void setIterationLevel(int iterate) {
		Iterations = iterate;
		intSet = makeFract(dim);
		
	}


	@Override
	public int[][] ReturnIntSet(CompPlane plane, int mult) {
		// TODO Auto-generated method stub
		return intSet;
	}


	@Override
	public void changePower(double n) {
		// TODO Auto-generated method stub
		power = n;
	}


	@Override
	public Plane getPlane() {
		// TODO Auto-generated method stub
		return currentPlane;
	}


	@Override
	public void SetCVal(ImNum ind) {
		// TODO Auto-generated method stub
		c = ind;
		intSet = makeFract(dim);
	}
	
}
