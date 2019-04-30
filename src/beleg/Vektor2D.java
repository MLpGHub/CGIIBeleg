package beleg;

import org.junit.Test;

public class Vektor2D {
	public double x, y;

	/**
	 * Konstruktor mit Standardwerten
	 * 
	 * @param x
	 * @param y
	 */
	public Vektor2D() {
		this(0, 0);
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param x
	 * @param y
	 */
	public Vektor2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Kopierkonstruktor
	 * 
	 * @param src
	 */
	public Vektor2D(Vektor2D src) {
		this(src.x, src.y);
	}

	/**
	 * Belegt den Vektor in 2D mit den übergebenen Werten
	 * 
	 * @param x
	 * @param y
	 */
	@Test
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * überprüft den Vektor in 2D auf Nullvektor-Eigenschaften
	 * 
	 */
	@Test
	public boolean isNullVector() {
		return (this.x == 0) && (this.y == 0);
	}

	/**
	 * Addition zweier Vektoren in 2D
	 * 
	 * @param v
	 * @throws Exception
	 */
	@Test
	public void add(Vektor2D v) throws Exception {
		if ((Double.MAX_VALUE - v.x < this.x) && (Double.MAX_VALUE - v.y < this.y)) {
			throw new Exception("Double Wraparound");
		}
		this.x += v.x;
		this.y += v.y;

		/*
		 * Vektor2D vErg = new Vektor2D(v1.x + v2.x, v1.y + v2.y); if((vErg.x <= v1.x)
		 * || (vErg.y <= v1.y)) { //Double Wraparound throw new
		 * Exception("Double Wraparound trat auf"); } return vErg;
		 */
	}

	/**
	 * Subtraktion zweier Vektoren in 2D
	 * 
	 * @param v
	 * @throws Exception
	 */
	@Test
	public void sub(Vektor2D v) throws Exception {
		if ((Double.MAX_VALUE - Math.abs(v.x) < Math.abs(this.x))
				&& (Double.MAX_VALUE - Math.abs(v.y) < Math.abs(this.y))) {
			throw new Exception("Double Wraparound");
		}
		this.x -= v.x;
		this.y -= v.y;

		/*
		 * Vektor2D vErg = new Vektor2D(v1.x - v2.x, v1.y - v2.y); if ((vErg.x >= v1.x)
		 * || (vErg.y >= v1.y)) { // Double Wraparound throw new
		 * Exception("Double Wraparound trat auf"); } return vErg;
		 */
	}

	/**
	 * Multiplikation des Vektors mit einem Skalarwert in 2D
	 * 
	 * @param d
	 * @throws Exception
	 */
	@Test
	public void mult(double d) throws Exception {
		double div = Double.MAX_VALUE / d;
		if ((div > this.x) && (div > this.y)) {
			throw new Exception("Double Wraparound");
		}
		this.x *= d;
		this.y *= d;

		/*
		 * Vektor2D vErg = new Vektor2D(v1.x * d, v1.y * d); if ((vErg.x <= v1.x) ||
		 * (vErg.y <= v1.y)) { // Double Wraparound throw new
		 * Exception("Double Wraparound trat auf"); } return vErg;
		 */
	}

	/**
	 * Division des Vektors mit einem Skalarwert in 2D
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

		/*
		 * Vektor2D vErg = new Vektor2D(v1.x / d, v1.y / d); if ((vErg.x >= v1.x) ||
		 * (vErg.y >= v1.y)) { // Double Wraparound throw new
		 * Exception("Double Wraparound trat auf"); } return vErg;
		 */
	}

	/**
	 * überprüft zwei Vektoren in 2D auf Gleichheit
	 * 
	 * @param v
	 * @return
	 */
	@Test
	public boolean isEqual(Vektor2D v) {
		return ((this.x == v.x) && (this.y == v.y));
	}

	/**
	 * überprüft zwei Vektoren in 2D auf Ungleichheit
	 * 
	 * @param v
	 * @return
	 */
	@Test
	public boolean isNotEqual(Vektor2D v) {
		return !isEqual(v);
	}

	/**
	 * Berechnet die Länge des Vektors in 2D
	 * 
	 * @return
	 */
	@Test
	public double length() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	/**
	 * Normiert den Vektor in 2D
	 * @return 
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
	}
}
