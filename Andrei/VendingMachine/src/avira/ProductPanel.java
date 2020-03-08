package avira;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProductPanel {
    static ProductPanel instance = null;
    JFrame productFrame = new JFrame();
    int nrprime = 0;
    int nrpro = 0;
    int nrvpn = 0;
    int nrpass = 0;
    int nroptim = 0;
    int nrspeed = 0;
    Limits limits = new Limits();

    private ProductPanel(JFrame frame, JFrame newFrame, Limits limits) throws IOException {
        this.limits = limits;
        frame.setVisible(false);
        newFrame.setVisible(true);
        JPanel productPanel = new JPanel();
        newFrame.setSize(1000, 600);
        newFrame.getContentPane().setBackground(Color.WHITE);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = newFrame.getSize().width;
        int h = newFrame.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        ImageIcon icon = new ImageIcon("icon.png");
        newFrame.setIconImage(icon.getImage());
        newFrame.setLocation(x, y);
        newFrame.getContentPane().add(BorderLayout.CENTER, productPanel);

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

        JButton buttonPrime = new JButton(new ImageIcon(cart));
        JButton buttonPro = new JButton(new ImageIcon(cart));
        JButton buttonVpn = new JButton(new ImageIcon(cart));
        JButton buttonPass = new JButton(new ImageIcon(cart));
        JButton buttonOptim = new JButton(new ImageIcon(cart));
        JButton buttonSpeed = new JButton(new ImageIcon(cart));

        primeBox.add(new JLabel(new ImageIcon(prime)));
        primeBox.add(buttonPrime);

        proBox.add(new JLabel(new ImageIcon(pro)));
        proBox.add(buttonPro);
        proBox.setLocation(0, 0);

        vpnBox.add(new JLabel(new ImageIcon(vpn)));
        vpnBox.add(buttonVpn);

        passBox.add(new JLabel(new ImageIcon(pass)));
        passBox.add(buttonPass);

        optimBox.add(new JLabel(new ImageIcon(optim)));
        optimBox.add(buttonOptim);

        speedBox.add(new JLabel(new ImageIcon(speed)));
        speedBox.add(buttonSpeed);

        productPanel.add(primeBox);
        productPanel.add(proBox);
        productPanel.add(vpnBox);
        productPanel.add(passBox);
        productPanel.add(optimBox);
        productPanel.add(speedBox);
        productPanel.setVisible(true);


        JLabel textPrime = new JLabel("  AVIRA PRIME\n 75$");
        textPrime.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textPrime.setSize(30, 30);
        textPrime.setBackground(Color.WHITE);
        primeBox.add(textPrime);
        textPrime.setVerticalTextPosition(SwingConstants.BOTTOM);
//        textPrime.setLocation(500, 100);


        JLabel textPro = new JLabel("  AVIRA PRO: 35$");
        textPro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textPro.setSize(30, 30);
        textPro.setBackground(Color.WHITE);
        proBox.add(textPro);
        textPro.setVerticalTextPosition(SwingConstants.BOTTOM);
//        textPrime.setLocation(500, 100);

        JLabel textVpn = new JLabel("  AVIRA VPN: 50$");
        textVpn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textVpn.setSize(30, 30);
        textVpn.setBackground(Color.WHITE);
        vpnBox.add(textVpn);
        textVpn.setVerticalTextPosition(SwingConstants.BOTTOM);
//        textPrime.setLocation(  500, 100);

        JLabel textPassword = new JLabel("  AVIRA Passwod Manager: 20$");
        textPassword.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textPassword.setSize(30, 30);
        textPassword.setBackground(Color.WHITE);
        passBox.add(textPassword);
        textPassword.setVerticalTextPosition(SwingConstants.BOTTOM);
//        textPrime.setLocation(  500, 100);

        JLabel textOptim = new JLabel("  AVIRA Optimizer: 10$");
        textOptim.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textOptim.setSize(30, 30);
        textOptim.setBackground(Color.WHITE);
        optimBox.add(textOptim);
        textOptim.setVerticalTextPosition(SwingConstants.BOTTOM);
//        textPrime.setLocation(  500, 100);

        JLabel textSystem = new JLabel("  AVIRA System Speedup: 25$");
        textSystem.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textSystem.setSize(30, 30);
        textSystem.setBackground(Color.WHITE);
        speedBox.add(textSystem);
        textSystem.setVerticalTextPosition(SwingConstants.BOTTOM);
//        textPrime.setLocation(  500, 100);
        productPanel.setBackground(Color.WHITE);

        Box cntBox = Box.createVerticalBox();
        Box cartBox = Box.createHorizontalBox();
        Box quant = Box.createVerticalBox();
//        Box qprime = Box.createHorizontalBox();

        JLabel cntTitle = new JLabel("Shopping cart: ");
        cntTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        cntTitle.setSize(30, 30);
        cntTitle.setBackground(Color.WHITE);
        cntBox.add(cntTitle);
        JLabel qStart = new JLabel("    ");
        qStart.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        qStart.setSize(30, 30);
        qStart.setBackground(Color.WHITE);

        JLabel cntPrime = new JLabel("AVIRA Prime: ");
        cntPrime.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        cntPrime.setSize(30, 30);
        cntPrime.setBackground(Color.WHITE);
        JLabel qPrime = new JLabel("   " + nrprime);
        qPrime.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        qPrime.setSize(30, 30);
        qPrime.setBackground(Color.WHITE);
//        qprime.add(cntPrime);
//        qprime.add(qPrime);
        cntBox.add(cntPrime);
//        cntBox.add(q);

//        Box qpro = Box.createHorizontalBox();
        JLabel cntPro = new JLabel("AVIRA PRO: ");
        cntPro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        cntPro.setSize(30, 30);
        cntPro.setBackground(Color.WHITE);
        JLabel qPro = new JLabel("   " + nrpro);
        qPro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        qPro.setSize(30, 30);
        qPro.setBackground(Color.WHITE);
//        qpro.add(cntPro);
//        qpro.add(qPro);
        cntBox.add(cntPro);

//        Box qvpn = Box.createHorizontalBox();
        JLabel cntVpn = new JLabel("AVIRA VPN: ");
        cntVpn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        cntVpn.setSize(30, 30);
        cntVpn.setBackground(Color.WHITE);
        JLabel qVpn = new JLabel("   " + nrvpn);
        qVpn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        qVpn.setSize(30, 30);
        qVpn.setBackground(Color.WHITE);
        cntBox.add(cntVpn);

        JLabel cntPass = new JLabel("AVIRA Password Manager: ");
        cntPass.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        cntPass.setSize(30, 30);
        cntPass.setBackground(Color.WHITE);
        JLabel qPass = new JLabel("   " + nrpass);
        qPass.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        qPass.setSize(30, 30);
        qPass.setBackground(Color.WHITE);
        cntBox.add(cntPass);

        JLabel cntOptim = new JLabel("AVIRA Optimizer: ");
        cntOptim.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        cntOptim.setSize(30, 30);
        cntOptim.setBackground(Color.WHITE);
        JLabel qOptim = new JLabel("   " + nroptim);
        qOptim.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        qOptim.setSize(30, 30);
        qOptim.setBackground(Color.WHITE);
        cntBox.add(cntOptim);

        JLabel cntSpeed = new JLabel("AVIRA System Speedup: ");
        cntSpeed.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        cntSpeed.setSize(30, 30);
        cntSpeed.setBackground(Color.WHITE);
        JLabel qSpeed = new JLabel("   " + nrspeed);
        qSpeed.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        qSpeed.setSize(30, 30);
        qSpeed.setBackground(Color.WHITE);
        cntBox.add(cntSpeed);

        quant.add(qStart);
        quant.add(qPrime);
        quant.add(qPro);
        quant.add(qVpn);
        quant.add(qPass);
        quant.add(qOptim);
        quant.add(qSpeed);
        cartBox.add(cntBox);
        cartBox.add(quant);
        productPanel.add(cntBox);
        productPanel.add(quant);

        buttonPrime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nrprime++;
                if (nrprime > limits.limitPrime) {
                    nrprime--;
                    qPrime.setForeground(Color.RED);
                }
                qPrime.setText("   " + nrprime);
            }
        });
        buttonPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nrpro++;
                if (nrpro > limits.limitPro) {
                    nrpro--;
                    qPro.setForeground(Color.RED);
                }
                qPro.setText("   " + nrpro);
            }
        });
        buttonVpn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nrvpn++;
                if (nrvpn > limits.limitVpn) {
                    nrvpn--;
                    qVpn.setForeground(Color.RED);
                }
                qVpn.setText("   " + nrvpn);
            }
        });
        buttonPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nrpass++;
                if (nrpass > limits.limitPass) {
                    nrpass--;
                    qPass.setForeground(Color.RED);
                }
                qPass.setText("   " + nrpass);
            }
        });
        buttonOptim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nroptim++;
                if (nroptim > limits.limitOptim) {
                    nroptim--;
                    qOptim.setForeground(Color.RED);
                }
                qOptim.setText("   " + nroptim);
            }
        });
        buttonSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nrspeed++;
                if (nrspeed > limits.limitSpeed) {
                    nrspeed--;
                    qSpeed.setForeground(Color.RED);
                }
                qSpeed.setText("   " + nrspeed);
            }
        });
//        cntBox.setLayout(null);
//        cntBox.setLocation(100, 300);
    }

    public static JFrame getInstance(JFrame frame, JFrame newFrame, Limits limits) throws IOException {
        if (instance == null) {
            instance = new ProductPanel(frame, newFrame, limits);
        }
        return instance.productFrame;
    }

}
