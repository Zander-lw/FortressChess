// Jakob Tuttle
// CPE 321
// Dec - 1 - 2021
/* This program contains the public class Piece which
   is designed to simulate a chess piece*/
import java.util.*;

/** This parent class defines all shared attributes
	and methods inherited by specialized chess 
	pieces*/
public class Piece
{
	private String type;
	private int number;
	private String color;
	private String position;
	private String initPos;
	private int points;
	private boolean isCaptured;

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
		
	public String getType()
	{
		return type;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String getPosition()
	{
		return position;
	}
	
	public String getInitPos()
	{
		return initPos;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public boolean getCaptured()
	{
		return isCaptured;
	}
	
	public void capture()
	{
		isCaptured = true;
	}
	
	public void move(String destination)
	{
		position = destination;
	}
}