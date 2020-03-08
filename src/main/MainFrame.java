package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame {
//    static MainFrame instance = null;
//    JFrame mainFrame = new JFrame();
    int nrprime = 10;
    int nrpro = 10;
    int nrvpn = 10;
    int nrpass = 10;
    int nroptim = 10;
    int nrspeed = 10;
    Limits limits = new Limits();

    public MainFrame(Limits limits) {
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

        JLabel title = new JLabel("AVIRA Vending Machine");
        title.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 38));
        title.setSize(600, 130);
        title.setLocation(245, 100);
        title.setForeground(Color.RED);
        title.setBackground(Color.WHITE);
        mainFrame.add(title);
        JLabel team = new JLabel("by Brute Force");
        team.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 26));
        team.setSize(600, 130);
        team.setLocation(600, 200);
        team.setForeground(Color.BLACK);
        team.setBackground(Color.WHITE);
        mainFrame.add(team);

        JButton startingButton = new JButton();
        startingButton.setBounds(150, 400, 300, 70);
        startingButton.setBackground(Color.RED);
        startingButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        startingButton.setText("Start Shopping");
        startingButton.setForeground(Color.WHITE);
        startingButton.setFocusable(false);

        JButton itemsButton = new JButton();
        itemsButton.setBounds(530, 400, 300, 70);
        itemsButton.setBackground(Color.RED);
        itemsButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        itemsButton.setText("Set initial stock");
        itemsButton.setForeground(Color.WHITE);
        itemsButton.setFocusable(false);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Avira Prime", 75));
        products.add(new Product("Antivirus Pro", 35));
        products.add(new Product("Phantom VPN", 50));
        products.add(new Product("Password Manager", 20));
        products.add(new Product("Optimizer", 10));
        products.add(new Product("System Speedup", 25));
        Setup.initialiseDefaultInventory(products);

        startingButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProductPanel productPanel = ProductPanel.getInstance(mainFrame, newFrame, limits, products);
                    productPanel.driver();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemsButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StockFrame.getInstance(mainFrame, newFrame, limits);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        mainFrame.add(startingButton);
        mainFrame.add(itemsButton);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

}
