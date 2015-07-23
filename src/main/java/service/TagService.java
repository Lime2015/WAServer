package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.TagDao;
import result.CheckTagResult;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Component
public class TagService {

	private TagDao dao;

	@Autowired
	public void setDao(TagDao dao) {
		this.dao = dao;
	}

	// ////////////////////////////////////////////////////////////////

	public void checkTag(HttpServletResponse response) {
		String result;
		CheckTagResult rs = new CheckTagResult();
		List<Integer> tagList = new ArrayList<Integer>();

		tagList.add(dao.checkAssemblymanTag());
		tagList.add(dao.checkBillTag());
		tagList.add(dao.checkCommitteeMeetingTag());
		tagList.add(dao.checkGeneralMeetingTag());
		tagList.add(dao.checkPartyHistoryTag());
		tagList.add(dao.checkVoteTag());

		rs.setTagList(tagList);
		
		Gson gson = new GsonBuilder().create();

		result = gson.toJson(rs, new TypeToken<CheckTagResult>(){}.getType());
		System.out.println("checkTag.do:" + result);

		try {
			response.setCharacterEncoding("UTF8"); // this line solves the problem
			response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
