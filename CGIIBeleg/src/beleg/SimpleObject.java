package beleg;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class SimpleObject extends BeweglichesObjekt {
	public SimpleObject() {
		super();
		try { this.speed.add(new Vektor3D(0.0005, 0, 0)); } catch (Exception e) {}
	}
	
	public void render() {
		float tip = 0.3f;
		glBegin(GL_TRIANGLE_FAN);
		glVertex3f((float)this.pos.x, 0.1f, 0);
		glVertex3f((float)this.pos.x, -0.1f, 0);
		if (this.speed.x < 0) tip = -tip;
		glVertex3f((float)this.pos.x + tip, 0, 0);
		glEnd();
	}
	
	public void update() {
		if (this.verhalten == null) {
			try {
				this.pos.add(this.speed);
			} catch (Exception e) {}
			return;
		} else {
			this.verhalten.update();
		}
		this.render();
	}
}
