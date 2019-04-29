package beleg;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

//import org.junit.Rule;
//import org.junit.rules.ExpectedException;

//fail("fail message");

class Vektor2DTest {
	@Test
	void setPosition2DTest() {
		Vektor2D v1 = new Vektor2D(1, 5);
		v1.setPosition(6, 8);
	}
	
	@Test
	void isNullVectorNegativ2DTest() {
		Vektor2D v = new Vektor2D(1, 5);
		boolean n = v.isNullVector();
		assertFalse(n);
	}
	
	@Test
	void isNullVectorPositiv2DTest() {
		Vektor2D v = new Vektor2D(0, 0);
		boolean n = v.isNullVector();
		assertTrue(n);
	}

	@Test
	void addAddition2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(2, 4);
		try {
			v1.add(v2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert(false);
		}
	}
	
	@Test (expected = Exception.class)
	void addOverflow2DTest() throws Exception {
		Vektor2D v = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
		v.add(v); // Exception
	}
	
	@Test
	void subSubtraction2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(2, 4);
		try {
			v1.sub(v2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert(false);
		}
	}
	
	@Test (expected=Exception.class)
	void subUnderflow2DTest() throws Exception {
		Vektor2D v = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);
		v.sub(v); // Exception
	}

	@Test
	void multMultiplication2DTest() {
			Vektor2D v1 = new Vektor2D(1, 4);
			try {
				v1.mult(5);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				assert(false);
			}
	}
	
	@Test (expected=Exception.class)
	void multOverflow2DTest() throws Exception {
		Vektor2D v1 = new Vektor2D(1, 4);
		v1.mult(Double.MAX_VALUE);
	}
	
	@Test
	void divDivision2DTest() {
		Vektor2D v = new Vektor2D(1, 4);
		try {
			v.div(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert(false);
		}
	}
	
	@Test (expected=Exception.class)
	void divDivisionNull2DTest() throws Exception {
		Vektor2D v = new Vektor2D(3, 3);
		v.div(0);
	}

	@Test
	void isEqualPositiv2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(1, 4);
		boolean vEq = v1.isEqual(v2);
		assertTrue(vEq);
	}
	
	@Test
	void isEqualNegativ2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(4, 1);
		boolean vEq = v1.isEqual(v2);
		assertFalse(vEq);
	}
	
	@Test
	void isNotEqualPositiv2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(4, 4);
		boolean vEq = v1.isNotEqual(v2);
		assertFalse(vEq);
	}
	
	@Test
	void isNotEqualNegativ2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(4, 1);
		boolean vEq = v1.isNotEqual(v2);
		assertTrue(vEq);
	}
	
	@Test
	void lengthCalculation2DTest() {
		Vektor2D v = new Vektor2D(3, 4);
		double l = v.length();
		assert(l == 5);
	}
	
	@Test
	void lengthZeroCalculation2DTest() {
		Vektor2D v = new Vektor2D(0, 0);
		double l = v.length();
		assert(l == 0);
	}
	
	@Test
	void normalizeCalculation2DTest() {
		Vektor2D v = new Vektor2D(1, 4);
		try {
			v.normalize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert(false);
		}
	}
	
	@Test
	void normalizeZeroCalculation2DTest() throws Exception {
		Vektor2D v = new Vektor2D(0, 0);
		v.normalize();
	}
}
