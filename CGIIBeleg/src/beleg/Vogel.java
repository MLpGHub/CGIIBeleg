package beleg;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glScaled;
import static org.lwjgl.opengl.GL11.glTranslated;

import org.lwjgl.util.vector.Vector3f;

public class Vogel extends BeweglichesObjekt {
	public Vogelschwarm schwarm;
	public Raubvogel raubvogel;
	public Model model;
	public boolean gefressen;
	
	public Vogel(int id, Vektor3D pos, Vektor3D speed, Vogelschwarm schwarm, Model model) {
		super(id, pos, speed);
		this.schwarm = schwarm;
		this.model = model;
		this.gefressen = false;
	}
	
	public void setGefressen(boolean b) {
		this.gefressen = b;
	}
	
	@Override
	public void update() {
		if (verhalten != null) {
			if (!gefressen) verhalten.update();
		}
	}
	
	public void render() {
		if (gefressen) return;
		float px = (float)pos.x;
		float py = (float)pos.y;
		float pz = (float)pos.z;
		int angle = 0;
		
		try {
			angle = (int)LineareAlgebra.angleDegree(new Vektor3D(1, 0, 0), speed);
			if (speed.y < 0) angle = 360 - angle;
			
		} catch (Exception e) {
		}
		
		if (model != null) {
			glBegin(GL_TRIANGLES);
			for (int i = 0; i < model.faces.size(); i++) {
				Vector3f v1 = model.vertices.get(model.faces.get(i).verticeIndices.get(0));
				Vector3f v2 = model.vertices.get(model.faces.get(i).verticeIndices.get(0));
				Vector3f v3 = model.vertices.get(model.faces.get(i).verticeIndices.get(0));
				glVertex3f(v1.x, v1.y, v1.z);
				glVertex3f(v2.x, v2.y, v2.z);
				glVertex3f(v3.x, v3.y, v3.z);
				/*
				System.out.println("v1[" + v1.x + ", " + v1.y + ", " + v1.z + "]");
				System.out.println("v2[" + v2.x + ", " + v2.y + ", " + v2.z + "]");
				System.out.println("v3[" + v3.x + ", " + v3.y + ", " + v3.z + "]");
				*/
			}
			glEnd();
		} else {
			//POGL.renderObjectWithForces((float)pos.x, (float)pos.y, 3, new Vektor2D(speed.x, speed.y), new Vektor2D());
			
			float size = 8;
			glLoadIdentity();
			glTranslated(pos.x, pos.y, 0);
			glScaled(size, size, size);
			
			glBegin(GL_TRIANGLES);
			
			glVertex3f(0, 0.5f, 0);
			glVertex3f(0, -0.5f, 0);
			glVertex3f(1.f, 0, 0);
			
			/*
			glVertex3f(-(float)Math.sin(angle) * 0.5f, (float)Math.sin(angle) * 0.5f, 0);
			glVertex3f(-(float)Math.sin(angle) * (-0.5f), (float)Math.sin(angle) * (-0.5f), 0);
			glVertex3f((float)Math.cos(angle) * 1.f, (float)Math.sin(angle) * 1.f, 0);
			*/
			glEnd();
			
		}
	}
}
