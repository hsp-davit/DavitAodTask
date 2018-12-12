package aodspace.ood.util;

/**
 * utility class which contain method about Math
 * 
 * @author davit
 *
 */
public final class MathUtil {

	private static final int DIVISOR = 100;

	/**
	 * private default constructor
	 */
	private MathUtil() {

	}

	/**
	 * calculate percent
	 * 
	 * @param number
	 * @param percent
	 * @return
	 */
	public static double calculatePercent(double number, double percent) {
		return number * percent / DIVISOR;
	}

	/**
	 * rounded number
	 * 
	 * @param number
	 * @param precision
	 * @return
	 */
	public static double round(double number) {
		return Math.round(number * DIVISOR) / DIVISOR;
	}
}
