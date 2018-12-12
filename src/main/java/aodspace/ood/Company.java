package aodspace.ood;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aodspace.ood.exception.IncorrectMemberException;
import aodspace.ood.staff.base.Member;
import aodspace.ood.staff.base.MemberType;
import aodspace.ood.staff.factory.MemberFactory;

/**
 * Class company, which contains list of members
 * 
 * @author davit
 *
 */
public class Company {

	private List<Member> members = new ArrayList<>();

	/**
	 * default constructor
	 */
	public Company() {
	}

	/**
	 * Add new member with type
	 * 
	 * @param name
	 * @param joinDate
	 * @param type
	 * @return
	 */
	public Member addMember(String name, LocalDate joinDate, MemberType type) {
		Member member = MemberFactory.makeMember(type);

		member.setName(name);
		member.setJoinDate(joinDate);

		members.add(member);

		return member;
	}

	/**
	 * @return the members
	 */
	public List<Member> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
