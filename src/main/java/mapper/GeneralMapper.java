package mapper;

import java.util.List;

import vo.general.GeneralMeeting;

public interface GeneralMapper {
	
	public int insert(GeneralMeeting meeting);
	public int update(GeneralMeeting meeting);
	public GeneralMeeting selectGeneralMeeting(Object generalMeeting);
	public List<GeneralMeeting> selectList();
	public int selectUpdate();

}
