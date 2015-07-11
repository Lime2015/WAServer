package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.PartyService;
import vo.party.PartyHistories;
import vo.party.PartyHistory;


@Controller
public class PartyHistoryController {
	
	private PartyService partyService = new PartyService();
	static PartyHistories partyHistories = new PartyHistories(); 
	
	@Autowired
	public void setPartyService(PartyService partyService) {
		this.partyService = partyService;
	}
	

	// saveParty.do
	@RequestMapping(value = "saveParty.do", method = RequestMethod.GET)
	public void saveAssemblyman(String xmlUrl, HttpServletResponse response,
			HttpServletRequest request) throws JAXBException {
		
		int updateTAG; //가장 마지막 update_tag 넘버 가져옴 
		
		try{
			updateTAG = partyService.selectUpdate();
		} catch(Exception e){
			updateTAG = 0;
		}


		//System.out.println("saveParty.do");
		//System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println(updateTAG);

		for (PartyHistory his : partyHistories.getPartyHistories()) {

			System.out.println(his);
			
			try{
				System.out.println("insert");
				his.setUpdate_tag(updateTAG + 1);
				partyService.insert(his);
				
			} catch(Exception e) {
				System.out.println("update");
				
				his.setUpdate_tag(updateTAG + 1);
				partyService.update(his);
			}
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectParty.do
	@RequestMapping(value = "selectParty.do", method = RequestMethod.GET)
	public ModelAndView selectAssemblyman(Object history,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		PartyHistory partyHistory = partyService.selectParty(history);
		System.out.println("history" + history);

		mv.setViewName("partyHistoy");
		mv.addObject("result", partyHistory);
		return mv;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListParty.do
	@RequestMapping(value = "selectListParty.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<PartyHistory> partyHistories = partyService.selectList();
		System.out.println("partyHistories : " + partyHistories);

		mv.setViewName("partyHistoryList");
		mv.addObject("list", partyHistories);
		return mv;
	}

	// ////////////////////////////////////////////////////////////
	private static void unMarshalingExample(String url) throws JAXBException {
		String xmlUrl = url;
		File file = new File(xmlUrl);
		JAXBContext jaxbContext = JAXBContext.newInstance(PartyHistories.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		PartyHistories hisList = (PartyHistories) jaxbUnmarshaller.unmarshal(file);
		partyHistories = null;
		partyHistories = hisList;
		/*for (PartyHistory his : hisList.getPartyHistories()) {
			System.out.println(his.getMember_seq());
			System.out.println(his.getParty_name());
		}*/

	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(PartyHistories.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(partyHistories, System.out);
		jaxbMarshaller.marshal(partyHistories, new File("c:/temp/party_history2.xml"));
	}

}
