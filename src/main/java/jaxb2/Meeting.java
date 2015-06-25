package jaxb2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="meeting")
@XmlAccessorType (XmlAccessType.FIELD)
public class Meeting {
	
	private String meeting_id;
	private String meeting_order;
	
	
	public String getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(String meeting_id) {
		this.meeting_id = meeting_id;
	}
	public String getMeeting_order() {
		return meeting_order;
	}
	public void setMeeting_order(String meeting_order) {
		this.meeting_order = meeting_order;
	}
	
	@Override
	public String toString() {
		return "Meeting [meeting_id=" + meeting_id + ", meeting_order="
				+ meeting_order + "]";
	}
	
	

}
