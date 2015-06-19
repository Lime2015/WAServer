package common;
import org.exolab.castor.xml.*;
import org.exolab.castor.mapping.*;

import vo.Assemblyman;
import vo.AssemblymanList;

import java.io.FileReader;
import java.util.List;
import java.util.Iterator;

public class ViewAssemblyList {

	public static void main(String[] args) {
		
		    try {
		     // -- Load a mapping file
		     Mapping mapping = new Mapping();
		     mapping.loadMapping("/config/assemblyman-mapping.xml");

		     Unmarshaller un = new Unmarshaller(AssemblymanList.class);
		     un.setMapping( mapping );

		     // -- Read in the AssemblymanList using the mapping
		     FileReader in = new FileReader("sample.xml");
		     AssemblymanList man = (AssemblymanList) un.unmarshal(in);
		     in.close();

		     // -- Display the assemblymanList
		     System.out.println( man.getAssemblymanListName());

		     List assemblyman = man.getAssemblyman();
		     Iterator iter = assemblyman.iterator();

		     while ( iter.hasNext() ) {
		       Assemblyman assemblyman2 = (Assemblyman) iter.next();
		       
		       System.out.println("\n" + assemblyman2.getManId());
		       System.out.println("\n" + assemblyman2.getName() );
		       System.out.println("-----------------------------");
		       System.out.println("ImgUrl = "+ assemblyman2.getImgUrl());
		       System.out.println("PartyId = " + assemblyman2.getPartyId());
		       System.out.println("partyName = " + assemblyman2.getPartyName());  
		       System.out.println("Localconsti = " + assemblyman2.getLocalConstituency());
		       }
		    } catch (Exception e) {
		      System.out.println( e );
		    }
	}

}


