package mapper;

import vo.MemberInfo;

public interface MemberInfoMapper {
	public int insert(MemberInfo memberInfo);
	public int update(MemberInfo memberInfo);
	public MemberInfo select(String memberId);
}
