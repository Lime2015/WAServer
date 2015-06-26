package vo.committee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="meeting")
@XmlAccessorType (XmlAccessType.FIELD)
public class CommitteeMeeting {
	
	private Integer assemblyman_id;
	private Integer update_tag;
	
	private Integer meeting_id;
	private String meeting_name;
	private String meeting_order;
	private String meeting_date;
	private String mod_dttm;
	private String attend_status;
	
	
	////////////////////////////////////////////////////////////////////////////
	public Integer getAssemblyman_id() {
		return assemblyman_id;
	}
	public void setAssemblyman_id(Integer assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}
	public Integer getUpdate_tag() {
		return update_tag;
	}
	public void setUpdate_tag(Integer update_tag) {
		this.update_tag = update_tag;
	}
	public Integer getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(Integer meeting_id) {
		this.meeting_id = meeting_id;
	}
	public String getMeeting_name() {
		return meeting_name;
	}
	public void setMeeting_name(String meeting_name) {
		this.meeting_name = meeting_name;
	}
	public String getMeeting_order() {
		return meeting_order;
	}
	public void setMeeting_order(String meeting_order) {
		this.meeting_order = meeting_order;
	}
	public String getMeeting_date() {
		return meeting_date;
	}
	public void setMeeting_date(String meeting_date) {
		this.meeting_date = meeting_date;
	}
	public String getMod_dttm() {
		return mod_dttm;
	}
	public void setMod_dttm(String mod_dttm) {
		this.mod_dttm = mod_dttm;
	}
	public String getAttend_status() {
		return attend_status;
	}
	public void setAttend_status(String attend_status) {
		this.attend_status = attend_status;
	}
	
	//////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "CommitteeMeeting [assemblyman_id=" + assemblyman_id
				+ ", update_tag=" + update_tag + ", meeting_id=" + meeting_id
				+ ", meeting_name=" + meeting_name + ", meeting_order="
				+ meeting_order + ", meeting_date=" + meeting_date
				+ ", mod_dttm=" + mod_dttm + ", attend_status=" + attend_status
				+ "]";
	}
	
	

}
