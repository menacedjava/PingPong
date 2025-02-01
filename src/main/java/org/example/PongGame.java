package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements KeyListener, ActionListener {


//    private static final int WIDTH = 800;
//    private static final int HEIGHT = 400;
//
//    private int ballX = 400, ballY = 200;
//    private int ballDX = 2, ballDY = 2;
//    private int leftPadY = 150, rightPadY = 150;
//    private final int PAD_WIDTH = 15, PAD_HEIGHT = 80;
//
//    private boolean leftUp = false, leftDown = false;
//    private boolean rightUp = false, rightDown = false;
//
//    private int leftScore = 0, rightScore = 0;
//
//    private Timer timer;
//
//    public PongGame() {
//        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//        this.setBackground(Color.BLACK);
//        this.addKeyListener(this);
//        this.setFocusable(true);
//
//        // Timer yaratish, har 10 millisekundda o'yinni yangilash
//        timer = new Timer(10, this);
//        timer.start();
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        // To'pni chizish
//        g.setColor(Color.WHITE);
//        g.fillOval(ballX, ballY, 15, 15); // To'pni chizish
//
//        // Padlarni chizish
//        g.fillRect(30, leftPadY, PAD_WIDTH, PAD_HEIGHT); // Chap pad
//        g.fillRect(WIDTH - 45, rightPadY, PAD_WIDTH, PAD_HEIGHT); // O'ng pad
//
//        // Skorlarni chizish
//        g.setFont(new Font("Arial", Font.PLAIN, 30));
//        g.drawString("Left: " + leftScore, 50, 30); // Chap o'yinchi
//        g.drawString("Right: " + rightScore, WIDTH - 150, 30); // O'ng o'yinchi
//
//        // O'yin tugashi haqida xabar
//        if (ballX <= 0 || ballX >= WIDTH - 15) {
//            g.setColor(Color.WHITE);
//            g.setFont(new Font("Arial", Font.BOLD, 40));
//            g.drawString("Game Over!", WIDTH / 2 - 120, HEIGHT / 2);
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Agar o'yin tugamagan bo'lsa, o'yinni davom ettirish
//        if (ballX <= 0) {
//            rightScore++; // O'ng o'yinchi gol oladi
//            resetBall(); // To'pni qayta boshlash
//        } else if (ballX >= WIDTH - 15) {
//            leftScore++; // Chap o'yinchi gol oladi
//            resetBall(); // To'pni qayta boshlash
//        } else {
//            moveBall(); // To'pni harakatlantirish
//            movePads(); // Padlarni harakatlantirish
//            checkCollisions(); // To'qnashuvlarni tekshirish
//        }
//        repaint(); // O'yin maydonini yangilash
//    }
//
//    private void moveBall() {
//        ballX += ballDX;
//        ballY += ballDY;
//
//        // To'pning yuqori va pastki chegaralardan to'qnashishi
//        if (ballY <= 0 || ballY >= HEIGHT - 15) {
//            ballDY = -ballDY; // Yuqoriga yoki pastga to'qnashganda
//        }
//    }
//
//    private void movePads() {
//        // Chap padni harakatlantirish
//        if (leftUp && leftPadY > 0) {
//            leftPadY -= 4; // Yuqoriga harakat
//        }
//        if (leftDown && leftPadY < HEIGHT - PAD_HEIGHT) {
//            leftPadY += 4; // Pastga harakat
//        }
//
//        // O'ng padni harakatlantirish
//        if (rightUp && rightPadY > 0) {
//            rightPadY -= 4; // Yuqoriga harakat
//        }
//        if (rightDown && rightPadY < HEIGHT - PAD_HEIGHT) {
//            rightPadY += 4; // Pastga harakat
//        }
//    }
//
//    private void checkCollisions() {
//        // Chap pad bilan to'qnashuvni tekshirish
//        if (ballX <= 45 && ballY + 15 >= leftPadY && ballY <= leftPadY + PAD_HEIGHT) {
//            ballDX = -ballDX; // Chap pad bilan to'qnashganda
//        }
//
//        // O'ng pad bilan to'qnashuvni tekshirish
//        if (ballX >= WIDTH - 45 && ballY + 15 >= rightPadY && ballY <= rightPadY + PAD_HEIGHT) {
//            ballDX = -ballDX; // O'ng pad bilan to'qnashganda
//        }
//    }
//
//    private void resetBall() {
//        // To'pni markazga qaytarish
//        ballX = WIDTH / 2 - 7;
//        ballY = HEIGHT / 2 - 7;
//        ballDX = -ballDX; // To'pning yo'nalishini o'zgartirish
//        ballDY = 2; // To'pning yuqori yoki pastga harakatlanishi
//    }
//
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        int key = e.getKeyCode();
//        if (key == KeyEvent.VK_W) {
//            leftUp = true;
//        }
//        if (key == KeyEvent.VK_S) {
//            leftDown = true;
//        }
//        if (key == KeyEvent.VK_UP) {
//            rightUp = true;
//        }
//        if (key == KeyEvent.VK_DOWN) {
//            rightDown = true;
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        int key = e.getKeyCode();
//        if (key == KeyEvent.VK_W) {
//            leftUp = false;
//        }
//        if (key == KeyEvent.VK_S) {
//            leftDown = false;
//        }
//        if (key == KeyEvent.VK_UP) {
//            rightUp = false;
//        }
//        if (key == KeyEvent.VK_DOWN) {
//            rightDown = false;
//        }
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {}
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Pong Game");
//        PongGame gamePanel = new PongGame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(gamePanel);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
}
