

import java.awt.*;

import javax.swing.*;


public class WindowTest1 extends JFrame
{
	PanelTest window;
	
	WindowTest1()
	{
		
		window = new PanelTest();
		
		this.add(window);
		this.pack();
		this.setVisible(true);
		
		
	}
	

}
