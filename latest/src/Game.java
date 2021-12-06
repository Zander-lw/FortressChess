import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Game extends JFrame 
{
    //SettingsDisplay Win = new SettingsDisplay(null);
    JButton SurrenderButton = new JButton("Surrender");
    JButton PassTurn = new JButton("PassTurn");
    int TimePass = 0;
    int TurnTracker = 0;
    int PieceCapture = 0;
    
    
    public int TurnTracker()
    {
        TurnTracker++;
        return TurnTracker;
    }
    Game(int boardID, int gameTime, int turnTime, int winChoice)
    {
        setTitle("Chess");
        setSize(550,300);
        setLayout(new GridLayout(1,2));
        add(new Board());
        JPanel gameData = new JPanel();
        gameData.setLayout(new GridLayout(7,1));
        gameData.add(new Button("Game Time:"));
        gameData.add(new Watch(gameTime));
        gameData.add(new Button("Player Time:"));
        gameData.add(new Watch(turnTime));
        gameData.add(SurrenderButton);
        gameData.add(PassTurn);  
        add(gameData);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        SurrenderButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent Surrender) {
            win();
            //dispose();
        }
      });
        
        PassTurn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent PassTurn) {
            }
          });
    setVisible(true);
    }
     public void winMessage()
     {   
            setVisible(false);    
            JOptionPane.showMessageDialog(this,
                    "Congratulations \n"
                    + "You have win the game\n",
                    "Winner", JOptionPane.PLAIN_MESSAGE);
    }
     public void tieMessage()
     {
         setVisible(false);
            JOptionPane.showMessageDialog(this,
                    "The game has end in a draw \n"
                    + "neither players has won \n",
                    "Draw", JOptionPane.PLAIN_MESSAGE);
    }
    public void win()
    {
        winMessage();
        dispose();
        new Menu().drawMenu();
    }
    public void tie() 
    {
        tieMessage();
        dispose();
        new Menu().drawMenu();
    }
    
}