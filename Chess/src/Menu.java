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
      //makeGame(boardID, turnTime,gme time, winChoice)
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
      "Put all the rules here",
      "How to Play", JOptionPane.PLAIN_MESSAGE);
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
