package beleg;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glFrustum;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.opengl.GL11.glScalef;

import org.lwjgl.opengl.Display;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Vogelsimulation extends LWJGLFenster {
	private Vogelschwarm schwarm;
	private String vSource = LoadShader.load("shader/vogelsimulation.vs");
	private String fSource = LoadShader.load("shader/vogelsimulation.fs");
	private ThreadLocalRandom r = ThreadLocalRandom.current();
	private Raubvogel grosserVogel;
	
	public Vogelsimulation() {
		super("Vogelsimulation", 1200, 800);
		schwarm = Vogelschwarm.getInstance();
		Model vogelModell = null;
		try {
			vogelModell = OBJLoader.loadModel(new File("obj/adler1.obj"));
		} catch (Exception e) {
			System.out.println(e);
		}
		grosserVogel = new Raubvogel(0, new Vektor3D(r.nextInt(WIDTH), r.nextInt(HEIGHT), 0), new Vektor3D(), null); //vogelModell
		grosserVogel.verhalten = new Raubvogelverhalten(grosserVogel, schwarm, 0.01, 0.05);
		for (int i = 0; i < 200; i++) {
			//Vektor3D pos = new Vektor3D(0, 0, 0);
			Vektor3D pos = new Vektor3D(r.nextInt(WIDTH), r.nextInt(HEIGHT), 0);
			//System.out.println(pos.x + ", " + pos.y);
			Vektor3D speed = new Vektor3D(r.nextDouble(0.5), r.nextDouble(0.5), 0);
			Vogel v = new Vogel(i, pos, speed, schwarm, null);
			v.verhalten = new Schwarmverhalten(v, grosserVogel, 20, 0.05, 3, true); //v, 20, 0.05, 3, true
			schwarm.add(v);
		}
		initDisplay();
	}
	
	public void prepareShader() {
		int program = glCreateProgram();
		
		int vs = glCreateShader(GL_VERTEX_SHADER);
		glShaderSource(vs, vSource);
		glCompileShader(vs);
		glAttachShader(program, vs);
		
		int fs = glCreateShader(GL_FRAGMENT_SHADER);
		glShaderSource(fs, fSource);
		glCompileShader(fs);
		glAttachShader(program, fs);
		
		glLinkProgram(program);
		glUseProgram(program);
	}
	
	public void transform() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 0, 1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST);
	}
	
	public void renderLoop() {
		prepareShader();
		glEnable(GL_DEPTH_TEST);
		
		while (!Display.isCloseRequested()) {
			glClearColor(0.4941f, 0.7529f, 0.9333f, 1);
			glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);
			
			transform();
			
			double time = System.nanoTime()/1e7;
			schwarm.render();
			if ((int)time%1 == 0)
				schwarm.update();
			grosserVogel.render();
			grosserVogel.update();
			Display.update();
		}
	}
	
	public static void main(String[] args) {
		new Vogelsimulation().start();
	}
}
