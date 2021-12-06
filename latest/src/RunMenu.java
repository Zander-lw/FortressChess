import java.util.*;

public class RunMenu
{
  public static void main(String args[])
  {  
    new Menu().drawMenu();
    
	  
	//Showing new board
   // Board testWindow = new Board();
    
    //Arraylist to store potential moves
    
    ArrayList<String> potMoves = new ArrayList<String>();
    gameLoop pleaseGamer = new gameLoop();
    
    //creating new board map
    //BoardMap boardmap = new BoardMap(8,8,32);
    ArrayList<String> pawnDest = new ArrayList<String>();
    int[] v = {192,0};
    //boardmap.printMap();
    //System.out.println(boardmap.getSquareName(v));
    //System.out.println(Arrays.toString(boardmap.getCoordinate("D4")));
    //pawnDest = boardmap.getMoves("B1");
    
   
    
    /*for(int i = 0; i < pawnDest.size(); i++)
    {
    	
    	potMoves.add(pawnDest.get(i));
        System.out.println(pawnDest.get(i)+"    Thissss=========="+ i);
        boardmap.getCoordinate(pawnDest.get(i));
        int[] temp = boardmap.getCoordinate(pawnDest.get(i));
        System.out.println(temp[0]+"   "+temp[1]);
       
        testWindow.highLightSquare(pawnDest.get(i));
       // testWindow.window.movePawn(boardmap.getCoordinate(pawnDest.get(i)));
        
     
    }
  */
    
    
    
    String booton = "fukDis";
    System.out.println("Entering loop===============");
    
    //Select Piece to move
    
   // testWindow.highLightSquare("B1");
    //testWindow.highLightSquare("B2");
    
    
    pleaseGamer.highLightPieces("Black");
 /* 
 //==================Highlight eligible pieces  Black team first ==============================   
    
    potMoves = boardmap.teamPositions("Black");
    
    for(int i = 0; i <potMoves.size();i++)
    {
    	testWindow.highLightSquare(potMoves.get(i));
    }
    
 //======================================================   
   */
    
    
   pleaseGamer.storeClick();  
  // pleaseGamer.rstClick();
   pleaseGamer.setOrigin(pleaseGamer.getDest());
   pleaseGamer.setLastPiece(pleaseGamer.getDest());

/*
//==========================Select one of the highlighted pieces================   
    while(testWindow.getClicked()== false) // waiting until a square to move to is selected
    {
   
    System.out.println(testWindow.getClicked());
    booton= testWindow.getRecent();
    }
    

    
    System.out.println("left the loop, booton =        " + booton);
  
    
    ArrayList<String> pieceDest = new ArrayList<String>();
    pieceDest = boardmap.getMoves(booton);
    
    String tempS = boardmap.getPieceType(booton);
    System.out.println("You done clicked on a darn:         "+tempS);
    
    String clickOne = booton;
    
//===================================================================================    
    */
  
   //pleaseGamer.storeClick(); 
  
  
   pleaseGamer.highLightMoves(pleaseGamer.getDest());
   pleaseGamer.rstClick();
  
  
   
 /*
//==========================Highlights potential moves of selected piece================================
    for(int i = 0; i < pieceDest.size(); i++)
    {
    	System.out.println(pieceDest.get(i));
    	potMoves.add(pieceDest.get(i));
        
        boardmap.getCoordinate(pieceDest.get(i));
        int[] temp = boardmap.getCoordinate(pieceDest.get(i));
        System.out.println(temp[0]+"   "+temp[1]);
       
        testWindow.highLightSquare(pieceDest.get(i));
      
     
    }
//================================================================================================ 
 */
   pleaseGamer.storeClick();
   pleaseGamer.rstClick();
   pleaseGamer.moveSelectedPiece();
//=======================================Select one of the highlighted squares to move to========================
   /* testWindow.setClicked(false);
    
    while(testWindow.getClicked()== false) // waiting until a square to move to is selected
    {
    System.out.println(testWindow.getClicked());
    booton= testWindow.getRecent();
    }
    
    
    
    
//=================================================================    
    potMoves.clear();
    pieceDest.clear();
    System.out.println("Choice selected: " +booton);
   
   
    //=======================Move Selected Piece
    
    //Check if desired square has piece of opposite color in it and if so check type
    int tempDest = boardmap.checkSquare(booton);
    String captureType = boardmap.getPieceType(booton);
    int captureNum = boardmap.getSquareNumber(booton);
    
    //
    boardmap.movePiece(clickOne,booton);
   
  
    System.out.println("tempDest =    "+ tempDest + "At square:     "+ booton);
    
    
    if(tempS == "Rook")
    {
    	 testWindow.window.movePiece(testWindow.window.rookBlack,boardmap.getCoordinate(booton));
    }
    else
    {
    	testWindow.window.movePiece(testWindow.window.pawnBlack,boardmap.getCoordinate(booton));
    }
    
    
    //========================================Remove Captured Pieces==========================
    int[] neverLand = {500,500};
    if(tempDest == 0) 
    {
    	System.out.println("You captured a: ");
    	if(captureType.equals("Pawn"))
    	{
    		System.out.print(captureType);
    		testWindow.window.movePiece(testWindow.window.pawnWhite,neverLand);
    	}
    	
    }
    
    
    
    //========================================================================================
   
    //==================================================================================  	
    /*
    //==============Test White turn=================================
    
    testWindow.setClicked(false);
    
    testWindow.highLightSquare("G1");
    
    while(testWindow.getClicked()== false) // waiting until a square to move to is selected
    {
    System.out.println(testWindow.getClicked());
    booton= testWindow.getRecent();
    }
    
    System.out.println("Choice selected: " +booton);
    potMoves.clear();
    pieceDest.clear();
    
    potMoves = boardmap.getMoves(booton);
    
    for(int i = 0; i < potMoves.size(); i++)
    {
    
    	
        System.out.println(potMoves.get(i));
        boardmap.getCoordinate(potMoves.get(i));
        int[] temp = boardmap.getCoordinate(potMoves.get(i));
        System.out.println(temp[0]+"   "+temp[1]);
       
        testWindow.highLightSquare(potMoves.get(i));
      
     
    }
    
    
    testWindow.setClicked(false);
    
    while(testWindow.getClicked()== false) // waiting until a square to move to is selected
    {
   System.out.println(testWindow.getClicked());
    booton= testWindow.getRecent();
    }
    testWindow.window.movePiece(testWindow.window.pawnWhite,boardmap.getCoordinate(booton));
    
    //=================================================================
    
    
 
    for(int i = 0; i < pieceDest.size(); i++)
    {
    	System.out.println(pieceDest.get(i));
    	potMoves.add(pieceDest.get(i));
        
        boardmap.getCoordinate(pieceDest.get(i));
        System.out.println( "Location            "+pieceDest.get(i));
        int[] temp = boardmap.getCoordinate(pieceDest.get(i));
        System.out.println(temp[0]+"   "+temp[1]);
       
        testWindow.highLightSquare(pieceDest.get(i));
       
        
     
    }
   
   // testWindow.window.movePawn(boardmap.getCoordinate(booton));
    
    
   // note for jakob -- add attribute to label multiple instances of one piece
    
    */
    
    

    
    
  }
}  
