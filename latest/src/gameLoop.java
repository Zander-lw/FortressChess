import java.util.ArrayList;

public class gameLoop {

	BoardMap boardmap = new BoardMap(8,8,32);
	Board testWindow = new Board();
	
	String originClick;
	
	String destClick;
	
	String lastPiece;
	
	int[] neverLand = {500,500};
	
	public gameLoop(){
		
	}
	
	
	public void highLightPieces(String Color)
	{
		 ArrayList<String> potMoves = new ArrayList<String>();
		if(Color.equals("Black"))
		{
			potMoves = boardmap.teamPositions("Black");
		}
		else
		{
			potMoves = boardmap.teamPositions("Black");
		}
		
		
		for(int i = 0; i < potMoves.size();i++)
		{
			testWindow.highLightSquare(potMoves.get(i));
		}
	}
	
	public void movePiece()
	{
		boardmap.movePiece(originClick,destClick);
		
	}
	
	public void storeClick()
	{
		
		while(testWindow.getClicked()== false) // waiting until a square to move to is selected
	    {
	   
	    System.out.println(testWindow.getClicked());
	   setDest(testWindow.getRecent());
	    }
		
		System.out.println(destClick);
		
	}
	
	public void rstClick()
	{
		testWindow.setClicked(false);
	}
	
	public void highLightMoves(String square)
	{
		ArrayList<String> potMoves = new ArrayList<String>();
		potMoves = boardmap.getMoves(square);
		
		for(int i = 0; i < potMoves.size();i++)
		{
			testWindow.highLightSquare(potMoves.get(i));
		}
		
	}
	
	
	
	public void moveSelectedPiece()
	{
		boardmap.movePiece(originClick,destClick);
		
		if(getLastPiece().equals("Pawn"))
		{
			System.out.println("Attempting to move pawn to:   " +destClick);
			testWindow.window.movePiece(testWindow.window.pawnBlack,boardmap.getCoordinate(getDest()));
		}
		
		else if(getLastPiece().equals("Rook"))
		{
			System.out.println("Attempting to move Rook to:   " +destClick);
			testWindow.window.movePiece(testWindow.window.rookBlack,boardmap.getCoordinate(getDest()));
		}
	}
	
	public void setOrigin(String square)
	{	
		setLastPiece(boardmap.getPieceType(square));
		System.out.println("This square holds a " + getLastPiece());
		originClick = square;
	}
	
	public String getOrigin()
	{
		String temp = originClick;
		
		return temp;
	}
	
	
	public void setDest(String square)
	{
		destClick = square;
	}
	
	public String getDest()
	{
		String temp = destClick;
		return temp;
	}
		
	
	public String getLastPiece()
	{
		String temp = lastPiece;
		return temp;
	}
	
	public void setLastPiece(String piece)
	{
	lastPiece = boardmap.getPieceType(destClick);
	}
}
