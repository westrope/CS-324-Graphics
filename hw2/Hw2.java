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
	Window w1 = MyGraphicsAPI.SetWindow(-9,-15,9,15,-1,0,0,1);
	Point p = MyGraphicsAPI.WindowToViewport( w1,-9 ,0 );
	p = MyGraphicsAPI.ViewPortToFrameWindow(p);

	MoveTo2D(p);
	double i;
	for( i = -9.0; i <= 9.0 ; i = i + 0.2)
	{
	    double y = 2 / (0.5 - Math.sin(x/2));
	    p = MyGraphicsAPI.WindowToViewport( w1, i, y);
	    p = MyGraphicsAPI.ViewPortToFrameWindow(p);
	    DrawTo2D(p, g);
	}
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
