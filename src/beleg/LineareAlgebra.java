package beleg;

public class LineareAlgebra {
	public static Vektor2D add(Vektor2D v1, Vektor2D v2) throws Exception {
		Vektor2D v = new Vektor2D(v1);
		v.add(v2);
		return v;
	}

	public static Vektor3D add(Vektor3D v1, Vektor3D v2) throws Exception {
		Vektor3D v = new Vektor3D(v1);
		v.add(v2);
		return v;
	}

	public static Vektor2D sub(Vektor2D v1, Vektor2D v2) throws Exception {
		Vektor2D v = new Vektor2D(v1);
		v.sub(v2);
		return v;
	}

	public static Vektor3D sub(Vektor3D v1, Vektor3D v2) throws Exception {
		Vektor3D v = new Vektor3D(v1);
		v.sub(v2);
		return v;
	}

	public static Vektor2D mult(Vektor2D vsrc, double d) throws Exception {
		Vektor2D v = new Vektor2D(vsrc);
		v.mult(d);
		return v;
	}

	public static Vektor3D mult(Vektor3D vsrc, double d) throws Exception {
		Vektor3D v = new Vektor3D(vsrc);
		v.mult(d);
		return v;
	}

	public static Vektor2D div(Vektor2D vsrc, double d) throws Exception {
		Vektor2D v = new Vektor2D(vsrc);
		v.div(d);
		return v;
	}

	public static Vektor3D div(Vektor3D vsrc, double d) throws Exception {
		Vektor3D v = new Vektor3D(vsrc);
		v.div(d);
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
	}

	public static Vektor3D normalize(Vektor3D v) {
		Vektor3D tmp = new Vektor3D(v);
		tmp.normalize();
		return tmp;
	}

	public static double euklDistance(Vektor2D v1, Vektor2D v2) {
		return Math.sqrt((v1.x - v2.x) * (v1.x - v2.x) + (v1.y - v2.y) * (v1.y - v2.y));
	}

	public static double euklDistance(Vektor3D v1, Vektor3D v2) {
		return Math.sqrt((v1.x - v2.x) * (v1.x - v2.x) + (v1.y - v2.y) * (v1.y - v2.y) + (v1.z - v2.z) * (v1.z - v2.z));
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

	public static double sinEquation(Vektor3D v1, Vektor3D v2) {
		return length(crossProduct(v1, v2)) / (length(v1) * length(v2));
	}

	public static double angleRad(Vektor2D v1, Vektor2D v2) {
		return Math.acos(cosEquation(v1, v2));
	}

	public static double angleRad(Vektor3D v1, Vektor3D v2) {
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

	public static double determinante(Vektor2D v1, Vektor2D v2) {
		return v1.x * v2.y - v1.y * v2.x;
	}

	public static double determinante(Vektor3D v1, Vektor3D v2, Vektor3D v3) {
		double a = v1.x * v2.y * v3.z;
		double b = v2.x * v3.y * v1.z;
		double c = v3.x * v1.y * v2.z;
		double d = v1.z * v2.y * v3.x;
		double e = v2.z * v3.y * v1.x;
		double f = v3.z * v1.y * v2.x;
		return a + b + c - d - e - f;
	}

	public static Vektor2D abs(Vektor2D vsrc) throws Exception {
		Vektor2D v = new Vektor2D(vsrc);
		if ((v.x == Double.MIN_VALUE) || (v.y == Double.MIN_VALUE))
			throw new Exception("nicht darstellbar");
		if (v.x < 0)
			v.x = -v.x;
		if (v.y < 0)
			v.y = -v.y;
		return v;
	}

	public static Vektor3D abs(Vektor3D vsrc) throws Exception {
		Vektor3D v = new Vektor3D(vsrc);
		if ((v.x == Double.MIN_VALUE) || (v.y == Double.MIN_VALUE) || (v.z == Double.MIN_VALUE))
			throw new Exception("nicht darstellbar");
		if (v.x < 0)
			v.x = -v.x;
		if (v.y < 0)
			v.y = -v.y;
		if (v.z < 0)
			v.z = -v.z;
		return v;
	}

	public static void show(Vektor2D v) {
		System.out.println("Vektor2D [" + v.x + ", " + v.y + "]");
	}

	public static void show(Vektor3D v) {
		System.out.println("Vektor3D [" + v.x + ", " + v.y + ", " + v.z + "]");
	}

}
