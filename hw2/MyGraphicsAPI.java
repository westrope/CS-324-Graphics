/* MyGraphicsAPI.java
   
   Ian Westrope
   CS 384
   HW #2
   2/11/14
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import 
public class MyGraphicsAPI extends JComponent 
{
    static int framewidth = 500;
    static int frameheight = 500;
    static float viewportminy;
    static float viewportminx;
    static float viewportmaxx;
    static float viewportmaxy;
    static float x;
    static float y;

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
	f.setVisible( true );
	f.getContentPane().add( new MyGraphicsAPI() );

	SetViewport( -1 , -1, 1, 1 );

    }

    public static void SetViewport( float width1, float height1, float width2, float height2  )
    {
	viewportminx = width1;
	viewportminy = height1;
	viewportmaxx = width2;
	viewportmaxy = height2;
    }

    public static window SetWindow( float width1, float height1, float width2, float height2)
    {
	window w = new window();
	this.w.windowminy = height1;
	this.w.windowminx = width1;
	this.w.windowmaxy = height2;
	this.w.windowmaxx = width2;
	return w;
    }

    public static point ViewPortToFrameWindow(float xv, float yv)
    {
	point p = new point();
	p.x = framewidth * (( xv - viewportminx ) / ( viewportmaxx - viewportminx ));
	p.y = frameheight * (( -yv - viewportminy ) / ( viewportmaxy - viewportminy ));
	return p;
    }

    public static point WindowToViewport(window w, float xwin, float ywin)
    {
	point p = new point();
	p.x = ((( xwin - w.windowminx ) / ( w.windowmaxx - w.windowminx )) * (viewportmaxx - viewportminx)) + viewportminx;
	p.y = ((( ywin - w.windowminy ) / ( w.windowmaxy - w.windowminy )) * ( viewportmaxy - viewportminy)) + viewportminy;
	return p;
    }

    public static void MoveTo2D(point p)
    {
	x = p.x;
	y = p.y;
    }

    public static void DrawTo2D(point p, Graphics g)
    {
	g.drawLine(x, y, p.x, p.y);
	MoveTo2D(p);
    }
}
