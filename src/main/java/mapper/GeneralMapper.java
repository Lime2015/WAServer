package mapper;

import java.util.List;

import vo.general.GeneralMeeting;

public interface GeneralMapper {
	
	public int insert(GeneralMeeting meeting);
	public int update(GeneralMeeting meeting);
	public GeneralMeeting selectGeneralMeeting(String general_id);
	public List<GeneralMeeting> selectList();
	public int selectUpdate();

}
