package com.rbms.rest.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbms.rest.service.RBMSService;
import com.rbms.rest.utils.DatabaseConnection;

@RestController
@CrossOrigin(origins = "*")
public class AppController 
{
	@Autowired
	RBMSService rbms_service;
	
	@RequestMapping(value="/init", method=RequestMethod.GET)
    public boolean createRule()
    {
    	DatabaseConnection connection = new DatabaseConnection();
    	try {
        	Connection conn = connection.establishConnection(); 
        	//connection.setConnection("RBMS","postgres","clause@DM19");
            //Connection conn = connection.getConnection();
           
           //if(rbms_service.createRule(conn)) {
           //	return true;
           //} else {
           //	return false;
           //}	
        	return true;
    	} catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
        
    }
}
