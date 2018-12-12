package aodspace.ood;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import aodspace.ood.staff.base.Member;
import aodspace.ood.staff.base.MemberType;
import aodspace.ood.staff.factory.MemberFactory;
import aodspace.ood.util.MathUtil;

/**
 * test methods
 * 
 * @author davit
 *
 */
public class MemberTest {

	@Test
	public void testEmployeeSalary() {
		Member employee1 = initMember("Employee", LocalDate.of(2017, Month.JULY, 29), MemberType.EMPLOYEE);

		double salary = MathUtil.round(employee1.calculateSalary(LocalDate.now()));
		assertEquals(103000, salary, 0);

		Member employee2 = initMember("MaxSalary", LocalDate.of(2000, Month.JULY, 29), MemberType.EMPLOYEE);
		salary = MathUtil.round(employee2.calculateSalary(LocalDate.now()));

		assertEquals(130000, salary, 0);
	}

	@Test
	public void testManagerSalary() {
		Member manager1 = initMember("Manager", LocalDate.of(2017, Month.JULY, 29), MemberType.MANAGER);
		double salary = MathUtil.round(manager1.calculateSalary(LocalDate.now()));

		assertEquals(105000, salary, 0);

		Member manager2 = initMember("MaxSalary", LocalDate.of(2000, Month.JULY, 29), MemberType.MANAGER);
		salary = MathUtil.round(manager2.calculateSalary(LocalDate.now()));

		assertEquals(140000, salary, 0);

		Member employee1 = initMember("Manager2Subordinate", LocalDate.of(2017, Month.JULY, 29), MemberType.EMPLOYEE);
		employee1.initSupervisor(manager2);

		salary = MathUtil.round(manager2.calculateSalary(LocalDate.now()));

		assertEquals(140515, salary, 0);
	}

	@Test
	public void testSalesSalary() {
		Member sales1 = initMember("Sales", LocalDate.of(2017, Month.JULY, 29), MemberType.SALES);
		double salary = MathUtil.round(sales1.calculateSalary(LocalDate.now()));

		assertEquals(101000, salary, 0);

		Member sales2 = initMember("MaxSalary", LocalDate.of(1000, Month.JULY, 29), MemberType.SALES);
		salary = MathUtil.round(sales2.calculateSalary(LocalDate.now()));

		assertEquals(135000, salary, 0);

		Member manager = initMember("Sales2Subordinate", LocalDate.of(2017, Month.JULY, 29), MemberType.MANAGER);
		manager.initSupervisor(sales2);

		salary = MathUtil.round(sales2.calculateSalary(LocalDate.now()));

		assertEquals(135315, salary, 0);
	}

	/**
	 * initialize member by given types
	 * 
	 * @param name
	 * @param joinDate
	 * @param type
	 * @return
	 */
	public Member initMember(String name, LocalDate joinDate, MemberType type) {
		Member member = MemberFactory.makeMember(type);

		member.setName(name);
		member.setJoinDate(joinDate);

		return member;
	}
}
