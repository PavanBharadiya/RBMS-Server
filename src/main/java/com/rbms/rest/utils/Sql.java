package com.rbms.rest.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Sql {

   private Connection conn;
   private ResultSet results;

   public Sql(Connection conn) {
       this.conn = conn;
   }

   public void update(String query) {
       try {
           this.conn.prepareStatement(query).executeUpdate();
           System.out.println("Succefully updated data");
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }
   
   public void insert(String query) {
       try {
           this.conn.prepareStatement(query).executeUpdate();
           System.out.println("Succefully Inserted data");
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }

   
   public  ResultSet select(String query) {
       try {
           this.results = this.conn.prepareStatement(query).executeQuery();
           ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
           
//           while (results.next())
//           {
//        	   ArrayList<String> temp = new ArrayList<String>();  
//        	   int id = results.getInt("id");
//        	   String firstName = results.getString("name");
//        	   String address = results.getString("address");
//        	   int age = results.getInt("age");
//        	   int salary = results.getInt("salary");
//              
//        	   temp.add(results.getInt("acc_no")+"");
//        	   temp.add(results.getString("br")+"");
//        	   temp.add(results.getString("address")+"");
//        	   temp.add(results.getInt("age")+"");
//        	   temp.add(results.getInt("salary")+"");
//        	   res.add(temp);
//             
//             
//             // print the results
//        	   System.out.format("%d, %s, %s, %s, %s", id, firstName, address, age, salary);
//        	   System.out.println();
//           }
           return results;
           //getResults();
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
           return null;
       }
   }
   
}