package aodspace.ood;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import aodspace.ood.staff.Employee;
import aodspace.ood.staff.Manager;
import aodspace.ood.staff.Sales;
import aodspace.ood.staff.base.MemberType;

/**
 * test methods
 * 
 * @author davit
 */
public class CompanyTest {
	
	@Test
	public void testAddMember() {
		Company company = new Company();
		
		company.addMember("Employee", LocalDate.of(2017, Month.JULY, 29), MemberType.EMPLOYEE);
		company.addMember("Manager", LocalDate.of(2017, Month.JULY, 29), MemberType.MANAGER);
		company.addMember("Sales", LocalDate.of(2017, Month.JULY, 29), MemberType.SALES);
			
		assertEquals(3, company.getMembers().size());
		
		assertEquals(company.getMembers().get(0).getClass(), Employee.class);
		assertEquals(company.getMembers().get(1).getClass(), Manager.class);
		assertEquals(company.getMembers().get(2).getClass(), Sales.class);
	}
}
