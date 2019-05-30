package beleg;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class SchwarmverhaltenMaus implements Verhalten {
	public Schwarmverhalten schwarmverhalten;
	public Vogel vogel;
	public double max_speed;
	
	public SchwarmverhaltenMaus(Vogel vogel, double dist, double max_speed) {
		//schwarmverhalten = new Schwarmverhalten(vogel, dist, max_speed);
		this.vogel = vogel;
		this.max_speed = max_speed;
	}
	
	public void update() {
		
		double mx = Mouse.getX() / (double)Display.getDisplayMode().getWidth() * 2 - 1;
		double my = Mouse.getY() / (double)Display.getDisplayMode().getHeight() * 2 - 1;
		Vektor3D mouse = new Vektor3D(mx, my, 0);
		//System.out.println("mouse: " + mx + ", " + my);
		try {
			mouse.sub(vogel.pos);
			mouse.normalize();
			mouse.mult(1);
			vogel.speed.add(mouse);
			if (vogel.speed.length() > max_speed)
				vogel.speed = LineareAlgebra.mult(LineareAlgebra.normalize(vogel.speed), max_speed);
			vogel.pos.add(vogel.speed);
		} catch (Exception e) {
		}
		
		schwarmverhalten.update();
	}
}
