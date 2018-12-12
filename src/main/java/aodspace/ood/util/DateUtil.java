package aodspace.ood.util;

import java.time.LocalDate;
import java.time.Period;

/**
 * utility class which contain method about date
 * 
 * @author davit
 *
 */
public final class DateUtil {

	/**
	 * private default constructor
	 */
	private DateUtil() {

	}

	/**
	 * get difference between two years
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static int getYearsDifference(LocalDate from, LocalDate to) {
		return Period.between(from, to).getYears();
	}
}
