package ui;

import exception.ImpossibleAgentException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PrintUi {
    private JFrame frame;
    private ImagePanel panel;

    public PrintUi() {

    }

    //EFFECTS:Return the framework of print ui
    public JFrame getFrame() {
        initialize();
        return frame;
    }

    //EFFECTS: Initialize the frame
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Print Map Panel");
        frame.setBounds(300, 150, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setImagePanel();
        setButton();
    }

    //MODIFIES:this
    //EFFECTS: put the tag map on the panel
    public void setImagePanel() {
        panel = new ImagePanel(new ImageIcon("data/image1.png").getImage());
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setExtendedState( Frame.MAXIMIZED_BOTH );
        }


    //MODIFIES: this
    //EFFECTS: Construct button
    public void setButton() {
        Button button = new Button("OK");
        button.setBounds(740, 900, 76, 23);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moveOn();

            }
        });
        panel.add(button);
    }

    //EFFECTS: Go to the next-on ui panel
    public void moveOn() {
        frame.dispose();
        NextOnUi index = new NextOnUi();
        JFrame frame1 = index.getFrame();
        frame1.setVisible(true);

    }

    }

