import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Class responsible for controlling the GUI of the menu and it's respective data
 * 
 */
public class Menu extends Frame implements ActionListener
{
  private int boardID, turnTime, winChoice, gameTime;
  private JFrame menu;
  private JPanel menuDisplay;
  private SettingsDisplay settingsDisplay;
  private JButton quit, start, settings, instructions;
  /**
   * Constructor to build the default menu
   */
  public Menu()
  {
    gameTime = 30;
    boardID = 0;
    turnTime = 120;
    winChoice = 1;
    menu = new JFrame();
    menuDisplay = new JPanel();
    settingsDisplay = new SettingsDisplay(this);
    menu.setSize(275,350);
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    start = new JButton();
    instructions = new JButton();
    settings = new JButton();
    quit = new JButton();
    setMenuLayout();   
  }
    /**
     * Draws the menu GUI
     */
  public void drawMenu()
  {
      menu.setSize(275,350);
      menu.setVisible(false);
      menu.setTitle("Main Menu");
      menu.setContentPane(menuDisplay);
      menu.setVisible(true);
  }
  /**
   * Creates the game according to the saved settings
   */
  public void startGame()
  {
      new Game(boardID, turnTime,gme time, winChoice);
  }
  /**
   * Creates the menu GUI setup/layout
   */
  private void setMenuLayout()
  {
    menuDisplay.setBorder(BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 1, true), "Menu"));
    start.setText("Start");
    start.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {startActionPerformed(evt);}});
    instructions.setText("Instructions");
    instructions.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {instructionsActionPerformed(evt);}});
    settings.setText("Settings");
    settings.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {settingsActionPerformed(evt);}});
    quit.setText("Quit");
    quit.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {quitActionPerformed(evt);}});
    GroupLayout layout = new GroupLayout(menuDisplay);
    menuDisplay.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(quit, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(instructions, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(start, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(settings, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(start, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(instructions, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(settings, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(quit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        ); 
  }
  /**
   * Sets the win condition to the user's choice
   * @param choice the selected win condition
   */
  public void setWin(int choice) {winChoice = choice;}
  /**
   * Sets the turn and game times
   * @param time1 the player turn time
   * @param time2 the total game time
   */
  public void setTime(int time1, int time2){turnTime = time1; gameTime = time2;}
  /**
   * Sets the board to the user's choice
   * @param num the selected board
   */
  public void setBoardID(int num){boardID = num;}
  /**
   * Listens for actions
   * @param e variable that holds the action data
   */
  public void actionPerformed(ActionEvent e){}
  /**
   * Listens for when the instruction button is clicked
   * @param evt variable that holds the action data
   */
  private void instructionsActionPerformed(ActionEvent evt) 
  {         
      JOptionPane.showMessageDialog(menu,
      "Piece Movement:\n"
        + "Kings move one square in any direction, so long as that square is not attacked by an enemy piece. Additionally, kings are able to make a special move, known as castling.\n"
        + "Queens move diagonally, horizontally, or vertically any number of squares. They are unable to jump over pieces. (9 Points)\n"
        + "Rooks move horizontally or vertically any number of squares. They are unable to jump over pieces. Rooks move when the king castles. (5 Points)\n"
        + "Bishops move diagonally any number of squares. They are unable to jump over pieces. (3 Points)\n"
        + "Knights move in an ‘L’ shape’: two squares in a horizontal or vertical direction, then move one square horizontally or vertically. They are the only piece able to jump over other pieces. (3 Points)\n"
        + "Pawns move vertically forward one square, with the option to move two squares if they have not yet moved. Pawns are the only piece to capture different to how they move.\n"
        + "The pawns capture one square diagonally in a forward direction. Pawns are unable to move backward on captures or moves. \nUpon reaching the other side of the board a pawn promotes into any other piece, except for a king. (1 Point)\n\n"  
      + "Gameplay:\n"
        + "Each player takes turns moving one of their own pieces. To move a piece, click on one of your pieces and then click on one of its valid movement squares.\n"
        + "If one of these squares is an enemy piece that piece is 'captured' and removed from the board.\n"
        + "There is an individual turn timer: if you dont move a piece in the alloted time your turn is skipped.\nThere is also a game timer, if that runs out the winner is determined by who has the most points.\n"
        + "Additionally, there are multiple boards to choose/play on.\n\n"
      + "Win Conditions:\n"
        + "There are two win main conditions that can be chosen in the settings menu.\n"
        + "The first win condition is known as a checkmate. When one of your pices is 'attacking' the opposing king (or vice versa), this is known as a check.\n" 
        + "When In check, the king must get out of check by either moving to a safe square, having one of its pieces block the attacker, or having a piece capture the attacker.\n"
        + "If none of these options are possible then it is considered checkmate the side giving checkmate wins.\n"
        + "Be careful: if the opposing king has no legal moves and is not currently in check then the result is a draw by stalemate.\n"
        + "The other main win condition is getting your king to the opposite side of the board, achieving this before your opponent is a win.\n"
        + "A default win condition that cannot be changed occurs when the game timer runs out.\n " 
        + "Each sides' captured pieces are converted to their specified points and added up. Whoever captured the most ponts is the winner, if the poiints are equal the result is a draw."
      ,"How to Play", JOptionPane.PLAIN_MESSAGE);
  }                                            
   /**
   * Listens for when the settings button is clicked
   * @param evt variable that holds the action data
   */
    private void settingsActionPerformed(ActionEvent evt) 
    {                                         
      menu.setVisible(false);
      menu.setSize(800,500);
      menu.setTitle("Settings");
      menu.setContentPane(settingsDisplay);
      menu.setVisible(true);       
    }                                        
   /**
   * Listens for when the quit button is clicked
   * @param evt variable that holds the action data
   */
    private void quitActionPerformed(ActionEvent evt) 
    {                                     
        menu.dispose();
    }                                    
   /**
   * Listens for when the start button is clicked
   * @param evt variable that holds the action data
   */
    private void startActionPerformed(ActionEvent evt) 
    {                                      
        startGame();
    }                                     
}
