package beleg;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

//import org.junit.Rule;
//import org.junit.rules.ExpectedException;

//fail("fail message");

class LineareAlgebraTest {
	@Test
	void add2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 2);
		Vektor2D v2 = new Vektor2D(1, 5);
		Vektor2D v3 = add(v1, v2);
		assert(v3.x == 3);
		assert(v3.y == 7);
	}
	
	@Test
	void add3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(2, 2, 7);
		Vektor3D v2 = new Vektor3D(1, 5, 8);
		Vektor3D v3 = add(v1, v2);
		assert(v3.x == 3);
		assert(v3.y == 7);
		assert(v3.z == 15);
	}
	
	@Test
	void sub2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 2);
		Vektor2D v2 = new Vektor2D(1, 5);
		Vektor2D v3 = sub(v1, v2);
		assert(v3.x == 1);
		assert(v3.y == -3);
	}
	
	@Test
	void sub3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(2, 2, 7);
		Vektor3D v2 = new Vektor3D(1, 5, 8);
		Vektor3D v3 = sub(v1, v2);
		assert(v3.x == 1);
		assert(v3.y == -3);
		assert(v3.z == -1);
	}
	
	@Test
	void mult2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 2);
		Vektor2D v2 = new Vektor2D(1, 5);
		Vektor2D v3 = mult(v1, v2);
		assert(v3.x == 2);
		assert(v3.y == 10);
	}
	
	@Test
	void mult3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(2, 2, 4);
		Vektor3D v2 = new Vektor3D(1, 5, 9);
		Vektor3D v3 = mult(v1, v2);
		assert(v3.x == 2);
		assert(v3.y == 10);
		assert(v3.z == 36);
	}
	
	@Test
	void div2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 2);
		Vektor2D v2 = new Vektor2D(1, 5);
		Vektor2D v3 = div(v1, v2);
		assert(v3.x == 2);
		assert(v3.y == 0.4);
	}
	
	@Test
	void div3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(2, 2, 5);
		Vektor3D v2 = new Vektor3D(1, 5, 10);
		Vektor3D v3 = div(v1, v2);
		assert(v3.x == 2);
		assert(v3.y == 0.4);
		assert(v3.z == 0.5);
	}
	
	@Test
	void isEqual2DLAPosTest() {
		Vektor2D v1 = new Vektor2D(4, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		assertTrue(v1.isEqual(v2));
	}
	
	@Test
	void isEqual2DLANegTest() {
		Vektor2D v1 = new Vektor2D(5, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		assertFalse(v1.isEqual(v2));
	}
	
	@Test
	void isEqual3DLAPosTest() {
		Vektor3D v1 = new Vektor3D(4, 3);
		Vektor3D v2 = new Vektor3D(4, 3);
		assertTrue(v1.isEqual(v2));
	}
	
	@Test
	void isEqual3DLANegTest() {
		Vektor3D v1 = new Vektor3D(5, 3);
		Vektor3D v2 = new Vektor3D(4, 3);
		assertFalse(v1.isEqual(v2));
	}
	
	@Test
	void isNotEqual2DLAPosTest() {
		Vektor2D v1 = new Vektor2D(3, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		assertTrue(v1.isNotEqual(v2));
	}
	
	@Test
	void isNotEqual2DLANegTest() {
		Vektor2D v1 = new Vektor2D(4, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		assertFalse(v1.isNotEqual(v2));
	}
	
	@Test
	void isNotEqual3DLAPosTest() {
		Vektor3D v1 = new Vektor3D(5, 3, 2);
		Vektor3D v2 = new Vektor3D(4, 3, 2);
		assertTrue(v1.isNotEqual(v2));
	}
	
	@Test
	void isNotEqual3DLANegTest() {
		Vektor3D v1 = new Vektor3D(4, 3, 2);
		Vektor3D v2 = new Vektor3D(4, 3, 2);
		assertFalse(v1.isNotEqual(v2));
	}
	
	@Test
	void length2DLACalcTest() {
		Vektor2D v = new Vektor2D(3, 4);
		assert(5.0 == length(v));
	}
	
	@Test
	void length3DLACalcTest() {
		Vektor3D v = new Vektor3D(3, 4, 0);
		assert(5.0 == length(v));
	}
	
	@Test
	void normalize2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(3, 4);
		Vektor2D v2 = normalize(v1);
		assert(v2.x == 0.6);
		assert(v2.y == 0.8);
	}
	
	@Test
	void normalize3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(3, 4, 0);
		Vektor3D v2 = normalize(v1);
		assert(v.x == 0.6);
		assert(v.y == 0.8);
		assert(v.z == 0);
	}
	
	@Test
	void euklDistance2DLACalcTest() { //parallelität?
		Vektor2D v1 = new Vektor2D(2, 3);
		Vektor2D v2 = new Vektor2D(2, 3);
		assert(?? == euklDistance(v1, v2));
	}
	
	@Test
	void euklDistance3DLACalcTest() { //windschief?
		Vektor3D v1 = new Vektor3D(2, 3);
		Vektor3D v2 = new Vektor3D(2, 3);
		assert(?? == euklDistance(v1, v2));
	}
	
	@Test
	void manhDistance2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 4);
		Vektor2D v2 = new Vektor2D(4, 5);
		assert(3.0 == manhattenDistance(v1, v2));
	}
	
	@Test
	void manhDistance2DLACalcWithNegTest() {
		Vektor2D v = new Vektor2D(2, -4);
		assert(6.0 == manhattenDistance(v));
	}
	
	@Test
	void manhDistance3DLACalcTest() {
		Vektor3D v = new Vektor3D(2, 4, 7);
		assert(13.0 == manhattenDistance(v));
	}
	
	@Test
	void manhDistance3DLACalcWithNegTest() {
		Vektor3D v = new Vektor3D(2, 4, -7);
		assert(13.0 == manhattenDistance(v));
	}
	
	@Test
	void crossProd3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(1, 0, 0);
		Vektor3D v2 = new Vektor3D(0, 1, 0);
		Vektor3D v3 = crossProduct(v1, v2);
		assert(v3.x == 0);
		assert(v3.y == 0);
		assert(v3.z == 1);
	}
	
	@Test
	void dotProd2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(2, 4);
		Vektor2D v2 = new Vektor2D(4, 5);
		assert(28.0 == dotProduct(v1, v2));
	}
	
	@Test
	void dotProd3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(2, 4, 2);
		Vektor3D v2 = new Vektor3D(4, 5, 1);
		assert(30.0 == dotProduct(v1, v2));
	}
	
	@Test
	void cosEqu2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert(0.0 == cosEquation(v1, v2));
	}
	
	@Test
	void cosEqu3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(4, 0, 2);
		Vektor3D v2 = new Vektor3D(0, 4, 2);
		assert(0.0 == cosEquation(v1, v2));
	}
	
	@Test
	void sinEqu2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert(1.0 == sinEquation(v1, v2));
	}
	
	@Test
	void sinEqu3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(4, 0, 2);
		Vektor3D v2 = new Vektor3D(0, 4, 2);
		assert(1.0 == sinEquation(v1, v2));
	}
	
	@Test
	void angRad2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert(0.25 == angleRad(v1, v2));
	}
	
	@Test
	void angRad3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(4, 0, 2);
		Vektor3D v2 = new Vektor3D(0, 4, 2);
		assert(0.25 == angleRad(v1, v2));
	}
	
	@Test
	void angDeg2DLACalcTest() {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert(90 == angleDegree(v1, v2));
	}
	
	@Test
	void angDeg3DLACalcTest() {
		Vektor3D v1 = new Vektor3D(4, 0, 2);
		Vektor3D v2 = new Vektor3D(0, 4, 2);
		assert(90 == angleDegree(v1, v2));
	}
	
	@Test
	void radToDegreeCalcTest() {
		assert(90 == radToDegree(0.25));
	}
	
	@Test
	void degreeToRadCalcTest() {
		assert(0.25 == degreeToRad(90));
	}
}
