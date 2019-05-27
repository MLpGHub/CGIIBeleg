package beleg;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glEnable;
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

import org.lwjgl.opengl.Display;
import java.util.concurrent.ThreadLocalRandom;

public class Vogelsimulation extends LWJGLFenster {
	private Vogelschwarm schwarm;
	private String vSource = LoadShader.load("shader/vogelsimulation.vs");
	private String fSource = LoadShader.load("shader/vogelsimulation.fs");
	private ThreadLocalRandom r = ThreadLocalRandom.current();
	
	public Vogelsimulation() {
		super("Vogelsimulation", 1200, 800);
		schwarm = Vogelschwarm.getInstance();
		for (int i = 0; i < 20; i++) {
			Vektor3D pos = new Vektor3D(r.nextDouble(1)-0.5, r.nextDouble(1)-0.5, 0);
			Vektor3D speed = new Vektor3D(r.nextDouble(0.00005), r.nextDouble(0.00005), 0);
			Vektor3D accel = new Vektor3D();
			Vogel v = new Vogel(i, pos, speed, accel, schwarm);
			v.verhalten = new Schwarmverhalten(v, 0.1);//new SimpleBehaviour(v); //new Schwarmverhalten(v, 0.2);
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
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	
	public void renderLoop() {
		prepareShader();
		glEnable(GL_DEPTH_TEST);
		while (!Display.isCloseRequested()) {
			glClearColor(0.4941f, 0.7529f, 0.9333f, 1);
			glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);
			
			transform();
			
			double time = System.nanoTime()/1e7;
			System.out.println("time is " + time);
			if ((int)time%1 == 0)
				schwarm.update();
			schwarm.render();
			Display.update();
		}
	}
	
	public static void main(String[] args) {
		new Vogelsimulation().start();
	}
}
