package com.rbms.rest.model;

public class InterimRule {

	private String table;
    private String element;
    private String operation;
    private String type;
    private String value;
    private String action;
    
    
    public InterimRule() {}
    
    
	public InterimRule(String table, String element, String operation, String type, String value, String action) {
		super();
		this.table = table;
		this.element = element;
		this.operation = operation;
		this.type = type;
		this.value = value;
		this.action = action;
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
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
    
    
}
