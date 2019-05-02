# Mandelbrot-Viewer-2
This is an in-progress project I am working on to visualize and interact with complex dynamical systems

Welcome to the Mandelbrot Set Explorer. The mandelbrot set is a fractal set which displays visually the long-term behavior of each point (c) on the complex plane under iterations of the function f(x)=x^2+c with the seed of the function x0=0. If a point is colored black, then it remains bound for n iterations of the function. All other colors represent different slopes of unboundedness. The mandelbrot set will appear on the left panel of the applet.

This program has the ability to zoom into any point with magnification on the order of 10^10. Once you get this deep, the java capability of distinguishing between points is lost, and you get distorted images. Further programming could ocvercome this issue. 

To zoom, click and drag the mouse to create the new frame you would like to view. The initial click will set the upper-left corner of the new zoom frame. Drag down and to the right to make your frame. The frame will auto-adjust to keep the image display to have a real-to-imaginary aspect ratio of 1:1. Once you dive deeper, you may see less interesting activity. At this point you can turn the iteration setting up (which is available through a chooser displayed on the applet). The iteration setting will provide further details of the bizzare behavior of points in the set.

To the right of the mandelbrot set is a julia set viewer. The Julia set is associated with a single point of the complex plane. To set a new value to estalish the julia set, double-click on a point in the mandelbrot set viewframe. You will see that as you dive into the mandelbrot set, the points which you are zooming into resemble aspects of the Julia sets derived from that region. Bizzare!

You can zoom into the Julia set display in the same manner as the mandelbrot set. The applet provides an option to reset the Julia set zoom so you can start over with a new Julia set. If you wish to overlay a grid, there is also a checkbox in the control panel which will enable a gridview display overlayed each set individually

Enjoy exploring!
