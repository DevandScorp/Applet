import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class MoveBallsApplet extends Applet implements Runnable{

    private Color bgColor;
    private double x =10;
    private double y =10;
    private final int WIDTH=1200;
    private final int HEIGHT=400;
    private double dx = 1;
    private double dy = 1;
    public int getColor(String strColor) {
        if (strColor != null && strColor.charAt(0) == '#') {
            return Integer.parseInt(strColor.substring(1), 16);
        }
        return 0;
    }


    Thread thread = null;
    public void start() {
        if (thread == null)
            thread = new Thread(this);
        thread.start();
    }

    public void init() {

        setSize(WIDTH, HEIGHT);
        String str = getParameter("BgColor");
        bgColor = new Color(getColor(str));
    }

    @Override
    public void run() {
        while(true) {
            try {
                x += dx;
                y += dy;
                if (x < 0) {
                    x = 0;
                    dx = -dx;
                }
                if (x + 10 >= WIDTH) {
                    x = WIDTH - 10;
                    dx = -dx;
                }
                if (y < 0) {
                    y = 0;
                    dy = -dy;
                }
                if (y + 10 >= HEIGHT) {
                    y = HEIGHT - 10;
                    dy = -dy;

                }
                repaint();
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g){

        super.paint(g);
        setBackground(bgColor);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        Ellipse2D el = new Ellipse2D.Double(x, y, 20, 20);
        g2d.fill(el);
    }
}
