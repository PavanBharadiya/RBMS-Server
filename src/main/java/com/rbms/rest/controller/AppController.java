package com.rbms.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbms.rest.model.AccountTable;
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
            System.out.println("Setting connection");
            //Connection conn = connection.establishConnection();
            
           connection.setConnection("RBMS","postgres","MT2018091@iiitb");
           Connection conn1 = connection.getConnection();
            System.out.println("conn="+conn1);
           
           if(rbms_service.createRule(conn1)) {
            return true;
           } else {
            return false;
           }    
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    @RequestMapping(value="/getAccount", method=RequestMethod.POST)
    public AccountTable getAccount(@RequestBody String account_number) {
        
        DatabaseConnection connection = new DatabaseConnection();
        try {
            System.out.println("Setting connection");
            //Connection conn = connection.establishConnection();
            
           connection.setConnection("RBMS","postgres","MT2018091@iiitb");
           Connection conn1 = connection.getConnection();
            System.out.println("conn="+conn1);
           
           AccountTable accountTable = rbms_service.fetchDetails(account_number,conn1);
           return accountTable;
                
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    
    @RequestMapping(value="/getTransactions", method=RequestMethod.POST)
    public boolean getTransactions(@RequestBody String account_number) {
        
        System.out.println(account_number);
        return true;
    }
    
}
