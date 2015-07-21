package controller;

import service.ReplyService;
import vo.reply.Reply;

public class Test_Reply {

	public static void main(String[] args) {
		
		ReplyService replyService = new ReplyService();
		Reply reply = new Reply();
		reply = createReply();
		replyService.insert(reply);
		System.out.println("insert");
		
	}
	
	private static Reply createReply(){
		Reply reply = new Reply();
		reply.setAssemblyman_id("10");
		reply.setMember_id(0012);
		reply.setMember_img("http://url");
		reply.setModt("2015.07.20");
		reply.setComment("언제나 응원합니다!!");
		reply.setReport(5);
		return reply;
	}

}
