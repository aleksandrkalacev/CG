package Tack1_my;

import java.awt.*;

public class Clock {
    private int x;
    private int y;
    private int height;
    private int width;
    private String color;

    public Clock(final int x, final int y, final int width, final int height, final String color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
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
        int stX = this.x;
        int stY = this.y;

        //Основа
        g.setColor(Color.decode(this.color));
        g.fillRect(stX - this.height/2, stY - this.width/2, this.height, this.width);
        g.setColor(Color.decode("#97641c"));
        g.setStroke(new BasicStroke(5.0f));
        g.drawRect(stX - this.height/2, stY - this.width/2, this.height, this.width);
        g.setStroke(new BasicStroke(1.0f));

        //Крыша
        g.setColor(Color.decode("#734417"));
        Polygon pl = new Polygon();
        pl.addPoint(stX - this.height/2 - 40, stY - this.width/2);
        pl.addPoint(stX - this.height/2 + this.height + 40, stY - this.width/2);
        pl.addPoint(stX, stY - this.width/2 - 150);

        g.setColor(Color.decode("#a0522d"));
        g.fillPolygon(pl);

        g.setStroke(new BasicStroke(20.0f));
        g.setColor(Color.decode("#97641c"));
        g.drawPolygon(pl);
        g.setStroke(new BasicStroke(1.0f));

        //Элементы декора
        g.setColor(Color.WHITE);
        g.fillOval(stX - 150, stY - 150, 300, 300);
        g.setStroke(new BasicStroke(15.0f));

        g.setColor(Color.BLACK);
        g.drawOval(stX - 150, stY - 150, 300, 300);

        g.setStroke(new BasicStroke(2.0f));

        g.setColor(Color.gray);
        g.drawOval(stX - 150, stY - 150, 300, 300);

        g.setStroke(new BasicStroke(1.0f));

        //стрелки и цифры
        g.setFont(new Font("Arial", Font.BOLD, 26));
        g.setColor(Color.BLACK);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.drawString("12", stX - g.getFontMetrics().stringWidth("12") / 2, stY - 110);
        g.drawString("6", stX - g.getFontMetrics().stringWidth("6") / 2, stY + 125);
        g.drawString("3", stX + 115, stY + g.getFontMetrics().getAscent() / 3);
        g.drawString("9", stX - 130, stY + g.getFontMetrics().getAscent() / 3);

        int stLen = 130;

        int minLen = 100;
        int min = (int) ((System.currentTimeMillis()/(1000 * 60)) % 60);
        double minAngle = (min * 6 * Math.PI/180) - Math.PI/2;
        int endXMin = (int) (stX + minLen * Math.cos(minAngle));
        int endYMin = (int) (stY + minLen * Math.sin(minAngle));

        g.setStroke(new BasicStroke(4.0f));
        g.drawLine(stX, stY, endXMin, endYMin);






        g.setStroke(new BasicStroke(4.0f));
        g.setColor(Color.RED);



        int sec = (int) ((System.currentTimeMillis()/1000) % 60);
        double angle = (sec * 6 * Math.PI/180) - Math.PI/2;
        int endX = (int) (stX + stLen * Math.cos(angle));
        int endY = (int) (stY + stLen * Math.sin(angle));


        g.setStroke(new BasicStroke(4.0f));
        g.setColor(Color.RED);





        g.drawLine(stX, stY, endX, endY);
        g.setColor(Color.green);
        g.drawLine(stX, stY, stX-50, stY-50);

        g.fillOval(stX - 8, stY - 8, 16, 16);
        g.setStroke(new BasicStroke(1.0f));

        //маятник
        int stXM = stX;
        int stYM = stY + 200;

        int lenM = 200;
        long timeM = System.currentTimeMillis();
        double maxAngle = Math.toRadians(20);
        double angleM = maxAngle * Math.sin(Math.PI * timeM / 1000.0);

        int endXM = stXM + (int) (lenM * Math.sin(angleM));
        int endYM = stYM + (int) (lenM * Math.cos(angleM));

        g.setStroke(new BasicStroke(8.0f));
        g.setColor(Color.decode("#954535"));
        g.drawLine(stXM, stYM, endXM, endYM);
        g.setStroke(new BasicStroke(1.0f));

        g.setColor(Color.YELLOW);
        int radiusM = 40;
        g.fillOval(endXM - radiusM, endYM - radiusM, radiusM * 2, radiusM * 2);
        g.setColor(Color.decode("#97641c"));
        g.drawOval(endXM - radiusM, endYM - radiusM, radiusM * 2, radiusM * 2);
    }
}
