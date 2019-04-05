package com.rbms.rest.model;

import javax.xml.bind.annotation.XmlElement;

public class RHS_bis 
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
    
    public RHS_bis() {
        super();
    }
    
    public RHS_bis(String action) 
    {
        super();
        this.action = action;
    }
    
}
