package project.quiz.maker;

import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.util.LinkedHashMap;
import javax.swing.JFrame;

public class DialogBrowseCollection extends javax.swing.JDialog {
    
    private final CollectionData collectionData = CollectionData.createInstance ();
    
    private final String MESSAGE_CHOOSE_COLLECTION = "Please select a collection to continue!";

    private JFrame caller = null;
    private DialogAddCollection dialogAddCollection = null;
    private DialogUpdateCollection dialogUpdateCollection = null;
    
    private Map<Integer, Collection> map;
    private int selectedCollectionID = -1;
    private String selectedCollectionName;
    private String addingCollectionName;
    private String prendingCollectionName;
    private boolean hasCollectionChanged;

    public DialogBrowseCollection ( java.awt.Frame parent, boolean modal ) {
        super (parent, modal);
        initComponents ();
        
        setTableCollection ();
    }

    public DialogBrowseCollection ( java.awt.Frame parent, boolean modal, JFrame caller ) {
        super (parent, modal);
        initComponents ();
        
        setMapData ();
        setTableCollection ();

        this.caller = caller;
    }

    public void setDialogAddCollectionClosed () {
        this.dialogAddCollection = null;
    }

    public void setDialogUpdateCollectionClosed () {
        this.dialogUpdateCollection = null;
    }
    
    public void setAddingCollectionName ( String message ) {
        this.addingCollectionName = message;
    }

    public void setPrendingCollectionName ( String message ) {
        this.prendingCollectionName = message;
    }

    public int getSelectedCollectionID () {
        return selectedCollectionID;
    }
    
    public String getSelectedCollectionName() {
        return selectedCollectionName;
    }

    private void setLabelTotalCollection () {
        label_totalCollection.setText ("total collections : " + table_collections.getRowCount ());
    }
    
    private boolean hasCollectionSelected () {
        return !(selectedCollectionName.equals ("") || selectedCollectionName.isEmpty ());
    }

    private void setMapData() {
        collectionData.hasFileExisted ();

        map = (LinkedHashMap<Integer, Collection>) collectionData.fetchMapData ();
    }
    
    private void setTableCollection () {
        // from collection to table
        DefaultTableModel model = (DefaultTableModel) table_collections.getModel ();
        model.getDataVector ().removeAllElements ();
        
        // set table with collection data
        map.entrySet ().stream ().map ((entry) -> entry.getValue ()).forEachOrdered ((value) -> {
            model.addRow (new Object[]{
                value.getCollectionID (),
                value.getCollectionName (),
                value.getTotalQuestion ()
            });
        });

        setLabelTotalCollection ();
    }    
    
    public void addCollection () {
        if ( !VerifyVariable.isEmptyOrDefault (addingCollectionName) ) {
            collectionData.insertData (addingCollectionName);
            hasCollectionChanged = true;
            
            setTableCollection ();
        }
    }

    public void updateCollection() { 
        boolean hasUpdated = false;
        boolean isPrendingCollectionNull = VerifyVariable.isEmptyOrDefault (prendingCollectionName);
        if ( isPrendingCollectionNull ) {
            return;
        }

        if ( !selectedCollectionName.equals (prendingCollectionName) ) {
            hasUpdated = collectionData.updateData (selectedCollectionID, selectedCollectionName, prendingCollectionName);
        }
        
        if(hasUpdated) {
            resetRelatedData();
            hasCollectionChanged = true; 
        }
    }

    private void removeCollection() {
        boolean hasRemoved = collectionData.removeData (selectedCollectionID, selectedCollectionName);
        
        if(hasRemoved) {
            resetRelatedData ();
            hasCollectionChanged = true; 
        }
    }
    
    private void resetRelatedData() {
        setMapData ();
        setTableCollection ();
        table_collections.clearSelection ();
        
        deSelectedData ();
    }
    
    private void deSelectedData () {
        selectedCollectionID = -1;
        selectedCollectionName = "";
        prendingCollectionName = "";
    }
    
