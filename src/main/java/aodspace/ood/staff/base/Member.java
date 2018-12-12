package aodspace.ood.staff.base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aodspace.ood.exception.IncorrectMemberException;
import aodspace.ood.util.DateUtil;
import aodspace.ood.util.MathUtil;

/**
 * class which contains informations about Member's details
 * 
 * @author davit
 *
 */
public abstract class Member {

	private static final double DEFAULT_SALARY = 100000;

	protected int annualSalaryWithPercent;
	protected int maximumSalaryPercentage;
	protected double subordinatesWithPercent;
	protected String name;
	protected Double salary;
	protected LocalDate joinDate;
	protected Member supervisor;
	protected MemberType type;
	protected List<Member> subordinates = new ArrayList<>();

	/**
	 * constructor for initialize default salary
	 */
	public Member() {
		salary = DEFAULT_SALARY;
	}

	/**
	 * salary for each year they have worked in the company
	 * 
	 * @param payDay
	 * @return
	 */
	public Double calculateSalary(LocalDate payDay) {
		int yearsOfWork = DateUtil.getYearsDifference(joinDate, payDay);

		Double dailySalary = DEFAULT_SALARY;
		for (int i = 0; i < yearsOfWork; i++) {
			Double salaryUp = dailySalary + MathUtil.calculatePercent(dailySalary, annualSalaryWithPercent);
			if (isMaximumSalary(salaryUp)) {
				return getMaxSalary();
			}
			dailySalary = salaryUp;
		}

		return dailySalary;
	}

	/**
	 * Check the given money greater than maximum salary or not
	 * 
	 * @param money
	 * @return
	 */
	private boolean isMaximumSalary(Double money) {
		return money > getMaxSalary();
	}

	/**
	 * get the max salary
	 * 
	 * @return
	 */
	private Double getMaxSalary() {
		return DEFAULT_SALARY + MathUtil.calculatePercent(DEFAULT_SALARY, maximumSalaryPercentage);
	}

	/**
	 * initialize supervisor
	 * 
	 * @param supervisor
	 */
	public void initSupervisor(Member supervisor) {
		validateSupervisor(supervisor);

		this.supervisor = supervisor;
		if (supervisor.isSupervisor()) {
			supervisor.addSubordinate(this);
		}
	}

	/**
	 * add subordinate
	 * 
	 * @param member
	 */
	public void addSubordinate(Member member) {
		subordinates.add(member);
	}

	/**
	 * Checks if current member supervisor or not
	 * 
	 * @return
	 */
	public boolean isSupervisor() {
		return type != MemberType.EMPLOYEE;
	}

	/**
	 * Validate supervisor
	 * 
	 * @param supervisor
	 */
	private void validateSupervisor(Member supervisor) {
		if (supervisor == null || supervisor.getName().equalsIgnoreCase("Employee")) {
			throw new IncorrectMemberException("Member can't be supervisor");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Member other = (Member) obj;
		if (joinDate == null) {
			if (other.joinDate != null) {
				return false;
			}
		} else if (!joinDate.equals(other.joinDate)) {
			return false;
		}

		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}

		if (salary == null) {
			if (other.salary != null) {
				return false;
			}
		} else if (!salary.equals(other.salary)) {
			return false;
		}

		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the joinDate
	 */
	public LocalDate getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}