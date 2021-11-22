import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.*;     


public class Menu
{    
Menu(){    
JFrame Frame = new JFrame("Chess");            
JButton Button = new JButton("Start");
JButton Button2 = new JButton("Instruction");
JButton Button3 = new JButton("Setting");
JButton Button4 = new JButton("Quit");

//Working in Progress (doesnt do anything)
//JPanel Panel = new JPanel();
//JLabel Title = new JLabel("Chess");

Button.setBounds(100,100,100, 30);    
Button2.setBounds(100,150,100, 30);
Button3.setBounds(100,200,100, 30);
Button4.setBounds(100,250,100, 30);

Frame.add(Button);  
Frame.add(Button2); 
Frame.add(Button3);
Frame.add(Button4);

Frame.setSize(300,400);    
Frame.setLayout(null);    
Frame.setVisible(true);    
Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Start
Button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent Start) {
    	new WindowTest1();
        Frame.dispose();
    }
  });


//Instruction
Button2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent Instruction) {
        JOptionPane.showMessageDialog(Frame,
                "Please read the instruction carefully\n"
                + "To start this game, please hit the button Start\n"
                + "To set the settings, please hit the button Setting\n"
                + "To quit the game, please hit the button Quit\n",
                "How to play", JOptionPane.PLAIN_MESSAGE);
    }
  });
//Setting
Button3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent Setting) 
    {
    	//Working in Progress
    	Watch Timer = new Watch();
    }
  }
);




//Quit
Button4.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent Quit)
    {
    	Frame.dispose();
    }
  }
);

}
}
