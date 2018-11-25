import java.applet.Applet;
import java.awt.*;
import java.util.Arrays;

public class Main extends Applet {
    private int WIDTH;
    private int HEIGHT;

    @Override
    public void init() {
        WIDTH = Integer.parseInt(getParameter("width"));
        HEIGHT = Integer.parseInt(getParameter("height"));
        super.init();
    }


    public void paint(Graphics g) {
        Graphics2D drp = (Graphics2D) g;
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
        g.setFont(newFont);
        drp.setColor(new Color(Integer.parseInt(getParameter("redG")), Integer.parseInt(getParameter("greenG")), Integer.parseInt(getParameter("blueG"))));
        for (int i = 0, count = -5; i < WIDTH; i += 40, ++count) {
            drp.drawLine(0, i, WIDTH, i);
            drp.drawLine(i, 0, i, HEIGHT);
            drp.drawString(Integer.toString(count), 5 + i, 20 + HEIGHT / 2);
            if (i != HEIGHT / 2) drp.drawString(Integer.toString(-count), 10 + HEIGHT / 2, 20 + i);

        }
        drp.setColor(Color.BLACK);
        drp.drawLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2);
        drp.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        double[] xCoord = new double[60];
        double[] yCoord = new double[60];
        double step = 0;
        for (int i = 0; i < 60; ++i, step += 0.05) {
            xCoord[i] = -1 + step;
            yCoord[i] = Math.pow(xCoord[i], 2) - 1;
        }
        int[] x = new int[60];
        int[] y = new int[60];
        for (int i = 0; i < 60; ++i) {
            x[i] = HEIGHT / 2 + (int) (xCoord[i] * 40);
            y[i] = WIDTH / 2 - (int) (yCoord[i] * 40);
        }
        drp.setStroke(new BasicStroke(3.0f));
        drp.setColor(new Color(Integer.parseInt(getParameter("redL")), Integer.parseInt(getParameter("greenL")), Integer.parseInt(getParameter("blueL"))));
        drp.drawPolyline(x, y, 60);
    }
}
