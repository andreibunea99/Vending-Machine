package avira;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PaymentFrame {
    Limits limits;

    public PaymentFrame(JFrame frame, ArrayList<Product> products) {
        frame.setVisible(false);
        JFrame newFrame = new JFrame("Payment Window");
        newFrame.setVisible(true);
        JPanel payPanel = new JPanel();
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
        newFrame.getContentPane().add(BorderLayout.CENTER, payPanel);
        payPanel.setBackground(Color.WHITE);

        Box mbox = Box.createVerticalBox();
        Box all = Box.createHorizontalBox();
        Box methods = Box.createVerticalBox();
        JButton cardButton = new JButton();
        cardButton.setBounds(150, 400, 300, 70);
        cardButton.setBackground(Color.RED);
        cardButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        cardButton.setText("Pay with Card");
        cardButton.setForeground(Color.WHITE);
        cardButton.setFocusable(false);
        methods.add(Box.createVerticalStrut(100));
        methods.add(cardButton);
        methods.add(Box.createVerticalStrut(20));
        JButton cashButton = new JButton();
        cashButton.setBounds(150, 400, 300, 70);
        cashButton.setBackground(Color.RED);
        cashButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        cashButton.setText("Pay with Cash");
        cashButton.setForeground(Color.WHITE);
        cashButton.setFocusable(false);
        methods.add(cashButton);

        JButton backButton = new JButton();
        backButton.setBounds(150, 400, 300, 70);
        backButton.setBackground(Color.BLACK);
        backButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        backButton.setText("Back to Menu");
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        methods.add(Box.createVerticalStrut(20));
        methods.add(backButton);

        all.add(methods);
        all.add(Box.createHorizontalStrut(250));
        payPanel.add(all);
        int nrtotal = 0;
        for (int i = 0; i < products.size(); i++) {
            nrtotal += products.get(i).getPrice() * products.get(i).getQuantity();
        }
        JLabel total = new JLabel("Total:     " + nrtotal + "$");
        total.setFont(new Font(Font.MONOSPACED, Font.BOLD, 26));
        total.setSize(30, 30);
        total.setBackground(Color.WHITE);
        methods.add(Box.createVerticalStrut(30));
        methods.add(total);

        JLabel msg = new JLabel("                ");
        msg.setFont(new Font(Font.MONOSPACED, Font.BOLD, 26));
        msg.setSize(30, 30);
        msg.setBackground(Color.WHITE);
        mbox.add(msg);
        all.add(mbox);
        all.add(Box.createHorizontalStrut(100));

        cardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msg.setText("Aproach the card");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    msg.setText("Payment approved");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        cashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msg.setText("Aproach the card");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    msg.setText("Payment approved");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.setVisible(false);
                new MainFrame();
            }
        });

    }

}
