package beleg;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Schwarmverhalten implements Verhalten {
	private Vogel vogel;
	private Raubvogel raubvogel;
	private double dist;
	private double min_speed;
	private double max_speed;
	private boolean followMouse;
	private Vektor3D accel;

	public Schwarmverhalten(Vogel vogel, Raubvogel raubvogel, double dist, double min_speed, double max_speed, boolean followMouse) {
		this.vogel = vogel;
		this.dist = dist;
		this.min_speed = min_speed;
		this.max_speed = max_speed;
		this.followMouse = followMouse;
		this.accel = new Vektor3D();
	}

	public Vektor3D seperation() {
		Vektor3D force = new Vektor3D();
		for (int i = 0; i < vogel.schwarm.getSchwarmgroesse(); i++) {
			if (vogel.id == i) continue;
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
			if (vogel.id == i) continue;
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
			if (i == vogel.id) continue; 
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
	
	public Vektor3D folgeMaus() {
		double mx = Mouse.getX();
		double my = Display.getDisplayMode().getHeight() - Mouse.getY();
		Vektor3D mouse = new Vektor3D(mx, my, 0);
		try {
			mouse.sub(vogel.pos);
			mouse.normalize();
		} catch (Exception e) {
		}
		return mouse;
	}
	
	public Vektor3D flieheVorRaubvogel() {
		Vektor3D force = new Vektor3D();
		int max = 15 * (int)dist;
		try {
			int dis = (int)LineareAlgebra.euklDistance(vogel.pos, raubvogel.pos);
			if (dis < max) {
				force.add(LineareAlgebra.sub(vogel.pos, raubvogel.pos));
				force.normalize();
				dis = -dis + max;
				if (dis >= 20)  {
					force.mult((double) dis / (double) max);
				}
			}
		} catch (Exception e) {
		}
		return force;
	}
	
	public void resetAcceleration() {
		try {
			accel.mult(0);
		} catch (Exception e) {}
	}

	public void update() {
		Vektor3D maus = folgeMaus();
		Vektor3D seperation = seperation();
		Vektor3D ausrichtung = ausrichtung();
		Vektor3D zusammenhalt = zusammenhalt();
		Vektor3D raubvogel = flieheVorRaubvogel();
		
		try {
			maus.mult(0.8); // 0.8
			seperation.mult(1.0); // 1.0
			ausrichtung.mult(0.12); // 0.12
			zusammenhalt.mult(0.01); // 0.01
			raubvogel.mult(1.0); //??
			
			if (followMouse) accel.add(maus);
			accel.add(seperation);
			accel.add(ausrichtung);
			accel.add(zusammenhalt);
			accel.add(raubvogel);
			
			vogel.speed.add(accel);
			
			double length = vogel.speed.length();
			
			//max bzw. min speed evtl. hier
			vogel.speed = LineareAlgebra.mult(LineareAlgebra.normalize(vogel.speed), max_speed);
			
			vogel.pos.add(vogel.speed);
			
			resetAcceleration();
		} catch (Exception e) {
		}
	}
}
