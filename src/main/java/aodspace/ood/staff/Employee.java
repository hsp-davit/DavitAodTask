package aodspace.ood.staff;

import aodspace.ood.staff.base.Member;
import aodspace.ood.staff.base.MemberType;

/**
 * initialize percent of employee
 * 
 * @author davit
 *
 */
public class Employee extends Member {

	private static final int EMPLOYEE_SALARY_WITH_PERCENT = 3;
	private static final int EMPLOYEE_MAXIMUM_SALARY_PERCENTAGE = 30;

	/**
	 * constructor for initialize Employee percent
	 */
	public Employee() {
		type = MemberType.EMPLOYEE;
		annualSalaryWithPercent = EMPLOYEE_SALARY_WITH_PERCENT;
		maximumSalaryPercentage = EMPLOYEE_MAXIMUM_SALARY_PERCENTAGE;
	}
}
