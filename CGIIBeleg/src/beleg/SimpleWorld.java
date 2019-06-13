package beleg;

import org.lwjgl.opengl.Display;

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

public class SimpleWorld extends LWJGLFenster {
	public SimpleObject so;
	public String vSource = LoadShader.load("shader/simpleworld.vs");
	public String fSource = LoadShader.load("shader/simpleworld.fs");
	
	public SimpleWorld() {
		super("SimpleWorld", 1200, 800);
		so = new SimpleObject();
		so.setVerhalten(new SimpleBehaviour(so));
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
			glClearColor(0.2f, 0.2f, 0.4f, 1);
			glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);
			
			transform();
			/*
			glBegin(GL_TRIANGLE_FAN);
			glVertex3f(0, 1.5f, 0);
			glVertex3f(0, 0.5f, 0);
			glVertex3f(2, 1, 0);
			glEnd();
			*/
			
			so.update();
			Display.update();
		}
	}
	
	public static void main(String[] args) {
		(new SimpleWorld()).start();
	}
}
