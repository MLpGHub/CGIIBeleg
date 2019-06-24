package beleg;

import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Raubvogelverhalten implements Verhalten {
	private Raubvogel raubvogel;
	private Vogelschwarm schwarm;
	private double min_speed;
	private double max_speed;
	private Vektor3D accel;
	
	public Raubvogelverhalten(Raubvogel raubvogel, Vogelschwarm schwarm, double min_speed, double max_speed) {
		this.raubvogel = raubvogel;
		this.schwarm = schwarm;
		this.min_speed = min_speed;
		this.max_speed = max_speed;
		this.accel = new Vektor3D();
	}

	public Vektor3D folgeMaus() {
		double mx = Mouse.getX();
		double my = Display.getDisplayMode().getHeight() - Mouse.getY();
		Vektor3D mouse = new Vektor3D(mx, my, 0);
		try {
			mouse.sub(raubvogel.pos);
			mouse.normalize();
		} catch (Exception e) {
		}
		return mouse;
	}
	
	public Vektor3D tastatursteuerung() {
		Vektor3D force = new Vektor3D();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W)) {
			try {
				force.add(LineareAlgebra.normalize(raubvogel.speed));
			} catch (Exception e) {
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S)) {
			try {
				force.add(LineareAlgebra.normalize(LineareAlgebra.negate(raubvogel.speed)));
			} catch (Exception e) {
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A)) {
			try {
				Vektor3D sp = raubvogel.speed;
				double a = - Math.PI / 2;
				double x = sp.x * Math.cos(a) - sp.y * Math.sin(a);
				double y = sp.x * Math.sin(a) + sp.y * Math.cos(a);
				force.add(new Vektor3D(x, y, 0));
			} catch (Exception e) {
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D)) {
			try {
				Vektor3D sp = raubvogel.speed;
				double a = + Math.PI / 2;
				double x = sp.x * Math.cos(a) - sp.y * Math.sin(a);
				double y = sp.x * Math.sin(a) + sp.y * Math.cos(a);
				force.add(new Vektor3D(x, y, 0));
			} catch (Exception e) {
			}
		}
		
		try {
			force.normalize();
		} catch (Exception e) {
		}
		
		return force;
	}
	
	public void resetAcceleration() {
		try {
			accel.mult(0);
		} catch (Exception e) {}
	}
	
	public void frissDenVogel() {
		Vektor3D pos = raubvogel.pos;
		int schwarmgroesse = schwarm.getSchwarmgroesse();
		for (int i = 0; i < schwarmgroesse; i++) {
			Vogel v = schwarm.getVogel(i);
			if (v.gefressen) continue;
			try {
				double dist = LineareAlgebra.euklDistance(pos, v.pos);
				if (dist < 10) {
					v.setGefressen(true);
					i--;
					schwarmgroesse--;
					raubvogel.mageninhalt++;
				}
			} catch (Exception e) {
			}
		}
	}
	
	@Override
	public void update() {
		Vektor3D tasten = tastatursteuerung();
		
		try {
			tasten.mult(0.8);
			accel.add(tasten);
			
			raubvogel.speed.add(LineareAlgebra.mult(accel, 0.0005));
			double length = raubvogel.speed.length();
			if (length < min_speed) raubvogel.speed = LineareAlgebra.mult(LineareAlgebra.normalize(raubvogel.speed), min_speed);
			else if (length > max_speed) raubvogel.speed = LineareAlgebra.mult(LineareAlgebra.normalize(raubvogel.speed), max_speed);
			
			raubvogel.pos.add(raubvogel.speed);
			resetAcceleration();
		} catch (Exception e) {
		}
		
		frissDenVogel();
		//if mageninhalt == 200 -> stop
	}
}
