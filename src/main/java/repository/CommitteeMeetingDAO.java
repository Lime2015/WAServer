package repository;

import java.util.List;

import mapper.CommitteeMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import vo.committee.CommitteeAssemblyman;
import vo.committee.CommitteeMeeting;
import vo.committee.CommitteeMeetingAttend;

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

	public CommitteeMeeting selectCommitteeMeeting(Object committeeMeeting) {
		CommitteeMapper mapper = session.getMapper(CommitteeMapper.class);
		return mapper.selectCommitteeMeeting(committeeMeeting);
	}

	public List<CommitteeMeeting> selectList() {
		CommitteeMapper mapper = session.getMapper(CommitteeMapper.class);
		return mapper.selectList();
	}

	public int selectUpdate() {
		CommitteeMapper mapper = session.getMapper(CommitteeMapper.class);
		return mapper.selectUpdate();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void create(int updateTAG,
			CommitteeMeetingAttend committeeMeetingAttend) throws Exception {

		CommitteeMapper mapper = session.getMapper(CommitteeMapper.class);
		try {
			for (CommitteeAssemblyman man : committeeMeetingAttend
					.getAssemblymen()) {

				System.out.println(man);
				String assemblyman_id = man.getAssemblyman_id();

				for (CommitteeMeeting meeting : man.getMeetings()) {
					meeting.setAssemblyman_id(assemblyman_id);
					meeting.setUpdate_tag(updateTAG + 1);

					System.out.println("meeting assembly_id : " + meeting.getAssemblyman_id());
					System.out.println("updateTAG = " + updateTAG);

					try {
						mapper.insert(meeting);
						System.out.println("Inserted into Data Table Successfully"
										+ man.getAssemblyman_id());

					} catch (Exception e) {
						int result = mapper.update(meeting);
						System.out.println("Update Data Table Successfully" 
								+ man.getAssemblyman_id());
						if (result == 0) {
							throw new RuntimeException("Insert & Update error!!" + man.getAssemblyman_id());
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;

		}
	}

}
