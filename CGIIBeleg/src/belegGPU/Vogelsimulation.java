package belegGPU;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUseProgram;

import java.util.concurrent.ThreadLocalRandom;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Vogelsimulation extends LWJGLFenster {
	private enum vogeltype { VOGEL, RAUBVOGEL }

	private int vogelProgram;
	private int raubvogelProgram;
	private ThreadLocalRandom r = ThreadLocalRandom.current();

	public Vogelsimulation() {
		super("Vogelsimulation", 1200, 800);
		initDisplay();
		
		vogelProgram = prepareShader(vogeltype.VOGEL);
		raubvogelProgram = prepareShader(vogeltype.RAUBVOGEL);
		
	}

	public int prepareShader(vogeltype type) {
		int program = glCreateProgram();
		
		String vSource = null;
		String fSource = null;
		
		if (type == vogeltype.VOGEL) {
			vSource = LoadShader.load("shader/vogelsimulationGPU.vs");
			fSource = LoadShader.load("shader/vogelsimulationGPU.fs");
		} else if (type == vogeltype.RAUBVOGEL) {
			vSource = LoadShader.load("shader/raubvogelGPU.vs");
			fSource = LoadShader.load("shader/raubvogelGPU.fs");
		}
		
		int vs = glCreateShader(GL_VERTEX_SHADER);
		glShaderSource(vs, vSource);
		glCompileShader(vs);
		glAttachShader(program, vs);
		
		int fs = glCreateShader(GL_FRAGMENT_SHADER);
		glShaderSource(fs, fSource);
		glCompileShader(fs);
		glAttachShader(program, fs);
		
		glLinkProgram(program);
		return program;
	}
	
	public void transform() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 0, 1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST);
	}
	
	public void renderLoop() {
		glEnable(GL_DEPTH_TEST);
		
		glUseProgram(raubvogelProgram);
		
		while (!Display.isCloseRequested()) {
			glClearColor(0.4941f, 0.7529f, 0.9333f, 1);
			glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);
			
			transform();
			
			double time = System.nanoTime()/1e7;
			glBegin(GL_TRIANGLES);
			glVertex3f(600, 500, 0);
			glVertex3f(400, 100, 0);
			glVertex3f(200, 300, 0);
			glEnd();
			/*
			schwarm.render();
			if ((int)time%1 == 0)
				schwarm.update();
			grosserVogel.render();
			grosserVogel.update();
			*/
			Display.update();
		}
	}
	
	public static void main(String[] args) {
		(new Vogelsimulation()).start();
	}
}
