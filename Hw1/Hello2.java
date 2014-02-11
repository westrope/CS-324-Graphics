/*  Hello2.java
 *
 *  Demonstrates "exit" procedure.
 */

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Hello2 extends JComponent
{
    static int FRAME_WIDTH  = 200;
    static int FRAME_HEIGHT = 200;

    public static void main( String[] args )
    {
	JFrame f = new JFrame( "Hello2" );

	//  Exit application when the window is closed
	f.addWindowListener( new WindowAdapter() {
		public void windowClosing( WindowEvent e )
		{  System.exit(0); }
	    }
	    );

	f.setSize( FRAME_WIDTH, FRAME_HEIGHT );
	f.getContentPane().add( new Hello2() );
	f.setVisible( true );
    }

    public void paintComponent( Graphics g )
    {
	g.drawString( "Hello, Java!", 100, 100 );
    }
}
