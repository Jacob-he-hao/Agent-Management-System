package ui;

import exception.ImpossibleAgentException;
import model.Agentlist;
import model.NewOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class SearchUi {
    private Agentlist rhineLifeAgents;
    private  Agentlist rhodeIslandAgent;
    private  Agentlist recruitedAgents;
    private JFrame frame;
    private JTextField textField;
    private String user;
    private NewOperation operation;


    public SearchUi() throws IOException {
        rhineLifeAgents = new Agentlist();
        rhodeIslandAgent = new Agentlist();
        recruitedAgents = new Agentlist();
        File rhineLife = new File("data/RhineLife.txt");
        File rhodeIsland = new File("data/RholesIsland.txt");
        rhineLifeAgents.load(rhineLife);
        rhodeIslandAgent.load(rhodeIsland);
        operation = new NewOperation(recruitedAgents, rhineLifeAgents, rhodeIslandAgent);

    }

    //EFFECTS:Return the framework of operational list
    public JFrame getFrame() {
        initialize();
        return frame;
    }

    //EFFECTS: Initialize the frame
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Search Panel");
        frame.setBounds(300, 150, 550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setTitle();
        setLabel();
        setButton();

    }

    //MODIFIES: this
    //EFFECTS: Construct title for the Search panel
    private void setTitle() {
        JLabel lblNewLabel = new JLabel("What's the name of agent you want to search?");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel.setBounds(111, 17, 320, 15);
        frame.getContentPane().add(lblNewLabel);
    }

    //MODIFIES: this
    //EFFECTS: Construct labels on the Search panel
    public void setLabel() {
        JLabel label1 = new JLabel("Name");
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label1.setBounds(87, 67, 67, 15);
        frame.getContentPane().add(label1);
        textField = new JTextField();
        textField.setBounds(154, 64, 141, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
    }


    //MODIFIES: this
    //EFFECTS: Construct button on the panel
    public void setButton() {
        Button button = new Button("OK");
        button.setBounds(87, 194, 76, 23);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                user = textField.getText();
                try {
                    operation.searchAgent(user);
                }  catch (ImpossibleAgentException ex) {
                    JOptionPane.showMessageDialog(frame, "This agent isn't available!");
                }
                moveOn();
            }
        });
        frame.getContentPane().add(button);
    }

    //EFFECTS: Go to the next-on ui-panel
    public void moveOn() {
        frame.dispose();
        NextOnUi index = new NextOnUi();
        JFrame frame1 = index.getFrame();
        frame1.setVisible(true);

    }
}
