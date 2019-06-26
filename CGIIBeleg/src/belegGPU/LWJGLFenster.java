package belegGPU;
import java.awt.Canvas;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public abstract class LWJGLFenster {
	protected int WIDTH, HEIGHT;
	protected String TITLE;
	
	public LWJGLFenster() {
		this("LWJGLFenster", 800, 600);
	}
	
	public LWJGLFenster(int width, int height) {
		this("LWJGLFenster", width, height);
	}
	
	public LWJGLFenster(String title, int width, int height) {
		this.TITLE = title;
		this.WIDTH = width;
		this.HEIGHT = height;
	}
	
	public void initDisplay(Canvas c) {
		try {
			Display.setParent(c);
		} catch (Exception e) {
			System.out.println(e);
		}
		initDisplay();
	}
	
	public void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public abstract void renderLoop();
	
	public void start() {
		renderLoop();
		Display.destroy();
		System.exit(0);
	}
}
