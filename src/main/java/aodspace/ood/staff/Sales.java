package aodspace.ood.staff;

import java.time.LocalDate;

import aodspace.ood.staff.base.Member;
import aodspace.ood.staff.base.MemberType;
import aodspace.ood.util.MathUtil;

/**
 * initialize percent of sales
 * 
 * @author davit
 */
public class Sales extends Member {

	private static final int SALES_SALARY_WITH_PERCENT = 1;
	private static final int SALES_MAXIMUM_SALARY_PERCENTAGE = 35;
	private static final double SALES_SUBORDINATE_UP_PERCENT = 0.3;

	/**
	 * constructor for initialize Sales percent
	 */
	public Sales() {
		type = MemberType.SALES;
		annualSalaryWithPercent = SALES_SALARY_WITH_PERCENT;
		maximumSalaryPercentage = SALES_MAXIMUM_SALARY_PERCENTAGE;
		subordinatesWithPercent = SALES_SUBORDINATE_UP_PERCENT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see aodspace.ood.staff.base.StaffMember#calculateSalary(java.time.LocalDate)
	 */
	public Double calculateSalary(LocalDate payDay) {
		Double salary = super.calculateSalary(payDay);

		for (Member subordinate : subordinates) {
			salary += MathUtil.calculatePercent(subordinate.calculateSalary(payDay), subordinatesWithPercent);
		}

		return salary;
	}
}
