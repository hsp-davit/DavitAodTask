package aodspace.ood.staff.factory;

import aodspace.ood.exception.MemberNotFoundException;
import aodspace.ood.staff.Employee;
import aodspace.ood.staff.Manager;
import aodspace.ood.staff.Sales;
import aodspace.ood.staff.base.Member;
import aodspace.ood.staff.base.MemberType;

/**
 * class MemberFactory for create member by given type
 * 
 * @author davit
 *
 */
public final class MemberFactory {

	/**
	 * private default constructor
	 */
	private MemberFactory() {
	}

	/**
	 * make the member
	 * 
	 * @param memberType
	 * @return
	 */
	public static Member makeMember(MemberType memberType) {
		switch (memberType) {
		case EMPLOYEE: {
			return new Employee();
		}

		case MANAGER: {
			return new Manager();
		}

		case SALES: {
			return new Sales();
		}
		}

		throw new MemberNotFoundException(memberType + " member not found");
	}
}
