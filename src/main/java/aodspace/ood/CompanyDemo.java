package aodspace.ood;

import java.time.LocalDate;
import java.time.Month;

import aodspace.ood.staff.base.Member;
import aodspace.ood.staff.base.MemberType;
import aodspace.ood.util.MathUtil;

/**
 * class for testing
 * 
 * @author davit
 */
public class CompanyDemo {
	static Company company = new Company();

	public static void main(String[] args) {

		Member employee = company.addMember("Employee", LocalDate.of(2017, Month.JULY, 29), MemberType.EMPLOYEE);
		Member manager = company.addMember("Manager", LocalDate.of(2017, Month.JULY, 29), MemberType.MANAGER);
		Member sales = company.addMember("Sales", LocalDate.of(2017, Month.JULY, 29), MemberType.SALES);

		employee.initSupervisor(manager);
		employee.initSupervisor(sales);

		LocalDate payDay = LocalDate.now();
		printMemberWhitSalary(payDay);

	}

	/**
	 * print member whit salary
	 * 
	 * @param payDay
	 */
	private static void printMemberWhitSalary(LocalDate payDay) {
		for (Member member : company.getMembers()) {
			double salary = MathUtil.round(member.calculateSalary(payDay));

			System.out.println("Member: " + member.getName() + " Salary: " + salary);
		}
	}
}
