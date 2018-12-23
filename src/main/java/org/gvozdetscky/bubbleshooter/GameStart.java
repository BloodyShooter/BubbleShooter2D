package org.gvozdetscky.bubbleshooter;

import javax.swing.*;

public class GameStart {

    public static void main(String[] args) {
        JFrame startFrame = new JFrame("BubbleShooter2D");

        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        startFrame.setContentPane(new GamePanel());

        startFrame.pack();

        startFrame.setLocationRelativeTo(null);
        startFrame.setVisible(true);
    }
}
