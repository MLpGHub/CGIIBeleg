package beleg;

public class LineareAlgebra {
	public static Vektor2D add(Vektor2D v1, Vektor2D v2) {
		Vektor2D v = new Vektor2D(v1);
		v.add(v2);
		return v;
	}
	
	public static Vektor3D add(Vektor3D v1, Vektor3D v2) {
		Vektor3D v = new Vektor3D(v1);
		v.add(v2);
		return v;
	}
	
	public static Vektor2D sub(Vektor2D v1, Vektor2D v2) {
		Vektor2D v = new Vektor2D(v1);
		v.sub(v2);
		return v;
	}
	
	public static Vektor3D sub(Vektor3D v1, Vektor3D v2) {
		Vektor3D v = new Vektor3D(v1);
		v.sub(v2);
		return v;
	}
	
	public static Vektor2D mult(Vektor2D v, double d) {
		Vektor2D v = new Vektor2D(v1);
		v.mult(v2);
		return v;
	}
	
	public static Vektor3D mult(Vektor3D v, double d) {
		Vektor3D v = new Vektor3D(v1);
		v.mult(v2);
		return v;
	}

	public static Vektor2D div(Vektor2D v, double d) {
		Vektor2D v = new Vektor2D(v1);
		v.div(v2);
		return v;
	}
	
	public static Vektor3D div(Vektor3D v, double d) {
		Vektor3D v = new Vektor3D(v1);
		v.div(v2);
		return v;
	}

	public static boolean isEqual(Vektor2D v1, Vektor2D v2) {
		return v1.isEqual(v2);
	}
	
	public static boolean isEqual(Vektor3D v1, Vektor3D v2) {
		return v1.isEqual(v2);
	}
	
	public static boolean isNotEqual(Vektor2D v1, Vektor2D v2) {
		return v1.isNotEqual(v2);
	}
	
	public static boolean isNotEqual(Vektor3D v1, Vektor3D v2) {
		return v1.isNotEqual(v2);
	}

	public static double length(Vektor2D v) {
		return v.length();
	}
	
	public static double length(Vektor3D v) {
		return v.length();
	}

	public static Vektor2D normalize(Vektor2D v) {
		Vektor2D tmp = new Vektor2D(v);
		tmp.normalize();
		return tmp;
		//return new Vektor2D(v).normalize();
	}
	
	public static Vektor3D normalize(Vektor3D v) {
		Vektor3D tmp = new Vektor3D(v);
		tmp.normalize();
		return tmp;
		//return new Vektor3D(v).normalize();
	}
	
	public static double euklDistance(Vektor2D v1, Vektor2D v2) {

	}
	
	public static double euklDistance(Vektor3D v1, Vektor3D v2) {

	}

	public static double manhattenDistance(Vektor2D v) {
		return Math.abs(v.x) + Math.abs(v.y);
	}
	
	public static double manhattenDistance(Vektor3D v) {
		return Math.abs(v.x) + Math.abs(v.y) + Math.abs(v.z);
	}


	public static Vektor3D crossProduct(Vektor3D v1, Vektor3D v2) {
		double x = v1.y * v2.z - v1.z * v2.y;
		double y = v1.z * v2.x - v1.x * v2.z;
		double z = v1.x * v2.y - v1.y * v2.x;
		return new Vektor3D(x, y, z);
	}

	public static double dotProduct(Vektor2D v1, Vektor2D v2) {
		return v1.x * v2.x + v1.y * v2.y;
	}
	
	public static double dotProduct(Vektor3D v1, Vektor3D v2) {
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}

	public static double cosEquation(Vektor2D v1, Vektor2D v2) {
		return dotProduct(v1, v2) / (length(v1) * length(v2));
	}
	
	public static double cosEquation(Vektor3D v1, Vektor3D v2) {
		return dotProduct(v1, v2) / (length(v1) * length(v2));
	}

	public static double sinEquation(Vektor2D v1, Vektor2D v2) {
		//return determinante(crossProduct(v1, v2)) / (length(v1) * length(v2));
	}
	
	public static double sinEquation(Vektor3D v1, Vektor3D v2) {// der Sinus des Winkel

	}

	public static double angleRad(Vektor2D v1, Vektor2D v2) {// der Winkel in Rad
		return Math.acos(cosEquation(v1, v2));
	}
	
	public static double angleRad(Vektor3D v1, Vektor3D v2) {// der Winkel in Rad
		return Math.acos(cosEquation(v1, v2));
	}

	public static double angleDegree(Vektor2D v1, Vektor2D v2) {
		return radToDegree(angleRad(v1, v2));
	}

	public static double angleDegree(Vektor3D v1, Vektor3D v2) {
		return radToDegree(angleRad(v1, v2));
	}

	public static double radToDegree(double ang) {
		return (180 * ang) / Math.PI;
	}
	
	public static double degreeToRad(double ang) {
		return (ang * Math.PI) / 180;
	}

	public static void determinante(Vektor2D v1, Vektor2D v2) {

	}
	
	public static void determinante(Vektor3D v1, Vektor3D v2, Vektor3D v3) {

	}

	public static void abs(Vektor2D v) { // double ?

	}

	public static void show(Vektor2D v) {

	}
	
	public static void show(Vektor3D v) {

	}



}
