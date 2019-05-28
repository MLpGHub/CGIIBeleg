package beleg;

public class Schwarmverhalten implements Verhalten {
	private Vogel vogel;
	private double dist;
	private double max_speed;

	public Schwarmverhalten(Vogel vogel, double dist, double max_speed) {
		this.vogel = vogel;
		this.dist = dist;
		this.max_speed = max_speed;
	}

	public Vektor3D seperation() {
		Vektor3D force = new Vektor3D();
		for (int i = 0; i < vogel.schwarm.getSchwarmgroesse(); i++) {
			Vogel v = vogel.schwarm.getVogel(i);
			try {
				if (LineareAlgebra.euklDistance(vogel.pos, v.pos) < dist)
					force.add(LineareAlgebra.sub(vogel.pos, v.pos));
			} catch (Exception e) {
			}
		}
		try {
			force.normalize();
		} catch (Exception e) {
		}
		
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
		
		return force;
	}

	public void update() {
		Vektor3D seperation = seperation();
		Vektor3D ausrichtung = ausrichtung();
		Vektor3D zusammenhalt = zusammenhalt();

		try {
			seperation.mult(1.0);
			ausrichtung.mult(0.12);
			zusammenhalt.mult(0.01);

			vogel.speed.add(seperation);
			vogel.speed.add(ausrichtung);
			vogel.speed.add(zusammenhalt);
			if (vogel.speed.length() > max_speed) {
				vogel.speed = LineareAlgebra.mult(LineareAlgebra.normalize(vogel.speed), max_speed); 
			}
			vogel.pos.add(vogel.speed);
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
