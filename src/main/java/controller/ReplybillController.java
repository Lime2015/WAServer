package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ReplybillService;
import vo.reply.Replybill;
import vo.reply.ReplybillList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class ReplybillController {
	private ReplybillService replybillService;
	static ReplybillList replybillList = new ReplybillList();
	
	@Autowired
	public void setReplybillService(ReplybillService replybillService) {
		this.replybillService = replybillService;
	}

	// saveReplybill.do
	@RequestMapping(value = "saveReplybill.do", method = RequestMethod.POST)
	public void saveMemberInfo(String ReplybillJSON, HttpServletResponse response) {
		System.out.println("saveReply.do:" + ReplybillJSON);
		Gson gson = new GsonBuilder().create();
		Replybill replybill = gson.fromJson(ReplybillJSON, Replybill.class);
		replybillService.saveBillreply(replybill, response);
	}

	


}
