import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class gui {
    public static void main(String args[]) throws IOException {
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m12 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m12);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter text");
        JTextField tf = new JTextField(10);
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label);
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

//        JTextArea ta = new JTextArea();

        JPanel venderPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, venderPanel);

//        Action action = new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String textToOutput = new String();
//                textToOutput = tf.getText();
//                ta.setText(textToOutput);
//            }
//        };
//        tf.addActionListener(action);

        //Image
        BufferedImage cart = ImageIO.read(new File("cart.jpg"));

        venderPanel.setBackground(Color.white);

        BufferedImage prime = ImageIO.read(new File("prime.png"));
        //venderPanel.add(new JButton(new ImageIcon(prime)));
        BufferedImage pro = ImageIO.read(new File("pro.png"));
        //venderPanel.add(new JButton(new ImageIcon(pro)));
        BufferedImage vpn = ImageIO.read(new File("vpn.png"));
        //venderPanel.add(new JButton(new ImageIcon(vpn)));
        BufferedImage pass = ImageIO.read(new File("pass.png"));
        //venderPanel.add(new JButton(new ImageIcon(pass)));
        BufferedImage optim = ImageIO.read(new File("optim.png"));
        //venderPanel.add(new JButton(new ImageIcon(optim)));
        BufferedImage speed = ImageIO.read(new File("speed.png"));
        //venderPanel.add(new JButton(new ImageIcon(speed)));


        Box primeBox = Box.createHorizontalBox();
        Box proBox = Box.createHorizontalBox();
        Box vpnBox = Box.createHorizontalBox();
        Box passBox = Box.createHorizontalBox();
        Box optimBox = Box.createHorizontalBox();
        Box speedBox = Box.createHorizontalBox();
        primeBox.add(Box.createGlue());
        proBox.add(Box.createGlue());
        vpnBox.add(Box.createGlue());
        passBox.add(Box.createGlue());
        optimBox.add(Box.createGlue());
        speedBox.add(Box.createGlue());

        primeBox.add(new JLabel(new ImageIcon(prime)));
        primeBox.add(new JButton(new ImageIcon(cart)));

        proBox.add(new JLabel(new ImageIcon(pro)));
        proBox.add(new JButton(new ImageIcon(cart)));

        vpnBox.add(new JLabel(new ImageIcon(vpn)));
        vpnBox.add(new JButton(new ImageIcon(cart)));

        passBox.add(new JLabel(new ImageIcon(pass)));
        passBox.add(new JButton(new ImageIcon(cart)));

        optimBox.add(new JLabel(new ImageIcon(optim)));
        optimBox.add(new JButton(new ImageIcon(cart)));

        speedBox.add(new JLabel(new ImageIcon(speed)));
        speedBox.add(new JButton(new ImageIcon(cart)));


        venderPanel.add(primeBox);
        venderPanel.add(proBox);
        venderPanel.add(vpnBox);
        venderPanel.add(passBox);
        venderPanel.add(optimBox);
        venderPanel.add(speedBox);


        //frame.setResizable(false);
        frame.setVisible(true);
    }
}