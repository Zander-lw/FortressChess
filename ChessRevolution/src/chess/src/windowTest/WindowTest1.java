package windowTest;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class WindowTest1 extends JFrame implements ActionListener		//deprecated code, included for reference
{
	int boardID;
	
	

	
	PanelTest window;

	JFrame board;
	
	Square A1 = new Square();
	Square A2 = new Square();
	Square A3 = new Square();
	Square A4 = new Square();
	Square A5 = new Square();
	Square A6 = new Square();
	Square A7 = new Square();
	Square A8 = new Square();
	
	Square B1 = new Square();
	Square B2 = new Square();
	Square B3 = new Square();
	Square B4 = new Square();
	Square B5 = new Square();
	Square B6 = new Square();
	Square B7 = new Square();
	Square B8 = new Square();
	
	Square C1 = new Square();
	Square C2 = new Square();
	Square C3 = new Square();
	Square C4 = new Square();
	Square C5 = new Square();
	Square C6 = new Square();
	Square C7 = new Square();
	Square C8 = new Square();
	
	Square D1 = new Square();
	Square D2 = new Square();
	Square D3 = new Square();
	Square D4 = new Square();
	Square D5 = new Square();
	Square D6 = new Square();
	Square D7 = new Square();
	Square D8 = new Square();
	
	Square E1 = new Square();
	Square E2 = new Square();
	Square E3 = new Square();
	Square E4 = new Square();
	Square E5 = new Square();
	Square E6 = new Square();
	Square E7 = new Square();
	Square E8 = new Square();
	
	Square F1 = new Square();
	Square F2 = new Square();
	Square F3 = new Square();
	Square F4 = new Square();
	Square F5 = new Square();
	Square F6 = new Square();
	Square F7 = new Square();
	Square F8 = new Square();
	
	Square G1 = new Square();
	Square G2 = new Square();
	Square G3 = new Square();
	Square G4 = new Square();
	Square G5 = new Square();
	Square G6 = new Square();
	Square G7 = new Square();
	Square G8 = new Square();
	
	Square H1 = new Square();
	Square H2 = new Square();
	Square H3 = new Square();
	Square H4 = new Square();
	Square H5 = new Square();
	Square H6 = new Square();
	Square H7 = new Square();
	Square H8 = new Square();
	
	
	
	WindowTest1()
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
		
		//A1.addActionListener(e -> e -> A1.returnSquare("A1"));	//add piece.move?
		A1.addActionListener(e -> A1.returnSquare("A1"));		
		A2.addActionListener(e -> A2.returnSquare("A2"));
		A3.addActionListener(e -> A3.returnSquare("A3"));
		A4.addActionListener(e -> A4.returnSquare("A4"));
		A5.addActionListener(e -> A5.returnSquare("A5"));
		A6.addActionListener(e -> A6.returnSquare("A6"));
		A7.addActionListener(e -> A7.returnSquare("A7"));
		A8.addActionListener(e -> A8.returnSquare("A8"));
		
		B1.addActionListener(e -> B1.returnSquare("B1"));
		B2.addActionListener(e -> B2.returnSquare("B2"));
		B3.addActionListener(e -> B3.returnSquare("B3"));
		B4.addActionListener(e -> B4.returnSquare("B4"));
		B5.addActionListener(e -> B5.returnSquare("B5"));
		B6.addActionListener(e -> B6.returnSquare("B6"));
		B7.addActionListener(e -> B7.returnSquare("B7"));
		B8.addActionListener(e -> B8.returnSquare("B8"));
		
		C1.addActionListener(e -> C1.returnSquare("C1"));
		C2.addActionListener(e -> C2.returnSquare("C2"));
		C3.addActionListener(e -> C3.returnSquare("C3"));
		C4.addActionListener(e -> C4.returnSquare("C4"));
		C5.addActionListener(e -> C5.returnSquare("C5"));
		C6.addActionListener(e -> C6.returnSquare("C6"));
		C7.addActionListener(e -> C7.returnSquare("C7"));
		C8.addActionListener(e -> C8.returnSquare("C8"));
		
		D1.addActionListener(e -> D1.returnSquare("D1"));
		D2.addActionListener(e -> D2.returnSquare("D2"));
		D3.addActionListener(e -> D3.returnSquare("D3"));
		D4.addActionListener(e -> D4.returnSquare("D4"));
		D5.addActionListener(e -> D5.returnSquare("D5"));
		D6.addActionListener(e -> D6.returnSquare("D6"));
		D7.addActionListener(e -> D7.returnSquare("D7"));
		D8.addActionListener(e -> D8.returnSquare("D8"));
	
		E1.addActionListener(e -> E1.returnSquare("E1"));
		E2.addActionListener(e -> E2.returnSquare("E2"));
		E3.addActionListener(e -> E3.returnSquare("E3"));
		E4.addActionListener(e -> E4.returnSquare("E4"));
		E5.addActionListener(e -> E5.returnSquare("E5"));
		E6.addActionListener(e -> E6.returnSquare("E6"));
		E7.addActionListener(e -> E7.returnSquare("E7"));
		E8.addActionListener(e -> E8.returnSquare("E8"));
	
		F1.addActionListener(e -> F1.returnSquare("F1"));
		F2.addActionListener(e -> F2.returnSquare("F2"));
		F3.addActionListener(e -> F3.returnSquare("F3"));
		F4.addActionListener(e -> F4.returnSquare("F4"));
		F5.addActionListener(e -> F5.returnSquare("F5"));
		F6.addActionListener(e -> F6.returnSquare("F6"));
		F7.addActionListener(e -> F7.returnSquare("F7"));
		F8.addActionListener(e -> F8.returnSquare("F8"));
		
		G1.addActionListener(e -> G1.returnSquare("G1"));
		G2.addActionListener(e -> G2.returnSquare("G2"));
		G3.addActionListener(e -> G3.returnSquare("G3"));
		G4.addActionListener(e -> G4.returnSquare("G4"));
		G5.addActionListener(e -> G5.returnSquare("G5"));
		G6.addActionListener(e -> G6.returnSquare("G6"));
		G7.addActionListener(e -> G7.returnSquare("G7"));
		G8.addActionListener(e -> G8.returnSquare("G8"));
		
		H1.addActionListener(e -> H1.returnSquare("H1"));
		H2.addActionListener(e -> H2.returnSquare("H2"));
		H3.addActionListener(e -> H3.returnSquare("H3"));
		H4.addActionListener(e -> H4.returnSquare("H4"));
		H5.addActionListener(e -> H5.returnSquare("H5"));
		H6.addActionListener(e -> H6.returnSquare("H6"));
		H7.addActionListener(e -> H7.returnSquare("H7"));
		H8.addActionListener(e -> H8.returnSquare("H8"));

		A1.setOpaque(false);
		A2.setOpaque(false);
		A3.setOpaque(false);
		A4.setOpaque(false);
		A5.setOpaque(false);
		A6.setOpaque(false);
		A7.setOpaque(false);
		A8.setOpaque(false);
		
		B2.setOpaque(false);
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
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

//to add: timer, win condition, board type?
//call move function and highlight functions
//--> in piece class...
//takes current position of piece, depending on the piece, and tells it where it can go
//same with highlight, if square occupied highlight differently
//initial position attribute is in the piece constructor
//a return function where you give it a position and it will return the coords to draw it, get position from piece









