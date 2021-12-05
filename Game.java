import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Game 
{

	JFrame Frame = new JFrame("Chess");
	SettingsDisplay Win = new SettingsDisplay(null);
	JButton SurrenderButton = new JButton("Surrender");
	int TimePass = 0;
	int TurnTracker = 0;
	int PieceCapture = 0;
	
	
	public int TurnTracker()
	{
		TurnTracker++;
		return TurnTracker;
	}
	Game()
	{
		Frame.add(SurrenderButton);  
		
		SurrenderButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent Surrender) {
	        Frame.dispose();
	        winMessage();
	    }
	  });
	
	}
	 public void winMessage()
	 {
			Frame.setSize(300,400);    
			Frame.setLayout(null);    
			Frame.setVisible(true);    
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	        JOptionPane.showMessageDialog(Frame,
	                "Congratulations \n"
	                + "You have win the game\n",
	                "Winner", JOptionPane.PLAIN_MESSAGE);
	}
	 public void tieMessage()
	 {
			Frame.setSize(300,400);    
			Frame.setLayout(null);    
			Frame.setVisible(true);    
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	        JOptionPane.showMessageDialog(Frame,
	                "The game has end in a draw \n"
	                + "neither players has won \n",
	                "Draw", JOptionPane.PLAIN_MESSAGE);
	}
	public void win()
	{
		Frame.dispose();
		winMessage();
	}
	public void tie() 
	{
		Frame.dispose();
		tieMessage();
	}
	public static void main(String[] args) 
	{
		
		Menu StartMenu = new Menu();
		//Watch Timer = new Watch();
	}
	
}