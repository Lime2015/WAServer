package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.ReplybillDAO;
import vo.reply.Replybill;

@Component
public class ReplybillService {

	private ReplybillDAO replybillDAO;

	@Autowired
	public void setReplybillDAO(ReplybillDAO replybillDAO) {
		this.replybillDAO = replybillDAO;
	}

	// /////////////////////////////////////////////////////////////////////////

	public int insert(Replybill reply) {
		return replybillDAO.insert(reply);
	}

	public int update(Replybill reply) {
		return replybillDAO.update(reply);
	}

	public Replybill selectReplybill(int reply_id) {
		return replybillDAO.selectReplybill(reply_id);
	}

	public List<Replybill> selectList() {
		return replybillDAO.selectList();
	}

	public void saveBillreply(Replybill reply, HttpServletResponse response) {
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
