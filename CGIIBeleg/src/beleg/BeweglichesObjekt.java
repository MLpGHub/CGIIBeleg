package beleg;

public abstract class BeweglichesObjekt extends BasisObjekt {
	public Vektor3D speed;
	public Vektor3D accel;
	public Verhalten verhalten;
	
	public BeweglichesObjekt() {
		this(0, new Vektor3D(0, 0, 0), new Vektor3D(0, 0, 0), new Vektor3D(0, 0, 0));
	}
	
	public BeweglichesObjekt(int id, double xpos, double ypos, double zpos, double xspeed, double yspeed, double zspeed, 
			double xaccel, double yaccel, double zaccel) {
		super(id, xpos, ypos, zpos);
		this.speed = new Vektor3D(xspeed, yspeed, zspeed);
		this.accel = new Vektor3D(xaccel, yaccel, zaccel);
		setVerhalten(null);
	}
	
	public BeweglichesObjekt(int id, Vektor3D pos, Vektor3D speed, Vektor3D accel) {
		super(id, pos);
		this.speed = new Vektor3D(speed);
		this.accel = new Vektor3D(accel);
		setVerhalten(null);
	}
	
	public void setVerhalten(Verhalten v) {
		this.verhalten = v;
	}
	
	public abstract void update();
}
