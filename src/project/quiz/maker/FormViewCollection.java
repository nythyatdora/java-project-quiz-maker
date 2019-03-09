
package project.quiz.maker;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class FormViewCollection extends javax.swing.JFrame {
    
    private final CollectionData collectionData = CollectionData.createInstance ();
    
    private final String MESSAGE_CHOOSE_QUESTION = "Please choose a question to continue!";
    private final String MESSAGE_UPDATE_QUESTION = "The selected question has been updated.";
    private final String MESSAGE_REMOVE_QUESTION = "The selected question has been removed!";
    
    private FormMain formMain = null;
    private FormUpdateQuestion formUpdateQuestion = null;
    private DialogBrowseCollection dialogBrowseCollection = null;
   
    private Map<Integer, Collection> map;
    private Collection selectedCollection = null;
    private Question selectedQuestion = null;
    
    private final JComboBox comboBoxCollectionID;
    
    public FormViewCollection () {
        this.comboBoxCollectionID = new JComboBox ();
        initComponents ();
        
        setMapData ();
        setComboCollection ();
        setTableQuestion ();
    }
    
    public FormViewCollection(FormMain formMain) {
        this ();
        this.formMain = formMain;
    }
    
    public Collection getSelectedCollection() {
        return selectedCollection;
    }
    
    public Question getSelectedQuestion() {
        return selectedQuestion;
    }
    
    public void setSelectedCollection(Collection collection) {
        this.selectedCollection = collection;
        
        setComboCollection ();
        comboBox_collection.setSelectedItem (collection.getCollectionName ());
    }
    
    public void setDialogBrowseCollectionClosed() {
        this.dialogBrowseCollection = null;
    }
    
    public void setFormUpdateCollectionClosed() {
        this.formUpdateQuestion = null;
    }
    
    public void setMapData() {
        collectionData.hasFileExisted ();
        map = (LinkedHashMap<Integer, Collection>) collectionData.fetchMapData ();  
    }
    
    public void setComboCollection() {
        comboBoxCollectionID.removeAllItems ();
        comboBox_collection.removeAllItems ();
        
        map.entrySet ().forEach ((entry) -> {
            Integer key = entry.getKey ();
            Collection value = entry.getValue ();
            
            comboBoxCollectionID.addItem (key);
            comboBox_collection.addItem (value.getCollectionName ());
        });
    }
    
    private void setTableQuestion() {
        DefaultTableModel model = (DefaultTableModel) tabel_question.getModel ();
        model.setRowCount (0);
        
        LinkedList<Question> questions = selectedCollection.getQuestionList();
        questions.forEach ((next) -> {
            model.addRow (new Object[] {
                next.getQuestionNO (),
                next.getQuestionDetail (),
                next.getAnswerList ().size (),
                VerifyVariable.isYesOrNo(next.getHasMultipleAnswer ())
            });
        });
    }
    
    public void updateQuestion(Question newValue) {
        boolean hasUpdated = false;
        LinkedList<Question> questions = selectedCollection.getQuestionList ();
        for ( Question next : questions ) {
            if(VerifyVariable.isValueEqual (next.getQuestionNO (), selectedQuestion.getQuestionNO ())) {
                next.setQuestionDetail (newValue.getQuestionDetail ());
                next.setAnswerList (newValue.getAnswerList ());
                next.setHasMultipleAnswer (newValue.getHasMultipleAnswer ());
                
                hasUpdated = true;
                break;
            }
        }   
        
        if(hasUpdated) {
            selectedCollection.setQuestionList (questions);
            collectionData.commitMapData (map, MESSAGE_UPDATE_QUESTION);
            
            resetRelatedData ();
        }   
    } 
    
    private void removeQuestion() {
        boolean hasRemoved = false;
            
        LinkedList<Question> questions = selectedCollection.getQuestionList ();
        for ( Question next : questions ) {
            if(VerifyVariable.isValueEqual (next.getQuestionNO (), selectedQuestion.getQuestionNO ())) {
                questions.remove (next);
                hasRemoved = true;
                break;
            }
        }   

        if(hasRemoved) {
            selectedCollection.setQuestionList (questions);
            collectionData.commitMapData (map, MESSAGE_REMOVE_QUESTION);

            resetRelatedData();
        }
    }
    
    private void resetRelatedData() {
        setMapData ();
        setTableQuestion ();
        deSelectedQuestion ();
    }
    
    public void deSelectedQuestion() {
        tabel_question.clearSelection ();
        selectedQuestion = null;
    }
    
    private void setSelectedCollection() {
        int selectedIndex = comboBox_collection.getSelectedIndex ();
        comboBoxCollectionID.setSelectedIndex (selectedIndex);
        int selectedID = (int) comboBoxCollectionID.getSelectedItem ();

        if(!VerifyVariable.isNull (selectedID)) {
            boolean isContained = map.containsKey (selectedID);

            if(isContained) {
                selectedCollection = map.get (selectedID);
                setTableQuestion ();
            }
        }
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
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panel_collection = new javax.swing.JPanel();
        label_collection = new javax.swing.JLabel();
        comboBox_collection = new javax.swing.JComboBox<>();
        button_browse = new javax.swing.JButton();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_question = new javax.swing.JTable();
        panel_buttons = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        button_refresh = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        button_remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VIEW COLLECTIONS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_background.setBackground(new java.awt.Color(255, 255, 255));
        panel_background.setPreferredSize(new java.awt.Dimension(1080, 720));

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
        label_title.setText("VIEW COLLECTIONS");
        label_title.setToolTipText("");

        javax.swing.GroupLayout panel_titleLayout = new javax.swing.GroupLayout(panel_title);
        panel_title.setLayout(panel_titleLayout);
        panel_titleLayout.setHorizontalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_titleLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_titleLayout.setVerticalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_titleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(label_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(75, 0));

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
        jPanel5.setPreferredSize(new java.awt.Dimension(75, 0));

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

        panel_collection.setBackground(new java.awt.Color(255, 255, 255));

        label_collection.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_collection.setText("choose collection");
        label_collection.setToolTipText("");

        comboBox_collection.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        comboBox_collection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBox_collectionItemStateChanged(evt);
            }
        });

        button_browse.setUI(new CSSButton());
        button_browse.setBackground(new java.awt.Color(219, 43, 48));
        button_browse.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_browse.setForeground(new java.awt.Color(255, 255, 255));
        button_browse.setText("BROWSE");
        button_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_browseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_collectionLayout = new javax.swing.GroupLayout(panel_collection);
        panel_collection.setLayout(panel_collectionLayout);
        panel_collectionLayout.setHorizontalGroup(
            panel_collectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_collectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_collectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_collection, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(comboBox_collection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(button_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_collectionLayout.setVerticalGroup(
            panel_collectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_collectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_collection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_collectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBox_collection, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        panel_table.setBackground(new java.awt.Color(255, 255, 255));

        tabel_question.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tabel_question.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "QUESTION", "ANSWERS COUNT", "MULTIPLE ANSWER?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableHeader header = tabel_question.getTableHeader();
        header.setPreferredSize(new Dimension(100, 25));

        Font myFont = new Font("Bahnschrift", Font.PLAIN, 14);
        tabel_question.getTableHeader().setFont(myFont);

        tabel_question.getColumnModel().getColumn(0).setPreferredWidth(15);
        tabel_question.getColumnModel().getColumn(1).setPreferredWidth(400);
        tabel_question.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabel_question.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabel_question.setRowHeight(25);
        tabel_question.getTableHeader().setResizingAllowed(false);
        tabel_question.getTableHeader().setReorderingAllowed(false);
        tabel_question.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_questionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_question);

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );

        panel_buttons.setBackground(new java.awt.Color(255, 255, 255));
        panel_buttons.setPreferredSize(new java.awt.Dimension(918, 40));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.GridLayout(1, 3, 25, 0));

        button_refresh.setUI(new CSSButton());
        button_refresh.setBackground(new java.awt.Color(219, 43, 48));
        button_refresh.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_refresh.setForeground(new java.awt.Color(255, 255, 255));
        button_refresh.setText("REFRESH");
        button_refresh.setPreferredSize(new java.awt.Dimension(229, 23));
        button_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_refreshActionPerformed(evt);
            }
        });
        jPanel13.add(button_refresh);

        button_update.setUI(new CSSButton());
        button_update.setBackground(new java.awt.Color(219, 43, 48));
        button_update.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_update.setForeground(new java.awt.Color(255, 255, 255));
        button_update.setText("UPDATE");
        button_update.setPreferredSize(new java.awt.Dimension(229, 23));
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });
        jPanel13.add(button_update);

        button_remove.setUI(new CSSButton());
        button_remove.setBackground(new java.awt.Color(219, 43, 48));
        button_remove.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_remove.setForeground(new java.awt.Color(255, 255, 255));
        button_remove.setText("REMOVE");
        button_remove.setPreferredSize(new java.awt.Dimension(229, 23));
        button_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_removeActionPerformed(evt);
            }
        });
        jPanel13.add(button_remove);

        javax.swing.GroupLayout panel_buttonsLayout = new javax.swing.GroupLayout(panel_buttons);
        panel_buttons.setLayout(panel_buttonsLayout);
        panel_buttonsLayout.setHorizontalGroup(
            panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_buttonsLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_buttonsLayout.setVerticalGroup(
            panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
                    .addComponent(panel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_backgroundLayout.createSequentialGroup()
                        .addComponent(panel_collection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(panel_backgroundLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_collection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
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

    private void button_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_browseActionPerformed
        if(!VerifyVariable.hasDialogOpened(dialogBrowseCollection)) {
            dialogBrowseCollection = new DialogBrowseCollection (null, false, this);
            dialogBrowseCollection.setVisible (true);
        }
    }//GEN-LAST:event_button_browseActionPerformed

    private void button_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_refreshActionPerformed
        setTableQuestion ();
    }//GEN-LAST:event_button_refreshActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        if(VerifyVariable.isNull (selectedQuestion)) {
            MessageBox.showMessage (null, MESSAGE_CHOOSE_QUESTION);
            return;
        }
            
        if(!VerifyVariable.hasDialogOpened (formUpdateQuestion)) {
            formUpdateQuestion = new FormUpdateQuestion (this);
            formUpdateQuestion.setVisible (true);
        }
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_removeActionPerformed
        if(VerifyVariable.isNull (selectedQuestion)) {
            MessageBox.showMessage (null, MESSAGE_CHOOSE_QUESTION);
            return;
        }
        
        removeQuestion();
    }//GEN-LAST:event_button_removeActionPerformed
    
    private void comboBox_collectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_collectionItemStateChanged
        if(evt.getStateChange () == ItemEvent.SELECTED) {   
            deSelectedQuestion ();
            setSelectedCollection();
        }
    }//GEN-LAST:event_comboBox_collectionItemStateChanged
       
    private void tabel_questionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_questionMouseClicked
        boolean isDoubleClicked = ( evt.getClickCount () == 2 );
        if ( isDoubleClicked ) {
            JTable source = (JTable) evt.getSource ();
            int row = source.rowAtPoint (evt.getPoint ());
            int selectedQuestionNO = (int) source.getModel ().getValueAt (row, 0);
            
            selectedQuestion = selectedCollection.getQuestionList ().get (selectedQuestionNO - 1);
        }
    }//GEN-LAST:event_tabel_questionMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if( VerifyVariable.hasFormOpened (formMain) ) {
            formMain.setFormViewCollectionClosed();
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
            java.util.logging.Logger.getLogger (FormViewCollection.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger (FormViewCollection.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger (FormViewCollection.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger (FormViewCollection.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater (new Runnable () {
            public void run () {
                new FormViewCollection ().setVisible (true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_browse;
    private javax.swing.JButton button_refresh;
    private javax.swing.JButton button_remove;
    private javax.swing.JButton button_update;
    private javax.swing.JComboBox<String> comboBox_collection;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_collection;
    private javax.swing.JLabel label_title;
    private javax.swing.JPanel panel_background;
    private javax.swing.JPanel panel_buttons;
    private javax.swing.JPanel panel_collection;
    private javax.swing.JPanel panel_table;
    private javax.swing.JPanel panel_title;
    private javax.swing.JTable tabel_question;
    // End of variables declaration//GEN-END:variables
}
