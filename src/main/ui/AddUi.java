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

public class AddUi {

    private  Agentlist rhineLifeAgents;
    private  Agentlist rhodeIslandAgent;
    private  Agentlist recruitedAgents;
    private JFrame frame;
    private JTextField textField;
    private String user;
    private Choice choice;
    private NewOperation operation;

    public AddUi() throws IOException {
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
        frame.setTitle("Add Action Panel");
        frame.setBounds(300, 150, 550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setTitle();
        setLabel();
        setChoice();
        setButton();

    }

    //MODIFIES: this
    //EFFECTS: Construct title for the main panel
    private void setTitle() {
        JLabel lblNewLabel = new JLabel("What's the name and organization of agent?");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel.setBounds(111, 17, 287, 15);
        frame.getContentPane().add(lblNewLabel);
    }

    //MODIFIES: this
    //EFFECTS: Construct labels on the add panel
    private void setLabel() {
        JLabel label1 = new JLabel("Name");
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label1.setBounds(87, 67, 100, 15);
        frame.getContentPane().add(label1);
        textField = new JTextField();
        textField.setBounds(200, 64, 141, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel("Organization");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label.setBounds(87, 108, 100, 15);
        frame.getContentPane().add(label);
    }

    //MODIFIES: this
    //EFFECTS: Construct choices box on the add panel
    public void setChoice() {
        choice = new Choice();
        choice.setBounds(200, 103, 141, 21);
        choice.add("RhineLife");
        choice.add("RhodeIsland");
        frame.getContentPane().add(choice);

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
                        operation.addAgent(choice.getSelectedItem(), user);
                        JOptionPane.showMessageDialog(frame, "The Agent has been added!");
                    } catch (IOException ignored) {
                        JOptionPane.showMessageDialog(frame, "This file is wrong");
                    } catch (ImpossibleAgentException ex) {
                        JOptionPane.showMessageDialog(frame, "This agent isn't available of this organization");
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
