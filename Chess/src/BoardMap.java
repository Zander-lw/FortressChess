// Jakob Tuttle
// CPE 321
// Dec - 1 - 2021
/* This program contains the public class BoardMap which
   maps Squares to Square names and their drawn coordinates,
   as well as keeping track of all the pieces in play at any
   given time*/
import java.util.*;

/** This class creates three arrays and an ArrayList;
	the first array contains all of the square objects,
	the second contains the string names of each 
	square on the board, and the third contains the 
	image coordinates. The ArrayList contains a dynamic
	list of all the currently uncaptured pieces*/
public class BoardMap
{
	private static ArrayList<Piece> pieces = new ArrayList<Piece>();
	private static Square[] squares;
	private static String[] squareNames;
	private static int[][] coordinates;
	private static int squareSize;
	private static int size;
	
	/** BoardMap constructor, takes in x and y which
		denote the size of the chessboard along with
		z which denotes the size of each square in
		pixels*/
	public BoardMap(int x, int y, int z)
	{
		squareSize = z;
		size = x*y;
		squares = new Square[size];
		squareNames = new String[size];
		coordinates = new int[size][];
		char ascii = 'A';
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				int[] v = new int[2];
				v[0] = i*squareSize;
				v[1] = j*squareSize;
				squareNames[(i*8)+j] = Character.toString(ascii) + Integer.toString(j+1);
				coordinates[(i*8)+j] = v;
				squares[(i*8)+j] = new Square(squareNames[(i*8)+j]);
			}
			ascii++;
		}
		pieces.add(new Piece("Pawn","White","B1"));
		pieces.add(new Piece("Pawn","White","B4"));
		pieces.add(new Piece("Pawn","White","B8"));
		pieces.add(new Piece("Pawn","Black","C2"));
		pieces.add(new Piece("Pawn","Black","C3"));
		pieces.add(new Piece("Pawn","Black","C5"));
	}
	
	/** Method to print the sqaure names and their
		matching coordinates*/
	public void printMap()
	{
		for(int i = 0; i < size; i++)
		{
			System.out.println(squareNames[i] + " : " + Arrays.toString(coordinates[i]));
		}
	}
	
	/** Method to get the square name using a set of
		drawing coordinates*/
	public String getSquareName(int[] coord)
	{
		int index;
		for(int i = 0; i < size; i++)
		{
			if(coordinates[i][0] == coord[0] && coordinates[i][1] == coord[1])
			{
				index = i;
				return squareNames[index];
			}
		}
		return null;
	}
	
	/** Method to get the drawing coordinates using a
		square name*/
	public int[] getCoordinate(String square)
	{
		int index = Arrays.asList(squareNames).indexOf(square);
		return coordinates[index].clone();
	}
	
	/** Method to set a certain square within the array 
		to invalid*/
	public void setInvalid(String square)
	{
		int index = Arrays.asList(squareNames).indexOf(square);
		squares[index].invalid();
	}
	
	private String getPieceType(String square)
	{
		for(int i = 0; i < pieces.size(); i++)
		{
			if((pieces.get(i)).getPosition().equals(square))
			{
				return (pieces.get(i)).getType();
			}
		}
		return null;
	}
	
	private String getPieceInitPos(String square)
	{
		for(int i = 0; i < pieces.size(); i++)
		{
			if((pieces.get(i)).getPosition().equals(square))
			{
				return (pieces.get(i)).getInitPos();
			}
		}
		return null;
	}
	
	/** Method to check if a certain square is valid, 
		occupied, and/or the color of the piece 
		occupying it*/
	public int checkSquare(String square)
	{
		int index = Arrays.asList(squareNames).indexOf(square);
		if(squares[index].isValid() == true)
		{
			for(int i = 0; i < pieces.size(); i++)
			{
				// check if square is occupied
				if((pieces.get(i)).getPosition().equals(square))
				{
					// if occupied; return 0 if piece is white, 1 if piece is black
					if((pieces.get(i)).getColor() == "White") { return 0; }	
					else { return 1; }
				}
			}
			return 2;		// return 2 if square is unoccupied
		}
		else { return -1; } // return -1 is square is invalid
	}
	
	public ArrayList<String> getMoves(String position)
	{
		int index;
		String type = getPieceType(position);
		String initPos = getPieceInitPos(position);
		//System.out.println(type);
		System.out.println(initPos + "\n");
		ArrayList<String> potentialDest = new ArrayList<String>();
		int[] currentCoord = getCoordinate(position);
		int[] destCoord = new int[2];
		// Pawn:
		if(type == "Pawn")
		{
			// Pawn moves if white
			if(checkSquare(position) == 0)
			{
				destCoord[0] = currentCoord[0] + squareSize;		// calculate coordinates for 1 square forward
				destCoord[1] = currentCoord[1];
				if(destCoord[0] <= (squareSize*8))					// check for valid coordinates
				{
					if(checkSquare(getSquareName(destCoord)) == 2)	// check if square is unoccupied
					{
						potentialDest.add(getSquareName(destCoord));	// if yes, add potential destination to arraylist
						if(position == initPos)							// if the pawn hasn't moved yet (position = initial position)
						{
							destCoord[0] = currentCoord[0] + (squareSize*2);	// coordinates for 2 squares forward
							destCoord[1] = currentCoord[1];
							if(checkSquare(getSquareName(destCoord)) == 2)		// check if square is unoccupied
							{
								potentialDest.add(getSquareName(destCoord));	// if yes, add potential destination to arraylist
							}
						}
					}
				}
				// check possible captures
				destCoord[0] = currentCoord[0] + squareSize;		// calculate coordinates for 1 square diagonal left
				destCoord[1] = currentCoord[1] - squareSize;
				if(destCoord[0] >= 0 && destCoord[1] >= 0)			// check for valid coordinates
				{
					if(checkSquare(getSquareName(destCoord)) == 1)		// check if target square is occupied by black piece
					{
						potentialDest.add(getSquareName(destCoord));	// if yes, add potential destination to arraylist
					}
				}
				destCoord[0] = currentCoord[0] + squareSize;		// calculate coordinates for 1 square diagonal right 
				destCoord[1] = currentCoord[1] + squareSize;
				if(destCoord[0] <= (squareSize*7) 
					&& destCoord[1] <= (squareSize*7))				// check for valid coordinates
				{
					if(checkSquare(getSquareName(destCoord)) == 1)		// check if target square is occupied by black piece
					{
						potentialDest.add(getSquareName(destCoord)); 	// if yes, add potential destination to arraylist
					}
				}
			}
			
			// Pawn moves if black
			else
			{
				destCoord[0] = currentCoord[0] - squareSize;		// calculate coordinates for 1 square forward
				destCoord[1] = currentCoord[1];
				if(destCoord[0] >= 0)								// check for valid coordinates
				{
					if(checkSquare(getSquareName(destCoord)) == 2)		// check if square is unoccupied
					{
						potentialDest.add(getSquareName(destCoord));	// if yes, add potential destination to arraylist
						if(position == initPos)							// if the pawn hasn't moved yet (position = initial position)
						{
							destCoord[0] = currentCoord[0] - (squareSize*2);	// coordinates for 2 squares forward
							destCoord[1] = currentCoord[1];
							if(checkSquare(getSquareName(destCoord)) == 2)		// check if square is unoccupied
							{
								potentialDest.add(getSquareName(destCoord));	// if yes, add potential destination to arraylist
							}
						}
					}
				}
				// check possible captures
				destCoord[0] = currentCoord[0] - squareSize;		// calculate coordinates for 1 square diagonal left
				destCoord[1] = currentCoord[1] - squareSize;
				if(destCoord[0] >= 0 && destCoord[1] >= 0)			// check for valid coordinates
				{
					if(checkSquare(getSquareName(destCoord)) == 0)		// check if target square is occupied by white piece
					{
						potentialDest.add(getSquareName(destCoord));	// if yes, add potential destination to arraylist
					}
				}
				destCoord[0] = currentCoord[0] - squareSize;		// calculate coordinates for 1 square diagonal right 
				destCoord[1] = currentCoord[1] + squareSize;
				if(destCoord[0] <= (squareSize*7)
					&& destCoord[1] <= (squareSize*7))					// check for valid coordinates
				{
					if(checkSquare(getSquareName(destCoord)) == 0)		// check if target square is occupied by white piece
					{
						potentialDest.add(getSquareName(destCoord)); 	// if yes, add potential destination to arraylist
					}
				}
			}
		}
		
		// Knight
		else if(type == "Knight") { potentialDest.add("Knight"); }
		
		// Rook
		else if(type == "Rook") { potentialDest.add("Rook"); }
		
		// Bishop
		else if(type == "Bishop") { potentialDest.add("Bishop"); }
		
		// Queen 
		else if(type == "Queen") { potentialDest.add("Queen"); }
		
		// King
		else { potentialDest.add("King"); }
		return (ArrayList<String>)potentialDest.clone();
	}
}
	