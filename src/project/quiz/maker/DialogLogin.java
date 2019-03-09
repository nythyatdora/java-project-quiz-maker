package project.quiz.maker;

import java.awt.CardLayout;
import java.util.Map;

public final class DialogLogin extends javax.swing.JDialog {
    
    private final UserData userData = UserData.createInstance ();
    private final UserJunkData junkData = UserJunkData.createInstance ();
    
    private final String MESSAGE_WRITE_USER = "Your account has been secussfully created!";
    private final String MESSAGE_PASSWORD_NOT_MATCH = "Password doesn't matched. Recheck your password again.";
    private final String MESSAGE_USERNAME_TAKEN = "Username has already been taken!";
    private final String MESSAGE_INCORRECT_INPUT = "The username or password you've entered doesn't\n match any account.";
    private final String MESSAGE_ACCESS_ALLOWED = "Access allowed!";
    
    private final String TEXT_LABEL_CREATE_ACCOUNT = "create account?";
    private final String UNDERLINE_TEXT_LABEL_CREATE_ACCOUNT = "<html><u>create account?</u></html>";
    
    private Map<Integer, User> map;
    private static User loggingUser;
    private static boolean accessAllowed;
    
    public DialogLogin ( java.awt.Frame parent, boolean modal ) {
        super (parent, modal);
        initComponents ();
        
        setMapData();
    }
    
    public User getLoggingUser() {
        if(!accessAllowed)
            return null;
        else
            return loggingUser;
    }
    
    public boolean getAccessAllowed() {
        return accessAllowed;
    }
    
    private void setMapData() {
        userData.hasFileExisted ();
        junkData.hasFileExisted ();
        
        map = userData.fetchMapData ();       
    }
    
    private void resetMapData() {
        map = userData.fetchMapData ();
    }
    
    private void createAccount() {
        boolean hasAddedAccount = false;
        String username = text_newUsername.getText();
        String password = String.valueOf (text_newPassword.getPassword ());
        String confirmPassword = String.valueOf (text_confirmNewPassword.getPassword());

        boolean allFilled = VerifyControl.hasAllInputFieldsFilled (panel_createAccount);
        if(!allFilled) {
            ModifyControl.requestFocusOnMissingField (panel_createAccount);
        }
        else {
            if(!password.equals (confirmPassword)) {
                MessageBox.showMessage (null, MESSAGE_PASSWORD_NOT_MATCH);
            }
            else {
                // check if the username exist
                boolean hasExisted = userData.hasFieldExisted (map, username);

                if(!hasExisted) {
                    writeUserData(username, password);

                    VerifyControl.clearInputFields (panel_createAccount);
                    
                    hasAddedAccount = true;
                }
                else {
                    VerifyControl.clearInputFields (panel_createAccount);
                    MessageBox.showMessage (null, MESSAGE_USERNAME_TAKEN);
                }
            }
        }
            
        if(hasAddedAccount)
            resetMapData ();
    }
    
    private void writeUserData (String username, String password) {
        UserJunk userJunk = (UserJunk) junkData.fetchJunkData ();
        int id = userJunk.getJunkID ();

        User user = new User(++id, username, password);
        map.put (user.getUserID (), user);
        userJunk.setJunkID (id);

        userData.commitMapData (map, MESSAGE_WRITE_USER);
        junkData.commitJunkData (userJunk);
    }
    
    private void login() {
        String username = text_username.getText();
        String password = String.valueOf (text_password.getPassword ());
                
        boolean allFilled = VerifyControl.hasAllInputFieldsFilled (panel_login);
        if(!allFilled) {
            ModifyControl.requestFocusOnMissingField (panel_login);
        }
        else {
            boolean userFound = false;
            
            for ( Map.Entry<Integer, User> entry : map.entrySet () ) {
                User value = entry.getValue ();
                
                boolean foundUsername = username.equals (value.getUsername ());
                boolean foundPassword = password.equals (value.getPassword ());   
                
                if(foundUsername) {
                    if(foundPassword) {
                        loggingUser = value;
                        userFound = true;
                        accessAllowed = true;
                        break;
                    }
                }          
            }
            
            if(!userFound) {
                MessageBox.showMessage (null, MESSAGE_INCORRECT_INPUT);
            }
            else {
                MessageBox.showMessage (null, MESSAGE_ACCESS_ALLOWED);
                VerifyControl.clearInputFields (panel_login);
                this.dispose ();
            }
        }
    }
    
