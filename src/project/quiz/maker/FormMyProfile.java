
package project.quiz.maker;

import java.util.Map;
import javax.swing.JTextField;

public class FormMyProfile extends javax.swing.JFrame {
    
    private final UserData userData = UserData.createInstance ();
     
    private final String MESSAGE_UPDATE_PASSWORD = "Your account has been updated successfully!";
    private final String MESSAGE_NEW_PASSWORD_NOT_MATCH = "New password doesn't matched. Recheck your password again.";
    private final String MESSAGE_OLD_PASSWORD_NOT_MATCH = "Password doesn't matched. Recheck your password again.";
    
    private FormMain formMain;
    
    private Map<Integer, User> map;
    private User loggedUser;
    
    public FormMyProfile () {
        initComponents ();
    }
    
    public FormMyProfile(FormMain formMain) {
        initComponents ();
        
        this.formMain = formMain;
        this.loggedUser = formMain.getLoggUser ();
        
        setMapData();
        setRecordFields ();
        setUsernameField();
    }
    
    private void setRecordFields() {
        UserRecord userRecord = loggedUser.getRecordDetail ();
        
        label_totalQuestion.setText ("total question : " + userRecord.getTotalQuestion ());
        label_totalCorrect.setText ("total correct : " + userRecord.getTotalCorrect ());
        label_totalIncorrect.setText ("total incorrect : " + userRecord.getTotalIncorrect ());
        label_averageSpeed.setText ("average speed : " + userRecord.getAverageSpeed ());
        label_recentRecord.setText ("recent record : " + userRecord.getRecentRecord ());
    }

    private void setUsernameField() {
        text_username.setText (loggedUser.getUsername ());
    }
    
