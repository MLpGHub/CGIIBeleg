package beleg;

import java.util.ArrayList;

public class Face {
	public ArrayList<Integer> verticeIndices;
	public int normalIndex;
	
	public Face(ArrayList<Integer> verticeIndices, int normalIndex) {
		this.verticeIndices = verticeIndices;
		this.normalIndex = normalIndex;
	}
}
