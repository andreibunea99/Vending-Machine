package avira;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static avira.ProductPanel.getInstance;

public class Main {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("AVIRA");
        mainFrame.setSize(1000, 600);
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
        title.setLocation(270, 100);
        title.setForeground(Color.RED);
        title.setBackground(Color.WHITE);
        mainFrame.add(title);
        JLabel team = new JLabel("by Brute Force");
        team.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 26));
        team.setSize(600, 130);
        team.setLocation(525, 200);
        team.setForeground(Color.BLACK);
        team.setBackground(Color.WHITE);
        mainFrame.add(team);

        JButton startingButton = new JButton();
        startingButton.setBounds(350, 400, 300, 70);
        startingButton.setBackground(Color.RED);
        startingButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        startingButton.setText("Start Shopping");
        startingButton.setForeground(Color.WHITE);
        startingButton.setFocusable(false);

        startingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProductPanel pp = getInstance(mainFrame);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        mainFrame.add(startingButton);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);

//        main.dispatchEvent(new WindowEvent(main, WindowEvent.WINDOW_CLOSING));
    }
}
