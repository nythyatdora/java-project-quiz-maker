
package project.quiz.maker;

import java.util.LinkedList;

public class FormUpdateQuestion extends javax.swing.JFrame {  
    
    private final String MESSAGE_UPDATE_NOTHING = "The selected question has been denied!";
    
    private final String DEFAULT_QUESTIONS[] = {
        (""),
        ("Which of these is the correct answer?"),
        ("Which of the following statements is true?"),
        ("Which of the following statements are false?")
    };

    private Question selectedQuestion;
    private FormViewCollection formViewCollection;
    
    public FormUpdateQuestion () {
        initComponents ();
        
        setComboQuestion ();
    }
    
    public FormUpdateQuestion(FormViewCollection formViewCollection) {
        this();
        
        this.formViewCollection = formViewCollection;
        selectedQuestion = formViewCollection.getSelectedQuestion ();
        setQuestionOnFields();
    }
    
    private void setComboQuestion() {
        for ( String str : DEFAULT_QUESTIONS ) {
            comboBox_defaultQuestion.addItem (str);    
        }
    }
    
    private void setQuestionOnFields() {
        textarea_customQuestion.setText (selectedQuestion.getQuestionDetail ());
        panel_answers.removeAllAnswers ();
        LinkedList<Answer> answers = selectedQuestion.getAnswerList ();
        for ( int i = answers.size () -1  ; i >= 0  ; i-- ) {
            Answer value = answers.get (i);

            panel_answers.addAnswer (value.getAnswerDetail (), value.getIsChosen ());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_background = new javax.swing.JPanel();
        panel_header = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        label_title = new javax.swing.JLabel();
        panel_paddingLeft = new javax.swing.JPanel();
        panel_paddingRight = new javax.swing.JPanel();
        panel_paddingTop = new javax.swing.JPanel();
        panel_question = new javax.swing.JPanel();
        label_defaultQuestion = new javax.swing.JLabel();
        comboBox_defaultQuestion = new javax.swing.JComboBox<>();
        label_custom = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea_customQuestion = new javax.swing.JTextArea();
        button_clear = new javax.swing.JButton();
        panel_answer = new javax.swing.JPanel();
        label_inputAnswers = new javax.swing.JLabel();
        button_add = new javax.swing.JButton();
        button_remove = new javax.swing.JButton();
        panel_answers = new project.quiz.maker.PanelAnswer();
        panel_buttons = new javax.swing.JPanel();
        button_update = new javax.swing.JButton();
        button_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UPDATE QUESTION");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_background.setBackground(new java.awt.Color(255, 255, 255));
        panel_background.setPreferredSize(new java.awt.Dimension(1080, 720));

        panel_header.setBackground(new java.awt.Color(20, 10, 37));

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
        label_title.setText("UPDATE QUESTION");

        javax.swing.GroupLayout panel_headerLayout = new javax.swing.GroupLayout(panel_header);
        panel_header.setLayout(panel_headerLayout);
        panel_headerLayout.setHorizontalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_headerLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_headerLayout.setVerticalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panel_paddingLeft.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_paddingLeftLayout = new javax.swing.GroupLayout(panel_paddingLeft);
        panel_paddingLeft.setLayout(panel_paddingLeftLayout);
        panel_paddingLeftLayout.setHorizontalGroup(
            panel_paddingLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panel_paddingLeftLayout.setVerticalGroup(
            panel_paddingLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );

        panel_paddingRight.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_paddingRightLayout = new javax.swing.GroupLayout(panel_paddingRight);
        panel_paddingRight.setLayout(panel_paddingRightLayout);
        panel_paddingRightLayout.setHorizontalGroup(
            panel_paddingRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panel_paddingRightLayout.setVerticalGroup(
            panel_paddingRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_paddingTop.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_paddingTopLayout = new javax.swing.GroupLayout(panel_paddingTop);
        panel_paddingTop.setLayout(panel_paddingTopLayout);
        panel_paddingTopLayout.setHorizontalGroup(
            panel_paddingTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_paddingTopLayout.setVerticalGroup(
            panel_paddingTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panel_question.setBackground(new java.awt.Color(255, 255, 255));
        panel_question.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUESTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 18))); // NOI18N

        label_defaultQuestion.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_defaultQuestion.setText("choose default question");
        label_defaultQuestion.setToolTipText("");

        comboBox_defaultQuestion.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        comboBox_defaultQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_defaultQuestionActionPerformed(evt);
            }
        });

        label_custom.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_custom.setText("or create custom question");
        label_custom.setToolTipText("");

        textarea_customQuestion.setColumns(20);
        textarea_customQuestion.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        textarea_customQuestion.setRows(5);
        jScrollPane1.setViewportView(textarea_customQuestion);

        button_clear.setUI(new jbuttoncss.CSSButton());
        button_clear.setBackground(new java.awt.Color(219, 43, 48));
        button_clear.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_clear.setForeground(new java.awt.Color(255, 255, 255));
        button_clear.setText("CLEAR");
        button_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_questionLayout = new javax.swing.GroupLayout(panel_question);
        panel_question.setLayout(panel_questionLayout);
        panel_questionLayout.setHorizontalGroup(
            panel_questionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_questionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_questionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addComponent(label_defaultQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBox_defaultQuestion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_custom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_questionLayout.setVerticalGroup(
            panel_questionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_questionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_defaultQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox_defaultQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_custom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_answer.setBackground(new java.awt.Color(255, 255, 255));
        panel_answer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ANSWERS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 18))); // NOI18N

        label_inputAnswers.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_inputAnswers.setText("input the answers");
        label_inputAnswers.setToolTipText("");

        button_add.setUI(new jbuttoncss.CSSButton());
        button_add.setBackground(new java.awt.Color(219, 43, 48));
        button_add.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_add.setForeground(new java.awt.Color(255, 255, 255));
        button_add.setText("ADD");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_remove.setUI(new jbuttoncss.CSSButton());
        button_remove.setBackground(new java.awt.Color(219, 43, 48));
        button_remove.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_remove.setForeground(new java.awt.Color(255, 255, 255));
        button_remove.setText("REMOVE");
        button_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_answerLayout = new javax.swing.GroupLayout(panel_answer);
        panel_answer.setLayout(panel_answerLayout);
        panel_answerLayout.setHorizontalGroup(
            panel_answerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_answerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_answerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_inputAnswers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_remove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_answers, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(button_add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_answerLayout.setVerticalGroup(
            panel_answerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_answerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_inputAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_answers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_buttons.setBackground(new java.awt.Color(255, 255, 255));

        button_update.setUI(new jbuttoncss.CSSButton());
        button_update.setBackground(new java.awt.Color(219, 43, 48));
        button_update.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_update.setForeground(new java.awt.Color(255, 255, 255));
        button_update.setText("UPDATE");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        button_reset.setUI(new jbuttoncss.CSSButton());
        button_reset.setBackground(new java.awt.Color(219, 43, 48));
        button_reset.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_reset.setForeground(new java.awt.Color(255, 255, 255));
        button_reset.setText("RESET");
        button_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_buttonsLayout = new javax.swing.GroupLayout(panel_buttons);
        panel_buttons.setLayout(panel_buttonsLayout);
        panel_buttonsLayout.setHorizontalGroup(
            panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buttonsLayout.createSequentialGroup()
                .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_buttonsLayout.setVerticalGroup(
            panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buttonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout panel_backgroundLayout = new javax.swing.GroupLayout(panel_background);
        panel_background.setLayout(panel_backgroundLayout);
        panel_backgroundLayout.setHorizontalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_paddingLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_paddingTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_backgroundLayout.createSequentialGroup()
                        .addComponent(panel_question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_answer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_paddingRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_paddingLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_paddingRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_backgroundLayout.createSequentialGroup()
                        .addComponent(panel_paddingTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_answer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        panel_answers.addAnswer ();
    }//GEN-LAST:event_button_addActionPerformed

    private void button_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_removeActionPerformed
        panel_answers.removeAnswer ();
    }//GEN-LAST:event_button_removeActionPerformed

    private void button_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_clearActionPerformed
        textarea_customQuestion.setText ("");
    }//GEN-LAST:event_button_clearActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        String question;       
        LinkedList<Answer> answers;
        
        boolean fromTextArea = textarea_customQuestion.isEnabled ();
        if(!fromTextArea)
            question = comboBox_defaultQuestion.getSelectedItem ().toString ();
        else 
            question = textarea_customQuestion.getText ();
        
        answers = panel_answers.getAllAnswers ();
        
        boolean allAllowed = !VerifyVariable.isEmptyOrDefault (question) && panel_answers.hasAllFilled () && panel_answers.hasChosenAnswer ();
        boolean hasMultipleAnswer = panel_answers.hasMultipleChosenAnswers ();
        if(allAllowed) {      
            Question newValue = new Question (selectedQuestion.getQuestionNO (), question, answers, hasMultipleAnswer);
            
            boolean isValueDiffrent = !selectedQuestion.equals (newValue);
            if(!isValueDiffrent) {
                MessageBox.showMessage (null, MESSAGE_UPDATE_NOTHING);
                
                formViewCollection.deSelectedQuestion ();
                formViewCollection.setFormUpdateCollectionClosed ();
            }
            else {
                formViewCollection.updateQuestion (newValue);
            }
            this.dispose ();
        }   
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_resetActionPerformed
        setQuestionOnFields ();
    }//GEN-LAST:event_button_resetActionPerformed

    private void comboBox_defaultQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_defaultQuestionActionPerformed
        String selectedItem = (String) comboBox_defaultQuestion.getSelectedItem();     
        
        if(!VerifyVariable.isEmptyOrDefault (selectedItem)) {
            textarea_customQuestion.setEnabled (false);
        }
        else {
            textarea_customQuestion.setEnabled (true);
        }
    }//GEN-LAST:event_comboBox_defaultQuestionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(formViewCollection != null) {
            formViewCollection.setFormUpdateCollectionClosed ();
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
            java.util.logging.Logger.getLogger (FormUpdateQuestion.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger (FormUpdateQuestion.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger (FormUpdateQuestion.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger (FormUpdateQuestion.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater (new Runnable () {
            public void run () {
                new FormUpdateQuestion ().setVisible (true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_clear;
    private javax.swing.JButton button_remove;
    private javax.swing.JButton button_reset;
    private javax.swing.JButton button_update;
    private javax.swing.JComboBox<String> comboBox_defaultQuestion;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_custom;
    private javax.swing.JLabel label_defaultQuestion;
    private javax.swing.JLabel label_inputAnswers;
    private javax.swing.JLabel label_title;
    private javax.swing.JPanel panel_answer;
    private project.quiz.maker.PanelAnswer panel_answers;
    private javax.swing.JPanel panel_background;
    private javax.swing.JPanel panel_buttons;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_paddingLeft;
    private javax.swing.JPanel panel_paddingRight;
    private javax.swing.JPanel panel_paddingTop;
    private javax.swing.JPanel panel_question;
    private javax.swing.JTextArea textarea_customQuestion;
    // End of variables declaration//GEN-END:variables
}