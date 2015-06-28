package vo.committee;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import vo.vote.Vote;

@XmlRootElement(name = "assemblyman")
@XmlAccessorType (XmlAccessType.FIELD)
public class CommitteeAssemblyman {

	@XmlElement(name = "assemblyman_id")
	private String assemblyman_id;
	
	@XmlElementWrapper(name="meetings")
	@XmlElement(name = "meetings")
	private List<CommitteeMeeting> meetings;
	
	/////////////////////////////////////////////////////////////////////////
	public String getAssemblyman_id() {
		return assemblyman_id;
	}

	public void setAssemblyman_id(String assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}

	public List<CommitteeMeeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<CommitteeMeeting> meetings) {
		this.meetings = meetings;
	}
	
}

