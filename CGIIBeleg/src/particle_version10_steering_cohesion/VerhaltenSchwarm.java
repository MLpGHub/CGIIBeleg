package particle_version10_steering_cohesion;

import beleg.LineareAlgebra;
import beleg.Vektor2D;

public class VerhaltenSchwarm implements Verhalten {
	private Flummi flummi;
	private Steuerungsverhalten steering;
	private final float MAX_VELOCITY = 5;

	public VerhaltenSchwarm(Flummi flummi) {
		this.flummi = flummi;
		this.steering = new Steuerungsverhalten();
	}

	@Override
	public void update() {
		Vektor2D mausForce = steering.followMousePosition(flummi.position);
		try {
			mausForce.mult(0.8);
		} catch (Exception e) {
		}
		steering.applyForce(mausForce);
		
		Vektor2D separationForce = steering.separation(flummi, 10);
		try {
			separationForce.mult(1.0);
		} catch (Exception e) {
		}
		steering.applyForce(separationForce);
		Vektor2D alignmentForce = steering.alignment(flummi, 15);
		try {
			alignmentForce.mult(0.12);
		} catch (Exception e) {
		}
		steering.applyForce(alignmentForce);
		
		Vektor2D cohesionForce = steering.cohesion(flummi, 15);
		try {
			cohesionForce.mult(0.01);
		} catch (Exception e) {
		}
		steering.applyForce(cohesionForce);
		
		try {
			flummi.velocity.add(steering.acceleration);
			//flummi.velocity.truncate(MAX_VELOCITY);{
			flummi.velocity = LineareAlgebra.mult(LineareAlgebra.normalize(flummi.velocity), (double)MAX_VELOCITY);
			flummi.position.add(flummi.velocity);
		} catch (Exception e) {
		}

		steering.resetAcceleration();
	}
}
