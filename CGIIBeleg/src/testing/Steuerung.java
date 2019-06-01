package testing;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Steuerung {
	private Vektor3D beschleunigung;
	
	public Steuerung() {
		this.beschleunigung = new Vektor3D();
	}
	
	public void resetBeschleunigung() {
		try {
			this.beschleunigung.mult(0);
		} catch (Exception e) {
		}
	}
	
	public Vektor3D folgeMaus(Vektor3D aktPos) {
		Vektor3D maus = new Vektor3D(Mouse.getX(), Display.getDisplayMode().getHeight() - Mouse.getY(), 0);
		try {
			maus.sub(aktPos);
			maus.normalize();
		} catch (Exception e) {
		}
		
		return maus;
	}
	
	public Vektor3D seperation(Vogel v, double dist) {
		//
		return null;
	}
	
	public Vektor3D ausrichtung(Vogel v, double dist) {
		//
		return null;
	}
	
	public Vektor3D zusammenhalt(Vogel v, double dist) {
		//
		return null;
	}
}
