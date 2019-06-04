package beleg;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
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
		//POGL.renderObjectWithForces((float)pos.x, (float)pos.y, 5, new Vektor2D(speed.x, speed.y), new Vektor2D());

		if (model != null) {
			int size = 5;
			glLoadIdentity();
			glTranslated(pos.x, pos.y, 0);
			glScaled(size, size, size);
			
			glBegin(GL_TRIANGLES);
			for (int i = 0; i < model.faces.size(); i++) {
				Vector3f v1 = model.vertices.get(model.faces.get(i).verticeIndices.get(0)); //IndexOutOfBoundsException
				Vector3f v2 = model.vertices.get(model.faces.get(i).verticeIndices.get(1));
				Vector3f v3 = model.vertices.get(model.faces.get(i).verticeIndices.get(2));
				glVertex3f(v1.x, v1.y, v1.z);
				glVertex3f(v2.x, v2.y, v2.z);
				glVertex3f(v3.x, v3.y, v3.z);
				//System.out.println("v1[" + v1.x + ", " + v1.y + ", " + v1.z + "]");
				//System.out.println("v2[" + v2.x + ", " + v2.y + ", " + v2.z + "]");
				//System.out.println("v3[" + v3.x + ", " + v3.y + ", " + v3.z + "]");
			}
			glEnd();
		} else {
			float size = 10;
			
			glLoadIdentity();
			glTranslated(pos.x, pos.y, 0);
			glScaled(size, size, size);
			
			glBegin(GL_TRIANGLE_FAN);
			float angleIncrement = 360.0f / 5;  // n is 5 in your case
			angleIncrement *= Math.PI / 180.0f;    // convert degrees to radians
			float angle = 0.0f;
			float radius = 1.f;
			for (int k = 0; k < 5; ++k) {
				glVertex3f((float)(radius * Math.cos(angle)), (float)(radius * Math.sin(angle)), 0);
			    angle += angleIncrement;
			}
			glEnd();
		}
	}
}
