package repository;

import java.util.List;

import mapper.VoteMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.vote.Vote;

@Component
public class VoteDAO {
	
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//////////////////////////////////////////////////////////////////////////////

	public int insert(Vote vote) {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.insert(vote);
	}
	public int update(Vote vote) {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.update(vote);
	}
	public Vote selectVote(String vote_id) {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.selectVote(vote_id);
	}

	public List<Vote> selectList() {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.selectList();
	}

	public int selectUpdate() {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.selectUpdate();
	}

}
