package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.CommitteeMeetingDAO;
import vo.committee.CommitteeMeeting;
import vo.committee.CommitteeMeetingAttend;

@Component
public class CommitteeMeetingService {
	
	private CommitteeMeetingDAO committeeMeetingDAO;
	
	@Autowired
	public void setCommitteeMeetingDAO(CommitteeMeetingDAO committeeMeetingDAO) {
		this.committeeMeetingDAO = committeeMeetingDAO;
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	public int insert(CommitteeMeeting meeting) {
		return committeeMeetingDAO.insert(meeting);
	}
	public int update(CommitteeMeeting meeting) {
		return committeeMeetingDAO.update(meeting);
	}
	public CommitteeMeeting selectCommitteeMeeting(Object committeeMeeting){
		return committeeMeetingDAO.selectCommitteeMeeting(committeeMeeting);
	}
	public List<CommitteeMeeting> selectList(){
		return committeeMeetingDAO.selectList();
	}
	public int selectUpdate(){
		return committeeMeetingDAO.selectUpdate();
	}

	public void saveData(int updateTAG,
			CommitteeMeetingAttend committeeMeetingAttend) throws Exception {
		committeeMeetingDAO.create(updateTAG, committeeMeetingAttend);
		
	}
	
}
