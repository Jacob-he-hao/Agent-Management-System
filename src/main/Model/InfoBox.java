package model;

import javax.swing.*;


public class InfoBox {

    //EFFECTS: create an information box;
    public static void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage);
    }
}

