package testing;

import org.junit.Test;

public class Vektor2D {
	public double x, y;

	public Vektor2D() {
		this(0, 0);
	}

	public Vektor2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vektor2D(Vektor2D src) {
		this(src.x, src.y);
	}

	@Test
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Test
	public boolean isNullVector() {
		return (this.x == 0) && (this.y == 0);
	}

	@Test
	public void add(Vektor2D v) throws Exception {
		this.x = DRechnung.add(this.x, v.x);
		this.y = DRechnung.add(this.y, v.y);

		/*
		 * Vektor2D vErg = new Vektor2D(v1.x + v2.x, v1.y + v2.y); if((vErg.x <= v1.x)
		 * || (vErg.y <= v1.y)) { //Double Wraparound throw new
		 * Exception("Double Wraparound trat auf"); } return vErg;
		 */
	}

	@Test
	public void sub(Vektor2D v) throws Exception {
		this.x = DRechnung.sub(this.x, v.x);
		this.y = DRechnung.sub(this.y, v.y);

		/*
		 * Vektor2D vErg = new Vektor2D(v1.x - v2.x, v1.y - v2.y); if ((vErg.x >= v1.x)
		 * || (vErg.y >= v1.y)) { // Double Wraparound throw new
		 * Exception("Double Wraparound trat auf"); } return vErg;
		 */
	}

	@Test
	public void mult(double d) throws Exception {
		this.x = DRechnung.mult(this.x, d);
		this.y = DRechnung.mult(this.y, d);

		/*
		 * Vektor2D vErg = new Vektor2D(v1.x * d, v1.y * d); if ((vErg.x <= v1.x) ||
		 * (vErg.y <= v1.y)) { // Double Wraparound throw new
		 * Exception("Double Wraparound trat auf"); } return vErg;
		 */
	}

	@Test
	public void div(double d) throws Exception {
		this.x = DRechnung.div(this.x, d);
		this.y = DRechnung.div(this.y, d);

		/*
		 * Vektor2D vErg = new Vektor2D(v1.x / d, v1.y / d); if ((vErg.x >= v1.x) ||
		 * (vErg.y >= v1.y)) { // Double Wraparound throw new
		 * Exception("Double Wraparound trat auf"); } return vErg;
		 */
	}

	@Test
	public boolean isEqual(Vektor2D v) {
		return ((this.x == v.x) && (this.y == v.y));
	}

	@Test
	public boolean isNotEqual(Vektor2D v) {
		return !isEqual(v);
	}

	@Test
	public double length() throws Exception {
		double x2 = DRechnung.mult(this.x, this.x);
		double y2 = DRechnung.mult(this.y, this.y);
		return Math.sqrt(DRechnung.add(x2, y2));
	}

	@Test
	public void normalize() throws Exception {
		double len = length();
		if (len == 0) {
			return;
		}
		this.x = DRechnung.div(this.x, len);
		this.y = DRechnung.div(this.y, len);
	}
}
