package com.rbms.rest.model;

public class InterimRule {

	private String table;
	private String type;
    
	private String element;
    private String operation1;
    private String value1;
    
    private String radio;
    private String operation2;
    private String value2;  
    
    public InterimRule() {}
    
    
	public InterimRule(String table, String element, String type, String operation1, String value1, String radio, String operation2, String value2) {
		super();
		this.table = table;
		this.element = element;
		this.operation1 = operation1;
		this.type = type;
		this.value1 = value1;
		this.radio = radio;
		this.operation2 = operation2;
		this.value2 = value2;
	}
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getOperation1() {
		return operation1;
	}
	public void setOperation1(String operation) {
		this.operation1 = operation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value) {
		this.value1 = value;
	}
	


	public String getRadio() {
		return radio;
	}


	public void setRadio(String radio) {
		this.radio = radio;
	}


	public String getOperation2() {
		return operation2;
	}


	public void setOperation2(String operation2) {
		this.operation2 = operation2;
	}


	public String getValue2() {
		return value2;
	}


	public void setValue2(String value2) {
		this.value2 = value2;
	}
    
    
}
