package jaxb;

import java.util.*;
import javax.xml.bind.annotation.*;

//@XmlRootElement(name = "Rules")
public class Rules {
	
	private String type;
	private String element;
	private String operation;
	private String value;
	private String action;
	
	@XmlElement
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	
	@XmlElement
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	@XmlElement
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@XmlElement
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public Rules() 
	{
		super();
	}
	
	public Rules(String type, String element, String operation, String value, String action)
	{
		super();
		this.type = type;
		this.element = element;
		this.operation = operation;
		this.value = value;
		this.action = action;
	}
	
}
