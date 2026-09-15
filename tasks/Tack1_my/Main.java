package Tack1_my;

import Tack1_my.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000,1000);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
