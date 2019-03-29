package jaxb;

import java.io.File;
import java.util.*;
import javax.xml.bind.*;

public class XMLParsing {
    public void marshall()
    {
        try {
            Rules rules = new Rules("Real Time","Balance","Greater than Equal to","10000","Move to Premium Category");
            
            JAXBContext jc = JAXBContext.newInstance(Rules.class);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(rules, System.out);
            ms.marshal(rules, new File("src\\data\\Rules.xml"));
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void marshallList()
    {
        try {
            List<Rules> listRules = new ArrayList<Rules>();
            listRules.add(new Rules("Real Time","Balance","Greater than Equal to","10000","1Move to Premium Category"));
            listRules.add(new Rules("Real Time","Balance","Greater than Equal to","10000","2Move to Premium Category"));
            listRules.add(new Rules("Real Time","Balance","Greater than Equal to","10000","3Move to Premium Category"));
            RuleList rlist = new RuleList();
            rlist.setListRules(listRules);
            JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(rlist, System.out);
            ms.marshal(rlist, new File("src\\data\\RulesList.xml"));
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void unmarshall()
    {
        try {
            JAXBContext jc = JAXBContext.newInstance(Rules.class);
            Unmarshaller ums = jc.createUnmarshaller();
            Rules rules = (Rules)ums.unmarshal(new File("src\\data\\Rules.xml"));
            
            System.out.println("Set of Rules");
            System.out.println("type " + rules.getType());
            System.out.println("element " + rules.getElement());
            System.out.println("operation " + rules.getOperation());
            System.out.println("calue " + rules.getValue());
            System.out.println("action " + rules.getAction());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void unmarshallList()
    {
        try {
            JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Unmarshaller ums = jc.createUnmarshaller();
            RuleList rl = (RuleList)ums.unmarshal(new File("src\\data\\RulesList.xml"));
            
            System.out.println("Set of Rules");
            for(Rules r : rl.getListRules())
            {
                System.out.println("type " + r.getType());
                System.out.println("element " + r.getElement());
                System.out.println("operation " + r.getOperation());
                System.out.println("calue " + r.getValue());
                System.out.println("action " + r.getAction());
                System.out.println("=============================");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
