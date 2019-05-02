package beleg;

import beleg.Vektor2D;
import beleg.Vektor3D;
import beleg.LineareAlgebra;

public class Driver {
	public static void main(String[] args) {
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor3D v2 = new Vektor3D(1, 2, 3);
		try {
			v1 = LineareAlgebra.abs(v1);
			v2 = LineareAlgebra.abs(v2);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("running");
	}
}
