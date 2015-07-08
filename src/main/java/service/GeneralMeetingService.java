package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.GeneralMeetingDAO;
import vo.general.GeneralMeeting;

@Component
public class GeneralMeetingService {
	
	private GeneralMeetingDAO generalMeetingDAO;
	
	@Autowired
	public void setGeneralMeetingDAO(GeneralMeetingDAO generalMeetingDAO) {
		this.generalMeetingDAO = generalMeetingDAO;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	public int insert(GeneralMeeting meeting) {
		return generalMeetingDAO.insert(meeting);
	}
	public int update(GeneralMeeting meeting) {
		return generalMeetingDAO.update(meeting);
	}
	public GeneralMeeting selectGeneralMeeting(String general_id){
		return generalMeetingDAO.selectGeneralMeeting(general_id);
	}
	public List<GeneralMeeting> selectList(){
		return generalMeetingDAO.selectList();
	}

	public int selectUpdate() {
		return generalMeetingDAO.selectUpdate();
	}
	

}
