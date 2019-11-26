package ui;

import model.StudentInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainUi {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField1;
    private String user;
    private String password;
    private StudentInfo stu1;

    //EFFECT: Launch the login panel
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

    //EFFECT: Construct initialize state for the panel
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Agent Calculator!");
        frame.setBounds(400, 250, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setTitle();
        setLabel();
        setButton();

    }

    //MODIFIES: this
    //EFFECTS: Construct title for the main panel
    public void setTitle() {
        JLabel lblNewLabel = new JLabel("What's your name and ID?");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel.setBounds(111, 17, 287, 15);
        frame.getContentPane().add(lblNewLabel);
    }

    //MODIFIES: this
    //EFFECTS: Construct labels on the main panel
    public void setLabel() {
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

    //MODIFIES: this
    //EFFECTS: Construct button
    public void setButton() {
        Button button = new Button("OK");
        button.setBounds(87, 194, 76, 23);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                user = textField.getText();
                password = textField1.getText();
                if (user.equals("") || user == null || password.equals("") || password == null || !validate(password)) {
                    JOptionPane.showMessageDialog(frame, "Hi, the Name or ID can't be valid！");
                    return;
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose();
                    moveOn();

                }
            }
        });
        frame.getContentPane().add(button);
    }

    //EFFECTS: test whether the password is valid
    public boolean validate(String id) {
        return (id.equals("w5s2b"));
    }


    //EFFECT: Go to the operation ui-panel
    public void moveOn() {
        StudentInfo stu = new StudentInfo(user, password);
        StudentOperationUi index = new StudentOperationUi(stu);
        JFrame frame2 = index.getFrame();
        frame2.setVisible(true);
    }

}

