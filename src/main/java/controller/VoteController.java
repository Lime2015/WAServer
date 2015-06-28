package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.VoteService;
import vo.vote.Vote;
import vo.vote.VoteAssemblyman;
import vo.vote.VoteGeneralMeeting;

@Controller
public class VoteController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AssemblymanController.class);

	private VoteService voteService;
	static VoteGeneralMeeting voteGeneralMeeting = new VoteGeneralMeeting();
	
	@Autowired
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}

	// saveVote.do
	@RequestMapping(value = "saveVote.do", method = RequestMethod.GET)
	public void saveAssemblyman(String xmlUrl, HttpServletResponse response,
			HttpServletRequest request) throws JAXBException {

		//System.out.println("saveVote.do");
		//System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		//System.out.println("unMarshingFinish : " + voteGeneralMeeting);

		for (VoteAssemblyman man : voteGeneralMeeting.getAssemblymen()) {
			
			logger.info("man :", man);
			Integer assemblyman_id = man.getAssemblyman_id();
			
			for(Vote vote : man.getVotes()){
				
				vote.setAssemblyman_id(assemblyman_id);
				//System.out.println("meeting assembly_id : "+ vote.getAssemblyman_id());
				// voteService.insert(vote);
				
				//프라임키 생성 assembly_id + bill_no
				String vote_id = assemblyman_id +"-" +vote.getBill_no();
				System.out.println("vote_id : " + vote_id);
				vote.setVote_id(vote_id);
				
				try{
					System.out.println("insert");
					vote.setUpdate_tag(1);
					voteService.insert(vote);
					
				} catch(Exception e) {
					System.out.println("update");
					Integer ver = voteService.selectVote(vote_id).getUpdate_tag();
					
					System.out.println("update ver :" + ver);
					vote.setUpdate_tag(ver + 1);
					voteService.update(vote);
				}
			}
		}
	}
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectVote.do
	@RequestMapping(value = "selectVote.do", method = RequestMethod.GET)
	public ModelAndView selectAssemblyman(String vote_id,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		Vote vote = voteService.selectVote(vote_id);
		System.out.println("vote_id" + vote_id);

		mv.setViewName("Vote");
		mv.addObject("result", vote);
		return mv;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListVote.do
	@RequestMapping(value = "selectListVote.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<Vote> votes = voteService.selectList();
		System.out.println("votes : " + votes);

		mv.setViewName("voteList");
		mv.addObject("list", votes);
		return mv;
	}

	// ////////////////////////////////////////////////////////////
	private static void unMarshalingExample(String url) throws JAXBException {
		
		String xmlUrl = url;
		File file = new File(xmlUrl);
		JAXBContext jaxbContext = JAXBContext.newInstance(VoteGeneralMeeting.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		VoteGeneralMeeting assemblymanLsit = (VoteGeneralMeeting) jaxbUnmarshaller.unmarshal(file);
		voteGeneralMeeting = null;
		voteGeneralMeeting = assemblymanLsit;
		for (VoteAssemblyman man : assemblymanLsit.getAssemblymen()) {
			//System.out.println(man.getAssemblyman_id());
			//System.out.println(man.getVotes());
		}

	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(VoteGeneralMeeting.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(voteGeneralMeeting, System.out);
		jaxbMarshaller
				.marshal(voteGeneralMeeting, new File("c:/temp/votes2.xml"));
	}



}
