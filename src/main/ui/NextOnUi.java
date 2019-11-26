package ui;

import model.NewOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class NextOnUi {

    private JFrame frame;

    public NextOnUi() {

    }

    //EFFECTS:Return the framework of operational list
    public JFrame getFrame() {
        initialize();
        return frame;
    }

    //EFFECTS: Initialize the frame
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Next-on Action Panel");
        frame.setBounds(300, 150, 950, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setTitle();
        setButton1();
        setButton3();
        setButton4();
        setButton5();
        setButton6();
    }

    //MODIFIES: this
    //EFFECTS: Construct title for the main panel
    private void setTitle() {
        JLabel lblNewLabel = new JLabel("What's the next operation you want to do?");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel.setBounds(111, 17, 287, 15);
        frame.getContentPane().add(lblNewLabel);
    }

    //MODIFIES:this
    //EFFECTS:Add the button1 to the panel
    public void setButton1() {
        Button button = new Button("Add Agent");
        button.setBounds(10, 81, 90, 23);
        frame.getContentPane().add(button);
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
        button2.setBounds(210, 81, 90, 23);
        frame.getContentPane().add(button2);
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
        button3.setBounds(410, 81, 90, 23);
        frame.getContentPane().add(button3);
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
        button4.setBounds(610, 81, 90, 23);
        frame.getContentPane().add(button4);
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
        button5.setBounds(810, 81, 90, 23);
        frame.getContentPane().add(button5);
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
