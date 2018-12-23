package org.gvozdetscky.bubbleshooter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    private Thread thread = new Thread(this);

    private BufferedImage image;
    private Graphics2D g;

    private GameBack background;

    public GamePanel() {
        super();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        requestFocus();

        thread.start();
    }

    public void run() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        background = new GameBack();

        while (true) {

            gameUpdate();
            gameRender();

            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gameUpdate() {
    }

    public void gameRender() {

    }
}