    private void loadCardCreateAccount() {
        CardLayout card = (CardLayout) panel_card.getLayout ();
        card.show (panel_card, "cardCreateAccount");
    }
    
    private void loadCardLogin() {
        CardLayout card = (CardLayout) panel_card.getLayout ();
        card.show (panel_card, "cardLogin");
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_background = new javax.swing.JPanel();
        panel_quote = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panel_card = new javax.swing.JPanel();
        panel_login = new javax.swing.JPanel();
        label_username = new javax.swing.JLabel();
        label_createAccount = new javax.swing.JLabel();
        button_login = new javax.swing.JButton();
        text_username = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        label_password = new javax.swing.JLabel();
        label_title1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        label_picture = new javax.swing.JLabel();
        text_password = new javax.swing.JPasswordField();
        panel_createAccount = new javax.swing.JPanel();
        label_newPassword = new javax.swing.JLabel();
        button_create = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        label_confirmNewPassword = new javax.swing.JLabel();
        text_newUsername = new javax.swing.JTextField();
        label_newUsername = new javax.swing.JLabel();
        label_title = new javax.swing.JLabel();
        button_back = new javax.swing.JButton();
        text_newPassword = new javax.swing.JPasswordField();
        text_confirmNewPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);

        panel_background.setBackground(new java.awt.Color(255, 255, 255));

