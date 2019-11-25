package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainUi {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField1;

    //Launch the login panel

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainUi window = new MainUi();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public MainUi() {
        initialize();
    }


    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Agent Calculator!");
        frame.setBounds(400, 250, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setTitle();
        setLabel();
        setButton();

    }

    private void setTitle() {
        JLabel lblNewLabel = new JLabel("What's your name and ID?");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel.setBounds(111, 17, 287, 15);
        frame.getContentPane().add(lblNewLabel);
    }


    private void setLabel() {
        JLabel label1 = new JLabel("Name");
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label1.setBounds(87, 67, 67, 15);
        frame.getContentPane().add(label1);
        textField = new JTextField();
        textField.setBounds(154, 64, 141, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel("ID");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label.setBounds(87, 108, 67, 15);
        frame.getContentPane().add(label);
        textField1 = new JTextField();
        textField1.setColumns(10);
        textField1.setBounds(154, 103, 141, 21);
        frame.getContentPane().add(textField1);
    }

    private void setButton() {
        Button button = new Button("OK");
        button.setBounds(87, 194, 76, 23);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String user = textField.getText();
                String password = textField1.getText();
                if (user.equals("") || user == null || password.equals("") || password == null) {
                    JOptionPane.showMessageDialog(frame, user + " " + ":Hi, the Name can't be blank！");
                    return;
                } else {
                    frame.dispose();
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                }
            }
        });
        frame.getContentPane().add(button);
    }
}

