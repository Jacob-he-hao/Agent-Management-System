package ui;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image img;


public ImagePanel(Image img){
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setSize(size);
    setLayout(null);
}


@Override
protected void paintComponent(Graphics g) {
Dimension size = this.getParent().getSize();
g.drawImage(img, 0, 0, size.width, size.height, this);
}

}

