package beleg;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glFrustum;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;

import org.lwjgl.opengl.Display;

//https://www.khronos.org/opengl/wiki/Main_Page

public class PentagonDepth extends LWJGLFenster {
	private String vertexSource = LoadShader.load("shader/vShader.vs");
	private String fragmentSource = LoadShader.load("shader/fShader.fs");
	
	public PentagonDepth() {
		super("TriangleDepth", 1200, 800);
		initDisplay();
	}
	
	public void prepareShader() {
		int program = glCreateProgram();
		
		int vertexShader = glCreateShader(GL_VERTEX_SHADER);
		glShaderSource(vertexShader, vertexSource);
		glCompileShader(vertexShader);
		glAttachShader(program, vertexShader);
		
		int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
		glShaderSource(fragmentShader, fragmentSource);
		glCompileShader(fragmentShader);
		glAttachShader(program, fragmentShader);
		
		glLinkProgram(program);
		glUseProgram(program);
	}
	
	public void transformation(double now) {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity(); //load identity matrix
		
        double r = 600 * 1. / 800;
        glFrustum(-1, 1, -r, r, 1, 20); //perspective projection?
        glMatrixMode(GL_MODELVIEW);

        glLoadIdentity();

        glTranslated(0, 0, -3);
        glRotatef((float) now * 5.0f, 0, 0, 1);
        glRotatef(10 * (float) now * 5.0f, 1, 0, 0);
	}
	
	public void renderLoop() {
		prepareShader();
		glEnable(GL_DEPTH_TEST); //https://www.khronos.org/opengl/wiki/Depth_Test
		long start = System.nanoTime(); //start value for variable operations
		float[] bColor = { 0.2f, 0.2f, 0.2f, 1.f}; //background color as array
		
		while (!Display.isCloseRequested()) {
			double now = (System.nanoTime() - start) / 1e9; //nice changing values
			
			glClearColor(bColor[0], bColor[1], bColor[2], bColor[3]);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); //clear the color and depth buffer
			
			//some transformations
			transformation(now);
			
			/*
			//triangle
			glBegin(GL_TRIANGLE_STRIP);
			glVertex3f(-0.5f, 0, 0);
			glVertex3f(0, 0.8f, 0);
			glVertex3f(0.5f, 0, 0);
			glEnd();
			*/
			
			glBegin(GL_TRIANGLE_FAN);
			float angleIncrement = 360.0f / 5;  // n is 5 in your case
			angleIncrement *= Math.PI / 180.0f;    // convert degrees to radians
			float angle = 0.0f;
			float radius = 1.f;
			for (int k = 0; k < 5; ++k) {
			    glVertex3f((float)(radius * Math.cos(angle)), (float)(radius * Math.sin(angle)), 0.0f);
			    angle += angleIncrement;
			}
			glEnd();
			
			Display.update();
		}
	}
	
	public static void main(String[] args) {
		new PentagonDepth().start();
	}
}
