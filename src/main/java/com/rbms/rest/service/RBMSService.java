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

	
    public boolean marshallList(Rules rule)
    {
    	
    	List<Rules> listRules = unmarshallList();
        try {
            
        	listRules.add(new Rules(rule.getType(), rule.getElement(), rule.getOperation(), rule.getValue(), rule.getAction()));
            
            RuleList rlist = new RuleList();
            rlist.setListRules(listRules);
            JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    
            //ms.marshal(rlist, System.out);
            ms.marshal(rlist, new File("C:\\Users\\Gaurav Joshi\\Desktop\\Files\\rules.xml"));
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
            JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Unmarshaller ums = jc.createUnmarshaller();
            RuleList rl = (RuleList)ums.unmarshal(new File("C:\\Users\\Gaurav Joshi\\Desktop\\Files\\rules.xml"));
            List<Rules> rules = new ArrayList<Rules>();
            
            for(Rules r : rl.getListRules())
            	rules.add(r);
            
            return rules;
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
