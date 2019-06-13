package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import beleg.DRechnung;

class DRechnungTest {
	@Test
	public void addDRTest() throws Exception {
		double a = 5;
		double b = 8;
		assert (DRechnung.add(a, b) == 13);
	}

	@Test
	public void addOverflowDRTest() {
		double a = DRechnung.MAX;
		double b = 8;
		Assertions.assertThrows(Exception.class, () -> {
			DRechnung.add(a, b);
		});
	}

	@Test // (expected = Exception.class)
	public void addUnderflowDRTest() {
		double a = DRechnung.MIN;
		double b = -5;
		Assertions.assertThrows(Exception.class, () -> {
			DRechnung.add(a, b);
		});
	}

	@Test
	public void subDRTest() throws Exception {
		double a = 5;
		double b = 8;
		assert (DRechnung.sub(a, b) == -3);
	}

	@Test
	public void subOverflowDRTest() {
		double a = DRechnung.MAX;
		double b = DRechnung.MIN;
		Assertions.assertThrows(Exception.class, () -> {
			DRechnung.sub(a, b);
		});
	}

	@Test
	public void subUnderflowDRTest() {
		double a = DRechnung.MIN;
		double b = DRechnung.MAX;
		Assertions.assertThrows(Exception.class, () -> {
			DRechnung.sub(a, b);
		});
	}

	@Test
	public void multDRTest() throws Exception {
		double a = 5;
		double b = 20;
		assert (DRechnung.mult(a, b) == 100);
	}

	@Test
	public void multOverflowDRTest() {
		double a = DRechnung.MAX;
		double b = DRechnung.MAX;
		Assertions.assertThrows(Exception.class, () -> {
			DRechnung.mult(a, b);
		});
	}

	@Test
	public void multUnderflowDRTest() {
		double a = DRechnung.MIN;
		double b = DRechnung.MIN;
		Assertions.assertThrows(Exception.class, () -> {
			DRechnung.mult(a, b);
		});
	}

	@Test
	public void divDRTest() throws Exception {
		double a = 20;
		double b = 5;
		assert (DRechnung.div(a, b) == 4);
	}

	@Test
	public void divWithZeroDRTest() {
		double a = 20;
		double b = 0;
		Assertions.assertThrows(Exception.class, () -> {
			DRechnung.div(a, b);
		});
	}
}
