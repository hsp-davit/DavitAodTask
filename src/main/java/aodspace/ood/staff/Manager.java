package aodspace.ood.staff;

import java.time.LocalDate;

import aodspace.ood.staff.base.Member;
import aodspace.ood.staff.base.MemberType;
import aodspace.ood.util.MathUtil;

/**
 * initialize percent of manager
 * 
 * @author davit
 */
public class Manager extends Member {

	private static final int MANAGER_SALARY_WITH_PERCENT = 5;
	private static final int MANAGER_MAX_SALARY_PERCENTAGE = 40;
	private static final double MANAGER_SUBORDINATE_UP_PERCENT = 0.5;

	/**
	 * constructor for initialize Manager percent
	 */
	public Manager() {
		type = MemberType.MANAGER;
		annualSalaryWithPercent = MANAGER_SALARY_WITH_PERCENT;
		maximumSalaryPercentage = MANAGER_MAX_SALARY_PERCENTAGE;
		subordinatesWithPercent = MANAGER_SUBORDINATE_UP_PERCENT;
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
