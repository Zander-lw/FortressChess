// Jakob Tuttle
// CPE 321
// Dec - 1 - 2021
/* This program contains the public class Piece which
   is designed to simulate a chess piece*/
import java.util.*;

/** This parent class defines all shared attributes
*	and methods inherited by specialized chess 
*	pieces
*/
public class Piece
{
	private String type;
	private int number;
	private String color;
	private String position;
	private String initPos;
	private int points;
	private boolean isCaptured;

	/** Piece Constructer takes in assigned attributes
	*	and sets all others to default values
	*	
	*	@param type		the type of piece
	*	@param number 	the number associated with it, ie: pawn1, pawn2
	*	@param color 	the color of the piece
	*	@param initPos	the initial position of the piece
	*/
	public Piece(String type, int number, String color, String initPos)
	{
		this.type = type;
		this.number = number;
		this.color = color;
		this.position = initPos;
		this.initPos = initPos;
		if(type == "Pawn")
			points = 1;
		else
			points = 2;
		isCaptured = false;
	}
	
	/** Method to return the piece type
	*	
	*	@return type 	the type of piece
	*/
	public String getType()
	{
		return type;
	}
	
	/** Method to return the piece number
	*	
	*	@return number 	the number associated with it, ie: pawn1, pawn2
	*/
	public int getNumber()
	{
		return number;
	}
	
	/** Method to return the piece color
	*	
	*	@return color 	the color of the piece
	*/
	public String getColor()
	{
		return color;
	}
	
	/** Method to return the current position of the piece 
	*	
	*	@return position 	the current position of the piece
	*/
	public String getPosition()
	{
		return position;
	}
	
	/** Method to return the initial position of the piece 
	*	
	*	@return initPos 	the initial position of the piece
	*/
	public String getInitPos()
	{
		return initPos;
	}
	
	/** Method to return the point value associated with the piece 
	*	
	*	@return points 	the point value of the piece
	*/
	public int getPoints()
	{
		return points;
	}
	
	/** Method to return the boolean value that determines
	*	whether or not the piece is captured
	*	
	*	@return isCaptured 	the capture status of the piece
	*/
	public boolean getCaptured()
	{
		return isCaptured;
	}
	
	/** Method to set the piece's isCaptured status to true,
	* 	thereby rendering it captured 
	*/
	public void capture()
	{
		isCaptured = true;
	}
	
	/** Method to set the piece's position to a new position,
	*	keeping track of its movement
	*
	*	@param destination 		the destination square name, ie A1, B5, etc...
	*/
	public void move(String destination)
	{
		position = destination;
	}
}