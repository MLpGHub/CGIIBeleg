package beleg;

//uses JUnit 4

//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;



//fail("fail message");
//
public class LineareAlgebraTest {
	//@org.junit.jupiter.api.Test
	@Test
	public void add2DLACalcTest() {
		try {
			Vektor2D v1 = new Vektor2D(2, 2);
			Vektor2D v2 = new Vektor2D(1, 5);
			Vektor2D v3 = LineareAlgebra.add(v1, v2);
			assert (v3.x == 3);
			assert (v3.y == 7);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void add3DLACalcTest() {
		try {
			Vektor3D v1 = new Vektor3D(2, 2, 7);
			Vektor3D v2 = new Vektor3D(1, 5, 8);
			Vektor3D v3 = LineareAlgebra.add(v1, v2);
			assert (v3.x == 3);
			assert (v3.y == 7);
			System.out.println(v3.z);
			assert (v3.z == 15);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void sub2DLACalcTest() {
		try {
			Vektor2D v1 = new Vektor2D(2, 2);
			Vektor2D v2 = new Vektor2D(1, 5);
			Vektor2D v3 = LineareAlgebra.sub(v1, v2);
			assert (v3.x == 1);
			assert (v3.y == -3);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void sub3DLACalcTest() {
		try {
			Vektor3D v1 = new Vektor3D(2, 2, 7);
			Vektor3D v2 = new Vektor3D(1, 5, 8);
			Vektor3D v3 = LineareAlgebra.sub(v1, v2);
			assert (v3.x == 1);
			assert (v3.y == -3);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void mult2DLACalcTest() {
		try {
			Vektor2D v1 = new Vektor2D(2, 2);
			Vektor2D v2 = LineareAlgebra.mult(v1, 2);
			assert (v2.x == 4);
			assert (v2.y == 4);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void mult3DLACalcTest() {
		try {
			Vektor3D v1 = new Vektor3D(2, 2, 4);
			Vektor3D v2 = LineareAlgebra.mult(v1, 4.0);
			assert (v2.x == 8);
			assert (v2.y == 8);
			assert (v2.z == 16);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void div2DLACalcTest() {
		try {
			Vektor2D v1 = new Vektor2D(2, 2);
			Vektor2D v3 = LineareAlgebra.div(v1, 2.0);
			assert (v3.x == 1);
			assert (v3.y == 1);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void div3DLACalcTest() {
		try {
			Vektor3D v1 = new Vektor3D(2, 2, 4);
			Vektor3D v3 = LineareAlgebra.div(v1, 4.0);
			assert (v3.x == 0.5);
			assert (v3.y == 0.5);
			assert (v3.z == 1);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void isEqual2DLAPosTest() {
		Vektor2D v1 = new Vektor2D(4, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		assertTrue(v1.isEqual(v2));
	}

	@Test
	public void isEqual2DLANegTest() {
		Vektor2D v1 = new Vektor2D(5, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		assertFalse(v1.isEqual(v2));
	}

	@Test
	public void isEqual3DLAPosTest() {
		Vektor3D v1 = new Vektor3D(4, 3, 3);
		Vektor3D v2 = new Vektor3D(4, 3, 3);
		assertTrue(v1.isEqual(v2));
	}

	@Test
	public void isEqual3DLANegTest() {
		Vektor3D v1 = new Vektor3D(5, 3, 4);
		Vektor3D v2 = new Vektor3D(4, 3, 4);
		assertFalse(v1.isEqual(v2));
	}

	@Test
	public void isNotEqual2DLAPosTest() {
		Vektor2D v1 = new Vektor2D(3, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		assertTrue(v1.isNotEqual(v2));
	}

	@Test
	public void isNotEqual2DLANegTest() {
		Vektor2D v1 = new Vektor2D(4, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		assertFalse(v1.isNotEqual(v2));
	}

	@Test
	public void isNotEqual3DLAPosTest() {
		Vektor3D v1 = new Vektor3D(5, 3, 2);
		Vektor3D v2 = new Vektor3D(4, 3, 2);
		assertTrue(v1.isNotEqual(v2));
	}

	@Test
	public void isNotEqual3DLANegTest() {
		Vektor3D v1 = new Vektor3D(4, 3, 2);
		Vektor3D v2 = new Vektor3D(4, 3, 2);
		assertFalse(v1.isNotEqual(v2));
	}

	@Test
	public void length2DLACalcTest() {
		Vektor2D v = new Vektor2D(3, 4);
		assert (5.0 == LineareAlgebra.length(v));
	}

	@Test
	public void length3DLACalcTest() {
		Vektor3D v = new Vektor3D(3, 4, 0);
		assert (5.0 == LineareAlgebra.length(v));
	}

	@Test
	public void normalize2DLACalcTest() {
		Vektor2D v = new Vektor2D(3, 4);
		v = LineareAlgebra.normalize(v);
		assert (v.x == 0.6);
		assert (v.y == 0.8);
	}

	@Test
	public void normalize3DLACalcTest() {
		Vektor3D v = new Vektor3D(3, 4, 0);
		v = LineareAlgebra.normalize(v);
		assert (v.x == 0.6);
		assert (v.y == 0.8);
		assert (v.z == 0);
	}

	@Test
	public void euklDistance2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 3);
		Vektor2D v2 = new Vektor2D(5, 7);
		assert (5.0 == LineareAlgebra.euklDistance(v1, v2));
	}

	@Test
	public void euklDistance3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(2, 3, 9);
		Vektor3D v2 = new Vektor3D(5, 7, 9);
		assert (5.0 == LineareAlgebra.euklDistance(v1, v2));
	}

	@Test
	public void manhDistance2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 4);
		assert (3.0 == LineareAlgebra.manhattenDistance(v1));
	}

	@Test
	public void manhDistance2DLACalcWithNegTest() {
		Vektor2D v = new Vektor2D(2, -4);
		assert (6.0 == LineareAlgebra.manhattenDistance(v));
	}

	@Test
	public void manhDistance3DLACalcTest() {
		Vektor3D v = new Vektor3D(2, 4, 7);
		assert (13.0 == LineareAlgebra.manhattenDistance(v));
	}

	@Test
	public void manhDistance3DLACalcWithNegTest() {
		Vektor3D v = new Vektor3D(2, 4, -7);
		assert (13.0 == LineareAlgebra.manhattenDistance(v));
	}

	@Test
	public void crossProd3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(1, 0, 0);
		Vektor3D v2 = new Vektor3D(0, 1, 0);
		Vektor3D v3 = LineareAlgebra.crossProduct(v1, v2);
		assert (v3.x == 0);
		assert (v3.y == 0);
		assert (v3.z == 1);
	}

	@Test
	public void dotProd2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 4);
		Vektor2D v2 = new Vektor2D(4, 5);
		assert (28.0 == LineareAlgebra.dotProduct(v1, v2));
	}

	@Test
	public void dotProd3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(2, 4, 2);
		Vektor3D v2 = new Vektor3D(4, 5, 1);
		assert (30.0 == LineareAlgebra.dotProduct(v1, v2));
	}

	@Test
	public void cosEqu2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert (0.0 == LineareAlgebra.cosEquation(v1, v2));
	}

	@Test
	public void cosEqu3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(4, 0, 2);
		Vektor3D v2 = new Vektor3D(0, 4, 2);
		assert (0.0 == LineareAlgebra.cosEquation(v1, v2));
	}

	@Test
	public void sinEqu3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(4, 0, 2);
		Vektor3D v2 = new Vektor3D(0, 4, 2);
		assert (1.0 == LineareAlgebra.sinEquation(v1, v2));
	}

	@Test
	public void angRad2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert (0.25 == LineareAlgebra.angleRad(v1, v2));
	}

	@Test
	public void angRad3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(4, 0, 2);
		Vektor3D v2 = new Vektor3D(0, 4, 2);
		assert (0.25 == LineareAlgebra.angleRad(v1, v2));
	}

	@Test
	public void angDeg2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert (90 == LineareAlgebra.angleDegree(v1, v2));
	}

	@Test
	public void angDeg3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(4, 0, 2);
		Vektor3D v2 = new Vektor3D(0, 4, 2);
		assert (90 == LineareAlgebra.angleDegree(v1, v2));
	}

	@Test
	public void radToDegreeCalcTest() {
		assert (90 == LineareAlgebra.radToDegree(0.25));
	}

	@Test
	public void degreeToRadCalcTest() {
		assert (0.25 == LineareAlgebra.degreeToRad(90));
	}

	@Test
	public void det2DCalcTest() {
		Vektor2D v1 = new Vektor2D(2, 4);
		Vektor2D v2 = new Vektor2D(4, 6);
		assert (-4.0 == LineareAlgebra.determinante(v1, v2));
	}

	@Test
	public void det3DCalcTest() {
		Vektor3D v1 = new Vektor3D(2, 4, 2);
		Vektor3D v2 = new Vektor3D(4, 6, 1);
		Vektor3D v3 = new Vektor3D(5, 2, 4);
		assert (-44.0 == LineareAlgebra.determinante(v1, v2, v3));
	}

	@Test
	public void absCalc2DPosTest() {
		try {
			Vektor2D v1 = new Vektor2D(4, -2);
			Vektor2D v2 = LineareAlgebra.abs(v1);
			assert (v2.x == 4.0);
			assert (v2.y == 2.0);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(expected=Exception.class)
	public void absCalc2DNegTest() throws Exception {
		Vektor2D v1 = new Vektor2D(4, Double.MIN_VALUE);
		Vektor2D v2 = LineareAlgebra.abs(v1);
		assert (v2.x == 4.0);
		assert (v2.y == 0);
	}

	@Test
	public void absCalc3DPosTest() {
		try {
			Vektor3D v1 = new Vektor3D(4, -2, 2);
			Vektor3D v2 = LineareAlgebra.abs(v1);
			assert (v2.x == 4.0);
			assert (v2.y == 2.0);
			assert (v2.y == 2.0);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(expected=Exception.class)
	public void absCalc3DNegTest() throws Exception {
		Vektor3D v1 = new Vektor3D(4, Double.MIN_VALUE, 2);
		Vektor3D v2 = LineareAlgebra.abs(v1);
		assert (v2.x == 4.0);
		assert (v2.y == 0);
		assert (v2.z == 2.0);
	}

	@Test
	public void show2DTest() {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(b);
		System.setOut(p);
		LineareAlgebra.show(new Vektor2D(1, 2));
		String s = "Vektor2D [1, 2]";
		assert (s == p.toString());
	}

	@Test
	public void show3DTest() {
		PrintStream p = new PrintStream(new ByteArrayOutputStream());
		System.setOut(p);
		LineareAlgebra.show(new Vektor3D(1, 2, 3));
		String s = "Vektor2D [1, 2, 3]";
		assert (s == p.toString());
	}
}
