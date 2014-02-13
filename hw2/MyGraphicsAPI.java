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
    int viewportwidth1;
    int viewportwidth2;
    int viewportheight1;
    int viewportheight2;
    float x;
    float y;

    class window
    {
    float windowheight1;
    float windnowwidth1;
    float windowheight2;
    float windowwidth2;
    }

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

	SetViewport( -1 , -1, 1, 1 );

    }

    public void SetViewport( int width1, int height1, int width2, int height2  )
    {
	viewportwidth1 = width1;
	viewportheight1 = height1;
	viewportwidth2 = width2;
	viewportheight2 = height2;
    }

    public window SetWindow( float width1, float height1, float width2, float height2)
    {
	window w = new window;
	w.windowheight1 = height1;
	w.windowwidth1 = width1;
	w.windowheight2 = height2;
	w.windowwidth2 = width2;
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
