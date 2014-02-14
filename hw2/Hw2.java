/* Hw2.java

   Ian Westrope
   CS 324
   HW #2
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*;

public class Hw2 extends JComponent
{
    static int framewidth = 500;
    static int frameheight = 500;
    static double x;
    static double y;

    public static void main( String[] args)
    {
	InitGraphics();


    }

    public void paintComponent( Graphics g)
    {	
	// Create window one
	Window w1 = MyGraphicsAPI.SetWindow(-9,-15,9,15,-1,0,0,1);
	
	// Graph the line y = 2 / (0.5 - sin( x/2 ))
	Point p = MyGraphicsAPI.WindowToViewport( w1,-9 ,0 );
	p = MyGraphicsAPI.ViewPortToFrameWindow(w1, p);
	MoveTo2D(p);
	double i;
	for( i = -9.0; i <= 9.0 ; i = i + 0.2)
	{
	    double y = 2 / (0.5 - Math.sin(i/2));
	    p = MyGraphicsAPI.WindowToViewport( w1, i, y);
	    p = MyGraphicsAPI.ViewPortToFrameWindow(w1, p);
	    DrawTo2D(p, g);
	    }

	// Create window two 
	Window w2 = MyGraphicsAPI.SetWindow(0, -15, (3.0*Math.PI), 20, 0,0,1,1);

       	// Graph the line 4.0e^(-.25x)cos(4x)
        p = MyGraphicsAPI.WindowToViewport( w2, 0 , 0 );
	p = MyGraphicsAPI.ViewPortToFrameWindow(w2, p);
	MoveTo2D(p);
	for( i = 0; i <= (3.0*Math.PI) ; i = i + 0.2)
	{
	    double y = 4.0 * Math.exp((-.25 * i)) * Math.cos((4.0 * i));
	    p = MyGraphicsAPI.WindowToViewport( w2, i, y);
	    p = MyGraphicsAPI.ViewPortToFrameWindow(w2, p);
	    DrawTo2D(p, g);
	}

	// Create window three 
	Window w3 = MyGraphicsAPI.SetWindow(0, 0, 20, 20, 0,-1,1,0);

       	// Graph the line 4.0e^(-.25x)cos(4x)
        p = MyGraphicsAPI.WindowToViewport( w3, 8 , 10 );
	p = MyGraphicsAPI.ViewPortToFrameWindow(w3, p);
	MoveTo2D(p);
	PrintName(p, g);

	// Create window four 
	Window w4 = MyGraphicsAPI.SetWindow(-10, 0, 10, 20, -1,-1,0,0);

       	// Graph the line y = sqrt(.5x + 5x^2
        p = MyGraphicsAPI.WindowToViewport( w4, -10 , 10 );
	p = MyGraphicsAPI.ViewPortToFrameWindow(w4, p);
	MoveTo2D(p);
	for( i = -10.0; i <= 10.0 ; i = i + 0.2)
	{
	    double y = Math.sqrt((.5 * i) + (.5 * Math.pow(i, 2)));
	    if( Double.isNaN(y) ) continue;
	    p = MyGraphicsAPI.WindowToViewport( w4, i, y);
	    p = MyGraphicsAPI.ViewPortToFrameWindow(w4, p);
	    DrawTo2D(p, g);
	}

       	// Graph the line y = sqrt(x + .5x^2
        p = MyGraphicsAPI.WindowToViewport( w4, -10 , 10 );
	p = MyGraphicsAPI.ViewPortToFrameWindow(w4, p);
	MoveTo2D(p);
	for( i = -10.0; i <= 10.0 ; i = i + 0.2)
	{
	    double y = Math.sqrt(i + (.5 * Math.pow(i, 2)));
	    if( Double.isNaN(y) ) continue;
	    p = MyGraphicsAPI.WindowToViewport( w4, i, y);
	    p = MyGraphicsAPI.ViewPortToFrameWindow(w4, p);
	    DrawTo2D(p, g);
	}
 
      	// Graph the line y = sqrt(4x + 5x^2
        p = MyGraphicsAPI.WindowToViewport( w4, -10 , 10 );
	p = MyGraphicsAPI.ViewPortToFrameWindow(w4, p);
	MoveTo2D(p);
	for( i = -10.0; i <= 10.0 ; i = i + 0.2)
	{
	    double y = Math.sqrt((4.0 * i) + (.5 * Math.pow(i, 2)));
	    if( Double.isNaN(y) ) continue;
	    p = MyGraphicsAPI.WindowToViewport( w4, i, y);
	    p = MyGraphicsAPI.ViewPortToFrameWindow(w4, p);
	    DrawTo2D(p, g);
	}

    }

    public static void PrintName(Point p, Graphics g)
    {
	Math.round(p.x);
	Math.round(p.y);
	int x = (int) p.x;
	int y = (int) p.y;
	g.drawString("Ian Westrope CS 384", x, y);
    }

    public static void MoveTo2D(Point p)
    {
	x = p.x;
	y = p.y;
    }

    public static void DrawTo2D(Point p, Graphics g)
    {
	Math.round(x);
	Math.round(y);
	Math.round(p.x);
	Math.round(p.y);
	int x1 = (int) x;
	int y1 = (int) y;
	int x2 = (int) p.x;
	int y2 = (int) p.y;
	g.drawLine(x1, y1, x2, y2);
	MoveTo2D(p);
    }

    public static void InitGraphics()
    {
	JFrame f = new JFrame( "HW #2" );
	
	//  Exit application when the window is closed
        f.addWindowListener( new WindowAdapter() {
             public void windowClosing( WindowEvent e )
             {  System.exit(0); }
             }
        );

	f.setSize( framewidth, frameheight );
	f.getContentPane().add( new Hw2() );
	f.setVisible( true );

	MyGraphicsAPI.SetViewport( -1 , -1, 1, 1 );

    }

}
