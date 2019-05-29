package beleg;

import java.io.*;
import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;

//http://paulbourke.net/dataformats/obj/
//https://www.youtube.com/watch?v=izKAvSV3qk0&list=PL19F2453814E0E315&index=24

public class OBJLoader {
	private OBJLoader() {
	};
	
	public static Model loadModel(File f) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(f));
		Model m = new Model();
		String line;
		while ((line = reader.readLine()) != null) { //parsing all vertices and indices
			if (line.startsWith("v ")) {
				float x = Float.valueOf(line.split(" ")[1]);
				float y = Float.valueOf(line.split(" ")[2]);
				float z = Float.valueOf(line.split(" ")[3]);
				m.vertices.add(new Vector3f(x, y, z));
			} else if (line.startsWith("vn ")) {
				float x = Float.valueOf(line.split(" ")[1]);
				float y = Float.valueOf(line.split(" ")[2]);
				float z = Float.valueOf(line.split(" ")[3]);
				m.normals.add(new Vector3f(x, y, z));
			} else if (line.startsWith("f ")) {
				ArrayList<Integer> vertexIndices = new ArrayList<Integer>();
				vertexIndices.add(Integer.valueOf(line.split(" ")[1].split("//")[0]));
				vertexIndices.add(Integer.valueOf(line.split(" ")[2].split("//")[0]));
				vertexIndices.add(Integer.valueOf(line.split(" ")[3].split("//")[0]));
				int normalIndex = Integer.valueOf(line.split(" ")[1].split("//")[1]);
				m.faces.add(new Face(vertexIndices, normalIndex));
			}
		}
		return m;
	}

}
