package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/*
import org.junit.Test;
import static org.junit.Assert.*;
*/
import beleg.DRechnung;

class DRechnungTest {
	@Test
	public void addDRTest() {
		double a = 5;
		double b = 8;
		try {
			assert(DRechnung.add(a, b) == 13);
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test //(expected = Exception.class)
	public void addOverflowDRTest() {
		double a = Double.MAX_VALUE;
		double b = 8;
		try {
			DRechnung.add(a, b);
			assert(false);
		} catch (Exception e) {
			assert(true);
		}
	}
	
	@Test //(expected = Exception.class)
	public void addUnderflowDRTest() {
		double a = Double.MIN_VALUE;
		double b = -5;
		try {
			DRechnung.add(a, b);
			assert(false);
		} catch (Exception e) {
			assert(true);
		}
	}
}
