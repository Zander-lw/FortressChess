
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Font;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class PanelTest extends JPanel
{

	Image board;
	
	Image pawnWhite;
	Image knightWhite;
	Image bishopWhite;
	Image rookWhite;
	Image queenWhite;
	Image kingWhite;
	
	Image pawnBlack;
	Image knightBlack;
	Image bishopBlack;
	Image rookBlack;
	Image queenBlack;
	Image kingBlack;
	
	PanelTest()
	{

		
		board = new ImageIcon("ProjectChessboardNormal.png").getImage();
		
		pawnWhite = new ImageIcon("32bPawnWhite.png").getImage();
		knightWhite = new ImageIcon("32bKnightWhite.png").getImage();
		bishopWhite = new ImageIcon("32bBishopWhite.png").getImage();
		rookWhite = new ImageIcon("32bRookWhite.png").getImage();
		queenWhite = new ImageIcon("32bQueenWhite.png").getImage();
		kingWhite = new ImageIcon("32bKingWhite.png").getImage();
		
		
		pawnBlack = new ImageIcon("32bPawnBlack.png").getImage();
		knightBlack = new ImageIcon("32bKnightBlack.png").getImage();
		bishopBlack = new ImageIcon("32bBishopBlack.png").getImage();
		queenBlack = new ImageIcon("32bQueenBlack.png").getImage();
		kingBlack = new ImageIcon("32bKingBlack.png").getImage();
		rookBlack = new ImageIcon("32bRookBlack.png").getImage();
		

		

		this.setPreferredSize(new Dimension(256,256) );
		
	}
	
	public void paint(Graphics in)
	{
		Graphics2D Draw = (Graphics2D) in;
		
		Draw.drawImage(board, 0, 0, null);
		
		
		Draw.drawImage(rookBlack, 0, 0, null);
		Draw.drawImage(knightBlack, 32, 0, null);
		Draw.drawImage(bishopBlack, 64, 0, null);
		Draw.drawImage(queenBlack, 96, 0, null);
		Draw.drawImage(kingBlack, 128, 0, null);
		Draw.drawImage(bishopBlack, 160, 0, null);
		Draw.drawImage(knightBlack, 192, 0, null);
		Draw.drawImage(rookBlack, 224, 0, null);
		
		Draw.drawImage(pawnBlack, 0, 32, null);
		Draw.drawImage(pawnBlack, 32, 32, null);
		Draw.drawImage(pawnBlack, 64, 32, null);
		Draw.drawImage(pawnBlack, 96, 32, null);
		Draw.drawImage(pawnBlack, 128, 32, null);
		Draw.drawImage(pawnBlack, 160, 32, null);
		Draw.drawImage(pawnBlack, 192, 32, null);
		Draw.drawImage(pawnBlack, 224, 32, null);
		
		Draw.drawImage(rookWhite, 0, 224, null);
		Draw.drawImage(knightWhite, 32, 224, null);
		Draw.drawImage(bishopWhite, 64, 224, null);
		Draw.drawImage(queenWhite, 96, 224, null);
		Draw.drawImage(kingWhite, 128, 224, null);
		Draw.drawImage(bishopWhite, 160, 224, null);
		Draw.drawImage(knightWhite, 192, 224, null);
		Draw.drawImage(rookWhite, 224, 224, null);
		
		Draw.drawImage(pawnWhite, 0, 192, null);
		Draw.drawImage(pawnWhite, 32, 192, null);
		Draw.drawImage(pawnWhite, 64, 192, null);
		Draw.drawImage(pawnWhite, 96, 192, null);
		Draw.drawImage(pawnWhite, 128, 192, null);
		Draw.drawImage(pawnWhite, 160, 192, null);
		Draw.drawImage(pawnWhite, 192, 192, null);
		Draw.drawImage(pawnWhite, 224, 192, null);
	}
	
	
}
