package vo.vote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vote")
@XmlAccessorType (XmlAccessType.FIELD)
public class Vote {
	
	private String assemblyman_id;
	private Integer update_tag;
	private String vote_id;
	
	private String bill_name;
	private Integer bill_no;
	private String vote_dttm;
	private String mod_dttm;
	private String bill_target_url;
	private String result;
	private String assemblyman_vote;
	
	////////////////////////////////////////////////////////////////////////////
	public String getAssemblyman_id() {
		return assemblyman_id;
	}
	public void setAssemblyman_id(String assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}
	public Integer getUpdate_tag() {
		return update_tag;
	}
	public void setUpdate_tag(Integer update_tag) {
		this.update_tag = update_tag;
	}
	public String getVote_id() {
		return vote_id;
	}
	public void setVote_id(String vote_id) {
		this.vote_id = vote_id;
	}
	public String getBill_name() {
		return bill_name;
	}
	public void setBill_name(String bill_name) {
		this.bill_name = bill_name;
	}
	public Integer getBill_no() {
		return bill_no;
	}
	public void setBill_no(Integer bill_no) {
		this.bill_no = bill_no;
	}
	public String getVote_dttm() {
		return vote_dttm;
	}
	public void setVote_dttm(String vote_dttm) {
		this.vote_dttm = vote_dttm;
	}
	public String getMod_dttm() {
		return mod_dttm;
	}
	public void setMod_dttm(String mod_dttm) {
		this.mod_dttm = mod_dttm;
	}
	public String getBill_target_url() {
		return bill_target_url;
	}
	public void setBill_target_url(String bill_target_url) {
		this.bill_target_url = bill_target_url;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getAssemblyman_vote() {
		return assemblyman_vote;
	}
	public void setAssemblyman_vote(String assemblyman_vote) {
		this.assemblyman_vote = assemblyman_vote;
	}
	
	@Override
	public String toString() {
		return "Vote [assemblyman_id=" + assemblyman_id + ", update_tag="
				+ update_tag + ", vote_id=" + vote_id + ", bill_name="
				+ bill_name + ", bill_no=" + bill_no + ", vote_dttm="
				+ vote_dttm + ", mod_dttm=" + mod_dttm + ", bill_target_url="
				+ bill_target_url + ", result=" + result
				+ ", assemblyman_vote=" + assemblyman_vote + "]";
	}
	
}
