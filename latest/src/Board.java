

import java.awt.*;

import javax.swing.*;


//import windowTest.Square;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Board extends JPanel implements ActionListener

{
	int boardID;
	PanelTest window;
	
	String lastButton;

	boolean cliked = false;
	

	JFrame board;
	
	Square A1 = new Square("A1");
	Square A2 = new Square("A2");
	Square A3 = new Square("A3");
	Square A4 = new Square("A4");
	Square A5 = new Square("A5");
	Square A6 = new Square("A6");
	Square A7 = new Square("A7");
	Square A8 = new Square("A8");
	
	Square B1 = new Square("B1");
	Square B2 = new Square("B2");
	Square B3 = new Square("B3");
	Square B4 = new Square("B4");
	Square B5 = new Square("B5");
	Square B6 = new Square("B6");
	Square B7 = new Square("B7");
	Square B8 = new Square("B8");
	
	Square C1 = new Square("C1");
	Square C2 = new Square("C2");
	Square C3 = new Square("C3");
	Square C4 = new Square("C4");
	Square C5 = new Square("C5");
	Square C6 = new Square("C6");
	Square C7 = new Square("C7");
	Square C8 = new Square("C8");
	
	Square D1 = new Square("D1");
	Square D2 = new Square("D2");
	Square D3 = new Square("D3");
	Square D4 = new Square("D4");
	Square D5 = new Square("D5");
	Square D6 = new Square("D6");
	Square D7 = new Square("D7");
	Square D8 = new Square("D8");
	
	Square E1 = new Square("E1");
	Square E2 = new Square("E2");
	Square E3 = new Square("E3");
	Square E4 = new Square("E4");
	Square E5 = new Square("E5");
	Square E6 = new Square("E6");
	Square E7 = new Square("E7");
	Square E8 = new Square("E8");
	
	Square F1 = new Square("F1");
	Square F2 = new Square("F2");
	Square F3 = new Square("F3");
	Square F4 = new Square("F4");
	Square F5 = new Square("F5");
	Square F6 = new Square("F6");
	Square F7 = new Square("F7");
	Square F8 = new Square("F8");
	
	Square G1 = new Square("G1");
	Square G2 = new Square("G2");
	Square G3 = new Square("G3");
	Square G4 = new Square("G4");
	Square G5 = new Square("G5");
	Square G6 = new Square("G6");
	Square G7 = new Square("G7");
	Square G8 = new Square("G8");
	
	Square H1 = new Square("H1");
	Square H2 = new Square("H2");
	Square H3 = new Square("H3");
	Square H4 = new Square("H4");
	Square H5 = new Square("H5");
	Square H6 = new Square("H6");
	Square H7 = new Square("H7");
	Square H8 = new Square("H8");
	
	Square[] buttons = {A1,A2,A3,A4,A5,A6,A7,A8,B1,B2,B3,B4,B5,B6,B7,B8,C1,C2,C3,C4,C5,C6,C7,C8,D1,D2,D3,D4,D5,D6,D7,D8,E1,E2,E3,E4,E5,E6,E7,E8,F1,F2,F3,F4,F5,F6,F7,F8,G1,G2,G3,G4,G5,G6,G7,G8,H1,H2,H3,H4,H5,H6,H7,H8};

	
	//========================================Highlight square method========================
	
	public void highLightSquare(String pos)
	{
		
		//System.out.println("Triggered=========================" + D1.getName()+ "compared to :                   "+ pos);
		for(int i = 0; i < buttons.length;i ++)
		{
			if(buttons[i].getName().equals(pos))
			{
				buttons[i].setOpaque(true);
				buttons[i].setVisible(true);
			}
		}
		
		
	}
	
			
	//=======================================================================================
	
	//==========================================Return Button name when pressed
	
	public boolean getClicked()
	{
		boolean temp = cliked;
		return temp;
	}
	
	public void setClicked(boolean x)
	{
		cliked = x;
	}
	
	public void recentButton(String name)
	{
		setClicked(true);
		lastButton = name;
		
		for(int i = 0; i < buttons.length;i ++)
		{
			buttons[i].setOpaque(false);
		}
	}
	
	public String getRecent()
	{
		return lastButton;
	}
	
	//==============================================================================
	Board()
	{
		board = new JFrame();
		window = new PanelTest();		
		
		window.setLayout(new GridLayout(8,8,0,0));
		
		window.add(A1);
		window.add(A2);
		window.add(A3);
		window.add(A4);
		window.add(A5);
		window.add(A6);
		window.add(A7);
		window.add(A8);
		
		window.add(B1);
		window.add(B2);
		window.add(B3);
		window.add(B4);
		window.add(B5);
		window.add(B6);
		window.add(B7);
		window.add(B8);
		
		window.add(C1);
		window.add(C2);
		window.add(C3);
		window.add(C4);
		window.add(C5);
		window.add(C6);
		window.add(C7);
		window.add(C8);
		
		window.add(D1);
		window.add(D2);
		window.add(D3);
		window.add(D4);
		window.add(D5);
		window.add(D6);
		window.add(D7);
		window.add(D8);
		
		window.add(E1);
		window.add(E2);
		window.add(E3);
		window.add(E4);
		window.add(E5);
		window.add(E6);
		window.add(E7);
		window.add(E8);
		
		window.add(F1);
		window.add(F2);
		window.add(F3);
		window.add(F4);
		window.add(F5);
		window.add(F6);
		window.add(F7);
		window.add(F8);
		
		window.add(G1);
		window.add(G2);
		window.add(G3);
		window.add(G4);
		window.add(G5);
		window.add(G6);
		window.add(G7);
		window.add(G8);
		
		window.add(H1);
		window.add(H2);
		window.add(H3);
		window.add(H4);
		window.add(H5);
		window.add(H6);
		window.add(H7);
		window.add(H8);
		
		A1.addActionListener(e -> recentButton("A1"));	
		int[] x = {100,100};
		A2.addActionListener(e -> recentButton("A2"));
		A3.addActionListener(e -> recentButton("A3"));
		A4.addActionListener(e -> recentButton("A4"));
		A5.addActionListener(e -> recentButton("A5"));
		A6.addActionListener(e -> recentButton("A6"));
		A7.addActionListener(e -> recentButton("A7"));
		A8.addActionListener(e -> recentButton("A8"));
		
		B1.addActionListener(e -> recentButton("B1"));
		B2.addActionListener(e -> recentButton("B2"));
		B3.addActionListener(e -> recentButton("B3"));
		B4.addActionListener(e -> recentButton("B4"));
		B5.addActionListener(e -> recentButton("B5"));
		B6.addActionListener(e -> recentButton("B6"));
		B7.addActionListener(e -> recentButton("B7"));
		B8.addActionListener(e -> recentButton("B8"));
		
		
		
		C1.addActionListener(e -> recentButton("C1"));
		C2.addActionListener(e -> recentButton("C2"));
		C3.addActionListener(e -> recentButton("C3"));
		C4.addActionListener(e -> recentButton("C4"));
		C5.addActionListener(e -> recentButton("C5"));
		C6.addActionListener(e -> recentButton("C6"));
		C7.addActionListener(e -> recentButton("C7"));
		C8.addActionListener(e -> recentButton("C8"));;
		
		D1.addActionListener(e -> recentButton("D1"));
		D2.addActionListener(e -> recentButton("D2"));
		D3.addActionListener(e -> recentButton("D3"));
		D4.addActionListener(e -> recentButton("D4"));
		D5.addActionListener(e -> recentButton("D5"));
		D6.addActionListener(e -> recentButton("D6"));
		D7.addActionListener(e -> recentButton("D7"));
		D8.addActionListener(e -> recentButton("D8"));
	
		E1.addActionListener(e -> recentButton("E1"));
		E2.addActionListener(e -> recentButton("E2"));
		E3.addActionListener(e -> recentButton("E3"));
		E4.addActionListener(e -> recentButton("E4"));
		E5.addActionListener(e -> recentButton("E5"));
		E6.addActionListener(e -> recentButton("E6"));
		E7.addActionListener(e -> recentButton("E7"));
		E8.addActionListener(e -> recentButton("E8"));
	
		F1.addActionListener(e -> recentButton("F1"));
		F2.addActionListener(e -> recentButton("F2"));
		F3.addActionListener(e -> recentButton("F3"));
		F4.addActionListener(e -> recentButton("F4"));
		F5.addActionListener(e -> recentButton("F5"));
		F6.addActionListener(e -> recentButton("F6"));
		F7.addActionListener(e -> recentButton("F7"));
		F8.addActionListener(e -> recentButton("F8"));
		
		G1.addActionListener(e -> recentButton("G1"));
		G2.addActionListener(e -> recentButton("G2"));
		G3.addActionListener(e -> recentButton("G3"));
		G4.addActionListener(e -> recentButton("G4"));
		G5.addActionListener(e -> recentButton("G5"));
		G6.addActionListener(e -> recentButton("G6"));
		G7.addActionListener(e -> recentButton("G7"));
		G8.addActionListener(e -> recentButton("G8"));
		
		H1.addActionListener(e -> recentButton("H1"));
		H2.addActionListener(e -> recentButton("H2"));
		H3.addActionListener(e -> recentButton("H3"));
		H4.addActionListener(e -> recentButton("H4"));
		H5.addActionListener(e -> recentButton("H5"));
		H6.addActionListener(e -> recentButton("H6"));
		H7.addActionListener(e -> recentButton("H7"));
		H8.addActionListener(e -> recentButton("H8"));
		
		A1.setOpaque(false);
		A2.setOpaque(false);
		A3.setOpaque(false);
		A4.setOpaque(false);
		A5.setOpaque(false);
		A6.setOpaque(false);
		A7.setOpaque(false);
		A8.setOpaque(false);
		
		B1.setOpaque(false);
		B2.setOpaque(false);
		B3.setOpaque(false);
		B4.setOpaque(false);
		B5.setOpaque(false);
		B6.setOpaque(false);
		B7.setOpaque(false);
		B8.setOpaque(false);
		
		C1.setOpaque(false);
		C2.setOpaque(false);
		C3.setOpaque(false);
		C4.setOpaque(false);
		C5.setOpaque(false);
		C6.setOpaque(false);
		C7.setOpaque(false);
		C8.setOpaque(false);
		
		D1.setOpaque(false);
		D2.setOpaque(false);
		D3.setOpaque(false);
		D4.setOpaque(false);
		D5.setOpaque(false);
		D6.setOpaque(false);
		D7.setOpaque(false);
		D8.setOpaque(false);
	
		E1.setOpaque(false);
		E2.setOpaque(false);
		E3.setOpaque(false);
		E4.setOpaque(false);
		E5.setOpaque(false);
		E6.setOpaque(false);
		E7.setOpaque(false);
		E8.setOpaque(false);
	
		F1.setOpaque(false);
		F2.setOpaque(false);
		F3.setOpaque(false);
		F4.setOpaque(false);
		F5.setOpaque(false);
		F6.setOpaque(false);
		F7.setOpaque(false);
		F8.setOpaque(false);
		
		G1.setOpaque(false);
		G2.setOpaque(false);
		G3.setOpaque(false);
		G4.setOpaque(false);
		G5.setOpaque(false);
		G6.setOpaque(false);
		G7.setOpaque(false);
		G8.setOpaque(false);
		
		H1.setOpaque(false);
		H2.setOpaque(false);
		H3.setOpaque(false);
		H4.setOpaque(false);
		H5.setOpaque(false);
		H6.setOpaque(false);
		H7.setOpaque(false);
		H8.setOpaque(false);

		


		
		this.add(window);
		this.setSize(256,256);
		this.setVisible(true);
			
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{

	}
	
	
	
}
//assign each square to have a name, as string, or instead 
