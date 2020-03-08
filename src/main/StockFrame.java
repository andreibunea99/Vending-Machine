package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class StockFrame {
    static StockFrame instance = null;
    JFrame stockFrame = new JFrame();
    int nrprime = 10;
    int nrpro = 10;
    int nrvpn = 10;
    int nrpass = 10;
    int nroptim = 10;
    int nrspeed = 10;
    Limits limits = new Limits();

    private StockFrame(JFrame frame, JFrame newFrame, Limits limits) throws IOException {
        this.limits = limits;
        frame.setVisible(false);
        newFrame.setVisible(true);
        JPanel stockPanel = new JPanel();
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
        newFrame.getContentPane().add(BorderLayout.CENTER, stockPanel);
        stockPanel.setBackground(Color.WHITE);

        Box cntBox = Box.createVerticalBox();
        Box cartBox = Box.createHorizontalBox();
        Box quant = Box.createVerticalBox();
//        Box qprime = Box.createHorizontalBox();

        JLabel blank = new JLabel(" ");
        blank.setFont(new Font(Font.MONOSPACED, Font.BOLD, 72));
        blank.setSize(30, 30);
        blank.setBackground(Color.WHITE);
        cntBox.add(blank);
        JLabel qBlank = new JLabel("  ");
        qBlank.setFont(new Font(Font.MONOSPACED, Font.BOLD, 72));
        qBlank.setSize(30, 30);
        qBlank.setBackground(Color.WHITE);

        JLabel cntTitle = new JLabel("Set initial stock: ");
        cntTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        cntTitle.setSize(30, 30);
        cntTitle.setBackground(Color.WHITE);
        cntBox.add(cntTitle);
        JLabel qStart = new JLabel("    ");
        qStart.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        qStart.setSize(30, 30);
        qStart.setBackground(Color.WHITE);

        JLabel cntPrime = new JLabel("AVIRA Prime: ");
        cntPrime.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        cntPrime.setSize(30, 30);
        cntPrime.setBackground(Color.WHITE);
        JTextField qPrime = new JTextField("     " + nrprime);
        qPrime.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        qPrime.setSize(30, 30);
        qPrime.setBackground(Color.WHITE);
//        qprime.add(cntPrime);
//        qprime.add(qPrime);
        cntBox.add(cntPrime);
//        cntBox.add(q);

//        Box qpro = Box.createHorizontalBox();
        JLabel cntPro = new JLabel("AVIRA PRO: ");
        cntPro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        cntPro.setSize(30, 30);
        cntPro.setBackground(Color.WHITE);
        JTextField qPro = new JTextField("     " + nrpro);
        qPro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        qPro.setSize(30, 30);
        qPro.setBackground(Color.WHITE);
//        qpro.add(cntPro);
//        qpro.add(qPro);
        cntBox.add(cntPro);

//        Box qvpn = Box.createHorizontalBox();
        JLabel cntVpn = new JLabel("AVIRA VPN: ");
        cntVpn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        cntVpn.setSize(30, 30);
        cntVpn.setBackground(Color.WHITE);
        JTextField qVpn = new JTextField("     " + nrvpn);
        qVpn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        qVpn.setSize(30, 30);
        qVpn.setBackground(Color.WHITE);
        cntBox.add(cntVpn);

        JLabel cntPass = new JLabel("AVIRA Password Manager: ");
        cntPass.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        cntPass.setSize(30, 30);
        cntPass.setBackground(Color.WHITE);
        JTextField qPass = new JTextField("     " + nrpass);
        qPass.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        qPass.setSize(30, 30);
        qPass.setBackground(Color.WHITE);
        cntBox.add(cntPass);

        JLabel cntOptim = new JLabel("AVIRA Optimizer: ");
        cntOptim.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        cntOptim.setSize(30, 30);
        cntOptim.setBackground(Color.WHITE);
        JTextField qOptim = new JTextField("     " + nroptim);
        qOptim.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        qOptim.setSize(30, 30);
        qOptim.setBackground(Color.WHITE);
        cntBox.add(cntOptim);

        JLabel cntSpeed = new JLabel("AVIRA System Speedup: ");
        cntSpeed.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        cntSpeed.setSize(30, 30);
        cntSpeed.setBackground(Color.WHITE);
        JTextField qSpeed = new JTextField("     " + nrspeed);
        qSpeed.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        qSpeed.setBackground(Color.WHITE);
        cntBox.add(cntSpeed);

        quant.add(qBlank);
        quant.add(qStart);
        quant.add(qPrime);
        quant.add(qPro);
        quant.add(qVpn);
        quant.add(qPass);
        quant.add(qOptim);
        quant.add(qSpeed);
        cartBox.add(cntBox);
        cartBox.add(quant);
//        stockPanel.add(cntBox);
//        stockPanel.add(quant);

        Box buttonBox = Box.createHorizontalBox();
        JButton startingButton = new JButton();
        startingButton.setBounds(150, 600, 400, 170);
        startingButton.setBackground(Color.RED);
        startingButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        startingButton.setText("Set Stock");
        startingButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockFrame.setVisible(false);
                limits.setLimits(Integer.parseInt(qPrime.getText().substring(5)), Integer.parseInt(qPro.getText().substring(5)), Integer.parseInt(qVpn.getText().substring(5)),
                        Integer.parseInt(qPass.getText().substring(5)), Integer.parseInt(qOptim.getText().substring(5)), Integer.parseInt(qSpeed.getText().substring(5)));
                new MainFrame(limits);
            }
        });
        startingButton.setForeground(Color.WHITE);
        startingButton.setFocusable(false);
        buttonBox.add(startingButton);
        Box all = Box.createVerticalBox();
        all.add(cartBox);
        all.add(Box.createVerticalStrut(30));
        all.add(buttonBox);
        stockPanel.add(all);
//        cntBox.add(startingButton);
    }

    public static JFrame getInstance(JFrame frame, JFrame newFrame, Limits limits) throws IOException {
        if (instance == null) {
            instance = new StockFrame(frame, newFrame, limits);
        }
        return instance.stockFrame;
    }

}
