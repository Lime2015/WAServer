package repository;

import mapper.MemberInfoMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.MemberInfo;

@Component
public class MemberInfoDao {
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	//////////////////////////////////////////////////////
	
	public int insert(MemberInfo memberInfo){
		MemberInfoMapper mapper = session.getMapper(MemberInfoMapper.class);
		return mapper.insert(memberInfo);
	}
	
	public int update(MemberInfo memberInfo){
		MemberInfoMapper mapper = session.getMapper(MemberInfoMapper.class);
		return mapper.update(memberInfo);
	}
	
	public MemberInfo select(String memberId){
		MemberInfoMapper mapper = session.getMapper(MemberInfoMapper.class);
		return mapper.select(memberId);
	}
}
