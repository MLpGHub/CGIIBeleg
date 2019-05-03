package beleg;

public class DRechnung {
	private DRechnung() {}
	
	public static double add(double a, double b) throws Exception{
		if ((a > 0) && (b > Double.MAX_VALUE - a)) {
			throw new Exception("Double Overflow");
		}
		if ((a < 0) && (b < Double.MIN_VALUE - a)) {
			throw new Exception("Double Underflow");
		}
		return a + b;
	}
	
	public static double sub(double a, double b) throws Exception {
		return add(a, -b);
	}
	
	public static double mult(double a, double b) throws Exception {
		if (a > Double.MAX_VALUE / b) {
			throw new Exception("Double Overflow");
		}
		if ((a < Double.MIN_VALUE / b)) {
			throw new Exception("Double Underflow");
		}

		if ((a == -1) && (b == Double.MIN_VALUE)) {
			throw new Exception("Double Overflow");
		}
		else if ((b == -1) && (a == Double.MIN_VALUE)) {
			throw new Exception("Double Overflow");
		}
		return a * b;
	}
	
	public static double div(double a, double b) throws Exception {
		if (b > -1 && b < 1) return mult(a, 1/b);
		return a / b;
	}
	
}
