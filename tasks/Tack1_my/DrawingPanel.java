package Tack1_my;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel implements ActionListener {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;

    private Clock clock;

    public DrawingPanel(final int height, final int width,final int timerDelay){
        this.PANEL_HEIGHT = height;
        this.PANEL_WIDTH = width;
        this.TIMER_DELAY = timerDelay;

        timer = new Timer(timerDelay,this);

        this.clock = new Clock( getWidth()/2,getHeight()/2,400,400);
        timer.start();
    }

    public void paint(final Graphics gr){
        super.paint(gr);
        clock.setX(getWidth()/2);
        clock.draw(gr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == timer){
            repaint();
            ticksFromStart++;
        }
    }
}
