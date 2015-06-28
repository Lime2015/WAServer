package repository;

import java.util.List;

import mapper.CommitteeMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.committee.CommitteeMeeting;

@Component
public class CommitteeMeetingDAO {

	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//////////////////////////////////////////////////////////////////////////////

	public int insert(CommitteeMeeting meeting) {
		CommitteeMapper mapper = session.getMapper(CommitteeMapper.class);
		return mapper.insert(meeting);
	}

	public int update(CommitteeMeeting meeting) {
		CommitteeMapper mapper = session.getMapper(CommitteeMapper.class);
		return mapper.update(meeting);
	}

	public CommitteeMeeting selectCommitteeMeeting(String committee_id) {
		CommitteeMapper mapper = session.getMapper(CommitteeMapper.class);
		return mapper.selectCommitteeMeeting(committee_id);
	}

	public List<CommitteeMeeting> selectList() {
		CommitteeMapper mapper = session.getMapper(CommitteeMapper.class);
		return mapper.selectList();
	}

}
