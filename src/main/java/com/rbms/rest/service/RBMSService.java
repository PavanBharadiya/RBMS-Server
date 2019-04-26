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
            ms.marshal(rlist, new File("src\\data\\RulesListNew.xml"));
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

            File file = new File("src\\data\\RulesListNew.xml");

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
    public static boolean createRule(Connection connection) 
    {

        ResultSet output;

        ArrayList<ArrayList<String>> result = unmarshallRule();
//        System.out.println("result:"+result);
        try {
            if(result.size() > 0) {
//                System.out.println(result);
                for(int i = 0;i < result.size();i++) {
                    if(result.get(i).get(0).equals("BT")) {
                        batch(result,connection,i);

                    }
                }
            }
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
//        return true;
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
                    query = query + cond.getElement()+" ";

                    int count  = 0;
                    for(Clause cl : cond.getClauseList())
                    {
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
                temp.add("select * from "+ query + ";");
                temp.add(op);
                all_rules.add(temp);
//                System.out.println("select * from "+ query + ";");
            }            
            return all_rules;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    // Mapping Correct Rule Structure
    public static boolean mapping(RuleList rule) 
    {

        System.out.println(rule.toString());
        return true;
    }


    public static boolean runBatchRule(Connection connection) 
    {

        ResultSet output;

        ArrayList<ArrayList<String>> result = unmarshallRule();
        System.out.println("result:"+result);
//        fetchAccountDetails("1",connection);
        try {
            if(result.size() > 0) {
                System.out.println(result);
                for(int i = 0;i < result.size();i++) {
                    if(result.get(i).get(0).equals("BT")) {
                        batch(result,connection,i);

                    }
                }
            }
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean runRealTimeRule(Connection connection) 
    {

        ResultSet output;

        ArrayList<ArrayList<String>> result = unmarshallRule();
        System.out.println("result:"+result);
        fetchAccountDetails("1",connection);
        try {
            if(result.size() > 0) {
                System.out.println(result);
                for(int i = 0;i < result.size();i++) {
                    if(result.get(i).get(0).equals("RT")) {
                        batch(result,connection,i);

                    }
                }
            }
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void batch(ArrayList<ArrayList<String>> result,Connection connection,int i) {
        ResultSet output;
        Sql sql = new Sql(connection);
//        System.out.println("Hello");
        try {
            output = sql.select(result.get(i).get(2));
            ResultSetMetaData rsmd = output.getMetaData();					

            if(result.get(i).get(3).contentEquals("insert")) {
                String query_update = result.get(i).get(1);
//                System.out.println(query_update);
                while (output.next())
                {
                    System.out.println();
                    PreparedStatement preparedStatement =  connection.prepareStatement(query_update);
//                    System.out.println("Before: " +preparedStatement.toString());
//                    System.out.println("column count: " + rsmd.getColumnCount());
                    for(int k=1 ; k<=rsmd.getColumnCount(); k++)
                    {
                        if(rsmd.getColumnTypeName(k).contains("char"))
                            preparedStatement.setString(k, output.getString(rsmd.getColumnLabel(k)));
                    }						
//                    System.out.println("After: " +preparedStatement.toString());
                    sql.insert(preparedStatement.toString());
                    System.out.println("inserted data");
//                    System.out.println();

                }

            }

            else if(result.get(i).get(3).contentEquals("update")) {
                String query_update = result.get(i).get(1);
//                System.out.println(query_update);

                while (output.next())
                {
                    System.out.println();
                    PreparedStatement preparedStatement =  connection.prepareStatement(query_update);
//                    System.out.println("Before: " +preparedStatement.toString());
                    if(rsmd.getColumnTypeName(1).contains("char"))
                        preparedStatement.setString(1, output.getString(rsmd.getColumnLabel(1)));
//                    System.out.println("After: " +preparedStatement.toString());
                    sql.update(preparedStatement.toString());
                    System.out.println("updated data");
//                    System.out.println();
                }

            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static List<TransactionTable> fetchTransactions(String acc_no,Connection connection)
    {
        ResultSet output;
        Sql sql = new Sql(connection);

        List<TransactionTable> list = new ArrayList<TransactionTable>();
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
                TransactionTable transactionTable = new TransactionTable();

                transactionTable.setTx_id(output.getString(rsmd.getColumnLabel(k++)));
                transactionTable.setBranch_code(output.getString(rsmd.getColumnLabel(k++)));
                transactionTable.setAcc_no(output.getString(rsmd.getColumnLabel(k++)));
                transactionTable.setCust_id(output.getString(rsmd.getColumnLabel(k++)));
                transactionTable.setTx_type(output.getString(rsmd.getColumnLabel(k++)));
                transactionTable.setTx_time(output.getString(rsmd.getColumnLabel(k++)));
                transactionTable.setTx_desc(output.getString(rsmd.getColumnLabel(k++)));
                transactionTable.setAcc_balance(output.getString(rsmd.getColumnLabel(k++)));
                transactionTable.setTx_amount(output.getString(rsmd.getColumnLabel(k++)));					
                list.add(transactionTable);
            }
            return list;

        }
        catch(Exception e) {
            e.printStackTrace();
            return null;

        }
    }


    public static AccountTable fetchAccountDetails(String acc_no,Connection connection) 
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
                accountTable.setAcc_no(output.getString(rsmd.getColumnLabel(k++)));
                accountTable.setBranch_code(output.getString(rsmd.getColumnLabel(k++)));
                accountTable.setCust_id(output.getString(rsmd.getColumnLabel(k++)));
                accountTable.setAcc_type(output.getString(rsmd.getColumnLabel(k++)));
                accountTable.setAcc_balance(output.getString(rsmd.getColumnLabel(k++)));
                accountTable.setLasttransactiontime(output.getString(rsmd.getColumnLabel(k++)));
                accountTable.setLastqrtrfeedeductdate(output.getString(rsmd.getColumnLabel(k++)));
                accountTable.setTransaction_count(output.getString(rsmd.getColumnLabel(k++)));
                accountTable.setCredit_score(output.getString(rsmd.getColumnLabel(k++)));

            }
            System.out.println(accountTable.getAcc_balance());
            return accountTable;
        }
        catch(Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateAccountDetails(AccountTable accountTable,Connection connection) 
    {

        ResultSet output;
        Sql sql = new Sql(connection);

        try {
            String Acc_No                 = accountTable.getAcc_no();
            String Branch_Code            = accountTable.getBranch_code();
            String Cust_ID                = accountTable.getCust_id();
            String Acc_Type               = accountTable.getAcc_type();
            String Acc_Balance            = accountTable.getAcc_balance();
            String LastTransactionTime    = accountTable.getLasttransactiontime();
            String LastQrtrFeeDeductDate  = accountTable.getLastqrtrfeedeductdate();
            String Transaction_count      = accountTable.getTransaction_count();
            String Credit_score           = accountTable.getCredit_score();

            String query = "update account set acc_balance = '"+ Acc_Balance + "',transaction_count = '"+ Transaction_count + "' where acc_no = '"+ Acc_No + "' ;" ;

            sql.update(query);
            return true;
        }
        catch(Exception e) 
        {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateTransactionDetails(TransactionTable transactionTable, Connection connection) 
    {

    	System.out.println(transactionTable);
        ResultSet output;
        Sql sql = new Sql(connection);

        try {
            String tx_id        = transactionTable.getTx_id();
            String branch_code  = transactionTable.getBranch_code();
            String acc_no       = transactionTable.getAcc_no();
            String cust_id      = transactionTable.getCust_id();
            String tx_type      = transactionTable.getTx_type();
            String tx_time      = transactionTable.getTx_time();
            String tx_desc      = transactionTable.getTx_desc();
            String acc_balance  = transactionTable.getAcc_balance();
            String tx_amount    = transactionTable.getTx_amount();
            
			PreparedStatement stmt=connection.prepareStatement("INSERT INTO transaction (tx_ID, branch_code, acc_no, cust_id, tx_type, tx_time, tx_desc, acc_balance, tx_amount) VALUES(?,?,?,?,?,?,?,?,?)");  
			stmt.setString(1, tx_id);  
			stmt.setString(2, branch_code);
			stmt.setString(3, acc_no);
			stmt.setString(4, cust_id);  
			stmt.setString(5, tx_type);
			stmt.setString(6, tx_time);
			stmt.setString(7, tx_desc);  
			stmt.setString(8, acc_balance);
			stmt.setString(9, tx_amount);
			  
			int i=stmt.executeUpdate();  

			if(i!=0)
				return true;
			else
				return false;
            
        }   
        catch(Exception e) 
        {   
        	return false;
        }
    }
    
    public String getAccountNumber(String id) {
    	
    	String account_num;
    	DatabaseConnection connection = new DatabaseConnection();
    	try {
    		
    		Connection conn = connection.establishConnection();
    		String sql = "SELECT acc_no FROM account where cust_id='" + id + "';";
    		Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            return rs.getString(0);
            
    	} catch(Exception e) {
    		return null;
    	}
    	
    }
}
