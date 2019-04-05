package jaxb;

import javax.xml.bind.annotation.XmlElement;

public class Clause 
{
    private String operation;
    private String value;
    
    @XmlElement(name = "operation")
    public String getOperation() 
    {
        return operation;
    }
    public void setOperation(String operation) 
    {
        this.operation = operation;
    }
    
    @XmlElement(name = "value")
    public String getValue() 
    {
        return value;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }
    
    public Clause() 
    {
        super();
    }
    public Clause(String operation, String value) 
    {
        super();
        this.operation = operation;
        this.value = value;
    }
    
}//class ends here
