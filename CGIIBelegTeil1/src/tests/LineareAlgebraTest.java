package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import beleg.LineareAlgebra;
import beleg.Vektor2D;
import beleg.Vektor3D;
import beleg.DRechnung;

import java.io.*;

public class LineareAlgebraTest {
	@Test
	public void add2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(2, 2);
		Vektor2D v2 = new Vektor2D(1, 5);
		Vektor2D v3 = LineareAlgebra.add(v1, v2);
		assert (v3.x == 3);
		assert (v3.y == 7);
	}

	@Test
	public void add3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(2, 2, 7);
		Vektor3D v2 = new Vektor3D(1, 5, 8);
		Vektor3D v3 = LineareAlgebra.add(v1, v2);
		assert (v3.x == 3);
		assert (v3.y == 7);
		assert (v3.z == 15);
	}

	@Test
	public void sub2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(2, 2);
		Vektor2D v2 = new Vektor2D(1, 5);
		Vektor2D v3 = LineareAlgebra.sub(v1, v2);
		assert (v3.x == 1);
		assert (v3.y == -3);
	}

	@Test
	public void sub3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(2, 2, 7);
		Vektor3D v2 = new Vektor3D(1, 5, 8);
		Vektor3D v3 = LineareAlgebra.sub(v1, v2);
		assert (v3.x == 1);
		assert (v3.y == -3);
		assert (v3.z == -1);
	}

	@Test
	public void mult2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(2, 2);
		Vektor2D v2 = LineareAlgebra.mult(v1, 2);
		assert (v2.x == 4);
		assert (v2.y == 4);
	}

	@Test
	public void mult3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(2, 2, 4);
		Vektor3D v2 = LineareAlgebra.mult(v1, 4.0);
		assert (v2.x == 8);
		assert (v2.y == 8);
		assert (v2.z == 16);
	}

	@Test
	public void div2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(2, 2);
		Vektor2D v2 = LineareAlgebra.div(v1, 2.0);
		assert (v2.x == 1);
		assert (v2.y == 1);
	}

	@Test
	public void div3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(2, 2, 4);
		Vektor3D v2 = LineareAlgebra.div(v1, 4.0);
		assert (v2.x == 0.5);
		assert (v2.y == 0.5);
		assert (v2.z == 1);
	}

	@Test
	public void isEqual2DLAPosTest() {
		Vektor2D v1 = new Vektor2D(4, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		Assertions.assertTrue(v1.isEqual(v2));
	}

	@Test
	public void isEqual2DLANegTest() {
		Vektor2D v1 = new Vektor2D(5, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		Assertions.assertFalse(v1.isEqual(v2));
	}

	@Test
	public void isEqual3DLAPosTest() {
		Vektor3D v1 = new Vektor3D(4, 3, 3);
		Vektor3D v2 = new Vektor3D(4, 3, 3);
		Assertions.assertTrue(v1.isEqual(v2));
	}

	@Test
	public void isEqual3DLANegTest() {
		Vektor3D v1 = new Vektor3D(5, 3, 4);
		Vektor3D v2 = new Vektor3D(4, 3, 4);
		Assertions.assertFalse(v1.isEqual(v2));
	}

	@Test
	public void isNotEqual2DLAPosTest() {
		Vektor2D v1 = new Vektor2D(3, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		Assertions.assertTrue(v1.isNotEqual(v2));
	}

	@Test
	public void isNotEqual2DLANegTest() {
		Vektor2D v1 = new Vektor2D(4, 3);
		Vektor2D v2 = new Vektor2D(4, 3);
		Assertions.assertFalse(v1.isNotEqual(v2));
	}

	@Test
	public void isNotEqual3DLAPosTest() {
		Vektor3D v1 = new Vektor3D(5, 3, 2);
		Vektor3D v2 = new Vektor3D(4, 3, 2);
		Assertions.assertTrue(v1.isNotEqual(v2));
	}

	@Test
	public void isNotEqual3DLANegTest() {
		Vektor3D v1 = new Vektor3D(4, 3, 2);
		Vektor3D v2 = new Vektor3D(4, 3, 2);
		Assertions.assertFalse(v1.isNotEqual(v2));
	}

	@Test
	public void length2DLACalcTest() throws Exception {
		Vektor2D v = new Vektor2D(3, 4);
		assert (5.0 == LineareAlgebra.length(v));
	}

	@Test
	public void length3DLACalcTest() throws Exception {
		Vektor3D v = new Vektor3D(3, 4, 0);
		assert (5.0 == LineareAlgebra.length(v));
	}
	
	@Test 
	public void lengthOverflow3DTest() {
		Vektor3D v = new Vektor3D(DRechnung.MAX, 3, 4);
		Assertions.assertThrows (Exception.class, () -> {
			v.length();
		});
	}

	@Test
	public void normalize2DLACalcTest() throws Exception {
		Vektor2D v = new Vektor2D(3, 4);
		v = LineareAlgebra.normalize(v);
		assert (v.x == 0.6);
		assert (v.y == 0.8);
	}

	@Test
	public void normalize3DLACalcTest() throws Exception {
		Vektor3D v = new Vektor3D(3, 4, 0);
		v = LineareAlgebra.normalize(v);
		assert (v.x == 0.6);
		assert (v.y == 0.8);
		assert (v.z == 0);
	}

	@Test
	public void euklDistance2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(2, 3);
		Vektor2D v2 = new Vektor2D(5, 7);
		assert (5.0 == LineareAlgebra.euklDistance(v1, v2));
	}

	@Test
	public void euklDistance3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(2, 3, 9);
		Vektor3D v2 = new Vektor3D(5, 7, 9);
		assert (5.0 == LineareAlgebra.euklDistance(v1, v2));
	}

	@Test
	public void manhDistance2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(2, 4);
		assert (6.0 == LineareAlgebra.manhattenDistance(v1));
	}

	@Test
	public void manhDistance2DLACalcWithNegTest() throws Exception {
		Vektor2D v = new Vektor2D(2, -4);
		assert (6.0 == LineareAlgebra.manhattenDistance(v));
	}

	@Test
	public void manhDistance3DLACalcTest() throws Exception {
		Vektor3D v = new Vektor3D(2, 4, 7);
		assert (13.0 == LineareAlgebra.manhattenDistance(v));
	}

	@Test
	public void manhDistance3DLACalcWithNegTest() throws Exception {
		Vektor3D v = new Vektor3D(2, 4, -7);
		assert (13.0 == LineareAlgebra.manhattenDistance(v));
	}

	@Test
	public void crossProd3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(1, 0, 0);
		Vektor3D v2 = new Vektor3D(0, 1, 0);
		Vektor3D v3 = LineareAlgebra.crossProduct(v1, v2);
		assert (v3.x == 0);
		assert (v3.y == 0);
		assert (v3.z == 1);
	}

	@Test
	public void dotProd2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(2, 4);
		Vektor2D v2 = new Vektor2D(4, 5);
		assert (28.0 == LineareAlgebra.dotProduct(v1, v2));
	}

	@Test
	public void dotProd3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(2, 4, 2);
		Vektor3D v2 = new Vektor3D(4, 5, 1);
		assert (30.0 == LineareAlgebra.dotProduct(v1, v2));
	}

	@Test
	public void cosEqu2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert (0.0 == LineareAlgebra.cosEquation(v1, v2));
	}

	@Test
	public void cosEqu3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(4, 0, 0);
		Vektor3D v2 = new Vektor3D(0, 4, 0);
		System.out.println("cosEq: " + LineareAlgebra.cosEquation(v1, v2));
		assert (0.0 == LineareAlgebra.cosEquation(v1, v2));
	}

	@Test
	public void sinEqu3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(4, 0, 0);
		Vektor3D v2 = new Vektor3D(0, 4, 0);
		assert (1.0 == LineareAlgebra.sinEquation(v1, v2));
	}

	@Test
	public void angRad2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert (1.5708 == Math.round(LineareAlgebra.angleRad(v1, v2)*10000.0)/10000.0);
	}

	@Test
	public void angRad3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(4, 0, 0);
		Vektor3D v2 = new Vektor3D(0, 4, 0);
		assert (1.5708 == Math.round(LineareAlgebra.angleRad(v1, v2)*10000.0)/10000.0);
	}

	@Test
	public void angDeg2DLACalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(4, 0);
		Vektor2D v2 = new Vektor2D(0, 4);
		assert (90 == LineareAlgebra.angleDegree(v1, v2));
	}

	@Test
	public void angDeg3DLACalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(4, 0, 0);
		Vektor3D v2 = new Vektor3D(0, 4, 0);
		assert (90 == LineareAlgebra.angleDegree(v1, v2));
	}

	@Test
	public void radToDegreeCalcTest() throws Exception {
		assert (90 == Math.round(LineareAlgebra.radToDegree(1.570796)*10000.0)/10000.0);
	}

	@Test
	public void degreeToRadCalcTest() throws Exception {
		assert (1.5708 == Math.round(LineareAlgebra.degreeToRad(90)*10000.0)/10000.0);
	}

	@Test
	public void det2DCalcTest() throws Exception {
		Vektor2D v1 = new Vektor2D(2, 4);
		Vektor2D v2 = new Vektor2D(4, 6);
		assert (-4.0 == LineareAlgebra.determinante(v1, v2));
	}

	@Test
	public void det3DCalcTest() throws Exception {
		Vektor3D v1 = new Vektor3D(2, 4, 2);
		Vektor3D v2 = new Vektor3D(4, 6, 1);
		Vektor3D v3 = new Vektor3D(5, 2, 4);
		assert (-44.0 == LineareAlgebra.determinante(v1, v2, v3));
	}

	@Test
	public void absCalc2DPosTest() throws Exception {
		Vektor2D v1 = new Vektor2D(4, -2);
		Vektor2D v2 = LineareAlgebra.abs(v1);
		assert (v2.x == 4.0);
		assert (v2.y == 2.0);
	}

	@Test
	public void absCalc3DPosTest() throws Exception {
		Vektor3D v1 = new Vektor3D(4, -2, 2);
		Vektor3D v2 = LineareAlgebra.abs(v1);
		assert (v2.x == 4.0);
		assert (v2.y == 2.0);
		assert (v2.y == 2.0);
	}

	@Test
	public void show2DTest() {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(b);
		PrintStream sOut = System.out;
		System.setOut(p);
		LineareAlgebra.show(new Vektor2D(1, 2));
		System.setOut(sOut);
		String ist = b.toString();
		
		
		b = new ByteArrayOutputStream();
		p = new PrintStream(b);
		sOut = System.out;
		System.setOut(p);
		System.out.println("Vektor2D [1.0, 2.0]");
		String soll = b.toString();
		System.setOut(sOut);
		
		Assertions.assertEquals(soll, ist);
	}

	@Test
	public void show3DTest() {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(b);
		PrintStream sOut = System.out;
		System.setOut(p);
		LineareAlgebra.show(new Vektor3D(1, 2, 3));
		System.setOut(sOut);
		String ist = b.toString();
		
		b = new ByteArrayOutputStream();
		p = new PrintStream(b);
		sOut = System.out;
		System.setOut(p);
		System.out.println("Vektor3D [1.0, 2.0, 3.0]");
		String soll = b.toString();
		System.setOut(sOut);
		
		Assertions.assertEquals(soll, ist);
	}
}
