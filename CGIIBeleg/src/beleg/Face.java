package beleg;

public class Face {
	public Vektor3D vertex = new Vektor3D();
	public Vektor3D normal = new Vektor3D();
	public Face(Vektor3D vertex, Vektor3D normal) {
		
		this.vertex =vertex;
		this.normal = normal;
	}
}
