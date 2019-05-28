package beleg;

import java.io.*;

public class OBJLoader {
	public static Model loadModel(File f) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferReader(new FileReader(f));
		Model m =  new Model();
		String line;
		while(line = reader.readLine()) != null){
			//parse
			if (line.startsWith("v ")) {
				float x = Float.valueOf(line.split("")[1]);
				float y = Float.valueOf(line.split("")[2]);
				float z = Float.valueOf(line.split("")[3]);
				m.vertices.add(new Vektor3D(x,y,z));
						
			}else if (line.startsWith("vn ")){
				
				float x = Float.valueOf(line.split("")[1]);
				float y = Float.valueOf(line.split("")[2]);
				float z = Float.valueOf(line.split("")[3]);
				m.normals.add(new Vektor3D(x,y,z));
			}else if (line.startsWith("f ")){
				
			Vektor3D vertexIndices = new Vektor3D(
					Float.valueOf(line.split(" ")[1].split("/")[0]),
					Float.valueOf(line.split(" ")[2]).split("/")[0]),
					Float.valueOf(line.split("")[3]).split("/")[0]));
			Vektor3D normalIndices = new Vektor3D(
					Float.valueOf(line.split(" ")[1].split("/")[0]),
					Float.valueOf(line.split(" ")[2]).split("/")[0]),
					Float.valueOf(line.split("")[3]).split("/")[0])); 
		}
		return m;
		}
	}

}
