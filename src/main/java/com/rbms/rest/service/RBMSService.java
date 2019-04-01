package com.rbms.rest.service;

import java.util.*;
import java.io.File;
import java.util.*;
import javax.xml.bind.*;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.rbms.rest.model.*;

@Service
public class RBMSService {

	
    public boolean marshallList(InterimRule rule) {
    	
    	List<Rules> listRules = unmarshallList();
        try {
            
        	listRules.add(new Rules(new LHS(rule.getTable(), rule.getElement(), rule.getOperation(), rule.getType(), rule.getValue()), new RHS(rule.getAction())));
//        	listRules.add(new Rules(new LHS(, ));
            RuleList rlist = new RuleList();
            rlist.setListRules(listRules);
            JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    
            ms.marshal(rlist, new File("src\\data\\RulesListNew.xml"));
            return true;
        } catch (Exception e) 
        {
        	e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    } 
	
    
    public List<Rules> unmarshallList()
    {
        try {

        	File file = new File("src\\data\\RulesListNew.xml");
            
            if(file.createNewFile()) {
            	List<Rules> temp = new ArrayList<Rules>();
            	return temp;
            } else {
            	JAXBContext jc = JAXBContext.newInstance(RuleList.class);
                Unmarshaller ums = jc.createUnmarshaller();
                RuleList rl = (RuleList)ums.unmarshal(file);
                List<Rules> rules = new ArrayList<Rules>();
                
                for(Rules r : rl.getListRules())
                	rules.add(r);
                
                return rules;	
        	
            }	
            
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }
    
    
	public boolean createUser(User user) {
		
		System.out.println(user.getAcc_num());
		return true;
	}
	
	
}
