package events;

import java.awt.Dimension;
import java.awt.Graphics;

public interface FractalS {
	public int[][] ReturnIntSet(CompPlane plane, int mult);
	public void updateBounds(double iMin,double iMax, double rMin, double rMax);
	public void changePower(double n);
	public int[][] makeFract(Dimension d);
	public Plane getPlane();
	public void makeIcon(Graphics g);
	public void setIterationLevel(int iterate);
	public void SetCVal(ImNum ind);
}
