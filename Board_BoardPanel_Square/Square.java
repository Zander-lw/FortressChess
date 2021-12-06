
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author christopher purves
 *
 *Methods used to coordinate piece information with piece.java
 *
 */
public class Square extends JButton implements ActionListener
{


	

	private boolean isVictorySquare;	//denotes victory square, currently unused
	
	private boolean isHighlighted;		//highlights square, currently unused
	
	private boolean valid;				//denotes if a square is valid or not
	
	private String name;				//stores the square's name
	
	private String position;			//stores the square's position
	
	
	/**
	 * 
	 * Square constructor, sets initial assumptions for the majority of the squares
	 * 
	 * @param position	;	the input position is the square's name
	 */
	Square(String position)
	{

			valid = true;
			isHighlighted = false;
			this.position = position;
			isVictorySquare = false;

			name = position;
		
	}


    /**
     * removes a square as a valid target square
     */
    public void invalid()
    {
        valid = false;
    }
	
    /**
     * returns whether or not a square is a valid target square
     */
    public boolean isValid()
    {
        return valid;
    }
	
	/**
	 * enables a square as a valid target square
	 */
	public void setValid()
	{
		this.valid = true;
	}
	

	/**
	 * @return	returns whether or not a square can be used to win the game
	 */
	public boolean getVictorySquare()
	{
		return isVictorySquare;
	}
	
	/**
	 * @param isVictory	;	enables or removes the ability to allow a square to win the game
	 */
	public void setVictrySquare(boolean isVictory)
	{
		this.isVictorySquare = isVictory;
	}


	/**
	 *	sets the name to the input parameter
	 */
	public void setName(String nameIn)
	{
		name = nameIn;
	}
	
	/**
	 *	returns the name of the square. A1, A2, etc.
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 *	no override
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		
		
	}

	
	
	
}