        panel_quote.setBackground(new java.awt.Color(20, 10, 37));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("<html>\"Don't stop<br>when you're<br>tired. STOP<br> when you<br>are <span style=\"color: red;\">DONE.</span>\"<br>- unknown </html>"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(20, 10, 37));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(20, 10, 37));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_quoteLayout = new javax.swing.GroupLayout(panel_quote);
        panel_quote.setLayout(panel_quoteLayout);
        panel_quoteLayout.setHorizontalGroup(
            panel_quoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_quoteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_quoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_quoteLayout.createSequentialGroup()
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_quoteLayout.setVerticalGroup(
            panel_quoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_quoteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_card.setLayout(new java.awt.CardLayout());

        panel_login.setBackground(new java.awt.Color(255, 255, 255));
        panel_login.setPreferredSize(new java.awt.Dimension(419, 550));

        label_username.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_username.setText("username");

        label_createAccount.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_createAccount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_createAccount.setText("create account?");
        label_createAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_createAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_createAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_createAccountMouseExited(evt);
            }
        });

        button_login.setUI(new CSSButton());
        button_login.setBackground(new java.awt.Color(219, 43, 48));
        button_login.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        button_login.setForeground(new java.awt.Color(255, 255, 255));
        button_login.setText("LOGIN");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });

        text_username.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(30, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label_password.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_password.setText("password");

        label_title1.setFont(new java.awt.Font("Bahnschrift", 0, 28)); // NOI18N
        label_title1.setText("WELCOME.");
        label_title1.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label_picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_user_100px.png"))); // NOI18N

        text_password.setEchoChar('\u26ab');

        javax.swing.GroupLayout panel_loginLayout = new javax.swing.GroupLayout(panel_login);
        panel_login.setLayout(panel_loginLayout);
        panel_loginLayout.setHorizontalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_username)
                    .addComponent(label_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label_createAccount))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_picture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(text_password))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_loginLayout.setVerticalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_title1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_picture, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_createAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        panel_card.add(panel_login, "cardLogin");

        panel_createAccount.setBackground(new java.awt.Color(255, 255, 255));

        label_newPassword.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_newPassword.setText("password");

        button_create.setUI(new CSSButton());
        button_create.setBackground(new java.awt.Color(219, 43, 48));
        button_create.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        button_create.setForeground(new java.awt.Color(255, 255, 255));
        button_create.setText("CREATE");
        button_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_createActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(30, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label_confirmNewPassword.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_confirmNewPassword.setText("confirm password");

        text_newUsername.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        label_newUsername.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_newUsername.setText("username");

        label_title.setFont(new java.awt.Font("Bahnschrift", 0, 28)); // NOI18N
        label_title.setText("NEW ACCOUNT");
        label_title.setToolTipText("");

        button_back.setUI(new CSSButton());
        button_back.setBackground(new java.awt.Color(219, 43, 48));
        button_back.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        button_back.setForeground(new java.awt.Color(255, 255, 255));
        button_back.setText("BACK");
        button_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_backActionPerformed(evt);
            }
        });

        text_newPassword.setEchoChar('\u26ab');

        text_confirmNewPassword.setEchoChar('\u26ab');

        javax.swing.GroupLayout panel_createAccountLayout = new javax.swing.GroupLayout(panel_createAccount);
        panel_createAccount.setLayout(panel_createAccountLayout);
        panel_createAccountLayout.setHorizontalGroup(
            panel_createAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_createAccountLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_createAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_newPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_confirmNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_create, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_newUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(text_newUsername)
                    .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(button_back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_newPassword)
                    .addComponent(text_confirmNewPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_createAccountLayout.setVerticalGroup(
            panel_createAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_createAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_newUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_newUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_confirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_confirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_create, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        panel_card.add(panel_createAccount, "cardCreateAccount");

        javax.swing.GroupLayout panel_backgroundLayout = new javax.swing.GroupLayout(panel_background);
        panel_background.setLayout(panel_backgroundLayout);
        panel_backgroundLayout.setHorizontalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_quote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_quote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void label_createAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_createAccountMouseClicked
        loadCardCreateAccount();
    }//GEN-LAST:event_label_createAccountMouseClicked

    private void label_createAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_createAccountMouseEntered
        label_createAccount.setText (UNDERLINE_TEXT_LABEL_CREATE_ACCOUNT);
    }//GEN-LAST:event_label_createAccountMouseEntered

    private void label_createAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_createAccountMouseExited
        label_createAccount.setText (TEXT_LABEL_CREATE_ACCOUNT);
    }//GEN-LAST:event_label_createAccountMouseExited
    
    private void button_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_createActionPerformed
        createAccount ();
    }//GEN-LAST:event_button_createActionPerformed

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        loadCardLogin();
    }//GEN-LAST:event_button_backActionPerformed

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
        login();
    }//GEN-LAST:event_button_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main ( String args[] ) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels () ) {
                if ( "Nimbus".equals (info.getName ()) ) {
                    javax.swing.UIManager.setLookAndFeel (info.getClassName ());
                    break;
                }
            }
        }
        catch ( ClassNotFoundException ex ) {
            java.util.logging.Logger.getLogger (DialogLogin.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger (DialogLogin.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger (DialogLogin.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger (DialogLogin.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater (new Runnable () {
            public void run () {
                DialogLogin dialog = new DialogLogin (new javax.swing.JFrame (), true);
                dialog.addWindowListener (new java.awt.event.WindowAdapter () {
                    @Override
                    public void windowClosing ( java.awt.event.WindowEvent e ) {
                        System.exit (0);
                    }
                });
                dialog.setVisible (true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_back;
    private javax.swing.JButton button_create;
    private javax.swing.JButton button_login;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel label_confirmNewPassword;
    private javax.swing.JLabel label_createAccount;
    private javax.swing.JLabel label_newPassword;
    private javax.swing.JLabel label_newUsername;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_picture;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_title1;
    private javax.swing.JLabel label_username;
    private javax.swing.JPanel panel_background;
    private javax.swing.JPanel panel_card;
    private javax.swing.JPanel panel_createAccount;
    private javax.swing.JPanel panel_login;
    private javax.swing.JPanel panel_quote;
    private javax.swing.JPasswordField text_confirmNewPassword;
    private javax.swing.JPasswordField text_newPassword;
    private javax.swing.JTextField text_newUsername;
    private javax.swing.JPasswordField text_password;
    private javax.swing.JTextField text_username;
    // End of variables declaration//GEN-END:variables
}
