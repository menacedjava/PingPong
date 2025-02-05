package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements KeyListener, ActionListener {


    private static final int vidth = 800;
    private static final int HEIGHT = 400;

    private int ballX = 400, ballY = 200;
    private int ballDX = 2, ballDY = 2;
    private int leftPadY = 150, rightPadY = 150;
    private final int PAD_WIDTH = 15, PAD_HEIGHT = 80;

    private boolean leftUp = false, leftDown = false;
    private boolean rightUp = false, rightDown = false;

    private int leftScore = 0, rightScore = 0;

    private Timer timer;

    public PongGame() {
        this.setPreferredSize(new Dimension(vidth, HEIGHT));
        this.setBackground(Color.BLACK);
        this.addKeyListener(this);
        this.setFocusable(true);


        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 15, 15);


        g.fillRect(30, leftPadY, PAD_WIDTH, PAD_HEIGHT);
        g.fillRect(vidth - 45, rightPadY, PAD_WIDTH, PAD_HEIGHT);


        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Left: " + leftScore, 50, 30);
        g.drawString("Right: " + rightScore, vidth - 150, 30);


        if (ballX <= 0 || ballX >= vidth - 15) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over!", vidth / 2 - 120, HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (ballX <= 0) {
            rightScore++;
            resetBall();
        } else if (ballX >= vidth - 15) {
            leftScore++;
            resetBall();
        } else {
            moveBall();
            movePads();
            checkCollisions();
        }
        repaint();
    }

    private void moveBall() {
        ballX += ballDX;
        ballY += ballDY;


        if (ballY <= 0 || ballY >= HEIGHT - 15) {
            ballDY = -ballDY;
        }
    }

    private void movePads() {

        if (leftUp && leftPadY > 0) {
            leftPadY -= 4;
        }
        if (leftDown && leftPadY < HEIGHT - PAD_HEIGHT) {
            leftPadY += 4;
        }


        if (rightUp && rightPadY > 0) {
            rightPadY -= 4;
        }
        if (rightDown && rightPadY < HEIGHT - PAD_HEIGHT) {
            rightPadY += 4;
        }
    }

    private void checkCollisions() {

        if (ballX <= 45 && ballY + 15 >= leftPadY && ballY <= leftPadY + PAD_HEIGHT) {
            ballDX = -ballDX;
        }


        if (ballX >= vidth - 45 && ballY + 15 >= rightPadY && ballY <= rightPadY + PAD_HEIGHT) {
            ballDX = -ballDX;
        }
    }

    private void resetBall() {

        ballX = vidth / 2 - 7;
        ballY = HEIGHT / 2 - 7;
        ballDX = -ballDX;
        ballDY = 2;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            leftUp = true;
        }
        if (key == KeyEvent.VK_S) {
            leftDown = true;
        }
        if (key == KeyEvent.VK_UP) {
            rightUp = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            rightDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            leftUp = false;
        }
        if (key == KeyEvent.VK_S) {
            leftDown = false;
        }
        if (key == KeyEvent.VK_UP) {
            rightUp = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            rightDown = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        PongGame gamePanel = new PongGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
