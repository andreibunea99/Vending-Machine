package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class PaymentFrame {
    //    static MainFrame instance = null;
//    JFrame mainFrame = new JFrame();
    int nrprime = 10;
    int nrpro = 10;
    int nrvpn = 10;
    int nrpass = 10;
    int nroptim = 10;
    int nrspeed = 10;
    Limits limits = new Limits();

    public PaymentFrame(Limits limits) {
        this.limits = limits;
        JFrame mainFrame = new JFrame("AVIRA");
        JFrame newFrame = new JFrame("Products");
        mainFrame.setSize(1000, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = mainFrame.getSize().width;
        int h = mainFrame.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        ImageIcon icon = new ImageIcon("icon.png");
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setLocation(x, y);
        mainFrame.setResizable(false);
        mainFrame.setBackground(Color.BLUE);
    }

}
