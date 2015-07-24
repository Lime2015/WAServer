package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.AssemblymanService;
import service.BillService;
import service.CommitteeMeetingService;
import service.GeneralMeetingService;
import service.PartyService;
import service.VoteService;
import vo.Assemblyman;
import vo.bill.Bill;
import vo.committee.CommitteeMeeting;
import vo.general.GeneralMeeting;
import vo.party.PartyHistory;
import vo.vote.Vote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class RequestController {

	private AssemblymanService assemblymanService;
	private BillService billService;
	private CommitteeMeetingService committeeMeetingService;
	private GeneralMeetingService generalMeetingService;
	private VoteService voteService;
	private PartyService partyService;

	static List<Assemblyman> assemblymen;
	static List<Bill> bills;
	static List<CommitteeMeeting> committeeMeetings;
	static List<GeneralMeeting> generalMeetings;
	static List<Vote> votes;
	static List<PartyHistory> partyHistories;

	@Autowired
	public void setAssemblymanService(AssemblymanService assemblymanService) {
		this.assemblymanService = assemblymanService;
	}
	@Autowired
	public void setBillService(BillService billService) {
		this.billService = billService;
	}
	@Autowired
	public void setGeneralMeetingService(
			CommitteeMeetingService committeeMeetingService) {
		this.committeeMeetingService = committeeMeetingService;
	}
	@Autowired
	public void setGeneralMeetingService(
			GeneralMeetingService generalMeetingService) {
		this.generalMeetingService = generalMeetingService;
	}
	@Autowired
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	@Autowired
	public void setPartyService(PartyService partyService) {
		this.partyService = partyService;
	}

	// RequestAssemblyman.do
	@RequestMapping(value = "requestAssemblyman.do", method = RequestMethod.POST)
	public void RequestAssemblyman(HttpServletResponse response) {
		
		System.out.println("RequestAssemblyman.do");

		assemblymen = assemblymanService.selectList();
		System.out.println("assemblymen :" + assemblymen);

		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(assemblymen);
		// String result = gson.toJson(assemblymen, new
		// TypeToken<Assemblyman>(){}.getType());
		System.out.println(result);

		PrintWriter writer;
		try {
			response.setCharacterEncoding("UTF8"); // this line solves the problem
		    response.setContentType("application/json");
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// RequestBill.do
	@RequestMapping(value = "requestBill.do", method = RequestMethod.POST)
	public void RequestBill(HttpServletResponse response) {
		System.out.println("RequestBill.do");

		bills = billService.selectList();
		System.out.println("bills :" + bills);

		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(bills);
		System.out.println(result);

		PrintWriter writer;
		try {
			response.setCharacterEncoding("UTF8"); // this line solves the problem
		    response.setContentType("application/json");
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// RequestCommitteeMeeting.do
	@RequestMapping(value = "requestCommitteeMeeting.do", method = RequestMethod.POST)
	public void RequestCommitteeMeeting(HttpServletResponse response) {
		System.out.println("RequestBill.do");

		committeeMeetings = committeeMeetingService.selectList();
		System.out.println("committeeMeetings :" + committeeMeetings);

		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(committeeMeetings);
		System.out.println(result);

		PrintWriter writer;
		try {
			response.setCharacterEncoding("UTF8"); // this line solves the problem
		    response.setContentType("application/json");
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// RequestGeneralMeeting.do
	@RequestMapping(value = "requestGeneralMeeting.do", method = RequestMethod.POST)
	public void RequestGeneralMeetingCommitteeMeeting(HttpServletResponse response) {
		System.out.println("RequestGeneralMeeting.do");

		generalMeetings = generalMeetingService.selectList();
		System.out.println("generalMeetings :" + generalMeetings);

		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(generalMeetings);
		System.out.println(result);

		PrintWriter writer;
		try {
			response.setCharacterEncoding("UTF8"); // this line solves the problem
		    response.setContentType("application/json");
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	// RequestVote.do
	@RequestMapping(value = "requestVote.do", method = RequestMethod.POST)
	public void RequestVoteCommitteeMeeting(HttpServletResponse response) {
		System.out.println("RequestVote.do");

		votes = voteService.selectList();
		System.out.println("votes :" + votes);

		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(votes);
		System.out.println(result);

		PrintWriter writer;
		try {
			response.setCharacterEncoding("UTF8"); // this line solves the problem
		    response.setContentType("application/json");
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// RequestParty.do
	@RequestMapping(value = "requestParty.do", method = RequestMethod.POST)
	public void RequestPartyCommitteeMeeting(HttpServletResponse response) {
		System.out.println("RequestParty.do");

		partyHistories = partyService.selectList();
		System.out.println("partyHistories :" + partyHistories);

		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(partyHistories);
		System.out.println(result);

		PrintWriter writer;
		try {
			response.setCharacterEncoding("UTF8"); // this line solves the problem
		    response.setContentType("application/json");
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
