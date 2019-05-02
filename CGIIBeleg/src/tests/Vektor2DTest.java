package beleg;

//uses JUnit 4

//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.junit.Assert.*;

//import org.junit.Rule;
//import org.junit.rules.ExpectedException;

//fail("fail message");

public class Vektor2DTest {
	@Test
	public void setPosition2DTest() {
		Vektor2D v1 = new Vektor2D(1, 5);
		v1.setPosition(6, 8);
	}
	
	@Test
	public void isNullVectorNegativ2DTest() {
		Vektor2D v = new Vektor2D(1, 5);
		boolean n = v.isNullVector();
		assertFalse(n);
	}
	
	@Test
	public void isNullVectorPositiv2DTest() {
		Vektor2D v = new Vektor2D(0, 0);
		boolean n = v.isNullVector();
		assertTrue(n);
	}

	@Test
	public void addAddition2DTest() {
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
	public void addOverflow2DTest() throws Exception {
		Vektor2D v = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
		v.add(v); // Exception
	}
	
	@Test
	public void subSubtraction2DTest() {
		Vektor2D v1 = new Vektor2D(3, 4);
		Vektor2D v2 = new Vektor2D(5, 4);
		try {
			v1.sub(v2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert(false);
		}
	}
	
	@Test (expected=Exception.class)
	public void subUnderflow2DTest() throws Exception {
		Vektor2D v1 = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);
		Vektor2D v2 = new Vektor2D(5, 5);
		v1.sub(v2); // Exception
	}

	@Test
	public void multMultiplication2DTest() {
			Vektor2D v1 = new Vektor2D(1, 4);
			try {
				v1.mult(5);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				assert(false);
			}
	}
	
	@Test (expected=Exception.class)
	public void multOverflow2DTest() throws Exception {
		Vektor2D v1 = new Vektor2D(1, 4);
		v1.mult(Double.MAX_VALUE);
	}
	
	@Test
	public void divDivision2DTest() {
		Vektor2D v = new Vektor2D(1, 4);
		try {
			v.div(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert(false);
		}
	}
	
	@Test (expected=Exception.class)
	public void divDivisionNull2DTest() throws Exception {
		Vektor2D v = new Vektor2D(3, 3);
		v.div(0);
	}

	@Test
	public void isEqualPositiv2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(1, 4);
		boolean vEq = v1.isEqual(v2);
		assertTrue(vEq);
	}
	
	@Test
	public void isEqualNegativ2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(4, 1);
		boolean vEq = v1.isEqual(v2);
		assertFalse(vEq);
	}
	
	@Test
	public void isNotEqualPositiv2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(4, 4);
		boolean vEq = v1.isNotEqual(v2);
		assertTrue(vEq);
	}
	
	@Test
	public void isNotEqualNegativ2DTest() {
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(1, 4);
		boolean vEq = v1.isNotEqual(v2);
		assertFalse(vEq);
	}
	
	@Test
	public void lengthCalculation2DTest() {
		Vektor2D v = new Vektor2D(3, 4);
		double l = v.length();
		assert(l == 5);
	}
	
	@Test
	public void lengthZeroCalculation2DTest() {
		Vektor2D v = new Vektor2D(0, 0);
		double l = v.length();
		assert(l == 0);
	}
	
	@Test
	public void normalizeCalculation2DTest() {
		Vektor2D v = new Vektor2D(1, 4);
		try {
			v.normalize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert(false);
		}
	}
	
	@Test
	public void normalizeZeroCalculation2DTest() throws Exception {
		Vektor2D v = new Vektor2D(0, 0);
		v.normalize();
	}
}
