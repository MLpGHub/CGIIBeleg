package beleg;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

//import org.junit.Rule;
//import org.junit.rules.ExpectedException;

//fail("fail message");

class Vektor3DTest {
	@Test
	void setPosition3DTest() {
		Vektor3D v1 = new Vektor3D(1, 5, 6);
		v1.setPosition(6, 8, 6);
	}

	@Test
	void isNullVectorNegativ3DTest() {
		Vektor3D v = new Vektor3D(1, 5, 5);
		boolean n = v.isNullVector();
		assertFalse(n);
	}

	@Test
	void isNullVectorPositiv3DTest() {
		Vektor3D v = new Vektor3D(0, 0, 0);
		boolean n = v.isNullVector();
		assertTrue(n);
	}

	@Test
	void addAddition3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 2);
		Vektor3D v2 = new Vektor3D(2, 4, 3);
		try {
			v1.add(v2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert (false);
		}
	}

	@Test(expected = Exception.class)
	void addOverflow3DTest() throws Exception {
		Vektor3D v = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		v.add(v); // Exception
	}

	@Test
	void subSubtraction3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4,3);
		Vektor3D v2 = new Vektor3D(2, 4,2);
		try {
			v1.sub(v2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert (false);
		}
	}

	@Test(expected = Exception.class)
	void subUnderflow3DTest() throws Exception {
		Vektor3D v = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE,Double.MIN_VALUE);
		v.sub(v); // Exception
	}

	@Test
	void multMultiplication3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 2);
		try {
			v1.mult(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert (false);
		}
	}

	@Test(expected = Exception.class)
	void multOverflow3DTest() throws Exception {
		Vektor3D v1 = new Vektor3D(1, 4, 2);
		v1.mult(Double.MAX_VALUE);
	}

	@Test
	void divDivision3DTest() {
		Vektor3D v = new Vektor3D(1, 4, 2);
		try {
			v.div(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert (false);
		}
	}

	@Test(expected = Exception.class)
	void divDivisionNull3DTest() throws Exception {
		Vektor3D v = new Vektor3D(3, 3 ,3);
		v.div(0);
	}

	@Test
	void isEqualPositiv3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 1);
		Vektor3D v2 = new Vektor3D(1, 4, 1);
		boolean vEq = v1.isEqual(v2);
		assertTrue(vEq);
	}

	@Test
	void isEqualNegativ3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 2);
		Vektor3D v2 = new Vektor3D(4, 1, 2);
		boolean vEq = v1.isEqual(v2);
		assertFalse(vEq);
	}

	@Test
	void isNotEqualPositiv3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 1);
		Vektor3D v2 = new Vektor3D(4, 4, 3);
		boolean vEq = v1.isNotEqual(v2);
		assertFalse(vEq);
	}

	@Test
	void isNotEqualNegativ3DTest() {
		Vektor3D v1 = new Vektor3D(1, 4, 1);
		Vektor3D v2 = new Vektor3D(1, 4, 1);
		boolean vEq = v1.isNotEqual(v2);
		assertTrue(vEq);
	}

	@Test
	void lengthCalculation3DTest() {
		Vektor3D v = new Vektor3D(3, 4, 0);
		double l = v.length();
		assert (l == 5);
	}

	@Test
	void lengthZeroCalculation3DTest() {
		Vektor3D v = new Vektor3D(0, 0, 0);
		double l = v.length();
		assert (l == 0);
	}

	@Test
	void normalizeCalculation3DTest() {
		Vektor3D v = new Vektor3D(1, 4, 1);
		try {
			v.normalize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert (false);
		}
	}

	@Test
	void normalizeZeroCalculation3DTest() throws Exception {
		Vektor3D v = new Vektor3D(0, 0, 0);
		v.normalize();
	}
}
