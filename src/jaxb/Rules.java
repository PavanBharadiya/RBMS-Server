package jaxb;

import javax.xml.bind.annotation.*;

public class Rules 
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
}
