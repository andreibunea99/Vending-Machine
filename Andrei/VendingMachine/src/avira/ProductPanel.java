package avira;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProductPanel {
    static ProductPanel instance = null;
    JFrame productFrame = new JFrame();

    private ProductPanel(JFrame frame) throws IOException {
        frame.setVisible(false);
        productFrame.setSize(1000, 600);
        productFrame.getContentPane().setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = productFrame.getSize().width;
        int h = productFrame.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        ImageIcon icon = new ImageIcon("icon.png");
        productFrame.setIconImage(icon.getImage());
        productFrame.setLocation(x, y);
        productFrame.setResizable(false);
        BufferedImage cart = ImageIO.read(new File("cart.jpg"));
        BufferedImage prime = ImageIO.read(new File("prime.png"));
        BufferedImage pro = ImageIO.read(new File("pro.png"));
        BufferedImage vpn = ImageIO.read(new File("vpn.png"));
        BufferedImage pass = ImageIO.read(new File("pass.png"));
        BufferedImage optim = ImageIO.read(new File("optim.png"));
        BufferedImage speed = ImageIO.read(new File("speed.png"));


        Box primeBox = Box.createHorizontalBox();
        Box proBox = Box.createHorizontalBox();
        Box vpnBox = Box.createHorizontalBox();
        Box passBox = Box.createHorizontalBox();
        Box optimBox = Box.createHorizontalBox();
        Box speedBox = Box.createHorizontalBox();

        primeBox.add(new JLabel(new ImageIcon(prime)));
        primeBox.add(new JButton(new ImageIcon(cart)));

        proBox.add(new JLabel(new ImageIcon(pro)));
        proBox.add(new JButton(new ImageIcon(cart)));
        proBox.setLocation(0, 0);

        vpnBox.add(new JLabel(new ImageIcon(vpn)));
        vpnBox.add(new JButton(new ImageIcon(cart)));

        passBox.add(new JLabel(new ImageIcon(pass)));
        passBox.add(new JButton(new ImageIcon(cart)));

        optimBox.add(new JLabel(new ImageIcon(optim)));
        optimBox.add(new JButton(new ImageIcon(cart)));

        speedBox.add(new JLabel(new ImageIcon(speed)));
        speedBox.add(new JButton(new ImageIcon(cart)));


        productFrame.add(primeBox);
        productFrame.add(proBox);
        productFrame.add(vpnBox);
        productFrame.add(passBox);
        productFrame.add(optimBox);
        productFrame.add(speedBox);
        productFrame.setVisible(true);
    }

    public static ProductPanel getInstance(JFrame frame) throws IOException {
        if (instance == null) {
            instance = new ProductPanel(frame);
        }
        return instance;
    }

}
