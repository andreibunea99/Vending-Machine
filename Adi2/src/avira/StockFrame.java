package avira;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class StockFrame {
    static StockFrame instance = null;
    JFrame stockFrame = new JFrame();
    ArrayList<Product> products;

    private StockFrame(JFrame frame, JFrame newFrame, ArrayList<Product> p) throws IOException {
        products = p;
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

        ArrayList<JLabel> cnt = new ArrayList<>();
        ArrayList<JTextField> q = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            JLabel cntTemp = new JLabel(products.get(i).getName() + ": ");
            cntTemp.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
            cntTemp.setSize(30, 30);
            cntTemp.setBackground(Color.WHITE);
            cnt.add(cntTemp);
            JTextField qTemp = new JTextField("     " + products.get(i).getQuantity());
            qTemp.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
            qTemp.setSize(30, 30);
            qTemp.setBackground(Color.WHITE);
            q.add(qTemp);
            cntBox.add(cntTemp);
        }

        quant.add(qBlank);
        quant.add(qStart);
        for (int i = 0; i < 6; ++i) {
            quant.add(q.get(i));
        }
        cartBox.add(cntBox);
        cartBox.add(quant);

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
                int[] n = new int[6];
                for (int i = 0; i < 6; ++i) {
                    n[i] = Integer.parseInt(q.get(i).getText().substring(5));
                }
                Setup.initialiseCustomInventory(products, n);
                new MainFrame();
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
    }

    public static StockFrame getInstance(JFrame frame, JFrame newFrame, ArrayList<Product> products) throws IOException {
        if (instance == null) {
            instance = new StockFrame(frame, newFrame, products);
        }
        return instance;
    }

}
