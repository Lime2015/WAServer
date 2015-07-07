package vo;

import java.util.Date;

public class MemberInfo {

	private String memberId;
	private int logonTypeId;
	private String memberNickname;
	private String address;
	private Date birthDate;
	private String gender;
	
	public MemberInfo(){}
	
	public MemberInfo(String memberId, int logonTypeId, String memberNickname, String address, Date birthDate, String gender) {
		this.memberId = memberId;
		this.logonTypeId = logonTypeId;
		this.memberNickname = memberNickname;
		this.address = address;
		this.birthDate = birthDate;
		this.gender = gender;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getLogonTypeId() {
		return logonTypeId;
	}

	public void setLogonTypeId(int logonTypeId) {
		this.logonTypeId = logonTypeId;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
