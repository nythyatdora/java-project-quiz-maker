package project.quiz.maker;

import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JComboBox;

public final class FormCreateQuiz extends javax.swing.JFrame {

    private final CollectionData collectionData = CollectionData.createInstance ();

    private FormMain formMain;
    private DialogBrowseCollection dialogBrowseCollection;

    private final String MESSAGE_ADD_QUESTION = "New question has been added\ninto selected collection!";

    private final String DEFAULT_QUESTIONS[] = {
        ( "" ),
        ( "Which of these is the correct answer?" ),
        ( "Which of the following statements is true?" ),
        ( "Which of the following statements are false?" )
    };

    private Map<Integer, Collection> map;
    private Collection chosenCollection = null;

    private final JComboBox comboBoxCollectionID;

    public FormCreateQuiz () {
        initComponents ();

        this.comboBoxCollectionID = new JComboBox ();

        setMapData ();
        setComboCollection ();
        setComboQuestion ();
    }

    public FormCreateQuiz ( FormMain formMain ) {
        this();
        this.formMain = formMain;
    }

    public void setMapData () {
        collectionData.hasFileExisted ();

        map = (LinkedHashMap<Integer, Collection>) collectionData.fetchMapData ();
    }

    public void setComboCollection () {
        // clean the combobox
        comboBoxCollectionID.removeAllItems ();
        comboBox_collection.removeAllItems ();

        // add new data to combobox
        map.entrySet ().forEach ((entry) -> {
            Integer key = entry.getKey ();
            Collection value = entry.getValue ();

            comboBoxCollectionID.addItem (key);
            comboBox_collection.addItem (value.getCollectionName ());
        });
    }

    private void setComboQuestion () {
        for ( String str : DEFAULT_QUESTIONS ) {
            comboBox_defaultQuestion.addItem (str);
        }
    }

    public void setChosenCollection ( Collection collection ) {
        this.chosenCollection = collection;

        setSelectedCollectionOnComboBox (chosenCollection.getCollectionName ());
    }

    private void setSelectedCollectionOnComboBox ( String collectionName ) {
        comboBox_collection.setSelectedItem (collectionName);
    }

    public void setDialogBrowseCollectionClosed () {
        this.dialogBrowseCollection = null;
    }

    public DialogBrowseCollection getDialogBrowseCollection () {
        return this.dialogBrowseCollection;
    }

    private void resetInputFields () {
        comboBox_defaultQuestion.setSelectedIndex (0);
        textarea_customQuestion.setText ("");
        panel_answers.resetDefault ();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttongroup_multipleAnswer = new javax.swing.ButtonGroup();
        panel_background = new javax.swing.JPanel();
        panel_header = new javax.swing.JPanel();
        label_title = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        panel_leftPadding = new javax.swing.JPanel();
        panel_rightPadding = new javax.swing.JPanel();
        panel_stepTwo = new javax.swing.JPanel();
        label_defaultQuestion = new javax.swing.JLabel();
        comboBox_defaultQuestion = new javax.swing.JComboBox<>();
        label_custom = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea_customQuestion = new javax.swing.JTextArea();
        button_clear = new javax.swing.JButton();
        panel_stepOne = new javax.swing.JPanel();
        label_collection = new javax.swing.JLabel();
        button_browse = new javax.swing.JButton();
        comboBox_collection = new javax.swing.JComboBox<>();
        panel_buttons = new javax.swing.JPanel();
        button_create = new javax.swing.JButton();
        button_reset = new javax.swing.JButton();
        panel_topPadding = new javax.swing.JPanel();
        panel_stepThree = new javax.swing.JPanel();
        label_inputAnswers = new javax.swing.JLabel();
        button_add = new javax.swing.JButton();
        button_remove = new javax.swing.JButton();
        panel_answers = new project.quiz.maker.PanelAnswer();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CREATE QUIZ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_background.setBackground(new java.awt.Color(255, 255, 255));

        panel_header.setBackground(new java.awt.Color(20, 10, 37));

        label_title.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        label_title.setForeground(new java.awt.Color(255, 255, 255));
        label_title.setText("CREATE QUIZ");
        label_title.setToolTipText("");

        jPanel7.setBackground(new java.awt.Color(20, 10, 37));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(20, 10, 37));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_headerLayout = new javax.swing.GroupLayout(panel_header);
        panel_header.setLayout(panel_headerLayout);
        panel_headerLayout.setHorizontalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_headerLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_headerLayout.setVerticalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        panel_leftPadding.setBackground(new java.awt.Color(255, 255, 255));
        panel_leftPadding.setPreferredSize(new java.awt.Dimension(75, 100));

