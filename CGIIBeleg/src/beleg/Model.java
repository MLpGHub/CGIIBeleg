package beleg;

//https://www.youtube.com/watch?v=izKAvSV3qk0&list=PL19F2453814E0E315&index=24

/**
 * Klasse für allgemeine obj Dateien
 * 
 */
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.*;

public class Model {
	public List<Vektor3D> vertices = new ArrayList<Vektor3D>();
	public List<Vektor3D> normals = new ArrayList<Vektor3D>();
	public List<Face> faces = new ArrayList<Face>();
	
	public Model() {
		
	}

}
