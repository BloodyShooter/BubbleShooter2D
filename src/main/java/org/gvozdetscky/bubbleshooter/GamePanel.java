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

    public static GameBack background;
    public static Player player;

    public GamePanel() {
        super();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();

    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        background = new GameBack();
        player = new Player();

        while (true) {

            gameUpdate();
            gameRender();
            gameDraw();

            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gameUpdate() {
        background.update();

        player.update();
    }

    public void gameRender() {
        background.draw(g);

        player.draw(g);
    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);

        g2.dispose();
    }
}
