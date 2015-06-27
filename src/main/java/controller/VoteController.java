package controller;

import java.io.File;

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
			
			System.out.println(man);
			Integer assemblyman_id = man.getAssemblyman_id();
			
			for(Vote vote : man.getVotes()){
				
				vote.setAssemblyman_id(assemblyman_id);
				//System.out.println("meeting assembly_id : "+ vote.getAssemblyman_id());
				// voteService.insert(vote);
				
				try{
					voteService.insert(vote);
				} catch(Exception e) {
					voteService.update(vote);
				}
			}
		}
	}
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectAssemblyman.do
/*	@RequestMapping(value = "selectAssemblyman.do", method = RequestMethod.GET)
	public ModelAndView selectAssemblyman(int manId,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		Assemblyman assemblyman = assemblymanService.selectAssemblyman(manId);
		System.out.println("AssemblymanId" + manId);

		mv.setViewName("viewAssemblyman");
		mv.addObject("result", assemblyman);
		return mv;
	}*/

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListAssemblyman.do
/*	@RequestMapping(value = "selectListAssemblyman.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<Assemblyman> assemblymen = assemblymanService.selectList();
		System.out.println("Assemblymen : " + assemblymen);

		mv.setViewName("viewAssemblymanList");
		mv.addObject("list", assemblymen);
		return mv;
	}*/

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
				.marshal(voteGeneralMeeting, new File("c:/temp/assemblymen.xml"));
	}



}
