package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.ReplyService;
import vo.MemberInfo;
import vo.reply.Reply;
import vo.reply.ReplyList;

@Controller
public class ReplyController {
	
	private ReplyService replyService;
	static ReplyList replyList = new ReplyList();
	
	@Autowired
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	// saveReply
	public void saveRely(String ReplyJSON, HttpServletResponse response) {

	}

	// save Reply
	@RequestMapping(value = "saveReply.do", method = RequestMethod.POST)
	public void saveMemberInfo(String ReplyJSON, HttpServletResponse response) {
		System.out.println("saveReply.do:" + ReplyJSON);
		Gson gson = new GsonBuilder().create();
		Reply reply = gson.fromJson(ReplyJSON, Reply.class);
		replyService.saveReply(reply, response);
	}

}
