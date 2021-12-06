public class SettingsDisplay extends javax.swing.JPanel 
{
    private int tempWinChoice;
    private Menu currentMenu;
    /**
    * Constructor to create the settings display
    */
    public SettingsDisplay(Menu menu) 
    {
        currentMenu = menu;
        initComponents();
    }
    @SuppressWarnings("unchecked")  
    /**
    * Sets-up the settings GUI layout
    */
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        winChoice1 = new javax.swing.JRadioButton();
        winChoice2 = new javax.swing.JRadioButton();
        winChoice3 = new javax.swing.JRadioButton();
        saveExitButton = new javax.swing.JButton();
        timeSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        board3 = new javax.swing.JToggleButton();
        board2 = new javax.swing.JToggleButton();
        board1 = new javax.swing.JToggleButton();
        timeSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Settings"));
        setMaximumSize(new java.awt.Dimension(800, 800));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Choose Win Condition"));

        buttonGroup1.add(winChoice1);
        winChoice1.setText("WinCondition1");
        winChoice1.setMaximumSize(new java.awt.Dimension(100, 25));
        winChoice1.setMinimumSize(new java.awt.Dimension(100, 25));
        winChoice1.setPreferredSize(new java.awt.Dimension(100, 25));
        winChoice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winChoice1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(winChoice2);
        winChoice2.setText("Wincondition2");
        winChoice2.setMaximumSize(new java.awt.Dimension(100, 25));
        winChoice2.setMinimumSize(new java.awt.Dimension(100, 25));
        winChoice2.setPreferredSize(new java.awt.Dimension(100, 25));
        winChoice2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winChoice2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(winChoice3);
        winChoice3.setText("WinCondition12");
        winChoice3.setMaximumSize(new java.awt.Dimension(100, 25));
        winChoice3.setMinimumSize(new java.awt.Dimension(100, 25));
        winChoice3.setPreferredSize(new java.awt.Dimension(100, 25));
        winChoice3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winChoice3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(winChoice1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(winChoice2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(winChoice3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(winChoice1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(winChoice2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(winChoice3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        saveExitButton.setText("Save & Exit");
        saveExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveExitButtonActionPerformed(evt);
            }
        });

        timeSlider.setMajorTickSpacing(60);
        timeSlider.setMaximum(600);
        timeSlider.setMinimum(10);
        timeSlider.setMinorTickSpacing(10);
        timeSlider.setPaintTicks(true);
        timeSlider.setSnapToTicks(true);
        timeSlider.setValue(120);
        timeSlider.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Select Turn Time "));
        timeSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        timeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                timeSliderStateChanged(evt);
            }
        });

        jLabel1.setLabelFor(timeSlider);
        jLabel1.setText("Turn Time: 120 Seconds");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Choose Board"));

        buttonGroup2.add(board3);
        board3.setIcon(new javax.swing.ImageIcon("bOne.png"));
        board3.setText("b3");
        board3.setMaximumSize(new java.awt.Dimension(500, 500));
        board3.setMinimumSize(new java.awt.Dimension(120, 120));
        board3.setPreferredSize(new java.awt.Dimension(120, 120));
        board3.setSelectedIcon(new javax.swing.ImageIcon("bOneSel.png"));
        board3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                board3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(board2);
        board2.setIcon(new javax.swing.ImageIcon("bOne.png"));
        board2.setText("b2");
        board2.setMaximumSize(new java.awt.Dimension(500, 500));
        board2.setMinimumSize(new java.awt.Dimension(120, 120));
        board2.setPreferredSize(new java.awt.Dimension(120, 120));
        board2.setSelectedIcon(new javax.swing.ImageIcon("bOneSel.png"));
        board2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                board2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(board1);
        board1.setIcon(new javax.swing.ImageIcon("bOne.png"));
        board1.setText("b1");
        board1.setMaximumSize(new java.awt.Dimension(500, 500));
        board1.setMinimumSize(new java.awt.Dimension(120, 120));
        board1.setPreferredSize(new java.awt.Dimension(120, 120));
        board1.setSelectedIcon(new javax.swing.ImageIcon("bOneSel.png"));
        board1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                board1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(board1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(board2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(board3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(board1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(board2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(board3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        timeSlider1.setMajorTickSpacing(10);
        timeSlider1.setMaximum(60);
        timeSlider1.setMinimum(1);
        timeSlider1.setMinorTickSpacing(1);
        timeSlider1.setPaintTicks(true);
        timeSlider1.setSnapToTicks(true);
        timeSlider1.setValue(30);
        timeSlider1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Select Game Time "));
        timeSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        timeSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                timeSlider1StateChanged(evt);
            }
        });

        jLabel2.setLabelFor(timeSlider);
        jLabel2.setText("Game Time: 30 Minutes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(timeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }                      
    /**
   * Listens for when the 3rd win choice button is clicked
   * @param evt variable that holds the action data
   */
    private void winChoice3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        tempWinChoice = 3;
    }                                          
    /**
   * Listens for when the save and exit button is clicked
   * @param evt variable that holds the action data
   */
    private void saveExitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
         currentMenu.setWin(tempWinChoice);
         currentMenu.setTime(timeSlider.getValue(), timeSlider1.getValue()*60);
         currentMenu.drawMenu();
    }                                              
    /**
   * Listens for when the 1st win choice button is clicked
   * @param evt variable that holds the action data
   */
    private void winChoice1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        tempWinChoice = 1;      
    }                                          
    /**
   * Listens for when the turn timer slider is changed
   * @param evt variable that holds the action data
   */
    private void timeSliderStateChanged(javax.swing.event.ChangeEvent evt) {                                        
        jLabel1.setText("Turn Time: " + timeSlider.getValue() + " Seconds");
    }                                       
    /**
   * Listens for when the 2nd win choice button is clicked
   * @param evt variable that holds the action data
   */
    private void winChoice2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        tempWinChoice = 2;
    }                                          
    /**
   * Listens for when the 1st board choice button is clicked
   * @param evt variable that holds the action data
   */
    private void board1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        currentMenu.setBoardID(1);
    }                                      
    /**
   * Listens for when the 2nd board choice button is clicked
   * @param evt variable that holds the action data
   */
    private void board2ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        currentMenu.setBoardID(2);
    }                                      
    /**
   * Listens for when the 3rd board choice button is clicked
   * @param evt variable that holds the action data
   */
    private void board3ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        currentMenu.setBoardID(3);
    }                                      
    /**
   * Listens for when the game timer slider is changed
   * @param evt variable that holds the action data
   */
    private void timeSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                         
        jLabel2.setText("Game Time: " + timeSlider1.getValue() + " Minutes");
    }                                                            
    private javax.swing.JToggleButton board1;
    private javax.swing.JToggleButton board2;
    private javax.swing.JToggleButton board3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton saveExitButton;
    private javax.swing.JSlider timeSlider;
    private javax.swing.JSlider timeSlider1;
    private javax.swing.JRadioButton winChoice1;
    private javax.swing.JRadioButton winChoice2;
    private javax.swing.JRadioButton winChoice3;                  
}