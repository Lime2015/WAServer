package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.ReplyDAO;
import vo.reply.Reply;

@Component
public class ReplyService {
	
	private ReplyDAO replyDAO;
	
	@Autowired
	public void setReplyDAO(ReplyDAO DAO) {
		this.replyDAO = DAO;
	}

	///////////////////////////////////////////////////////////////////////////
	
	public int insert(Reply reply){
		return replyDAO.insert(reply);
	}
	public int update(Reply reply){
		return replyDAO.update(reply);
	}
	public Reply selectReply(int reply_id){
		return replyDAO.selectReply(reply_id);
	}
	public List<Reply> selectList(){
		return replyDAO.selectList();
	}

	public void saveReply(Reply reply, HttpServletResponse response) {
		String result;

		if (insert(reply) == 1) {
			result = "{\"result\":1}";
		} else {
			result = "{\"result\":0}";
		}

		try {
			PrintWriter writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
