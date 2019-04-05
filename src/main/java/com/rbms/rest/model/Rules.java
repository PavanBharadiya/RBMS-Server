package com.rbms.rest.model;

import javax.xml.bind.annotation.*;

public class Rules 
{
    
	private LHS lhs;
	private RHS rhs;
   
	@XmlElement(name = "antecedent")
    public LHS getLhs() 
    {
        return lhs;
    }
    public void setLhs(LHS lhs) 
    {
        this.lhs = lhs;
    }
   
    @XmlElement(name = "consequent")
    public RHS getRhs() 
    {
        return rhs;
    }
    public void setRhs(RHS rhs) 
    {
        this.rhs = rhs;
    }
    
    public Rules() 
    {
        super();
    }
    
    public Rules(LHS lhs, RHS rhs) 
    {
        super();
        this.lhs = lhs;
        this.rhs = rhs;
    }

}//class ends here
