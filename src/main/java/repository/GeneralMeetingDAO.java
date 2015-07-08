package repository;

import java.util.List;

import mapper.GeneralMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.general.GeneralMeeting;

@Component
public class GeneralMeetingDAO {
	
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//////////////////////////////////////////////////////////////////////////////

	public int insert(GeneralMeeting meeting) {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class); 
		return mapper.insert(meeting);
	}
	public int update(GeneralMeeting meeting) {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class); 
		return mapper.update(meeting);
	}
	public GeneralMeeting selectGeneralMeeting(String general_id) {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class);
		return mapper.selectGeneralMeeting(general_id);
	}
	public List<GeneralMeeting> selectList() {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class);
		return mapper.selectList();
	}

	public int selectUpdate() {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class);
		return mapper.selectUpdate();
	}

}
