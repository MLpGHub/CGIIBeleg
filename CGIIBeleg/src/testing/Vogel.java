package testing;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Vogel extends BeweglichesObjekt {
	public Vogelschwarm vogelschwarm;
	
	public Vogel(int id, Vektor3D pos, Vektor3D speed, Verhalten verhalten, Vogelschwarm vogelschwarm) {
		super(id, pos, speed);
		this.vogelschwarm = vogelschwarm;
		this.setVerhalten(verhalten);
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
}
