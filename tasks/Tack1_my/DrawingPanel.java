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

    private Clock clock1;


    public DrawingPanel(final int height, final int width,final int timerDelay){
        this.PANEL_HEIGHT = height;
        this.PANEL_WIDTH = width;
        this.TIMER_DELAY = timerDelay;



        timer = new Timer(timerDelay,this);

        this.clock1  = new Clock( PANEL_WIDTH/2 + 875,PANEL_HEIGHT/2 - 200,400,400, "#b67b54" );


        timer.start();
    }

    public void paint(final Graphics gr){
        super.paint(gr);

        //фон
        gr.setColor(Color.decode("#c5c09b"));
        gr.fillRect(0,0, gr.getClipBounds().width, gr.getClipBounds().height);


        clock1.draw(gr);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == timer){
            repaint();
            ticksFromStart++;
        }
    }
}
