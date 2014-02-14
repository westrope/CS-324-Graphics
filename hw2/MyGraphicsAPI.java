/* MyGraphicsAPI.java
   
   Ian Westrope
   CS 384
   HW #2
   2/11/14
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGraphicsAPI extends JComponent 
{
    static int framewidth = 500;
    static int frameheight = 500;
    static double viewportminy;
    static double viewportminx;
    static double viewportmaxx;
    static double viewportmaxy;
    static double x;
    static double y;

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
	f.getContentPane().add( new MyGraphicsAPI() );
	f.setVisible( true );

	SetViewport( -1 , -1, 1, 1 );

    }

    public static void SetViewport( double width1, double height1, double width2, double height2  )
    {
	viewportminx = width1;
	viewportminy = height1;
	viewportmaxx = width2;
	viewportmaxy = height2;
    }

    public static Window SetWindow( double width1, double height1, double width2, double height2, double vpminx, double vpminy, double vpmaxx, double vpmaxy)
    {
	Window w = new Window();
	w.vpminx = vpminx;
	w.vpminy = vpminy;
	w.vpmaxx = vpmaxx;
	w.vpmaxy = vpmaxy;
	w.windowminy = height1;
	w.windowminx = width1;
	w.windowmaxy = height2;
	w.windowmaxx = width2;
	return w;
    }

    public static Point ViewPortToFrameWindow(Point p)
    {
	Point p2 = new Point();
	p2.x = framewidth * (( p.x - viewportminx ) / ( viewportmaxx - viewportminx ));
	p2.y = frameheight * (( -(p.y) - viewportminy ) / ( viewportmaxy - viewportminy ));
	return p2;
    }

    public static Point WindowToViewport(Window w, double xwin, double ywin)
    {
	Point p = new Point();
	p.x = ((( xwin - w.windowminx ) / ( w.windowmaxx - w.windowminx )) * (w.vpmaxx - w.vpminx)) + w.vpminx;
	p.y = ((( ywin - w.windowminy ) / ( w.windowmaxy - w.windowminy )) * ( w.vpmaxy - w.vpminy)) + w.vpminy;
	return p;
    }

}
