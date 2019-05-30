package beleg;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Schwarmverhalten implements Verhalten {
	private Vogel vogel;
	private double dist;
	private double max_speed;
	private boolean followMouse;

	public Schwarmverhalten(Vogel vogel, double dist, double max_speed, boolean followMouse) {
		this.vogel = vogel;
		this.dist = dist;
		this.max_speed = max_speed;
		this.followMouse = followMouse;
	}

	public Vektor3D seperation() {
		Vektor3D force = new Vektor3D();
		for (int i = 0; i < vogel.schwarm.getSchwarmgroesse(); i++) {
			Vogel v = vogel.schwarm.getVogel(i);
			try {
				double ed = LineareAlgebra.euklDistance(vogel.pos, v.pos);
				//if (ed == 0) System.out.println("collision");
				if (ed < dist * 2. / 3.)
					force.add(LineareAlgebra.sub(vogel.pos, v.pos));
			} catch (Exception e) {
			}
		}
		try {
			force.normalize();
		} catch (Exception e) {
		}
		
		//if (vogel.id == 0) System.out.println("seperation[" + force.x + ", " + force.y + ", " + force.z + "]");
		return force;
	}

	public Vektor3D ausrichtung() {
		Vektor3D force = new Vektor3D();
		for (int i = 0; i < vogel.schwarm.getSchwarmgroesse(); i++) {
			Vogel v = vogel.schwarm.getVogel(i);
			try {
				if (LineareAlgebra.euklDistance(vogel.pos, v.pos) < dist)
					force.add(v.speed);
			} catch (Exception e) {
			}
		}
		try {
			force.normalize();
		} catch (Exception e) {
		}
		
		//if (vogel.id == 0) System.out.println("ausrichtung[" + force.x + ", " + force.y + ", " + force.z + "]");
		return force;
	}

	public Vektor3D zusammenhalt() {
		Vektor3D force = new Vektor3D();
		for (int i = 0; i < vogel.schwarm.getSchwarmgroesse(); i++) {
			//if (i == vogel.id) continue; 
			Vogel v = vogel.schwarm.getVogel(i);
			try {
				if (LineareAlgebra.euklDistance(vogel.pos, v.pos) < dist)
					force.add(LineareAlgebra.sub(v.pos, vogel.pos));
			} catch (Exception e) {
			}
		}
		try {
			force.normalize();
		} catch (Exception e) {
		}
		
		//if (vogel.id == 0) System.out.println("zusammenhalt[" + force.x + ", " + force.y + ", " + force.z + "]");
		return force;
	}

	public void update() {
		Vektor3D seperation = seperation();
		Vektor3D ausrichtung = ausrichtung();
		Vektor3D zusammenhalt = zusammenhalt();

		double mx = Mouse.getX() / (double)Display.getDisplayMode().getWidth() * 2 - 1;
		double my = Mouse.getY() / (double)Display.getDisplayMode().getHeight() * 2 - 1;
		Vektor3D mouse = new Vektor3D(mx, my, 0);
		//System.out.println("mouse: " + mx + ", " + my);
		
		try {
			mouse.sub(vogel.pos);
			mouse.normalize();
			mouse.mult(1); // 0.8
			
			if (followMouse) vogel.accel.add(mouse);
			
			seperation.mult(1.0); // 1.0
			ausrichtung.mult(0.1); // 0.12
			zusammenhalt.mult(0.1); // 0.01
			
			vogel.accel.add(seperation);
			vogel.accel.add(ausrichtung);
			vogel.accel.add(zusammenhalt);
			
			vogel.speed.add(vogel.accel);
			
			if (vogel.speed.length() > max_speed) {
				vogel.speed = LineareAlgebra.mult(LineareAlgebra.normalize(vogel.speed), max_speed); 
			}
			
			vogel.pos.add(vogel.speed);
			
			vogel.resetAcceleration();
		} catch (Exception e) {
		}
		/*
		if (vogel.pos.x >= 1) {
			vogel.pos.x = 1;
			if (vogel.speed.x > 0) vogel.speed.x = 0;
		}
		if (vogel.pos.x <= -1) {
			vogel.pos.x = -1;
			if (vogel.speed.x < 0) vogel.speed.x = 0;
		}
		if (vogel.pos.y >= 1) {
			vogel.pos.y = 1;
			if (vogel.speed.y > 0) vogel.speed.y = 0;
		}
		if (vogel.pos.y <= -1) {
			vogel.pos.y = -1;
			if (vogel.speed.y < 0) vogel.speed.y = 0;
		}
		*/
	}
}
