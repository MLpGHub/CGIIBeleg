package testing;

import org.junit.Test;

public class Vektor3D {
	public double x, y, z;

	public Vektor3D() {
		this(0, 0, 0);
	}

	public Vektor3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vektor3D(Vektor3D src) {
		this(src.x, src.y, src.z);
	}

	@Test
	public void setPosition(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public boolean isNullVector() {
		return (this.x == 0) && (this.y == 0) && (this.z == 0);
	}

	@Test
	public void add(Vektor3D v) throws Exception {
		this.x = DRechnung.add(this.x, v.x);
		this.y = DRechnung.add(this.y, v.y);
		this.z = DRechnung.add(this.z, v.z);
	}

	@Test
	public void sub(Vektor3D v) throws Exception {
		this.x = DRechnung.sub(this.x, v.x);
		this.y = DRechnung.sub(this.y, v.y);
		this.z = DRechnung.sub(this.z, v.z);
	}

	@Test
	public void mult(double d) throws Exception {
		this.x = DRechnung.mult(this.x, d);
		this.y = DRechnung.mult(this.y, d);
		this.z = DRechnung.mult(this.z, d);
	}

	@Test
	public void div(double d) throws Exception {
		this.x = DRechnung.div(this.x, d);
		this.y = DRechnung.div(this.y, d);
		this.z = DRechnung.div(this.z, d);
	}

	@Test
	public boolean isEqual(Vektor3D v) {
		return (this.x == v.x) && (this.y == v.y) && (this.z == v.z);
	}

	@Test
	public boolean isNotEqual(Vektor3D v) {
		return !isEqual(v);
	}

	@Test
	public double length() throws Exception {
		double x2 = DRechnung.mult(this.x, this.x);
		double y2 = DRechnung.mult(this.y, this.y);
		double z2 = DRechnung.mult(this.z, this.z);
		double x2y2 = DRechnung.add(x2, y2);
		return Math.sqrt(DRechnung.add(x2y2, z2));
	}

	@Test
	public void normalize() throws Exception {
		double len = length();
		if (len == 0) {
			return;
		}
		this.x = DRechnung.div(this.x, len);
		this.y = DRechnung.div(this.y, len);
		this.z = DRechnung.div(this.z, len);
	}
}
