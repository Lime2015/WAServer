package repository;

import mapper.TagMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagDao {
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	//////////////////////////////////////////////////////

	public int checkAssemblymanTag(){
		TagMapper mapper = session.getMapper(TagMapper.class);
		return mapper.checkAssemblymanTag();
	}

	public int checkBillTag(){
		TagMapper mapper = session.getMapper(TagMapper.class);
		return mapper.checkBillTag();
	}

	public int checkCommitteeMeetingTag(){
		TagMapper mapper = session.getMapper(TagMapper.class);
		return mapper.checkCommitteeMeetingTag();
	}

	public int checkGeneralMeetingTag(){
		TagMapper mapper = session.getMapper(TagMapper.class);
		return mapper.checkGeneralMeetingTag();
	}

	public int checkPartyHistoryTag(){
		TagMapper mapper = session.getMapper(TagMapper.class);
		return mapper.checkPartyHistoryTag();
	}

	public int checkVoteTag(){
		TagMapper mapper = session.getMapper(TagMapper.class);
		return mapper.checkVoteTag();
	}

}
