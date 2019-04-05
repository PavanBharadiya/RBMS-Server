package com.rbms.rest.model;

import javax.xml.bind.annotation.*;

public class Rules_bis 
{
    
	private LHS lhs;
	private RHS rhs;
   
	@XmlElement(name = "LHS")
    public LHS getLhs() 
    {
        return lhs;
    }
    public void setLhs(LHS lhs) 
    {
        this.lhs = lhs;
    }
   
    @XmlElement(name = "RHS")
    public RHS getRhs() 
    {
        return rhs;
    }
    public void setRhs(RHS rhs) 
    {
        this.rhs = rhs;
    }
    
    public Rules_bis() 
    {
        super();
    }
    
    public Rules_bis(LHS lhs, RHS rhs) 
    {
        super();
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
