package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.MemberInfoService;
import vo.MemberInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class MemberInfoController {

	private MemberInfoService service;

	@Autowired
	public void setService(MemberInfoService service) {
		this.service = service;
	}

	// //////////////////////////////////////////////////////////////

	// check MemberInfo
	@RequestMapping(value = "checkMember.do", method = RequestMethod.POST)
	public void checkMemberInfo(String memberJSON, HttpServletResponse response) {
		System.out.println("checkMember.do:" + memberJSON);
		Gson gson = new GsonBuilder().create();
//		MemberInfo memberInfo = gson.fromJson(memberJSON, new TypeToken<MemberInfo>(){}.getType());
		MemberInfo memberInfo = gson.fromJson(memberJSON, MemberInfo.class);
		service.checkMemberInfo(memberInfo, response);
	}

	// save MemberInfo
	@RequestMapping(value = "saveMember.do", method = RequestMethod.POST)
	public void saveMemberInfo(String memberJSON, HttpServletResponse response) {
		System.out.println("saveMember.do:" + memberJSON);
		Gson gson = new GsonBuilder().create();
		MemberInfo memberInfo = gson.fromJson(memberJSON, MemberInfo.class);
		service.saveMemberInfo(memberInfo, response);
	}
}
