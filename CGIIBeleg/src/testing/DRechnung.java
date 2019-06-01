package testing;

import org.junit.Test;

public class DRechnung {
	public static double MIN = -Double.MAX_VALUE;
	public static double MAX = Double.MAX_VALUE;

	private DRechnung() {
	}

	@Test
	public static double add(double a, double b) throws Exception {
		if ((a > 0) && (b > MAX - a)) {
			throw new Exception("Double Overflow");
		}
		if ((a < 0) && (b < MIN - a)) {
			throw new Exception("Double Underflow");
		}
		return a + b;
	}

	@Test
	public static double sub(double a, double b) throws Exception {
		return add(a, -b);
	}

	@Test
	public static double mult(double a, double b) throws Exception {
		if (Math.abs(a) > Math.abs(MAX / b)) {
			throw new Exception("Double Overflow");
		}
		/*
		if (a < MIN / b) {
			throw new Exception("Double Underflow");
		}
		*/
		return a * b;
	}

	@Test
	public static double div(double a, double b) throws Exception {
		if (b == 0) {
			throw new Exception("Division by zero is not defined");
		}
		if (b > -1 && b < 1)
			return mult(a, 1 / b);
		return a / b;
	}

}
