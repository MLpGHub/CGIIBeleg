package beleg;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Vogel extends BeweglichesObjekt {
	public Vogelschwarm schwarm;
	
	public Vogel(int id, Vektor3D pos, Vektor3D speed, Vektor3D accel, Vogelschwarm schwarm) {
		super(id, pos, speed, accel);
		this.schwarm = schwarm;
	}
	
	public void render() {
		float px = (float)pos.x;
		float py = (float)pos.y;
		float pz = (float)pos.z;
		
		glBegin(GL_TRIANGLES);
		glVertex3f(px, py + 0.01f, pz);
		glVertex3f(px, py - 0.01f, pz);
		glVertex3f(px + 0.02f, py, pz);
		glEnd();
	}
	
	public void update() {
		if (verhalten != null) verhalten.update();
	}
}
