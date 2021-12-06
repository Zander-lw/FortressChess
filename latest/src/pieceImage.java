import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Font;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class pieceImage  {

	
	int xVal;
	int yVal;
	Image name;
	
	int number;
	
	
	
	public pieceImage(int x, int y , Image pieceName, int num)
	{
		xVal = x;
		yVal = y;
		name = pieceName;
		number = num;
	}
	
	
	public int getX()
	{
		return xVal;
	}
	

	public Image getName()
	{
		return name;
	}
	
	public int getY()
	{
		return yVal;
	}
	
	public void setX(int x)
	{
		xVal = x;
	}
	
	public void setY(int y)
	{
		yVal = y;
	}
	
	public void setImage(Image temp)
	{
		name = temp;
	}
}
