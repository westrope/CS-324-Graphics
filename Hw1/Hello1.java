/*  Hello1.java
 *
 *  Displays "Hello, Java!" in the middle of a frame.
 */

import java.awt.Graphics;
import javax.swing.*;

public class Hello1 extends JComponent
{
    public static void main( String[] args )
    {
	JFrame f = new JFrame( "Hello1" );
	f.setSize( 200, 200 );
	f.getContentPane().add( new Hello1() );
	f.setVisible( true );
    }

    public void paintComponent( Graphics g )
    {
	g.drawString( "Hello, Java!", 100, 100 );
    }
}