        javax.swing.GroupLayout panel_leftPaddingLayout = new javax.swing.GroupLayout(panel_leftPadding);
        panel_leftPadding.setLayout(panel_leftPaddingLayout);
        panel_leftPaddingLayout.setHorizontalGroup(
            panel_leftPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panel_leftPaddingLayout.setVerticalGroup(
            panel_leftPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_rightPadding.setBackground(new java.awt.Color(255, 255, 255));
        panel_rightPadding.setPreferredSize(new java.awt.Dimension(75, 100));

        javax.swing.GroupLayout panel_rightPaddingLayout = new javax.swing.GroupLayout(panel_rightPadding);
        panel_rightPadding.setLayout(panel_rightPaddingLayout);
        panel_rightPaddingLayout.setHorizontalGroup(
            panel_rightPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panel_rightPaddingLayout.setVerticalGroup(
            panel_rightPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_stepTwo.setBackground(new java.awt.Color(255, 255, 255));
        panel_stepTwo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STEP TWO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 18))); // NOI18N

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

        javax.swing.GroupLayout panel_stepTwoLayout = new javax.swing.GroupLayout(panel_stepTwo);
        panel_stepTwo.setLayout(panel_stepTwoLayout);
        panel_stepTwoLayout.setHorizontalGroup(
            panel_stepTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stepTwoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_stepTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(label_defaultQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBox_defaultQuestion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_custom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_stepTwoLayout.setVerticalGroup(
            panel_stepTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stepTwoLayout.createSequentialGroup()
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

        panel_stepOne.setBackground(new java.awt.Color(255, 255, 255));
        panel_stepOne.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STEP ONE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 18))); // NOI18N

        label_collection.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_collection.setText("choose collection");
        label_collection.setToolTipText("");

        button_browse.setUI(new jbuttoncss.CSSButton());
        button_browse.setBackground(new java.awt.Color(219, 43, 48));
        button_browse.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_browse.setForeground(new java.awt.Color(255, 255, 255));
        button_browse.setText("BROWSE");
        button_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_browseActionPerformed(evt);
            }
        });

        comboBox_collection.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        comboBox_collection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBox_collectionItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel_stepOneLayout = new javax.swing.GroupLayout(panel_stepOne);
        panel_stepOne.setLayout(panel_stepOneLayout);
        panel_stepOneLayout.setHorizontalGroup(
            panel_stepOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stepOneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_stepOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_collection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_stepOneLayout.createSequentialGroup()
                        .addComponent(comboBox_collection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(button_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_stepOneLayout.setVerticalGroup(
            panel_stepOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stepOneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_collection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_stepOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox_collection, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(button_browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        panel_buttons.setBackground(new java.awt.Color(255, 255, 255));

        button_create.setUI(new jbuttoncss.CSSButton());
        button_create.setBackground(new java.awt.Color(219, 43, 48));
        button_create.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        button_create.setForeground(new java.awt.Color(255, 255, 255));
        button_create.setText("CREATE");
        button_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_createActionPerformed(evt);
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
                .addComponent(button_create, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_buttonsLayout.setVerticalGroup(
            panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buttonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_create, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        panel_topPadding.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_topPaddingLayout = new javax.swing.GroupLayout(panel_topPadding);
        panel_topPadding.setLayout(panel_topPaddingLayout);
        panel_topPaddingLayout.setHorizontalGroup(
            panel_topPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_topPaddingLayout.setVerticalGroup(
            panel_topPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panel_stepThree.setBackground(new java.awt.Color(255, 255, 255));
        panel_stepThree.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STEP THREE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 18))); // NOI18N

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

        javax.swing.GroupLayout panel_stepThreeLayout = new javax.swing.GroupLayout(panel_stepThree);
        panel_stepThree.setLayout(panel_stepThreeLayout);
        panel_stepThreeLayout.setHorizontalGroup(
            panel_stepThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_stepThreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_stepThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_inputAnswers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_answers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_stepThreeLayout.setVerticalGroup(
            panel_stepThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stepThreeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_inputAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_answers, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_backgroundLayout = new javax.swing.GroupLayout(panel_background);
        panel_background.setLayout(panel_backgroundLayout);
        panel_backgroundLayout.setHorizontalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_leftPadding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_backgroundLayout.createSequentialGroup()
                        .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel_stepTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_stepOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_stepThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel_topPadding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_rightPadding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addComponent(panel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_leftPadding, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(panel_backgroundLayout.createSequentialGroup()
                        .addComponent(panel_topPadding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_backgroundLayout.createSequentialGroup()
                                .addComponent(panel_stepOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_stepTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(panel_stepThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_rightPadding, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)))
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

    private void button_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_browseActionPerformed
        if ( !VerifyVariable.hasDialogOpened (dialogBrowseCollection) ) {
            dialogBrowseCollection = new DialogBrowseCollection (null, false, this);
            dialogBrowseCollection.setVisible (true);
        }
    }//GEN-LAST:event_button_browseActionPerformed

    private void button_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_clearActionPerformed
        textarea_customQuestion.setText ("");
    }//GEN-LAST:event_button_clearActionPerformed

    private void button_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_createActionPerformed
        String question;
        LinkedList<Question> questions;
        LinkedList<Answer> answers;

        boolean fromTextArea = textarea_customQuestion.isEnabled ();
        if ( !fromTextArea ) {
            question = comboBox_defaultQuestion.getSelectedItem ().toString ();
        }
        else {
            question = textarea_customQuestion.getText ();
        }

        answers = panel_answers.getAllAnswers ();

        boolean allAllowed = !VerifyVariable.isEmptyOrDefault (question) && panel_answers.hasAllFilled () && panel_answers.hasChosenAnswer ();
        boolean hasMultipleAnswer = panel_answers.hasMultipleChosenAnswers ();
        if ( allAllowed ) {
            Collection selectedCollection = map.get (chosenCollection.getCollectionID ());
            selectedCollection.addQuestion (question, answers, hasMultipleAnswer);

            // set no for questions
            int i = 0;
            questions = selectedCollection.getQuestionList ();
            for ( Question next : questions ) {
                next.setQuestionNO (++i);
            }

            collectionData.commitMapData (map, MESSAGE_ADD_QUESTION);
            resetInputFields ();
        }
    }//GEN-LAST:event_button_createActionPerformed

    private void button_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_resetActionPerformed
        resetInputFields ();
    }//GEN-LAST:event_button_resetActionPerformed

    private void comboBox_defaultQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_defaultQuestionActionPerformed
        String selectedItem = (String) comboBox_defaultQuestion.getSelectedItem ();

        if ( !VerifyVariable.isEmptyOrDefault (selectedItem) ) {
            textarea_customQuestion.setEnabled (false);
        }
        else {
            textarea_customQuestion.setEnabled (true);
        }
    }//GEN-LAST:event_comboBox_defaultQuestionActionPerformed

    private void comboBox_collectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_collectionItemStateChanged
        if ( evt.getStateChange () == ItemEvent.SELECTED ) {
            int selectedIndex = comboBox_collection.getSelectedIndex ();
            comboBoxCollectionID.setSelectedIndex (selectedIndex);
            int selectedID = (int) comboBoxCollectionID.getSelectedItem ();
            String selectedItem = (String) comboBox_collection.getSelectedItem ();

            if ( !VerifyVariable.isEmptyOrDefault (selectedItem) ) {
                boolean isContained = map.containsKey (selectedID);

                if ( isContained ) {
                    chosenCollection = map.get (selectedID);
                }
            }
        }
    }//GEN-LAST:event_comboBox_collectionItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if ( VerifyVariable.hasFormOpened (formMain) ) {
            formMain.setFormCreateQuizClosed ();
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
            java.util.logging.Logger.getLogger (FormCreateQuiz.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger (FormCreateQuiz.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger (FormCreateQuiz.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger (FormCreateQuiz.class.getName ()).log (java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater (new Runnable () {
            public void run () {
                new FormCreateQuiz ().setVisible (true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_browse;
    private javax.swing.JButton button_clear;
    private javax.swing.JButton button_create;
    private javax.swing.JButton button_remove;
    private javax.swing.JButton button_reset;
    private javax.swing.ButtonGroup buttongroup_multipleAnswer;
    private javax.swing.JComboBox<String> comboBox_collection;
    private javax.swing.JComboBox<String> comboBox_defaultQuestion;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_collection;
    private javax.swing.JLabel label_custom;
    private javax.swing.JLabel label_defaultQuestion;
    private javax.swing.JLabel label_inputAnswers;
    private javax.swing.JLabel label_title;
    private project.quiz.maker.PanelAnswer panel_answers;
    private javax.swing.JPanel panel_background;
    private javax.swing.JPanel panel_buttons;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_leftPadding;
    private javax.swing.JPanel panel_rightPadding;
    private javax.swing.JPanel panel_stepOne;
    private javax.swing.JPanel panel_stepThree;
    private javax.swing.JPanel panel_stepTwo;
    private javax.swing.JPanel panel_topPadding;
    private javax.swing.JTextArea textarea_customQuestion;
    // End of variables declaration//GEN-END:variables
}