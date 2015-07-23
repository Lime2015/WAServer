package mapper;

import java.util.List;

import vo.Assemblyman;

public interface TagMapper {
	public int checkAssemblymanTag();
	public int checkBillTag();
	public int checkCommitteeMeetingTag();
	public int checkGeneralMeetingTag();
	public int checkPartyHistoryTag();
	public int checkVoteTag();

}
