package com.rbms.rest.model;

import javax.xml.bind.annotation.XmlElement;

public class LHS 
{
    private String table;
    private String element;
    private String operation;
    private String type;
    private String value;
    
    @XmlElement
    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }
    
    @XmlElement
    public String getElement() 
    {
        return element;
    }
    public void setElement(String element) 
    {
        this.element = element;
    }
    
    @XmlElement
    public String getOperation() 
    {
        return operation;
    }
    public void setOperation(String operation) 
    {
        this.operation = operation;
    }
    
    @XmlElement
    public String getType() 
    {
        return type;
    }
    public void setType(String type) 
    {
        this.type = type;
    }
     
    @XmlElement
    public String getValue() 
    {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
    public LHS() {
        super();
    }
    
    public LHS(String table, String element, String operation, String type, String value) {
        super();
        this.table = table;
        this.element = element;
        this.operation = operation;
        this.type = type;
        this.value = value;
    }

    
}
