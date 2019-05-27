package beleg;

public class LineareAlgebra {
	private LineareAlgebra() {
	}

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

	public static double length(Vektor2D v) throws Exception {
		return v.length();
	}

	public static double length(Vektor3D v) throws Exception {
		return v.length();
	}

	public static Vektor2D normalize(Vektor2D v) throws Exception {
		Vektor2D tmp = new Vektor2D(v);
		tmp.normalize();
		return tmp;
	}

	public static Vektor3D normalize(Vektor3D v) throws Exception {
		Vektor3D tmp = new Vektor3D(v);
		tmp.normalize();
		return tmp;
	}

	public static double euklDistance(Vektor2D v1, Vektor2D v2) throws Exception {
		double a = DRechnung.sub(v1.x, v2.x);
		double b = DRechnung.sub(v1.y, v2.y);
		double a2 = DRechnung.mult(a, a);
		double b2 = DRechnung.mult(b, b);
		return Math.sqrt(DRechnung.add(a2, b2));
	}

	public static double euklDistance(Vektor3D v1, Vektor3D v2) throws Exception {
		double a = DRechnung.sub(v1.x, v2.x);
		double b = DRechnung.sub(v1.y, v2.y);
		double c = DRechnung.sub(v1.z, v2.z);
		double a2 = DRechnung.mult(a, a);
		double b2 = DRechnung.mult(b, b);
		double c2 = DRechnung.mult(c, c);
		double ab = DRechnung.add(a2, b2);
		return Math.sqrt(DRechnung.add(ab, c2));
	}

	public static double manhattenDistance(Vektor2D v) throws Exception {
		return DRechnung.add(Math.abs(v.x), Math.abs(v.y));
	}

	public static double manhattenDistance(Vektor3D v) throws Exception {
		double a = DRechnung.add(Math.abs(v.x), Math.abs(v.y));
		return DRechnung.add(a, Math.abs(v.z));
	}

	public static Vektor3D crossProduct(Vektor3D v1, Vektor3D v2) throws Exception {
		double x = DRechnung.sub(DRechnung.mult(v1.y, v2.z), DRechnung.mult(v1.z, v2.y));
		double y = DRechnung.sub(DRechnung.mult(v1.z, v2.x), DRechnung.mult(v1.x, v2.z));
		double z = DRechnung.sub(DRechnung.mult(v1.x, v2.y), DRechnung.mult(v1.y, v2.x));
		return new Vektor3D(x, y, z);
	}

	public static double dotProduct(Vektor2D v1, Vektor2D v2) throws Exception {
		double a = DRechnung.mult(v1.x, v2.x);
		double b = DRechnung.mult(v1.y, v2.y);
		return DRechnung.add(a, b);
	}

	public static double dotProduct(Vektor3D v1, Vektor3D v2) throws Exception {
		double x = DRechnung.mult(v1.x, v2.x);
		double y = DRechnung.mult(v1.y, v2.y);
		double z = DRechnung.mult(v1.z, v2.z);
		return DRechnung.add(DRechnung.add(x, y), z);
	}

	public static double cosEquation(Vektor2D v1, Vektor2D v2) throws Exception {
		double a = dotProduct(v1, v2);
		double b = DRechnung.mult(length(v1), length(v2));
		return DRechnung.div(a, b);
	}

	public static double cosEquation(Vektor3D v1, Vektor3D v2) throws Exception {
		double a = dotProduct(v1, v2);
		double b = DRechnung.mult(length(v1), length(v2));
		return DRechnung.div(a, b);
	}

	public static double sinEquation(Vektor3D v1, Vektor3D v2) throws Exception {
		double a = length(crossProduct(v1, v2));
		double b = DRechnung.mult(length(v1), length(v2));
		return DRechnung.div(a, b);
	}

	public static double angleRad(Vektor2D v1, Vektor2D v2) throws Exception {
		return Math.acos(cosEquation(v1, v2));
	}

	public static double angleRad(Vektor3D v1, Vektor3D v2) throws Exception {
		return Math.acos(cosEquation(v1, v2));
	}

	public static double angleDegree(Vektor2D v1, Vektor2D v2) throws Exception {
		return radToDegree(angleRad(v1, v2));
	}

	public static double angleDegree(Vektor3D v1, Vektor3D v2) throws Exception {
		return radToDegree(angleRad(v1, v2));
	}

	public static double radToDegree(double ang) throws Exception {
		double a = DRechnung.mult(180, ang);
		return DRechnung.div(a, Math.PI);
	}

	public static double degreeToRad(double ang) throws Exception {
		double a = DRechnung.mult(ang, Math.PI);
		return DRechnung.div(a, 180);
	}

	public static double determinante(Vektor2D v1, Vektor2D v2) throws Exception {
		double a = DRechnung.mult(v1.x, v2.y);
		double b = DRechnung.mult(v1.y, v2.x);
		return DRechnung.sub(a, b);
	}

	public static double determinante(Vektor3D v1, Vektor3D v2, Vektor3D v3) throws Exception {
		double a = DRechnung.mult(DRechnung.mult(v1.x, v2.y), v3.z);
		double b = DRechnung.mult(DRechnung.mult(v2.x, v3.y), v1.z);
		double c = DRechnung.mult(DRechnung.mult(v3.x, v1.y), v2.z);
		double d = DRechnung.mult(DRechnung.mult(v1.z, v2.y), v3.x);
		double e = DRechnung.mult(DRechnung.mult(v2.z, v3.y), v1.x);
		double f = DRechnung.mult(DRechnung.mult(v3.z, v1.y), v2.x);
		double sum1 = DRechnung.add(DRechnung.add(a, b), c);
		double sum2 = DRechnung.add(DRechnung.add(-d, -e), -f);
		return DRechnung.add(sum1, sum2);
		// return a + b + c - d - e - f;
	}

	public static Vektor2D abs(Vektor2D vsrc) throws Exception {
		Vektor2D v = new Vektor2D(vsrc);
		//if ((v.x == DRechnung.MIN) || (v.y == DRechnung.MIN))
		//	throw new Exception("nicht darstellbar");
		if (v.x < 0)
			v.x = -v.x;
		if (v.y < 0)
			v.y = -v.y;
		return v;
	}

	public static Vektor3D abs(Vektor3D vsrc) throws Exception {
		Vektor3D v = new Vektor3D(vsrc);
		//if ((v.x == DRechnung.MIN) || (v.y == DRechnung.MIN) || (v.z == DRechnung.MIN))
		//	throw new Exception("nicht darstellbar");
		if (v.x < 0)
			v.x = -v.x;
		if (v.y < 0)
			v.y = -v.y;
		if (v.z < 0)
			v.z = -v.z;
		return v;
	}
	
	public static Vektor2D negate(Vektor2D v) {
		return new Vektor2D(-v.x, -v.y);
	}
	
	public static Vektor3D negate(Vektor3D v) {
		return new Vektor3D(-v.x, -v.y, -v.z);
	}

	public static void show(Vektor2D v) {
		System.out.println("Vektor2D [" + v.x + ", " + v.y + "]");
	}

	public static void show(Vektor3D v) {
		System.out.println("Vektor3D [" + v.x + ", " + v.y + ", " + v.z + "]");
	}

}
