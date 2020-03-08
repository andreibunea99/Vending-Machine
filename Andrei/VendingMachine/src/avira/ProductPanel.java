package avira;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProductPanel {
    static ProductPanel instance = null;
    JFrame oldFrame, newFrame;
    ArrayList<Product> products;
    ArrayList<BufferedImage> productImages;
    ArrayList<JLabel> productTexts;
    ArrayList<Box> boxes;
    ArrayList<JButton> productButtons;
    int[] nr = {0, 0, 0, 0, 0, 0};
    Limits limits = new Limits();

    private ProductPanel(JFrame frame, JFrame newFrame, Limits limits, ArrayList<Product> products) throws IOException {
        this.limits = limits;
        oldFrame = frame;
        this.newFrame = newFrame;
        this.products = products;
        productImages = new ArrayList<>();
        productTexts = new ArrayList<>();
        boxes = new ArrayList<>();
        productButtons = new ArrayList<>();
    }

    private void InitialiseSecondPannel() throws IOException {
        // initialise images
        productImages.add(ImageIO.read(new File("prime.png")));
        productImages.add(ImageIO.read(new File("pro.png")));
        productImages.add(ImageIO.read(new File("vpn.png")));
        productImages.add(ImageIO.read(new File("pass.png")));
        productImages.add(ImageIO.read(new File("optim.png")));
        productImages.add(ImageIO.read(new File("speed.png")));

        // initialise texts
        for (int i = 0; i < 6; ++i) {
            JLabel temp = new JLabel("  " + products.get(i).getName() + "\n " + products.get(i).getPrice() + "$");
            temp.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            temp.setSize(30, 30);
            temp.setBackground(Color.WHITE);
            temp.setVerticalTextPosition(SwingConstants.BOTTOM);
            productTexts.add(temp);
        }

        // initialise boxes and buttons
        BufferedImage cart = ImageIO.read(new File("cart.jpg"));
        for (int i = 0; i < 6; ++i) {
            boxes.add(Box.createHorizontalBox());
            productButtons.add(new JButton(new ImageIcon(cart)));
        }
    }

    public void driver() throws IOException {
        InitialiseSecondPannel();
        oldFrame.setVisible(false);
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

        for (int i = 0; i < 6; ++i) {
            boxes.get(i).add(new JLabel(new ImageIcon(productImages.get(i))));
            boxes.get(i).add(productButtons.get(i));
        }

//        proBox.setLocation(0, 0);

        for (int i = 0; i < 6; ++i) {
            productPanel.add(boxes.get(i));
        }
        productPanel.setVisible(true);

        for (int i = 0; i < 6; ++i) {
            boxes.get(i).add(productTexts.get(i));
        }

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

        ArrayList<JLabel> cnt = new ArrayList<>();
        ArrayList<JLabel> q = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            JLabel cntTemp = new JLabel(products.get(i).getName());
            cntTemp.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            cntTemp.setSize(30, 30);
            cntTemp.setBackground(Color.WHITE);
            cnt.add(cntTemp);
            JLabel qTemp = new JLabel("   " + nr[i]);
            qTemp.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            qTemp.setSize(30, 30);
            qTemp.setBackground(Color.WHITE);
            q.add(qTemp);
            cntBox.add(cntTemp);
        }

        quant.add(qStart);
        for (int i = 0; i < 6; ++i) {
            quant.add(q.get(i));
        }
        cartBox.add(cntBox);
        cartBox.add(quant);
//        productPanel.add(cntBox);
//        productPanel.add(quant);

//        for (int i = 0; i < 6; ++i) {
//            int finalI = i;
//            productButtons.get(i).addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    nr[finalI]++;
//                    if (nr[finalI] > limits[finalI]) {
//                        nr[finalI]--;
//
//                    }
//                }
//            });
//        }

        productButtons.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nr[0]++;
                if (nr[0] > limits.limitPrime) {
                    nr[0]--;
                    q.get(0).setForeground(Color.RED);
                }
                q.get(0).setText("   " + nr[0]);
            }
        });
        productButtons.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nr[1]++;
                if (nr[1] > limits.limitPro) {
                    nr[1]--;
                    q.get(1).setForeground(Color.RED);
                }
                q.get(1).setText("   " + nr[1]);
            }
        });
        productButtons.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nr[2]++;
                if (nr[2] > limits.limitVpn) {
                    nr[2]--;
                    q.get(2).setForeground(Color.RED);
                }
                q.get(2).setText("   " + nr[2]);
            }
        });
        productButtons.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nr[3]++;
                if (nr[3] > limits.limitPass) {
                    nr[3]--;
                    q.get(3).setForeground(Color.RED);
                }
                q.get(3).setText("   " + nr[3]);
            }
        });
        productButtons.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nr[4]++;
                if (nr[4] > limits.limitOptim) {
                    nr[4]--;
                    q.get(4).setForeground(Color.RED);
                }
                q.get(4).setText("   " + nr[4]);
            }
        });
        productButtons.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nr[5]++;
                if (nr[5] > limits.limitSpeed) {
                    nr[5]--;
                    q.get(5).setForeground(Color.RED);
                }
                q.get(5).setText("   " + nr[5]);
            }
        });
        Box buttonBox = Box.createHorizontalBox();
        JButton finishButton = new JButton();
        finishButton.setBounds(150, 600, 400, 170);
        finishButton.setBackground(Color.RED);
        finishButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        finishButton.setText("Go to payment");
//        finishButton.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                stockFrame.setVisible(false);
//                limits.setLimits(Integer.parseInt(qPrime.getText().substring(5)), Integer.parseInt(qPro.getText().substring(5)), Integer.parseInt(qVpn.getText().substring(5)),
//                        Integer.parseInt(qPass.getText().substring(5)), Integer.parseInt(qOptim.getText().substring(5)), Integer.parseInt(qSpeed.getText().substring(5)));
//                new MainFrame(limits);
//            }
//        });
        finishButton.setForeground(Color.WHITE);
        finishButton.setFocusable(false);
        buttonBox.add(finishButton);
        Box all = Box.createVerticalBox();
        all.add(cartBox);
        all.add(Box.createVerticalStrut(30));
        all.add(buttonBox);
        productPanel.add(all);
    }

    public static ProductPanel getInstance(JFrame frame, JFrame newFrame, Limits limits, ArrayList<Product> products) throws IOException {
        if (instance == null) {
            instance = new ProductPanel(frame, newFrame, limits, products);
        }
        return instance;
    }

}
