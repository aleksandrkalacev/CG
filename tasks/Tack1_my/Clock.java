package Tack1_my;

import java.awt.*;

public class Clock {
    private int x;
    private int y;
    private int height;
    private int width;


    public Clock(final int x,final int y, final int width, final int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void setWidth(int width){
        this.width = width;
    }


    public void setHeight(int height){
        this.height = height;
    }

    void draw(final Graphics gr){
        Graphics2D g = (Graphics2D) gr;

        //Фон

        g.setColor(Color.decode("#c5c09b"));
        g.fillRect(0,0, g.getClipBounds().width, g.getClipBounds().height);


        //Основа


        g.setColor(Color.decode("#b67b54"));
        g.fillRect(g.getClipBounds().width/2 - this.height/2, g.getClipBounds().height/2 - this.width/2,this.height,this.width);
        g.setColor(Color.decode("#97641c"));
        g.setStroke(new BasicStroke(5.0f));
        g.drawRect(g.getClipBounds().width/2 - this.height/2, g.getClipBounds().height/2 - this.width/2,this.height,this.width);
        g.setStroke(new BasicStroke(1.0f));


        //Крыша

        g.setColor(Color.decode("#734417"));

        Polygon pl = new Polygon();
        pl.addPoint(g.getClipBounds().width/2 - this.height/2 - 40, g.getClipBounds().height/2 - this.width/2);
        pl.addPoint(g.getClipBounds().width/2 - this.height/2 + this.height + 40, g.getClipBounds().height/2 - this.width/2);
        pl.addPoint(g.getClipBounds().width/2, g.getClipBounds().height/2 - this.width/2 - 150);

        g.setColor(Color.decode("#a0522d"));
        g.fillPolygon(pl);


        g.setStroke(new BasicStroke(20.0f));
        g.setColor(Color.decode("#97641c"));
        g.drawPolygon(pl);
        g.setStroke(new BasicStroke(1.0f));

        //Элементы декора

        g.setColor(Color.WHITE);
        g.fillOval(g.getClipBounds().width/2 - 150, g.getClipBounds().height/2 - 150,300,300);
        g.setStroke(new BasicStroke(15.0f));


        g.setColor(Color.BLACK);
        g.drawOval(g.getClipBounds().width/2 - 150, g.getClipBounds().height/2 - 150,300,300);

        g.setStroke(new BasicStroke(2.0f));


        g.setColor(Color.gray);
        g.drawOval(g.getClipBounds().width/2 - 150, g.getClipBounds().height/2 - 150,300,300);

        g.setStroke(new BasicStroke(1.0f));

        //Элементы циферблата



        //стрелки и цифры


        int stX = g.getClipBounds().width/2;
        int stY = g.getClipBounds().height/2;

        // 1. Настраиваем крупный красивый шрифт
        g.setFont(new Font("Arial", Font.BOLD, 26));
        g.setColor(Color.BLACK);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        g.drawString("12", stX - g.getFontMetrics().stringWidth("12") / 2, stY - 110);
        g.drawString("6", stX - g.getFontMetrics().stringWidth("6") / 2, stY + 125);
        g.drawString("3", stX + 115, stY + g.getFontMetrics().getAscent() / 3);
        g.drawString("9", stX - 130, stY + g.getFontMetrics().getAscent() / 3);



        int stLen = 130;

        int sec = (int) ((System.currentTimeMillis()/1000) % 60);

        double angle = (sec * 6 * Math.PI/180) - Math.PI/2;

        int endX = (int) (stX + stLen * Math.cos(angle));
        int endY = (int) (stY + stLen * Math.sin(angle));

        g.setStroke(new BasicStroke(4.0f));
        g.setColor(Color.RED);


        g.drawLine(stX, stY, endX, endY);

        g.drawLine(stX, stY, stX-50, stY-50);


        g.setColor(Color.BLACK);
        g.fillOval(stX - 8, stY - 8, 16, 16);

        g.setStroke(new BasicStroke(1.0f));
    }


}
