package jaxb;

import java.io.File;
import java.util.*;
import javax.xml.bind.*;

public class XMLParsing {

    public void marshallList() {
        try {
            List<Rules> rules = new ArrayList<Rules>();
            rules.add(new Rules(new LHS("Account1", "Balance", ">=", "RT", 1000), new RHS("SQL1")));
            rules.add(new Rules(new LHS("Account2", "Balance", ">=", "RT", 2000), new RHS("SQL2")));
            rules.add(new Rules(new LHS("Account3", "Balance", ">=", "RT", 3000), new RHS("SQL3")));
            RuleList rulelist = new RuleList();
            rulelist.setListRules(rules);

            JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ms.marshal(rulelist, System.out);
            ms.marshal(rulelist, new File("src\\data\\RulesListNew.xml"));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
    }

    public void unmarshallList() {
        try {
            JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Unmarshaller ums = jc.createUnmarshaller();
            RuleList rulelist = (RuleList) ums.unmarshal(new File("src\\data\\RulesListNew.xml"));

            System.out.println("Set of Rules");
            for (Rules rules : rulelist.getListRules()) 
            {
                System.out.println("table " + rules.getLhs().getTable());
                System.out.println("type " + rules.getLhs().getElement());
                System.out.println("element " + rules.getLhs().getOperation());
                System.out.println("operation " + rules.getLhs().getType());
                System.out.println("value " + rules.getLhs().getValue());
                System.out.println("action " + rules.getRhs().getAction());
                System.out.println("=============================");
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
    }

}
