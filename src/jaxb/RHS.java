package jaxb;

import javax.xml.bind.annotation.XmlElement;

public class RHS 
{
    
    private String action;
    
    @XmlElement
    public String getAction() 
    {
        return action;
    }
    public void setAction(String action) 
    {
        this.action = action;
    }
    
    public RHS() {
        super();
    }
    
    public RHS(String action) 
    {
        super();
        this.action = action;
    }
    
}
