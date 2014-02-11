/*  Hello3.java
 *
 *  Demonstrates variables, line drawing.
 */

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Hello3 extends JComponent
{
    static int FRAME_WIDTH  = 200;
    static int FRAME_HEIGHT = 200;

    public static void main( String[] args )
    {
	JFrame f = new JFrame( "Hello3" );

	//  Exit application when the window is closed
	f.addWindowListener( new WindowAdapter() {
		public void windowClosing( WindowEvent e )
		{  System.exit(0); }
	    }
	    );

	f.setSize( FRAME_WIDTH, FRAME_HEIGHT );
	f.getContentPane().add( new Hello3() );
	f.setVisible( true );
    }

    public void paintComponent( Graphics g )
    {
	int xC = FRAME_WIDTH/2;
	int yC = FRAME_HEIGHT/2;

	g.drawString( "Hello, Java!", xC, yC );

	g.drawLine( 0, 0, FRAME_WIDTH, FRAME_HEIGHT );
	g.drawLine( 0, FRAME_HEIGHT, FRAME_WIDTH, 0 );
    }
}
