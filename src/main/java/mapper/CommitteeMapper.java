package mapper;

import java.util.List;

import vo.committee.CommitteeMeeting;

public interface CommitteeMapper {

	public int insert(CommitteeMeeting meeting);
	public int update(CommitteeMeeting meeting);
	public CommitteeMeeting selectCommitteeMeeting(String committee_id);
	public List<CommitteeMeeting> selectList();

}
