package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ReplyService;
import service.ReplybillService;
import vo.reply.Reply;
import vo.reply.Replybill;

@Controller
public class Test_Reply {
	
	private ReplybillService replybillService;
	
	@Autowired
	public void setReplyService(ReplybillService service) {
		this.replybillService = service;
	}
	@RequestMapping(value="saveTest.do", method=RequestMethod.GET)
	public void saveReply(){
		
		//replyService = new ReplyService();
		Replybill reply = new Replybill();
		reply = createReply();
		replybillService.insert(reply);
		System.out.println("insert");
		
	}
	
	private static Replybill createReply(){
		Replybill reply = new Replybill();
		reply.setAssemblyman_id("10");
		reply.setMember_id(0012);
		reply.setMember_img("http://url");
		reply.setModt("2015.07.20");
		reply.setComment("언제나 응원합니다!!");
		reply.setReport(5);
		return reply;
	}

}
