package com.rbms.rest.service;

import com.rbms.rest.utils.*;
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
import java.sql.ResultSet;
import java.sql.SQLException;

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

	//Marshaling
	public boolean marshallList(Rules rule) {

		List<Rules> listRules = unmarshallList();
		try {

			listRules.add(new Rules(new LHS(rule.getTable(), rule.getElement(), rule.getOperation1(), rule.getType(), rule.getValue1()), new RHS(rule.getAction())));
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

	//UnMarshalling
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


	//Create New Rules
	public static boolean createRule(Connection connection) {

		ResultSet output;

		Sql sql = new Sql(connection);

		ArrayList<ArrayList<String>> result = unmarshallRule();

		try{
			if(result.size() > 0) {     	
				for(int i = 0;i < result.size();i++) {

					if(result.get(i).get(1).equals("acc_balance") ) {

						String query = "select * from "+ result.get(i).get(0) + " where " + result.get(i).get(1)  + result.get(i).get(2) + result.get(i).get(4) + ";";
						output = sql.select(query);
						
						while (output.next())
						{
							ArrayList<String> temp = new ArrayList<String>();  
							int acc_no = output.getInt("acc_no");
							String Branch_Code = output.getString("Branch_Code");
							int cust_id = output.getInt("Cust_ID");
							String Acc_Type = output.getString("Acc_Type");
							float Acc_Balance = output.getFloat("Acc_Balance");

						
			    			String query_update = "insert into premium_account values("+acc_no+",'"+Branch_Code+"',"+cust_id+",'"+Acc_Type+"',"+Acc_Balance+");";
			    			sql.insert(query_update);
							
							//String query_delete = "delete from account where acc_no="+acc_no;
							//System.out.println(query_delete);
							//sql.update(query_delete);
							//System.out.println("done2");

						}
					}
				}
			}
			return true;
		}
		catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	//UnMarshalling Rule Creater
	public static ArrayList<ArrayList<String>> unmarshallRule() {
		try {
			JAXBContext jc = JAXBContext.newInstance(RuleList.class);
			Unmarshaller ums = jc.createUnmarshaller();
			RuleList rulelist = (RuleList) ums.unmarshal(new File("src\\data\\RulesListNew_1.xml"));

			ArrayList<ArrayList<String>> all_rules = new ArrayList<ArrayList<String>>();
			for (Rules rules : rulelist.getListRules()) 
			{
				ArrayList<String> temp = new ArrayList<String>();

				temp.add(rules.getLhs().getTable()+"");
				temp.add(rules.getLhs().getElement()+"");
				temp.add(rules.getLhs().getOperation()+"");
				temp.add(rules.getLhs().getType()+"");
				temp.add(rules.getLhs().getValue()+"");
				temp.add(rules.getRhs().getAction()+"");
				all_rules.add(temp);
			}
			return all_rules;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Mapping Correct Rule Structure
	public static boolean mapping(RuleList rule) {
		
		System.out.println(rule.toString());
		return true;
	}

}
