/*  Hello4.java
 *
 *  Illustrates Colors, arrays and a method.
 *  Displays lines correctly upon resizing frame (window).
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello4 extends JComponent
{
    static int frameWidth  = 200;
    static int frameHeight = 200;

    Color [] lineColors = { Color.black, Color.red,   Color.green,
			    Color.blue,  Color.orange, Color.magenta };

    static int iColor = 0;    // line color index

    public static void main( String[] args )
    {
	JFrame f = new JFrame( "Hello4" );

	//  Exit application when the window is closed
	f.addWindowListener( new WindowAdapter() {
		public void windowClosing( WindowEvent e )
		{  System.exit(0); }
	    }
	    );

	f.setSize( frameWidth, frameHeight );
	f.getContentPane().add( new Hello4() );
	f.setVisible( true );
    }

    public void paintComponent( Graphics g )
    {
	frameWidth  = getWidth();
	frameHeight = getHeight();

	int xC = frameWidth/2;
	int yC = frameHeight/2;

	g.drawString( "Hello, Java!", xC, yC );

	drawLines( g );
    }

    public void drawLines( Graphics g )
    {
	g.setColor( lineColors[iColor] );

	g.drawLine( 0, 0, frameWidth, frameHeight );
	g.drawLine( 0, frameHeight, frameWidth, 0 );

	if( ++iColor == lineColors.length ) iColor = 0;
    }
}
