package Tack1_my;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawingPanel panel;

    public MainWindow() throws HeadlessException{
        panel = new DrawingPanel(1920, 1080,100);
        this.add(panel);
    }
}
