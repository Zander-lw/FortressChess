// Jakob Tuttle

// CPE 321
// Dec - 1 - 2021
/* This program contains the public class BoardMap which
   maps Squares to Square names and their drawn coordinates,
   as well as keeping track of all the pieces in play at any
   given time*/

		// Jakob Tuttle
		// CPE 321
		// Dec - 1 - 2021
		/* This program contains the public class BoardMap which
		   maps Squares to Square names and their drawn coordinates,
		   as well as keeping track of all the pieces in play at any
		   given time*/
		import java.util.*;

		/** This class creates three arrays and an ArrayList;
		*	the first array contains all of the square objects,
		*	the second contains the string names of each 
		*	square on the board, and the third contains the 
		*	image coordinates. The ArrayList contains a dynamic
		*	list of all the currently uncaptured pieces
		*/
		public class BoardMap
		{
			private static ArrayList<Piece> pieces = new ArrayList<Piece>();
			private static Square[] squares;
			private static String[] squareNames;
			private static int[][] coordinates;
			private static int squareSize;
			private static int size;
			
			/** BoardMap constructor, takes in x and y which
			*	denote the size of the chessboard along with
			*	z which denotes the size of each square in
			*	pixels
			*	
			*	@param x 	width of chess board
			*	@param y 	height of chess board
			*	@param z  	pixel size of each square
			*/
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
				pieces.add(new Piece("Pawn",1,"Black","B2"));
				pieces.add(new Piece("Rook",1,"Black","B1"));
				
				pieces.add(new Piece("Pawn",1,"White","G1"));

				
			}
			
			/** Method to print the sqaure names and their
			*	matching coordinates
			*/
			public void printMap()
			{
				for(int i = 0; i < size; i++)
				{
					System.out.println(squareNames[i] + " : " + Arrays.toString(coordinates[i]));
				}
			}
			
			/** Method to get the square name using a set of
			*	drawing coordinates
			*	
			*	@param coord 					array of coordinates
			*	@return squareNames[index] 		string name associated with corresponding 
			*									square or null if it doesn't exist
			*/
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
			
			
			/** Method to return number of piece at selected square
			*
			*	@param square						name of square
			*	@return number of square
			*/
			public int getSquareNumber(String square)
			{
				for(int i = 0; i < pieces.size(); i++)
				{
					if(pieces.get(i).getPosition().equals(square))
					{
						return (pieces.get(i)).getNumber();
					}
				}
				return 0;
			}
			
			
			
			/** Method to get the drawing coordinates using a
			*	square name
			*
			*	@param square						name of square
			*	@return coordinates[index].clone()	clone of the corresponding coordinate array
			*/
			public int[] getCoordinate(String square)
			{
				int index = Arrays.asList(squareNames).indexOf(square);
				return coordinates[index].clone();
			}
			
			/** Method to set a certain square within the array 
			*	to invalid
			*
			*	@param square 	target square to set invalid
			*/
			public void setInvalid(String square)
			{
				int index = Arrays.asList(squareNames).indexOf(square);
				squares[index].invalid();
			}
			
			/** Method to get the type of a certain piece 
			*
			*	@param square 						position of piece whose type is returned
			*	@return pieces.get(i)).getType()	type of target piece 
			* 										or null if nonexistent
			*/
			public String getPieceType(String square)
			{
				for(int i = 0; i < pieces.size(); i++)
				{
					if(pieces.get(i).getPosition().equals(square))
					{
						return (pieces.get(i)).getType();
					}
				}
				return null;
			}
			
			
			
			
			
			
			/** Method to get the initial position of a 
			*	certain piece 
			*
			*	@param square						position of piece whose type is returned
			*	@return pieces.get(i).getInitPos() 	initial position of target piece 
			* 										or null if nonexistent
			*/
			private String getPieceInitPos(String square)
			{
				for(int i = 0; i < pieces.size(); i++)
				{
					if(pieces.get(i).getPosition().equals(square))
					{
						return pieces.get(i).getInitPos();
					}
				}
				return null;
			}
			
			/** Method to check if a certain square is valid, 
			*	occupied, and/or the color of the piece 
			*	occupying it
			*
			* 	@param square 	position/name of target square
			*	@return int 	value based on occupied/invalid
			* 					status of target square
			*/
			public int checkSquare(String square)
			{
				int index = Arrays.asList(squareNames).indexOf(square);
				if(squares[index].isValid() == true)
				{
					for(int i = 0; i < pieces.size(); i++)
					{
						// check if square is occupied
						if(pieces.get(i).getPosition().equals(square))
						{
							// if occupied; return 0 if piece is white, 1 if piece is black
							if(pieces.get(i).getColor() == "White") { return 0; }	
							else { return 1; }
						}
					}
					return 2;		// return 2 if square is unoccupied
				}
				else { return -1; } // return -1 is square is invalid
			}
			
			/** Method to change the position of a certain
			*	piece and capture the target piece if it is
			*	occupying the destination
			*
			* 	@param currentPiece					piece to be moved
			* 	@param dest							destination square name
			*	@return pieces.get(i).getColor()	return color of captured piece if said
			* 										piece is a king, otherwise null
			*/
			public String movePiece(String currentPiece, String dest)
			{
				for(int i = 0; i < pieces.size(); i++)
				{
					if(pieces.get(i).getPosition().equals(dest))
					{
						pieces.get(i).capture();
						if(pieces.get(i).getType().equals("King"))
						{
							return pieces.get(i).getColor();
						}
						pieces.remove(i);
						break;
					}
				}
				for(int i = 0; i < pieces.size(); i++)
				{
					if(pieces.get(i).getPosition().equals(currentPiece))
					{
						pieces.get(i).move(dest);
					}
				}
				return null;
			}
			
			/** Method to return the position of all pieces
			* 	on a team given team color
			*
			* 	@param color			color of target team
			*	@return positions		ArrayList of piece positions
			*/
			public ArrayList<String> teamPositions(String color)
			{
				ArrayList<String> positions = new ArrayList<String>();
				for(int i = 0; i < pieces.size(); i++)
				{
					if(pieces.get(i).getColor().equals(color))
					{
						positions.add(pieces.get(i).getPosition());
					}
				}
				return (ArrayList<String>)positions.clone();
			}
			
			/** Method to return the possible position 
			*	a certain piece can be moved
			*
			* 	@param position				position of target piece
			*	@return potentialDest		ArrayList of potential positions
			*/
			public ArrayList<String> getMoves(String position)
			{
				int index;
				String type = getPieceType(position);
				String initPos = getPieceInitPos(position);
				System.out.println("Piece at: " + initPos);
				System.out.println("===============");
				ArrayList<String> potentialDest = new ArrayList<String>();
				int[] currentCoord = getCoordinate(position);
				int[] destCoord = new int[2];
				String destSquare;
				// Pawn:
				if(type == "Pawn")
				{
					// Pawn moves if white
					if(checkSquare(position) == 0)
					{
						destCoord[0] = currentCoord[0] - squareSize;		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1];
						destSquare = getSquareName(destCoord);				// get square name
						if(destCoord[0] >= 0)								// check for valid coordinates
						{
							if(checkSquare(destSquare) == 2)				// check if square is unoccupied
							{
								potentialDest.add(destSquare);					// if yes, add potential destination to arraylist
								if(position == initPos)							// if the pawn hasn't moved yet (position = initial position)
								{
									destCoord[0] = currentCoord[0] - (squareSize*2);	// coordinates for 2 squares forward
									destCoord[1] = currentCoord[1];
									destSquare = getSquareName(destCoord);				// get square name
									if(checkSquare(destSquare) == 2)					// check if square is unoccupied
									{
										potentialDest.add(destSquare);					// if yes, add potential destination to arraylist
									}
								}
							}
						}
						// check possible captures
						destCoord[0] = currentCoord[0] - squareSize;		// calculate coordinates for 1 square diagonal left
						destCoord[1] = currentCoord[1] - squareSize;
						destSquare = getSquareName(destCoord);				// get square name
						if(destCoord[0] >= 0 && destCoord[1] >= 0)			// check for valid coordinates
						{
							if(checkSquare(destSquare) == 1)				// check if target square is occupied by white piece
							{
								potentialDest.add(destSquare);				// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - squareSize;		// calculate coordinates for 1 square diagonal right 
						destCoord[1] = currentCoord[1] + squareSize;
						destSquare = getSquareName(destCoord);				// get square name
						if(destCoord[0] <= (squareSize*7)
							&& destCoord[1] <= (squareSize*7))				// check for valid coordinates
						{
							if(checkSquare(destSquare) == 1)				// check if target square is occupied by white piece
							{
								potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
							}
						}
					}
					
					// Pawn moves if black
					else
					{
						destCoord[0] = currentCoord[0] + squareSize;		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1];
						destSquare = getSquareName(destCoord);				// get square name
						if(destCoord[0] <= (squareSize*7))					// check for valid coordinates
						{
							if(checkSquare(destSquare) == 2)				// check if square is unoccupied
							{
								potentialDest.add(destSquare);					// if yes, add potential destination to arraylist
								if(position == initPos)							// if the pawn hasn't moved yet (position = initial position)
								{
									destCoord[0] = currentCoord[0] + (squareSize*2);	// coordinates for 2 squares forward
									destCoord[1] = currentCoord[1];
									destSquare = getSquareName(destCoord);				// get square name
									if(checkSquare(destSquare) == 2)					// check if square is unoccupied
									{
										potentialDest.add(destSquare);					// if yes, add potential destination to arraylist
									}
								}
							}
						}
						// check possible captures
						destCoord[0] = currentCoord[0] + squareSize;		// calculate coordinates for 1 square diagonal left
						destCoord[1] = currentCoord[1] - squareSize;
						destSquare = getSquareName(destCoord);				// get square name
						if(destCoord[0] >= 0 && destCoord[1] >= 0)			// check for valid coordinates
						{
							if(checkSquare(destSquare) == 0)				// check if target square is occupied by black piece
							{
								potentialDest.add(destSquare);				// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] + squareSize;		// calculate coordinates for 1 square diagonal right 
						destCoord[1] = currentCoord[1] + squareSize;
						destSquare = getSquareName(destCoord);				// get square name
						if(destCoord[0] <= (squareSize*7) 
							&& destCoord[1] <= (squareSize*7))				// check for valid coordinates
						{
							if(checkSquare(destSquare) == 0)				// check if target square is occupied by black piece
							{
								potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
							}
						}
					}
				}
				
				// Knight
				else if(type == "Knight")
				{
					// Knight moves if white
					if(checkSquare(position) == 0)
					{
						destCoord[0] = currentCoord[0] + (2*squareSize);		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] + squareSize;
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] <= (squareSize*7) 
							&& destCoord[1] <= (squareSize*7))					// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 1
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] + squareSize;			// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] + (2*squareSize);
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] <= (squareSize*7) 
							&& destCoord[1] <= (squareSize*7))					// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 1
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] + (2*squareSize);		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] - squareSize;
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] <= (squareSize*7) && destCoord[1] >= 0)	// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 1
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] + squareSize;			// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] - (2*squareSize);
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] <= (squareSize*7) && destCoord[1] >= 0)	// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 1
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - (2*squareSize);		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] - squareSize;
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] >= 0 && destCoord[1] >= 0)				// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 1
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - squareSize;			// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] - (2*squareSize);
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] >= 0 && destCoord[1] >= 0)				// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 1
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - (2*squareSize);		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] + squareSize;
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] >= 0 && destCoord[1] <= (squareSize*7))	// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 1
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - squareSize;			// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] + (2*squareSize);
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] >= 0 && destCoord[1] <= (squareSize*7))	// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 1
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
					}
					
					// Knight moves if black
					else
					{
						destCoord[0] = currentCoord[0] + (2*squareSize);		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] + squareSize;
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] <= (squareSize*7) 
							&& destCoord[1] <= (squareSize*7))					// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 0
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] + squareSize;			// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] + (2*squareSize);
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] <= (squareSize*7) 
							&& destCoord[1] <= (squareSize*7))					// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 0
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] + (2*squareSize);		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] - squareSize;
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] <= (squareSize*7) && destCoord[1] >= 0)	// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 0
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] + squareSize;			// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] - (2*squareSize);
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] <= (squareSize*7) && destCoord[1] >= 0)	// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 0
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - (2*squareSize);		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] - squareSize;
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] >= 0 && destCoord[1] >= 0)				// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 0
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - squareSize;			// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] - (2*squareSize);
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] >= 0 && destCoord[1] >= 0)				// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 0
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - (2*squareSize);		// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] + squareSize;
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] >= 0 && destCoord[1] <= (squareSize*7))	// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 0
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
						destCoord[0] = currentCoord[0] - squareSize;			// calculate coordinates for 1 square forward
						destCoord[1] = currentCoord[1] + (2*squareSize);
						destSquare = getSquareName(destCoord);					// get square name
						if(destCoord[0] >= 0 && destCoord[1] <= (squareSize*7))	// check for valid coordinates
						{
							// check if target square is unoccupied or occupied by opposing piece
							if(checkSquare(destSquare) == 0
								|| checkSquare(destSquare) == 2)
							{
								potentialDest.add(destSquare); 					// if yes, add potential destination to arraylist
							}
						}
					}
				}
						
				
				// Rook
				else if(type == "Rook")
				{
					for(int d = 0; d < 4; d++)
					{
						for(int i = 1; i < 8; i++)
						{
							if(d == 0)
							{
								destCoord[0] = currentCoord[0] + (i*squareSize);	// calculate coordinates for i squares down
								destCoord[1] = currentCoord[1];
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] <= (squareSize*7))					// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 1)
							{
								destCoord[0] = currentCoord[0];						// calculate coordinates for i squares left
								destCoord[1] = currentCoord[1] - (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[1] >= 0)								// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 2)
							{
								destCoord[0] = currentCoord[0] - (i*squareSize);	// calculate coordinates for i squares up
								destCoord[1] = currentCoord[1];
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] >= 0)								// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 3)
							{
								destCoord[0] = currentCoord[0];						// calculate coordinates for i squares right
								destCoord[1] = currentCoord[1] + (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[1] <= (squareSize*7))					// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
						}
					}
				}
				
				// Bishop
				else if(type == "Bishop")
				{
					for(int d = 0; d < 4; d++)
					{
						for(int i = 1; i < 8; i++)
						{
							if(d == 0)
							{
								destCoord[0] = currentCoord[0] + (i*squareSize);	// calculate coordinates for i squares diagonal down right
								destCoord[1] = currentCoord[1] + (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] <= (squareSize*7)
									&& destCoord[1] <= (squareSize*7))				// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 1)
							{
								destCoord[0] = currentCoord[0] + (i*squareSize);	// calculate coordinates for i squares diagonal down left
								destCoord[1] = currentCoord[1] - (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name 
								if(destCoord[0] <= (squareSize*7) && destCoord[1] >= 0)	// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 2)
							{
								destCoord[0] = currentCoord[0] - (i*squareSize);	// calculate coordinates for i squares diagonal up left
								destCoord[1] = currentCoord[1] - (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] >= 0 && destCoord[1] >= 0)			// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 3)
							{
								destCoord[0] = currentCoord[0] - (i*squareSize);	// calculate coordinates for i squares diagonal up right 
								destCoord[1] = currentCoord[1] + (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] >= 0 && destCoord[1] <= (squareSize*7))	// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
						}
					}
				}
				
				// Queen 
				else if(type == "Queen")
				{
					for(int d = 0; d < 8; d++)
					{
						for(int i = 1; i < 8; i++)
						{
							if(d == 0)
							{
								destCoord[0] = currentCoord[0] + (i*squareSize);	// calculate coordinates for i squares down
								destCoord[1] = currentCoord[1];
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] <= (squareSize*7))					// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 1)
							{
								destCoord[0] = currentCoord[0];						// calculate coordinates for i squares left
								destCoord[1] = currentCoord[1] - (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[1] >= 0)								// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 2)
							{
								destCoord[0] = currentCoord[0] - (i*squareSize);	// calculate coordinates for i squares up
								destCoord[1] = currentCoord[1];
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] >= 0)								// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 3)
							{
								destCoord[0] = currentCoord[0];						// calculate coordinates for i squares right
								destCoord[1] = currentCoord[1] + (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[1] <= (squareSize*7))					// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 4)
							{
								destCoord[0] = currentCoord[0] + (i*squareSize);	// calculate coordinates for i squares diagonal down right
								destCoord[1] = currentCoord[1] + (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] <= (squareSize*7)
									&& destCoord[1] <= (squareSize*7))				// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 5)
							{
								destCoord[0] = currentCoord[0] + (i*squareSize);	// calculate coordinates for i squares diagonal down left
								destCoord[1] = currentCoord[1] - (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name 
								if(destCoord[0] <= (squareSize*7) && destCoord[1] >= 0)	// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 6)
							{
								destCoord[0] = currentCoord[0] - (i*squareSize);	// calculate coordinates for i squares diagonal up left
								destCoord[1] = currentCoord[1] - (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] >= 0 && destCoord[1] >= 0)			// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
							if(d == 7)
							{
								destCoord[0] = currentCoord[0] - (i*squareSize);	// calculate coordinates for i squares diagonal up right 
								destCoord[1] = currentCoord[1] + (i*squareSize);
								destSquare = getSquareName(destCoord);				// get square name
								if(destCoord[0] >= 0 && destCoord[1] <= (squareSize*7))	// check for valid coordinates
								{
									if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
									}
									// check if square contains allied piece or is invalid
									else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1)
									{
										break;										// do not add square, move to next direction
									}
									else											// check if square is occupied by opposing piece 
									{
										potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
										break;										// move to next direction
									}
								}
							}
						}
					}
				}
				// King
				else
				{
					destCoord[0] = currentCoord[0] + squareSize;		// calculate coordinates for 1 square down
					destCoord[1] = currentCoord[1];
					destSquare = getSquareName(destCoord);				// get square name
					if(destCoord[0] <= (squareSize*7))					// check for valid coordinates
					{
						if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
						{
							potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
						}
						// check if square contains allied piece or is invalid; if yes, do not add square;
						else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1){}
						else											// check if square is occupied by opposing piece 
						{
							potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
						}
					}
					destCoord[0] = currentCoord[0];						// calculate coordinates for 1 square left
					destCoord[1] = currentCoord[1] - squareSize;
					destSquare = getSquareName(destCoord);				// get square name
					if(destCoord[1] >= 0)								// check for valid coordinates
					{
						if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
						{
							potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
						}
						// check if square contains allied piece or is invalid; if yes, do not add square;
						else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1){}
						else											// check if square is occupied by opposing piece 
						{
							potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
						}
					}
					destCoord[0] = currentCoord[0] - squareSize;		// calculate coordinates for 1 square up
					destCoord[1] = currentCoord[1];
					destSquare = getSquareName(destCoord);				// get square name
					if(destCoord[0] >= 0)								// check for valid coordinates
					{
						if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
						{
							potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
						}
						// check if square contains allied piece or is invalid; if yes, do not add square;
						else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1){}
						else											// check if square is occupied by opposing piece 
						{
							potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
						}
					}
					destCoord[0] = currentCoord[0];						// calculate coordinates for 1 square right
					destCoord[1] = currentCoord[1] + squareSize;
					destSquare = getSquareName(destCoord);				// get square name
					if(destCoord[1] <= (squareSize*7))					// check for valid coordinates
					{
						if(checkSquare(destSquare) == 2)				// check if target square is unoccupied
						{
							potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
						}
						// check if square contains allied piece or is invalid; if yes, do not add square;
						else if(checkSquare(destSquare) == checkSquare(position) || checkSquare(destSquare) == -1){}
						else											// check if square is occupied by opposing piece 
						{
							potentialDest.add(destSquare); 				// if yes, add potential destination to arraylist
						}
					}
				}
				return (ArrayList<String>)potentialDest.clone();
			}
		}
			