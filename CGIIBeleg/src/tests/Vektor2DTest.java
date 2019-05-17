package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import beleg.DRechnung;
import beleg.Vektor2D;

//fail("fail message");

public class Vektor2DTest {
	@Test
	public void setPosition2DTest() {
		Vektor2D v = new Vektor2D(1, 5);
		v.setPosition(6, 8);
		assert (v.x == 6);
		assert (v.y == 8);
	}

	@Test
	public void isNullVectorNegativ2DTest() {
		Vektor2D v = new Vektor2D(1, 5);
		boolean n = v.isNullVector();
		Assertions.assertFalse(n);
	}

	@Test
	public void isNullVectorPositiv2DTest() {
		Vektor2D v = new Vektor2D(0, 0);
		boolean n = v.isNullVector();
		Assertions.assertTrue(n);
	}

	@Test
	public void addAddition2DTest() throws Exception {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(2, 4);
		v1.add(v2);
		assert (v1.x == 3);
		assert (v1.y == 8);
	}

	@Test
	public void addOverflow2DTest() {
		Vektor2D v = new Vektor2D(DRechnung.MAX, DRechnung.MAX);
		Assertions.assertThrows(Exception.class, () -> {
			v.add(v);
		});
	}

	@Test
	public void addAsSub2DTest() {
		Vektor2D v1 = new Vektor2D(DRechnung.MIN, 4);
		Vektor2D v2 = new Vektor2D(DRechnung.MIN, 1);
		Assertions.assertThrows(Exception.class, () -> {
			v1.add(v2);
		});
	}

	@Test
	public void subSubtraction2DTest() throws Exception {
		Vektor2D v1 = new Vektor2D(3, 4);
		Vektor2D v2 = new Vektor2D(5, 4);
		v1.sub(v2);
		assert (v1.x == -2);
		assert (v1.y == 0);
	}

	@Test
	public void subUnderflow2DTest() {
		Vektor2D v1 = new Vektor2D(DRechnung.MIN, DRechnung.MIN);
		Vektor2D v2 = new Vektor2D(5, 5);
		Assertions.assertThrows(Exception.class, () -> {
			v1.sub(v2);
		});
	}

	@Test
	public void multMultiplication2DTest() throws Exception {
		Vektor2D v = new Vektor2D(1, 4);
		v.mult(5);
		assert (v.x == 5);
		assert (v.y == 20);
	}

	@Test
	public void multOverflow2DTest() {
		Vektor2D v = new Vektor2D(1, 4);
		Assertions.assertThrows(Exception.class, () -> {
			v.mult(DRechnung.MAX);
		});
	}

	@Test
	public void divDivision2DTest() throws Exception {
		Vektor2D v = new Vektor2D(1, 4);
		v.div(5);
		assert (v.x == 1 / 5.);
		assert (v.y == 4 / 5.);
	}

	@Test
	public void divDivisionNull2DTest() {
		Vektor2D v = new Vektor2D(3, 3);
		Assertions.assertThrows(Exception.class, () -> {
			v.div(0);
		});
	}

	@Test
	public void isEqualPositiv2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(1, 4);
		boolean vEq = v1.isEqual(v2);
		Assertions.assertTrue(vEq);
	}

	@Test
	public void isEqualNegativ2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(4, 1);
		boolean vEq = v1.isEqual(v2);
		Assertions.assertFalse(vEq);
	}

	@Test
	public void isNotEqualPositiv2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(4, 4);
		boolean vEq = v1.isNotEqual(v2);
		Assertions.assertTrue(vEq);
	}

	@Test
	public void isNotEqualNegativ2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(1, 4);
		boolean vEq = v1.isNotEqual(v2);
		Assertions.assertFalse(vEq);
	}

	@Test
	public void lengthCalculation2DTest() throws Exception {
		Vektor2D v = new Vektor2D(3, 4);
		double l = v.length();
		assert (l == 5);
	}

	@Test
	public void lengthZeroCalculation2DTest() throws Exception {
		Vektor2D v = new Vektor2D(0, 0);
		double l = v.length();
		assert (l == 0);
	}

	@Test
	public void normalizeCalculation2DTest() throws Exception {
		Vektor2D v = new Vektor2D(3, 4);
		v.normalize();
		assert (v.x == 3 / 5.);
		assert (v.y == 4 / 5.);
	}

	@Test
	public void normalizeZeroCalculation2DTest() throws Exception {
		Vektor2D v = new Vektor2D(0, 0);
		v.normalize();
		assert (v.x == 0);
		assert (v.y == 0);
	}
}
