package beleg;

import java.util.ArrayList;
import org.lwjgl.*;
import org.lwjgl.util.vector.Vector3f;

public class Model {
	public ArrayList<Vector3f> vertices;
	public ArrayList<Vector3f> normals;
	public ArrayList<Face> faces;
	
	public Model() {
		vertices = new ArrayList<Vector3f>();
		normals = new ArrayList<Vector3f>();
		faces = new ArrayList<Face>();
	}

}
