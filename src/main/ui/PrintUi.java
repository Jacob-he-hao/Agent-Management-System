package ui;

import exception.ImpossibleAgentException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PrintUi {
    private JFrame frame;
    private ImageIcon image1;
    private JLabel label1;

    public PrintUi() {

        image1 =  new ImageIcon("data/image1.png");
        label1 = new JLabel(image1);

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
        frame.setBounds(300, 150, 1200, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(label1);
        setButton();
    }


    //MODIFIES: this
    //EFFECTS: Construct button
    public void setButton() {
        Button button = new Button("OK");
        button.setBounds(890, 1100, 120, 30);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moveOn();

            }
        });
        frame.getContentPane().add(button);
    }

    //EFFECTS: Go to the next-on ui panel
    public void moveOn() {
        frame.dispose();
        NextOnUi index = new NextOnUi();
        JFrame frame1 = index.getFrame();
        frame1.setVisible(true);

    }
}

