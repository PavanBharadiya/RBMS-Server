package com.rbms.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Condition 
{
    private String element;
    private String conjunction;
    private List<Clause> clauseList  = new ArrayList<Clause>();
    
    @XmlElement(name = "element")
    public String getElement() 
    {
        return element;
    }
    public void setElement(String element) 
    {
        this.element = element;
    }
    @XmlElement(name = "conjuction")
    public String getConjunction() 
    {
        return conjunction;
    }
    public void setConjunction(String conjunction) 
    {
        this.conjunction = conjunction;
    }
    
    @XmlElement(name = "clause")
    public List<Clause> getClauseList() 
    {
        return clauseList;
    }
    public void setClauseList(List<Clause> clauseList) 
    {
        this.clauseList = clauseList;
    }
     
    public Condition() 
    {
        super();
    }
    public Condition(String element, String conjunction, List<Clause> clauseList) 
    {
        super();
        this.element = element;
        this.conjunction = conjunction;
        this.clauseList = clauseList;
    }
    
}//class ends here
