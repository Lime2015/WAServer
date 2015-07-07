package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberInfoDao;
import vo.MemberInfo;

@Component
public class MemberInfoService {

	private MemberInfoDao dao;

	@Autowired
	public void setDao(MemberInfoDao dao) {
		this.dao = dao;
	}

	// ////////////////////////////////////////////////////////////////

	public MemberInfo select(String memberId) {
		return dao.select(memberId);
	}

	public void checkMemberInfo(MemberInfo memberInfo, HttpServletResponse response) {
		String result;

		if (select(memberInfo.getMemberId()) == null) {
			result = "{\"result\":0}";
		} else {
			result = "{\"result\":1}";
		}

		try {
			PrintWriter writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insert(MemberInfo memberInfo) {
		return dao.insert(memberInfo);
	}

	public void saveMemberInfo(MemberInfo memberInfo, HttpServletResponse response) {
		String result;

		if (insert(memberInfo) == 1) {
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
