package com.cognizant.bhaskar;

//Author : Bhaskar, Anil (360758)
//Email : anil.bhaskar@cognizant.com

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import au.com.bytecode.opencsv.CSVWriter;

public class Utility {
	
	public Utility(){
		Properties properties = new Properties();
		FileInputStream fileIn = null;	
	DBConfig db = new DBConfig();	

	try {
		
		fileIn = new FileInputStream("resources/db.properties");
		properties.load(fileIn);
		
		String t = properties.getProperty("TABLENAME");
		String col = properties.getProperty("COL");
		String grp1 = properties.getProperty("GRP1");
		String grp2 = properties.getProperty("GRP2");
		String grp3 = properties.getProperty("GRP3");
		String grp4 = properties.getProperty("GRP4");
		
		String grp = "";
		if(!grp1.isEmpty()){grp = grp.concat(grp1);}
		if(!grp2.isEmpty()){grp = grp.concat(","+grp2);}
		if(!grp3.isEmpty()){grp = grp.concat(","+grp3);}
		if(!grp4.isEmpty()){grp = grp.concat(","+grp4);}

		
		Connection c = (Connection) db.getConnection();
		
		String sqlComm = "SELECT * FROM `"+t+"`";
		
		String sql1 = "SELECT * FROM "+t+" where "+col+" in ("+grp1+")";
		String sql2 = "SELECT * FROM "+t+" where "+col+" in ("+grp2+")";
		String sql3 = "SELECT * FROM "+t+" where "+col+" in ("+grp3+")";
		String sql4 = "SELECT * FROM "+t+" where "+col+" in ("+grp4+")";
		String sql = "SELECT * FROM "+t+" where "+col+" not in ("+grp+")";
		
		if(grp1.isEmpty()&&grp2.isEmpty()&&grp3.isEmpty()&&grp4.isEmpty()){
			
			Statement stm = (Statement) c.createStatement();			
			ResultSet rs = stm.executeQuery(sqlComm);
			CSVWriter writer = new CSVWriter(new FileWriter("output.csv"));
			writer.writeAll(rs, true);
			writer.flush();	
			rs.close();
		}
		
		if(!grp1.isEmpty()){
			
			Statement stm = (Statement) c.createStatement();			
			ResultSet rs = stm.executeQuery(sql1);
			CSVWriter writer = new CSVWriter(new FileWriter("output1.csv"));
			writer.writeAll(rs, true);
			writer.flush();		
			rs.close();
		}
		
		if(!grp2.isEmpty()){
			
			Statement stm = (Statement) c.createStatement();			
			ResultSet rs = stm.executeQuery(sql1);
			CSVWriter writer = new CSVWriter(new FileWriter("output2.csv"));
			writer.writeAll(rs, true);
			writer.flush();		
			rs.close();
		}
		
		if(!grp3.isEmpty()){
			
			Statement stm = (Statement) c.createStatement();			
			ResultSet rs = stm.executeQuery(sql1);
			CSVWriter writer = new CSVWriter(new FileWriter("output3.csv"));
			writer.writeAll(rs, true);
			writer.flush();	
			rs.close();
		
		}

		if(!grp4.isEmpty()){
			
			Statement stm = (Statement) c.createStatement();			
			ResultSet rs = stm.executeQuery(sql1);
			CSVWriter writer = new CSVWriter(new FileWriter("output4.csv"));
			writer.writeAll(rs, true);
			writer.flush();	
			rs.close();
		
		}
		
		if(!grp.equals("")){
			
			Statement stm = (Statement) c.createStatement();			
			ResultSet rs = stm.executeQuery(sql);
			CSVWriter writer = new CSVWriter(new FileWriter("outputNotIn.csv"));
			writer.writeAll(rs, true);
			writer.flush();		
			rs.close();
		}
		
		c.close();
		System.out.println("Done");

		
	} catch (SQLException  | IOException e) {
		e.printStackTrace();
	}

}}
