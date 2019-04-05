package jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class LHS 
{
    private String table;
    private String type;
    private List<Condition> conditionList  = new ArrayList<Condition>();

    @XmlElement(name = "table")
    public String getTable() 
    {
        return table;
    }
    public void setTable(String table) 
    {
        this.table = table;
    }
    
    @XmlElement(name = "type")
    public String getType() 
    {
        return type;
    }
    public void setType(String type) 
    {
        this.type = type;
    }
    
    @XmlElement(name = "conditon")
    public List<Condition> getConditionList() 
    {
        return conditionList;
    }
    public void setConditionList(List<Condition> conditionList) 
    {
        this.conditionList = conditionList;
    }
    
    public LHS() 
    {
        super();
    }
    
    public LHS(String table, String type, List<Condition> conditionList) 
    {
        super();
        this.table = table;
        this.type = type;
        this.conditionList = conditionList;
    }

}//class ends here