    private void setMapData() {
        userData.hasFileExisted ();
        map = userData.fetchMapData ();
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_background = new javax.swing.JPanel();
        panel_title = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        label_title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        panel_personalRecord = new javax.swing.JPanel();
        label_totalQuestion = new javax.swing.JLabel();
        label_totalCorrect = new javax.swing.JLabel();
        label_totalIncorrect = new javax.swing.JLabel();
        label_averageSpeed = new javax.swing.JLabel();
        label_recentRecord = new javax.swing.JLabel();
        button_reset = new javax.swing.JButton();
        panel_accountSetting = new javax.swing.JPanel();
        label_username = new javax.swing.JLabel();
        text_username = new javax.swing.JTextField();
        label_password = new javax.swing.JLabel();
        label_confirmPassword = new javax.swing.JLabel();
        label_oldPassword = new javax.swing.JLabel();
        button_confirm = new javax.swing.JButton();
        text_oldPassword = new javax.swing.JPasswordField();
        text_newPassword = new javax.swing.JPasswordField();
        text_confirmNewPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MY PROFILE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_background.setBackground(new java.awt.Color(255, 255, 255));

        panel_title.setBackground(new java.awt.Color(20, 10, 37));

        jPanel2.setBackground(new java.awt.Color(20, 10, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(75, 100));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(20, 10, 37));
        jPanel3.setPreferredSize(new java.awt.Dimension(75, 100));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        label_title.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        label_title.setForeground(new java.awt.Color(255, 255, 255));
        label_title.setText("MY PROFILE");

        javax.swing.GroupLayout panel_titleLayout = new javax.swing.GroupLayout(panel_title);
        panel_title.setLayout(panel_titleLayout);
        panel_titleLayout.setHorizontalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_titleLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_titleLayout.setVerticalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_titleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(75, 100));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(868, 66));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 25));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panel_personalRecord.setBackground(new java.awt.Color(255, 255, 255));
        panel_personalRecord.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PERSONAL RECORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 18))); // NOI18N

        label_totalQuestion.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_totalQuestion.setText("total question :");

        label_totalCorrect.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_totalCorrect.setText("total correct :");

        label_totalIncorrect.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_totalIncorrect.setText("total incorrect :");

        label_averageSpeed.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_averageSpeed.setText("average speed :");

        label_recentRecord.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_recentRecord.setText("recent record :");

        button_reset.setUI(new CSSButton());
        button_reset.setBackground(new java.awt.Color(219, 43, 48));
        button_reset.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        button_reset.setForeground(new java.awt.Color(255, 255, 255));
        button_reset.setText("RESET");
        button_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_personalRecordLayout = new javax.swing.GroupLayout(panel_personalRecord);
        panel_personalRecord.setLayout(panel_personalRecordLayout);
        panel_personalRecordLayout.setHorizontalGroup(
            panel_personalRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_personalRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_personalRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_totalQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_totalCorrect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(label_totalIncorrect, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(label_averageSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(label_recentRecord, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(button_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_personalRecordLayout.setVerticalGroup(
            panel_personalRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_personalRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_totalQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_totalCorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_totalIncorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_averageSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_recentRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_accountSetting.setBackground(new java.awt.Color(255, 255, 255));
        panel_accountSetting.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACCOUNT SETTING", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 18))); // NOI18N

        label_username.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_username.setText("username");

        text_username.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        text_username.setEnabled(false);

        label_password.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_password.setText("new password");

        label_confirmPassword.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_confirmPassword.setText("confirm new password");

        label_oldPassword.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_oldPassword.setText("old password");

        button_confirm.setUI(new CSSButton());
        button_confirm.setBackground(new java.awt.Color(219, 43, 48));
        button_confirm.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        button_confirm.setForeground(new java.awt.Color(255, 255, 255));
        button_confirm.setText("CONFIRM");
        button_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_confirmActionPerformed(evt);
            }
        });

        text_oldPassword.setEchoChar('\u26ab');

        text_newPassword.setEchoChar('\u26ab');

        text_confirmNewPassword.setEchoChar('\u26ab');

        javax.swing.GroupLayout panel_accountSettingLayout = new javax.swing.GroupLayout(panel_accountSetting);
        panel_accountSetting.setLayout(panel_accountSettingLayout);
        panel_accountSettingLayout.setHorizontalGroup(
            panel_accountSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_accountSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_accountSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_username, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(label_oldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_accountSettingLayout.createSequentialGroup()
                        .addGroup(panel_accountSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_confirmNewPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_newPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_oldPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_confirm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_confirmPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panel_accountSettingLayout.setVerticalGroup(
            panel_accountSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_accountSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_confirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(button_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_backgroundLayout = new javax.swing.GroupLayout(panel_background);
        panel_background.setLayout(panel_backgroundLayout);
        panel_backgroundLayout.setHorizontalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                    .addGroup(panel_backgroundLayout.createSequentialGroup()
                        .addComponent(panel_personalRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_accountSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_backgroundLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_personalRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_accountSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void button_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_resetActionPerformed
        User user = loggedUser;
        user.setRecordDetail (new UserRecord ());
        
        boolean hasExisted = userData.hasFieldExisted (map, user.getUsername ());
        if(hasExisted) {
            map.put (user.getUserID (), user);
            userData.commitMapData (map, MESSAGE_UPDATE_PASSWORD);
            
            loggedUser = user;
            setRecordFields ();
        }   
    }//GEN-LAST:event_button_resetActionPerformed
    
    private void button_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_confirmActionPerformed
        String username = text_username.getText();
        String oldPassword = String.valueOf (text_oldPassword.getPassword ());
        String newPassword = String.valueOf (text_newPassword.getPassword());
        String confirmNewPassword = String.valueOf (text_confirmNewPassword.getPassword());
        
        boolean allFilled =  VerifyControl.hasAllInputFieldsFilled (panel_accountSetting);
        
        if(!allFilled) {
            // request focus on the missing field
            JTextField missingField = (JTextField) VerifyControl.getEmptyInputField (panel_accountSetting);
            missingField.requestFocus ();
        }
        else {
            if(!newPassword.equals (confirmNewPassword)) {
                MessageBox.showMessage (null, MESSAGE_NEW_PASSWORD_NOT_MATCH);
            }
            else {
                if(!oldPassword.equals (loggedUser.getPassword ())) {
                    MessageBox.showMessage (null, MESSAGE_OLD_PASSWORD_NOT_MATCH); 
                }
                else {
                    User user = loggedUser;
                    user.setPassword (newPassword);
                    
                    userData.hasFileExisted ();
                    map = userData.fetchMapData ();
                    
                    boolean hasExisted = userData.hasFieldExisted (map, username);
                    if(hasExisted) {
                        map.put (user.getUserID (), user);
                        userData.commitMapData (map, MESSAGE_UPDATE_PASSWORD);
                    }
                }
            }
        }
    }//GEN-LAST:event_button_confirmActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if( VerifyVariable.hasFormOpened (formMain) ) {
            formMain.setLoggedUser (loggedUser);
            formMain.setFormMyProfileClosed ();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger (FormMyProfile.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger (FormMyProfile.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger (FormMyProfile.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger (FormMyProfile.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater (new Runnable () {
            public void run () {
                new FormMyProfile ().setVisible (true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_confirm;
    private javax.swing.JButton button_reset;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel label_averageSpeed;
    private javax.swing.JLabel label_confirmPassword;
    private javax.swing.JLabel label_oldPassword;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_recentRecord;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_totalCorrect;
    private javax.swing.JLabel label_totalIncorrect;
    private javax.swing.JLabel label_totalQuestion;
    private javax.swing.JLabel label_username;
    private javax.swing.JPanel panel_accountSetting;
    private javax.swing.JPanel panel_background;
    private javax.swing.JPanel panel_personalRecord;
    private javax.swing.JPanel panel_title;
    private javax.swing.JPasswordField text_confirmNewPassword;
    private javax.swing.JPasswordField text_newPassword;
    private javax.swing.JPasswordField text_oldPassword;
    private javax.swing.JTextField text_username;
    // End of variables declaration//GEN-END:variables
}
