package testing;

public abstract class BasisObjekt {
	public int id;
	public Vektor3D pos;
	
	public BasisObjekt() {
		this(0, 0, 0, 0);
	}
	
	public BasisObjekt(int id, double xpos, double ypos, double zpos) {
		this.id = id;
		this.pos = new Vektor3D(xpos, ypos, zpos);
	}
	
	public BasisObjekt(int id, Vektor3D pos) {
		this.id = id;
		this.pos = new Vektor3D(pos);
	}
	
	public abstract void render();
}
