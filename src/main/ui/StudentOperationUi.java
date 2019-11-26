package ui;

import model.StudentInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class StudentOperationUi {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField1;
    private StudentInfo info;
    private JPanel panel;
    private JPanel panel1;



    //EFFECTS:Create the framework of operational list
    public StudentOperationUi(StudentInfo info) {
        this.info = info;
    }

    //EFFECTS:Return the framework of operational list
    public JFrame getFrame() {
        initialize();
        return frame;
    }

    //EFFECTS:Initialize the content of the frame
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Operation Panel");
        frame.setBounds(300, 150, 550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setPanel1();
        setPanel2();
        setLable1();
        setLable2();
        setTextfield();
        setButton1();
        setButton3();
        setButton4();
        setButton5();
        setButton6();

    }

    //MODIFIES:this
    //EFFECTS:Add the label1 to the panel
    public void setLable1() {
        JLabel newLabel = new JLabel(info.getName() + " " + ":welcome to the operation panel!");
        newLabel.setBounds(54, 10, 322, 15);
        frame.getContentPane().add(newLabel);

        JLabel newLabel1 = new JLabel("Student Information");
        newLabel1.setBounds(94, 10, 120, 15);
        panel.add(newLabel1);

        JLabel newLabel2 = new JLabel("CS ID");
        newLabel2.setBounds(22, 37, 40, 15);
        panel.add(newLabel2);

        JLabel newLabel3 = new JLabel("Name");
        newLabel3.setBounds(22, 67, 44, 15);
        panel.add(newLabel3);
    }


    //MODIFIES:this
    //EFFECTS:Construct the panel1 to the frame
    public void setPanel1() {
        panel = new JPanel();
        panel.setBounds(29, 52, 250, 180);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
    }

    //MODIFIES:this
    //EFFECTS:Construct the panel2 to the frame
    public void setPanel2() {
        panel1 = new JPanel();
        panel1.setBounds(317, 52, 110, 180);
        frame.getContentPane().add(panel1);
        panel1.setLayout(null);
    }


    //MODIFIES:this
    //EFFECTS:Add the label2 to the panel
    public void setLable2() {
        JLabel newLabel4 = new JLabel("Operation Menu");
        newLabel4.setBounds(15, 10, 120, 15);
        panel1.add(newLabel4);
    }

    //MODIFIES:this
    //EFFECTS: Add the text fields to the panel
    public void setTextfield() {
        textField1 = new JTextField();
        textField1.setBounds(72, 66, 154, 21);
        textField1.setText(info.getName());
        panel.add(textField1);
        textField1.setColumns(10);

        textField = new JTextField();
        textField.setBounds(72, 35, 154, 21);
        textField.setText(info.getIdnum() + "");
        panel.add(textField);
        textField.setColumns(10);
    }


    //MODIFIES:this
    //EFFECTS:Add the button1 to the panel
    public void setButton1() {
        Button button = new Button("Add Agent");
        button.setBounds(10, 31, 90, 23);
        panel1.add(button);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                try {
                    moveOn();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    //MODIFIES:this
    //EFFECTS:Add the button3 to the panel
    public void setButton3() {
        Button button2 = new Button("Search");
        button2.setActionCommand("4");
        button2.setBounds(10, 56, 90, 23);
        panel1.add(button2);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                try {
                    moveOn2();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    //MODIFIES:this
    //EFFECTS:Add the button4 to the panel
    public void setButton4() {
        Button button3 = new Button("Search Recruited");
        button3.setBounds(10, 81, 90, 23);
        panel1.add(button3);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                try {
                    moveOn3();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    //MODIFIES:this
    //EFFECTS:Add the button5 to the panel
    public void setButton5() {
        Button button4 = new Button("Print Tag Map");
        button4.setBounds(10, 106, 90, 23);
        panel1.add(button4);
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                moveOn4();
            }
        });
    }

    //MODIFIES:this
    //EFFECTS:Add the button6 to the panel
    public void setButton6() {
        Button button5 = new Button("Quit");
        button5.setBounds(10, 131, 90, 23);
        panel1.add(button5);
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                moveOn5();
            }
        });
    }


    //EFFECTS: Go to the add ui-panel
    public void moveOn() throws IOException {
        AddUi index = new AddUi();
        JFrame frame1 = index.getFrame();
        frame1.setVisible(true);
    }



    //EFFECTS: Go to the search ui-panel
    public void moveOn2() throws IOException {
        SearchUi index = new SearchUi();
        JFrame frame3 = index.getFrame();
        frame3.setVisible(true);
    }

    //EFFECTS: Go to the search-recruited ui-panel
    public void moveOn3() throws IOException {
        SearchRecruitedUi index = new SearchRecruitedUi();
        JFrame frame4 = index.getFrame();
        frame4.setVisible(true);
    }

    //EFFECTS: Go to the print ui-panel
    public void moveOn4() {
        PrintUi index = new PrintUi();
        JFrame frame5 = index.getFrame();
        frame5.setVisible(true);
    }

    //EFFECTS: Go to the quit ui-panel
    public void moveOn5() {
        QuitUi index = new QuitUi();
        JFrame frame6 = index.getFrame();
        frame6.setVisible(true);
    }





}
