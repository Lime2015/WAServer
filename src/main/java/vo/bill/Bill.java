package vo.bill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bill")
@XmlAccessorType (XmlAccessType.FIELD)
public class Bill {
	
	private Integer assemblyman_id;
	private Integer update_tag;
	
	private Integer bill_seq;
	private Integer bill_no;
	private String bill_status;
	private String bill_title;
	private String proposer_info;
	private String bill_class;
	private String receive_date;
	private String refer_date;
	private String bill_date3;
	private String committee_name;
	private Integer committee_id;
	private Integer committee_class;
	private String bill_result;
	private String bill_target_url;
	
	///////////////////////////////////////////////////////////////////////////////////
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
	public Integer getBill_seq() {
		return bill_seq;
	}
	public void setBill_seq(Integer bill_seq) {
		this.bill_seq = bill_seq;
	}
	public Integer getBill_no() {
		return bill_no;
	}
	public void setBill_no(Integer bill_no) {
		this.bill_no = bill_no;
	}
	public String getBill_status() {
		return bill_status;
	}
	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}
	public String getBill_title() {
		return bill_title;
	}
	public void setBill_title(String bill_title) {
		this.bill_title = bill_title;
	}
	public String getProposer_info() {
		return proposer_info;
	}
	public void setProposer_info(String proposer_info) {
		this.proposer_info = proposer_info;
	}
	public String getBill_class() {
		return bill_class;
	}
	public void setBill_class(String bill_class) {
		this.bill_class = bill_class;
	}
	public String getReceive_date() {
		return receive_date;
	}
	public void setReceive_date(String receive_date) {
		this.receive_date = receive_date;
	}
	public String getRefer_date() {
		return refer_date;
	}
	public void setRefer_date(String refer_date) {
		this.refer_date = refer_date;
	}
	public String getBill_date3() {
		return bill_date3;
	}
	public void setBill_date3(String bill_date3) {
		this.bill_date3 = bill_date3;
	}
	public String getCommittee_name() {
		return committee_name;
	}
	public void setCommittee_name(String committee_name) {
		this.committee_name = committee_name;
	}
	public Integer getCommittee_id() {
		return committee_id;
	}
	public void setCommittee_id(Integer committee_id) {
		this.committee_id = committee_id;
	}
	public Integer getCommittee_class() {
		return committee_class;
	}
	public void setCommittee_class(Integer committee_class) {
		this.committee_class = committee_class;
	}
	public String getBill_result() {
		return bill_result;
	}
	public void setBill_result(String bill_result) {
		this.bill_result = bill_result;
	}
	public String getBill_target_url() {
		return bill_target_url;
	}
	public void setBill_target_url(String bill_target_url) {
		this.bill_target_url = bill_target_url;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Bill [assemblyman_id=" + assemblyman_id + ", update_tag="
				+ update_tag + ", bill_seq=" + bill_seq + ", bill_no="
				+ bill_no + ", bill_status=" + bill_status + ", bill_title="
				+ bill_title + ", proposer_info=" + proposer_info
				+ ", bill_class=" + bill_class + ", receive_date="
				+ receive_date + ", refer_date=" + refer_date + ", bill_date3="
				+ bill_date3 + ", committee_name=" + committee_name
				+ ", committee_id=" + committee_id + ", committee_class="
				+ committee_class + ", bill_result=" + bill_result
				+ ", bill_target_url=" + bill_target_url + "]";
	}
	
}
