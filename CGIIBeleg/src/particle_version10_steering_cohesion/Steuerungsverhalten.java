package particle_version10_steering_cohesion;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import beleg.Vektor2D;
import beleg.LineareAlgebra;

public class Steuerungsverhalten {
	public Vektor2D acceleration;
	private Random zuf = ThreadLocalRandom.current();

	public Steuerungsverhalten() {
		acceleration = new Vektor2D(0, 0);
	}

	public void resetAcceleration() {
		try {
			acceleration.mult(0);
		} catch (Exception e) {
		}
	}

	public void applyForce(Vektor2D force) {
		Vektor2D forceHelp = new Vektor2D(force);
		try {
			acceleration.add(forceHelp);
		} catch (Exception e) {
		}
	}

	public Vektor2D randomForce() {
		return new Vektor2D(zuf.nextFloat() * 10 - 5, zuf.nextFloat() * 10 - 5);
	}

	public Vektor2D followMousePosition(Vektor2D currentPosition) {
		Vektor2D mousePosition = new Vektor2D(Mouse.getX(), Display.getDisplayMode().getHeight() - Mouse.getY());
		try {
			mousePosition.sub(currentPosition);
			mousePosition.normalize();
		} catch (Exception e) {
		}
		return mousePosition;
	}

	public Vektor2D separation(Flummi me, float dist) {
		Vektor2D steeringForce = new Vektor2D(0, 0);
		for (int i = 0; i < me.objektManager.getFlummiSize(); i++) {
			if (me.id == i)
				continue;

			BasisObjekt bObj = me.objektManager.getFlummi(i);
			if (bObj instanceof Flummi) {
				Flummi bObjF = (Flummi)bObj;
				try {
					if (LineareAlgebra.euklDistance(me.position, bObjF.position) == 0)
						System.out.println("collision");
					if (LineareAlgebra.euklDistance(me.position, bObjF.position) < dist)
						steeringForce.add(LineareAlgebra.sub(me.position, bObjF.position));
				} catch (Exception e) {
				}
					
			}
		}
		try {
			LineareAlgebra.normalize(steeringForce);
		} catch (Exception e) {
		}
		return steeringForce;
	}

	public Vektor2D alignment(Flummi me, float dist) {
		Vektor2D steeringForce = new Vektor2D(0, 0);
		for (int i = 0; i < me.objektManager.getFlummiSize(); i++) {
			if (me.id == i)
				continue;

			BasisObjekt bObj = me.objektManager.getFlummi(i);
			if (bObj instanceof Flummi) {
				Flummi bObjF = (Flummi)bObj;
				try {
					if (LineareAlgebra.euklDistance(me.position, bObjF.position) < dist)
						steeringForce.add(bObjF.velocity);
				} catch (Exception e) {
				}
			}
		}

		try {
			LineareAlgebra.normalize(steeringForce);
		} catch (Exception e) {
		}
		return steeringForce;
	}

	public Vektor2D cohesion(Flummi me, float dist) {
		Vektor2D steeringForce = new Vektor2D(0, 0);
		for (int i = 0; i < me.objektManager.getFlummiSize(); i++) {
			if (me.id == i)
				continue;

			BasisObjekt bObj = me.objektManager.getFlummi(i);
			if (bObj instanceof Flummi) {
				Flummi bObjF = (Flummi)bObj;
				try {
					if (LineareAlgebra.euklDistance(me.position, bObjF.position) < dist)
						steeringForce.add(LineareAlgebra.sub(bObjF.position, me.position));
				} catch (Exception e) {
				}
			}
		}

		try {
			LineareAlgebra.normalize(steeringForce);
		} catch (Exception e) {
		}
		return steeringForce;
	}
}
