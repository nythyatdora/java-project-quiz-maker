package project.quiz.maker;

public class AnswerControl extends javax.swing.JPanel {

    public AnswerControl () {
        initComponents ();
    }

    public AnswerControl ( String answerDetail ) {
        this ();
        textarea_answer.setText (answerDetail);
    }

    public AnswerControl ( String answerDetail, boolean isChosen ) {
        this (answerDetail);
        radio_correct.setSelected (isChosen);
    }

    public void setAnswerEditable ( boolean value ) {
        textarea_answer.setEditable (value);
        textarea_answer.setFocusable (value);
    }

    public boolean isChosenAnswer () {
        return radio_correct.isSelected ();
    }

    public String getAnswerDescription () {
        return textarea_answer.getText ();
    }

    public Answer getAnswer () {
        return new Answer (getAnswerDescription (), isChosenAnswer ());
    }

    public Answer getAnswer ( int answerNO ) {
        return new Answer (answerNO, getAnswerDescription (), isChosenAnswer ());
    }

    public void setAnswer ( String answerDetail, boolean isChosen ) {
        textarea_answer.setText (answerDetail);
        radio_correct.setSelected (isChosen);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_background = new javax.swing.JPanel();
        panel_radiobutton = new javax.swing.JPanel();
        radio_correct = new javax.swing.JRadioButton();
        panel_textarea = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea_answer = new javax.swing.JTextArea();

        panel_background.setBackground(new java.awt.Color(255, 255, 255));

        panel_radiobutton.setBackground(new java.awt.Color(255, 255, 255));

        radio_correct.setBackground(new java.awt.Color(255, 255, 255));
        radio_correct.setFocusPainted(false);
        radio_correct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panel_radiobuttonLayout = new javax.swing.GroupLayout(panel_radiobutton);
        panel_radiobutton.setLayout(panel_radiobuttonLayout);
        panel_radiobuttonLayout.setHorizontalGroup(
            panel_radiobuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_radiobuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radio_correct, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_radiobuttonLayout.setVerticalGroup(
            panel_radiobuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(radio_correct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_textarea.setBackground(new java.awt.Color(255, 255, 255));

        textarea_answer.setColumns(20);
        textarea_answer.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        textarea_answer.setRows(1);
        jScrollPane1.setViewportView(textarea_answer);

        javax.swing.GroupLayout panel_textareaLayout = new javax.swing.GroupLayout(panel_textarea);
        panel_textarea.setLayout(panel_textareaLayout);
        panel_textareaLayout.setHorizontalGroup(
            panel_textareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_textareaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_textareaLayout.setVerticalGroup(
            panel_textareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_textareaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_backgroundLayout = new javax.swing.GroupLayout(panel_background);
        panel_background.setLayout(panel_backgroundLayout);
        panel_backgroundLayout.setHorizontalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_radiobutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_textarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_textarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_radiobutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_background;
    private javax.swing.JPanel panel_radiobutton;
    private javax.swing.JPanel panel_textarea;
    private javax.swing.JRadioButton radio_correct;
    private javax.swing.JTextArea textarea_answer;
    // End of variables declaration//GEN-END:variables
}
