package com.rbms.rest.model;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ruleList")
public class RuleList 
{
    private List<Rules> listRules = new ArrayList<Rules>();

    @XmlElement(name = "rule")
    public List<Rules> getListRules() 
    {
        return listRules;
    }
    public void setListRules(List<Rules> listRules) 
    {
        this.listRules = listRules;
    }
}//class ends here
