package com.ltztec.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static int WIDTH = 480;
	public static int HEIGHT = 480;

	public BufferedImage game_bg;

	

	public static Rectangle maskHole;

	public static int score = 0;

	public static int mx, my;
	public static boolean isPressed = false;

	public Game() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
	}

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setTitle("Cath the Crab");
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		new Thread(game).start();
	}

	public void tick() {

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(game_bg, 0, 0, null);

	

		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString("Score - " + score, 15, 25);

		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		double fps = 60.0;
		while (true) {
			tick();
			render();

			try {
				Thread.sleep((int) (1000 / fps));
			} catch (InterruptedException e) {
			}
			System.out.println("FPS: " + (int) fps);
		}

	}
}