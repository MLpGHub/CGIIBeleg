package beleg;

import org.junit.Test;

public class Vektor3D {
	public double x, y, z;

	/**
	 * Konstruktor mit Standardwerten
	 * 
	 * @param x
	 * @param y
	 */
	public Vektor3D() {
		this(0, 0, 0);
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param x
	 * @param y
	 */
	public Vektor3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Kopierkonstruktor
	 * 
	 * @param src
	 */
	public Vektor3D(Vektor3D src) {
		this(src.x, src.y, src.z);
	}

	/**
	 * Belegt den Vektor in 3D mit den übergebenen Werten
	 * 
	 * @param x
	 * @param y
	 */
	@Test
	public void setPosition(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * überprüft einen Vektor in 3D auf Nullvektor-Eigenschaften
	 * 
	 */
	@Test
	public boolean isNullVector() {
		return (this.x == 0) && (this.y == 0) && (this.z == 0);
	}

	/**
	 * Addition zweier Vektoren in 3D
	 * 
	 * @param v
	 * @throws Exception
	 */
	@Test
	public void add(Vektor3D v) throws Exception {
		if ((Double.MAX_VALUE - v.x < this.x) && (Double.MAX_VALUE - v.y < this.y)
				&& (Double.MAX_VALUE - v.z < this.z)) {
			throw new Exception("Double Wraparound");
		}
		this.x += v.x;
		this.y += v.y;
		this.z += v.z;
	}

	/**
	 * Subtraktion zweier Vektoren in 3D
	 * 
	 * @param v
	 * @throws Exception
	 */
	@Test
	public void sub(Vektor3D v) throws Exception {
		if ((Double.MAX_VALUE - Math.abs(v.x) < Math.abs(this.x))
				&& (Double.MAX_VALUE - Math.abs(v.y) < Math.abs(this.y))
				&& (Double.MAX_VALUE - Math.abs(v.z) < Math.abs(this.z))) {
			throw new Exception("Double Wraparound");
		}
		this.x -= v.x;
		this.y -= v.y;
		this.z -= v.z;
	}

	/**
	 * Multiplikation des Vektors mit einem Skalarwert in 3D
	 * 
	 * @param d
	 * @throws Exception
	 */
	@Test
	public void mult(double d) throws Exception {
		double div = Double.MAX_VALUE / d;
		if ((div > this.x) && (div > this.y) && (div > this.z)) {
			throw new Exception("Double Wraparound");
		}
		this.x *= d;
		this.y *= d;
		this.z *= d;
	}

	/**
	 * Division des Vektors mit einem Skalarwert in 3D
	 * 
	 * @param d
	 * @throws Exception
	 */
	@Test
	public void div(double d) throws Exception {
		if (d == 0) {
			throw new Exception("Division durch Null ist nicht erlaubt");
		}

		this.x /= d;
		this.y /= d;
		this.z /= d;
	}

	/**
	 * überprüft zwei Vektoren in 3D auf Gleichheit
	 * 
	 * @param v
	 * @return
	 */
	@Test
	public boolean isEqual(Vektor3D v) {
		return (this.x == v.x) && (this.y == v.y) && (this.z == v.z);
	}

	/**
	 * überprüft zwei Vektoren in 3D auf Ungleichheit
	 * 
	 * @param v
	 * @return
	 */
	@Test
	public boolean isNotEqual(Vektor3D v) {
		return !isEqual(v);
	}

	/**
	 * Berechnet die Länge des Vektors in 2D
	 * 
	 * @return
	 */
	@Test
	public double length() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	/**
	 * Normiert den Vektor in 2D
	 * 
	 * @throws Exception
	 */
	@Test
	public void normalize() {
		double len = length();
		if (len == 0) {
			return;
		}
		this.x /= len;
		this.y /= len;
		this.z /= len;
	}
}
