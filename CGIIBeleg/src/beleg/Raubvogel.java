package beleg;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScaled;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.util.vector.Vector3f;

public class Raubvogel extends BeweglichesObjekt {
	public Model model;
	int mageninhalt; //[Vögel]
	
	public Raubvogel(int id, Vektor3D pos, Vektor3D speed, Model model) {
		super(id, pos, speed);
		this.model = model;
		this.mageninhalt = 0;
	}
	
	@Override
	public void render() {
		int angle = 0;
		try {
			angle = (int)LineareAlgebra.angleDegree(new Vektor3D(1, 0, 0), speed);
			if (speed.y < 0) angle = 360 - angle;
		} catch (Exception e) {
		}
		
		if (model != null) {
			int size = 25;
			glLoadIdentity();
			glTranslated(pos.x, pos.y, 0);
			glScaled(size, size, size);
			glRotatef((float)angle, 0, 0, 1.f);
			
			glBegin(GL_TRIANGLES);
			for (int i = 0; i < model.faces.size(); i++) {
				Vector3f v1 = null;
				Vector3f v2 = null;
				Vector3f v3 = null;
				Face f = model.faces.get(i);
				try {
					int index = f.verticeIndices.get(0);
					v1 = model.vertices.get(index-1);
				} catch (IndexOutOfBoundsException iobe) {
					System.out.println("v1");
				}
				try {
					int index = f.verticeIndices.get(1);
					v2 = model.vertices.get(index-1);
				} catch (IndexOutOfBoundsException iobe) {
					System.out.println("v2");
				}
				try {
					int index = f.verticeIndices.get(2);
					v3 = model.vertices.get(index-1);
				} catch (IndexOutOfBoundsException iobe) {
					System.out.println("v3, " + i + ", size: " + model.faces.size());
				}
				glVertex3f(v1.x, v1.y, v1.z);
				glVertex3f(v2.x, v2.y, v2.z);
				glVertex3f(v3.x, v3.y, v3.z);
			}
			glEnd();
		} else {
			float size = 10;
			
			glLoadIdentity();
			glTranslated(pos.x, pos.y, 0);
			glScaled(size, size, size);
			glRotatef((float)angle, 0, 0, 1.f);
			
			glBegin(GL_TRIANGLE_FAN);
			float angleIncrement = 360.0f / 5;  // n is 5 in your case
			angleIncrement *= Math.PI / 180.0f;    // convert degrees to radians
			float ang = 0.0f;
			float radius = 1.f;
			for (int k = 0; k < 5; ++k) {
				glVertex3f((float)(radius * Math.cos(ang)), (float)(radius * Math.sin(ang)), 0);
			    ang += angleIncrement;
			}
			glEnd();
		}
	}
}
