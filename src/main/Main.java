package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static main.ProductPanel.getInstance;

public class Main {

    public static void main(String[] args) throws IOException {
        Limits limits = new Limits();
        new MainFrame(limits);
    }
}
