package belegGPU;

public abstract class BeweglichesObjekt extends BasisObjekt {
	public Vektor3D speed;
	public Verhalten verhalten;
	
	public BeweglichesObjekt() {
		this(0, new Vektor3D(0, 0, 0), new Vektor3D(0, 0, 0));
	}
	
	public BeweglichesObjekt(int id, double xpos, double ypos, double zpos, double xspeed, double yspeed, double zspeed) {
		super(id, xpos, ypos, zpos);
		this.speed = new Vektor3D(xspeed, yspeed, zspeed);
		setVerhalten(null);
	}
	
	public BeweglichesObjekt(int id, Vektor3D pos, Vektor3D speed) {
		super(id, pos);
		this.speed = new Vektor3D(speed);
		setVerhalten(null);
	}
	
	public void setVerhalten(Verhalten v) {
		this.verhalten = v;
	}
	
	public void update() {
		if (verhalten != null) verhalten.update();
		else {
			try {
				pos.add(speed);
			} catch (Exception e) {
			}
		}
	}
}
