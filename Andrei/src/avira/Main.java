package avira;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame main = new JFrame("Main Frame");
        main.setSize(1000, 600);
        main.getContentPane().setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = main.getSize().width;
        int h = main.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        main.setLocation(x, y);
        main.setResizable(false);
        main.setBackground(Color.BLUE);

        JLabel title = new JLabel("AVIRA Vending Machine");
        title.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 38));
        title.setSize(600, 130);
        title.setLocation(270, 100);
        title.setForeground(Color.RED);
        title.setBackground(Color.WHITE);
        main.add(title);
        JLabel team = new JLabel("by Brute Force");
        team.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 26));
        team.setSize(600, 130);
        team.setLocation(525, 200);
        team.setForeground(Color.BLACK);
        team.setBackground(Color.WHITE);
        main.add(team);

        JButton startingButton = new JButton();
        startingButton.setBounds(350, 400, 300, 70);
        startingButton.setBackground(Color.RED);
        startingButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        startingButton.setText("Start Shopping");
        startingButton.setForeground(Color.WHITE);
        startingButton.setFocusable(false);

        main.add(startingButton);
        main.setLayout(null);
        main.setVisible(true);
    }
}
