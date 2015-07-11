package repository;

import java.util.List;

import mapper.PartyMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.party.PartyHistory;

@Component
public class PartyDAO {
	
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//////////////////////////////////////////////////

	public int insert(PartyHistory his) {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.insert(his);
	}

	public int update(PartyHistory his) {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.update(his);
	}

	public PartyHistory selectParty(Object history) {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.selectParty(history);
	}

	public List<PartyHistory> selectList() {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.selectList();
	}

	public int selectUpdate() {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.selectUpdate();
	}

}
