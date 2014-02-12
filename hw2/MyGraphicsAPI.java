/* MyGraphicsAPI.java
   
   Ian Westrope
   CS 384
   HW #2
   2/11/14
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGraphicsAPI extends Jcomponent 
{
    int framewidth = 500;
    int frameheight = 500;
    int viewportwidth;
    int viewportheight;
    int windowheight;
    int widnowwidth;
    float x;
    float y;

    public void InitGraphics()
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
	f.getContentPane().add( new HW2() );

	SetViewport( 1 , 1 );
	SetWindow(

    }

    public void SetViewport( int width, int height  )
    {
	viewportwidth = width;
	viewportheight = height;
    }

    public SetWindow()
    {

    }

    public WindowToViewport(int xwin, int ywin)
    {

    }

    public MoveTo2D()
    {

    }

    public DrawTo2D()
    {

    }
