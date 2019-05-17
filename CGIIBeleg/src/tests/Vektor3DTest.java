package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import beleg.DRechnung;
import beleg.Vektor3D;

//fail("fail message");

public class Vektor3DTest {
	@Test
	public void setPosition3DTest() {
		Vektor3D v = new Vektor3D(1, 5, 6);
		v.setPosition(6, 8, 6);
		assert (v.x == 6);
		assert (v.y == 8);
		assert (v.z == 6);
	}

	@Test
	public void isNullVectorNegativ3DTest() {
		Vektor3D v = new Vektor3D(1, 5, 5);
		boolean n = v.isNullVector();
		Assertions.assertFalse(n);
	}

	@Test
	public void isNullVectorPositiv3DTest() {
		Vektor3D v = new Vektor3D(0, 0, 0);
		boolean n = v.isNullVector();
		Assertions.assertTrue(n);
	}

	@Test
	public void addAddition3DTest() throws Exception {
		Vektor3D v1 = new Vektor3D(1, 4, 2);
		Vektor3D v2 = new Vektor3D(2, 4, 3);
		v1.add(v2);
		assert (v1.x == 3);
		assert (v1.y == 8);
		assert (v1.z == 5);
	}

	@Test
	public void addOverflow3DTest() {
		Vektor3D v = new Vektor3D(DRechnung.MAX, DRechnung.MAX, DRechnung.MAX);
		Assertions.assertThrows(Exception.class, () -> {
			v.add(v);
		});
	}

	@Test
	public void subSubtraction3DTest() throws Exception {
		Vektor3D v1 = new Vektor3D(1, 4, 3);
		Vektor3D v2 = new Vektor3D(2, 4, 2);
		v1.sub(v2);
		assert (v1.x == -1);
		assert (v1.y == 0);
		assert (v1.z == 1);
	}

	@Test
	public void subUnderflow3DTest() {
		Vektor3D v1 = new Vektor3D(DRechnung.MIN, DRechnung.MIN, DRechnung.MIN);
		Vektor3D v2 = new Vektor3D(5, 5, 5);
		Assertions.assertThrows(Exception.class, () -> {
			v1.sub(v2);
		});
	}

	@Test
	public void multMultiplication3DTest() throws Exception {
		Vektor3D v1 = new Vektor3D(1, 4, 2);
		v1.mult(5);
		assert (v1.x == 5);
		assert (v1.y == 20);
		assert (v1.z == 10);
	}

	@Test
	public void multOverflow3DTest() {
		Vektor3D v = new Vektor3D(1, 4, 2);
		Assertions.assertThrows(Exception.class, () -> {
			v.mult(DRechnung.MAX);
		});
	}

	@Test
	public void divDivision3DTest() throws Exception {
		Vektor3D v = new Vektor3D(1, 4, 2);
		v.div(5);
		assert (v.x == 1 / 5.);
		assert (v.y == 4 / 5.);
		assert (v.z == 2 / 5.);
	}

	@Test
	public void divDivisionNull3DTest() {
		Vektor3D v = new Vektor3D(3, 3, 3);
		Assertions.assertThrows(Exception.class, () -> {
			v.div(0);
		});
	}

	@Test
	public void isEqualPositiv3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 1);
		Vektor3D v2 = new Vektor3D(1, 4, 1);
		boolean vEq = v1.isEqual(v2);
		Assertions.assertTrue(vEq);
	}

	@Test
	public void isEqualNegativ3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 2);
		Vektor3D v2 = new Vektor3D(4, 1, 2);
		boolean vEq = v1.isEqual(v2);
		Assertions.assertFalse(vEq);
	}

	@Test
	public void isNotEqualPositiv3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 1);
		Vektor3D v2 = new Vektor3D(4, 4, 3);
		boolean vEq = v1.isNotEqual(v2);
		Assertions.assertTrue(vEq);
	}

	@Test
	public void isNotEqualNegativ3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 1);
		Vektor3D v2 = new Vektor3D(1, 4, 1);
		boolean vEq = v1.isNotEqual(v2);
		Assertions.assertFalse(vEq);
	}

	@Test
	public void lengthCalculation3DTest() throws Exception {
		Vektor3D v = new Vektor3D(3, 4, 0);
		double l = v.length();
		assert (l == 5);
	}

	@Test
	public void lengthZeroCalculation3DTest() throws Exception {
		Vektor3D v = new Vektor3D(0, 0, 0);
		double l = v.length();
		assert (l == 0);
	}

	@Test
	public void normalizeCalculation3DTest() throws Exception {
		Vektor3D v = new Vektor3D(3, 4, 0);
		v.normalize();
		assert (v.x == 3 / 5.);
		assert (v.y == 4 / 5.);
		assert (v.z == 0);
	}

	@Test
	public void normalizeZeroCalculation3DTest() throws Exception {
		Vektor3D v = new Vektor3D(0, 0, 0);
		v.normalize();
		assert (v.x == 0);
		assert (v.y == 0);
		assert (v.z == 0);
	}
}
