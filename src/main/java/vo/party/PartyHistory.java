package vo.party;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "party_history")
@XmlAccessorType (XmlAccessType.FIELD)
public class PartyHistory {
	
	private Integer update_tag;
	private String history_id;
	
	private Integer member_seq;
	private String party_name;
	private String in_date;
	private String out_date;
	private String note;
	
	public Integer getUpdate_tag() {
		return update_tag;
	}
	public void setUpdate_tag(Integer update_tag) {
		this.update_tag = update_tag;
	}
	public String getHistory_id() {
		return history_id;
	}
	public void setHistory_id(String history_id) {
		this.history_id = history_id;
	}
	public Integer getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(Integer member_seq) {
		this.member_seq = member_seq;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getIn_date() {
		return in_date;
	}
	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}
	public String getOut_date() {
		return out_date;
	}
	public void setOut_date(String out_date) {
		this.out_date = out_date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "PartyHistory [update_tag=" + update_tag + ", history_id="
				+ history_id + ", member_seq=" + member_seq + ", party_name="
				+ party_name + ", in_date=" + in_date + ", out_date="
				+ out_date + ", note=" + note + "]";
	}

}
