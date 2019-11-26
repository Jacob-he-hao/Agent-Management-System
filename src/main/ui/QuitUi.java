package ui;

import exception.ImpossibleAgentException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class QuitUi  {
    private JFrame frame;


    public QuitUi() {

    }

    //EFFECTS:Return the framework of operational list
    public JFrame getFrame() {
        initialize();
        return frame;
    }

    //EFFECTS: Initialize the frame
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Quit Panel");
        frame.setBounds(300, 150, 550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setTitle();
        setButton();
    }

    //MODIFIES: this
    //EFFECTS: Construct title for the quit panel
    private void setTitle() {
        JLabel lblNewLabel = new JLabel("Thank you!");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblNewLabel.setBounds(150, 80, 287, 40);
        frame.getContentPane().add(lblNewLabel);
    }


    //MODIFIES: this
    //EFFECTS: Construct button
    public void setButton() {
        Button button = new Button("OK");
        button.setBounds(87, 194, 76, 23);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });
        frame.getContentPane().add(button);
    }
}
