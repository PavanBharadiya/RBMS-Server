package com.rbms.rest.service;

import com.rbms.rest.utils.*;
import java.util.*;
import java.sql.*;


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

    // Marshaling front end
    public boolean marshallList(Rules rule) 
    {   
        /* for appending old rules */
        List<Rules> listRules = unmarshallList();
        try {
            listRules.add(rule);
            RuleList rlist = new RuleList();
            rlist.setListRules(listRules);
            JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(rlist, new File("src\\data\\RulesListNew1.xml"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    // UnMarshalling front end
    public List<Rules> unmarshallList() 
    {
        try {

            File file = new File("src\\data\\RulesListNew1.xml");

            if (file.createNewFile()) 
            {
                List<Rules> temp = new ArrayList<Rules>();
                return temp;
            } 
            else 
            {
                JAXBContext jc = JAXBContext.newInstance(RuleList.class);
                Unmarshaller ums = jc.createUnmarshaller();
                RuleList rl = (RuleList) ums.unmarshal(file);
                List<Rules> rules = new ArrayList<Rules>();

                for (Rules r : rl.getListRules())
                    rules.add(r);
                return rules;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean createUser(User user) 
    {

        System.out.println(user.getAcc_num());
        return true;
    }
    
    // Create New Rules
    public static boolean createRule(Connection connection) {

    	ResultSet output;

    	ArrayList<ArrayList<String>> result = unmarshallRule();
    	System.out.println("result:"+result);
    	fetchDetails("1",connection);
//    	try {
//    		if(result.size() > 0) {
//    			System.out.println(result);
//    			for(int i = 0;i < result.size();i++) {
//    				if(result.get(i).get(0).equals("BT")) {
//    					batch(result,connection,i);
//    					
//    				}
//    			}
//
//
//
//    		}
//    		return true;
//    	}
//    	catch(Exception e) {
//    		e.printStackTrace();
//    		return false;
//    	}
    	return true;


    }

    // UnMarshalling Rule Creator
    public static ArrayList<ArrayList<String>> unmarshallRule() {
        
    	try {
        	File file = new File("src\\data\\RulesListNew.xml");
        	JAXBContext jc = JAXBContext.newInstance(RuleList.class);
            Unmarshaller ums = jc.createUnmarshaller();
            RuleList rl = (RuleList) ums.unmarshal(file);
            List<Rules> rules1 = new ArrayList<Rules>();

            for (Rules r : rl.getListRules())
                rules1.add(r);
           
            ArrayList<ArrayList<String>> all_rules = new ArrayList<ArrayList<String>>();
            for (Rules rules : rl.getListRules()) 
            {
            	String query = "";
            	 int count_of_condition = 0;
            	ArrayList<String> temp = new ArrayList<String>();
            	temp.add(rules.getLhs().getType());
//            	temp.add(rules.getLhs().getTable());
            	temp.add(rules.getRhs().getAction());
            	
            	String operation = rules.getRhs().getAction();
            	String  op = "";
            	for(int i = 0;i < operation.length();i++) {
            		if(operation.charAt(i) == ' ')
            				break;
            		else 
            			op = op + operation.charAt(i);
            		
            	}
          
            	
            	query = query + rules.getLhs().getTable()+" where ";
            	
            	for(Condition cond : rules.getLhs().getConditionList())
                {
            		if(count_of_condition > 0)
                    	query = query + " & ";
            		
            		count_of_condition ++;
//                    temp.add(cond.getElement());
//                    temp.add(cond.getConjunction());
                    query = query + cond.getElement()+" ";
                    
                    int count  = 0;
                    for(Clause cl : cond.getClauseList())
                    {
//                        temp.add(cl.getValue());
//                        temp.add(cl.getOperation());
                       
                        if(count > 0 && !cond.getConjunction().equals("none")) {
                        	query = query + cond.getConjunction()+" "+cond.getElement()+" ";
                        }
                        count++;
                        if(cl.getValue().contains("CURRENT")) {
                        query = query + cl.getOperation() +" "+ cl.getValue()+" ";
                        }
                        else {
                        	query = query + cl.getOperation() +" '"+ cl.getValue()+"' ";
                        }
                    }
                    
                }
            	//temp.add(count_of_condition+"");
            	temp.add("select * from "+ query + ";");
            	temp.add(op);
            	all_rules.add(temp);
            	System.out.println("select * from "+ query + ";");
            }
            
           
        
            
            
            return all_rules;
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
        }
    }

    // Mapping Correct Rule Structure
    public static boolean mapping(RuleList rule) {

        System.out.println(rule.toString());
        return true;
    }
    
    
    public static void batch(ArrayList<ArrayList<String>> result,Connection connection,int i) {
    	ResultSet output;
    	Sql sql = new Sql(connection);
    	System.out.println("Hello");
    	try {
    	output = sql.select(result.get(i).get(2));
    	
    	//System.out.println("sql op:"+output);

		ResultSetMetaData rsmd = output.getMetaData();					
		
		if(result.get(i).get(3).contentEquals("insert")) {
		String query_update = result.get(i).get(1);
		System.out.println(query_update);
		while (output.next())
		{
			System.out.println();
			PreparedStatement preparedStatement =  connection.prepareStatement(query_update);
			System.out.println("Before: " +preparedStatement.toString());
			
			System.out.println("column count: " + rsmd.getColumnCount());

			for(int k=1 ; k<=rsmd.getColumnCount(); k++)
			{
				if(rsmd.getColumnTypeName(k).contains("char"))
					preparedStatement.setString(k, output.getString(rsmd.getColumnLabel(k)));
			}						
			System.out.println("After: " +preparedStatement.toString());
			sql.insert(preparedStatement.toString());
			System.out.println("inserted data");
			System.out.println();

		}

    }
		
		else if(result.get(i).get(3).contentEquals("update")) {
			String query_update = result.get(i).get(1);
			System.out.println(query_update);
			
			while (output.next())
			{
				System.out.println();
				PreparedStatement preparedStatement =  connection.prepareStatement(query_update);
				System.out.println("Before: " +preparedStatement.toString());

				
				
					if(rsmd.getColumnTypeName(1).contains("char"))
						preparedStatement.setString(1, output.getString(rsmd.getColumnLabel(1)));
										
				System.out.println("After: " +preparedStatement.toString());
				sql.update(preparedStatement.toString());
				System.out.println("updated data");
				System.out.println();

			}
			
		}
		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void getTransaction(String acc_no,Connection connection)
    {
    	ResultSet output;
    	Sql sql = new Sql(connection);
    	TransactionTable transactionTable = new TransactionTable();
    	
    	try 
    	{
    		String query = "select * from transaction where acc_no = '" + acc_no+"'";
    		System.out.println(query);
    		output = sql.select(query);
    		
    		ResultSetMetaData rsmd = output.getMetaData();
    		
    		while (output.next())
    		{
    			System.out.println();
    			int k=1;
    			transactionTable.setTx_Id(output.getString(rsmd.getColumnLabel(k++)));
    			transactionTable.setBranch_Code(output.getString(rsmd.getColumnLabel(k++)));
    			transactionTable.setAcc_No(output.getString(rsmd.getColumnLabel(k++)));
    			transactionTable.setCust_ID(output.getString(rsmd.getColumnLabel(k++)));
    			transactionTable.setTx_Type(output.getString(rsmd.getColumnLabel(k++)));
    			transactionTable.setTx_time(output.getString(rsmd.getColumnLabel(k++)));
    			transactionTable.setTx_desc(output.getString(rsmd.getColumnLabel(k++)));
    			transactionTable.setAcc_Balance(output.getString(rsmd.getColumnLabel(k++)));
    			transactionTable.setTx_amount(output.getString(rsmd.getColumnLabel(k++)));


//    			for(int k=1 ; k<=rsmd.getColumnCount(); k++)
//    			{
//    				
//    					System.out.println(output.getString(rsmd.getColumnLabel(k)));
//    			}						
    		}

    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		//return new ArrayList<String>();
    		
    	}
    }
    
    
    public static AccountTable fetchDetails(String acc_no,Connection connection) 
    {

    	ResultSet output;
    	Sql sql = new Sql(connection);
    	AccountTable accountTable = new AccountTable();
    	try {
    		String query = "select * from account where acc_no = '" + acc_no+"' ;";
    		System.out.println(query);
    		output = sql.select(query);

    		ResultSetMetaData rsmd = output.getMetaData();

    		while (output.next())
    		{
    			System.out.println();
    			int k=1;
    			accountTable.setAcc_No(output.getString(rsmd.getColumnLabel(k++)));
    			accountTable.setBranch_Code(output.getString(rsmd.getColumnLabel(k++)));
    			accountTable.setCust_ID(output.getString(rsmd.getColumnLabel(k++)));
    			accountTable.setAcc_Type(output.getString(rsmd.getColumnLabel(k++)));
    			accountTable.setAcc_Balance(output.getString(rsmd.getColumnLabel(k++)));
    			accountTable.setLastTransactionTime(output.getString(rsmd.getColumnLabel(k++)));
    			accountTable.setLastQrtrFeeDeductDate(output.getString(rsmd.getColumnLabel(k++)));
    			accountTable.setTransaction_count(output.getString(rsmd.getColumnLabel(k++)));
    			accountTable.setCredit_score(output.getString(rsmd.getColumnLabel(k++)));

    		}
    		System.out.println(accountTable.getAcc_Balance());
    		return accountTable;
    	}
    	catch(Exception e) 
    	{
    		e.printStackTrace();
    		return null;
    	}
    }

    public static void updateDetailsAccount(AccountTable accountTable,Connection connection) 
    {

    	ResultSet output;
    	Sql sql = new Sql(connection);

    	try {
    			String Acc_No                 = accountTable.getAcc_No();
    			String Branch_Code            = accountTable.getBranch_Code();
    			String Cust_ID                = accountTable.getCust_ID();
    			String Acc_Type               = accountTable.getAcc_Type();
    			String Acc_Balance            = accountTable.getAcc_Balance();
    			String LastTransactionTime    = accountTable.getLastTransactionTime();
    			String LastQrtrFeeDeductDate  = accountTable.getLastQrtrFeeDeductDate();
    			String Transaction_count      = accountTable.getTransaction_count();
    			String Credit_score           = accountTable.getCredit_score();
    			
    			String query = "update account set acc_balance = '"+ Acc_Balance + "' and transaction_count = '"+ Transaction_count + "' where acc_no = '"+ Acc_No + "' ;" ;
    		
    			sql.update(query);
    			
    			//String query1 =  ;
    			
    			

    	}
    	catch(Exception e) 
    	{
    		e.printStackTrace();
    	}
    }


}