    private void selectCollection() {
        boolean foundKey = map.containsKey (selectedCollectionID);
        if ( foundKey ) {
            if(caller instanceof FormCreateQuiz) {
                FormCreateQuiz formNewQuestionCollection = (FormCreateQuiz) caller;
                formNewQuestionCollection.setChosenCollection (map.get (selectedCollectionID));
                formNewQuestionCollection.setDialogBrowseCollectionClosed ();
            }
            else if (caller instanceof FormViewCollection) {
                FormViewCollection formViewCollection = (FormViewCollection) caller;
                formViewCollection.setSelectedCollection (map.get (selectedCollectionID));
                formViewCollection.setDialogBrowseCollectionClosed ();
            }
            this.dispose ();
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
        label_title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panel_paddingLeft = new javax.swing.JPanel();
        panel_buttons = new javax.swing.JPanel();
        button_add = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        button_select = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        label_collection = new javax.swing.JLabel();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_collections = new javax.swing.JTable();
        panel_paddingRight = new javax.swing.JPanel();
        label_totalCollection = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BROWSE COLLECTION");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_background.setBackground(new java.awt.Color(255, 255, 255));

        panel_header.setBackground(new java.awt.Color(20, 10, 37));

        label_title.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        label_title.setForeground(new java.awt.Color(255, 255, 255));
        label_title.setText("BROWSE COLLECTION");

        jPanel4.setBackground(new java.awt.Color(20, 10, 37));
        jPanel4.setPreferredSize(new java.awt.Dimension(75, 100));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_headerLayout = new javax.swing.GroupLayout(panel_header);
        panel_header.setLayout(panel_headerLayout);
        panel_headerLayout.setHorizontalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_headerLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_headerLayout.setVerticalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_paddingLeft.setBackground(new java.awt.Color(255, 255, 255));
        panel_paddingLeft.setPreferredSize(new java.awt.Dimension(75, 0));

        javax.swing.GroupLayout panel_paddingLeftLayout = new javax.swing.GroupLayout(panel_paddingLeft);
        panel_paddingLeft.setLayout(panel_paddingLeftLayout);
        panel_paddingLeftLayout.setHorizontalGroup(
            panel_paddingLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panel_paddingLeftLayout.setVerticalGroup(
            panel_paddingLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_buttons.setBackground(new java.awt.Color(255, 255, 255));

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

        button_delete.setUI(new jbuttoncss.CSSButton());
        button_delete.setBackground(new java.awt.Color(219, 43, 48));
        button_delete.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_delete.setForeground(new java.awt.Color(255, 255, 255));
        button_delete.setText("DELETE");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

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

        button_select.setUI(new jbuttoncss.CSSButton());
        button_select.setBackground(new java.awt.Color(219, 43, 48));
        button_select.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_select.setForeground(new java.awt.Color(255, 255, 255));
        button_select.setText("SELECT");
        button_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_selectActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(121, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_buttonsLayout = new javax.swing.GroupLayout(panel_buttons);
        panel_buttons.setLayout(panel_buttonsLayout);
        panel_buttonsLayout.setHorizontalGroup(
            panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_buttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buttonsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(button_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
                    .addGroup(panel_buttonsLayout.createSequentialGroup()
                        .addGroup(panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_select, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panel_buttonsLayout.setVerticalGroup(
            panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_buttonsLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(button_select, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        label_collection.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_collection.setText("choose collection");

        panel_table.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table_collections.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        table_collections.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "COLLECTION NAME", "TOTAL QUESTIONS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_collections.setDropMode(javax.swing.DropMode.INSERT);
        JTableHeader header = table_collections.getTableHeader();
        header.setPreferredSize(new Dimension(100, 25));

        Font myFont = new Font("Bahnschrift", Font.PLAIN, 14);
        table_collections.getTableHeader().setFont(myFont);

        table_collections.getColumnModel().getColumn(0).setPreferredWidth(50);
        table_collections.getColumnModel().getColumn(1).setPreferredWidth(250);
        table_collections.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_collections.setRowHeight(25);
        table_collections.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_collections.setShowVerticalLines(false);
        table_collections.getTableHeader().setResizingAllowed(false);
        table_collections.getTableHeader().setReorderingAllowed(false);
        table_collections.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_collectionsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_collections);

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        panel_paddingRight.setBackground(new java.awt.Color(255, 255, 255));
        panel_paddingRight.setPreferredSize(new java.awt.Dimension(75, 0));

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

        label_totalCollection.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        label_totalCollection.setText("total collections :");

        javax.swing.GroupLayout panel_backgroundLayout = new javax.swing.GroupLayout(panel_background);
        panel_background.setLayout(panel_backgroundLayout);
        panel_backgroundLayout.setHorizontalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_paddingLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_backgroundLayout.createSequentialGroup()
                        .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_backgroundLayout.createSequentialGroup()
                                .addComponent(label_collection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_backgroundLayout.createSequentialGroup()
                                .addComponent(panel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(16, 16, 16)))
                        .addComponent(panel_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_totalCollection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_paddingRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_backgroundLayout.createSequentialGroup()
                        .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_backgroundLayout.createSequentialGroup()
                                .addComponent(label_collection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(panel_buttons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_totalCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_paddingLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(panel_paddingRight, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)))
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
        if ( !VerifyVariable.hasDialogOpened (dialogAddCollection) ) {
            dialogAddCollection = new DialogAddCollection (null, true, this);
            dialogAddCollection.setVisible (true);
        }
    }//GEN-LAST:event_button_addActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        if ( !hasCollectionSelected () ) {
            MessageBox.showMessage (null, MESSAGE_CHOOSE_COLLECTION);
            return;
        }
        
        removeCollection ();
    }//GEN-LAST:event_button_deleteActionPerformed

    private void table_collectionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_collectionsMouseClicked
        boolean isDoubleClicked = ( evt.getClickCount () == 2 );
        if ( isDoubleClicked ) {
            JTable source = (JTable) evt.getSource ();
            int row = source.rowAtPoint (evt.getPoint ());
            selectedCollectionID = (int) source.getModel ().getValueAt (row, 0);
            selectedCollectionName = String.valueOf (source.getModel ().getValueAt (row, 1));
        }
    }//GEN-LAST:event_table_collectionsMouseClicked

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        if ( !hasCollectionSelected () ) {
            MessageBox.showMessage (null, MESSAGE_CHOOSE_COLLECTION);
            return;
        }

        if ( !VerifyVariable.hasDialogOpened (dialogUpdateCollection) ) {
            dialogUpdateCollection = new DialogUpdateCollection (null, true, this);
            dialogUpdateCollection.setVisible (true);
        }
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_selectActionPerformed
        if ( !hasCollectionSelected () ) {
            MessageBox.showMessage (null, MESSAGE_CHOOSE_COLLECTION);
            return;
        }

        selectCollection();
    }//GEN-LAST:event_button_selectActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(caller != null) {
            if(caller instanceof FormCreateQuiz) {
                FormCreateQuiz formNewQuestionCollection = (FormCreateQuiz) caller;
                
                if(hasCollectionChanged) {
                    formNewQuestionCollection.setMapData ();
                    formNewQuestionCollection.setComboCollection ();
                }
                    
                formNewQuestionCollection.setDialogBrowseCollectionClosed ();      
            }
            else if(caller instanceof FormViewCollection) {
                FormViewCollection formViewCollection = (FormViewCollection) caller;
                
                if(hasCollectionChanged) {
                    formViewCollection.setMapData ();
                    formViewCollection.setComboCollection ();
                }
                    
                formViewCollection.setDialogBrowseCollectionClosed ();
            } 
            evt.getWindow ().dispose ();
        }
        evt.getWindow ().dispose ();
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
            java.util.logging.Logger.getLogger (DialogBrowseCollection.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger (DialogBrowseCollection.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger (DialogBrowseCollection.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger (DialogBrowseCollection.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater (new Runnable () {
            public void run () {
                DialogBrowseCollection dialog = new DialogBrowseCollection (new javax.swing.JFrame (), true);
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
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_select;
    private javax.swing.JButton button_update;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_collection;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_totalCollection;
    private javax.swing.JPanel panel_background;
    private javax.swing.JPanel panel_buttons;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_paddingLeft;
    private javax.swing.JPanel panel_paddingRight;
    private javax.swing.JPanel panel_table;
    private javax.swing.JTable table_collections;
    // End of variables declaration//GEN-END:variables
}
