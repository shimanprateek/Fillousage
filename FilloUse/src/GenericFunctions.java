import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
public class GenericFunctions {

	static String filepath = "C:\\Users\\shima\\Desktop\\Mortgage\\";
	static String filename = "Datasheet.xlsx";
	static String sheetname = "";

	public static ArrayList<Map<String, String>>  getValues (String filepath,String Filename,String sheetname,String Scenario_Type)
	{
		Fillo f = new Fillo(); 
		ArrayList<Map<String, String>> rows = new ArrayList<Map<String, String>>();
		if(ValidateScenario(Filename,sheetname,Scenario_Type))
		{
			try {  
				
				//String filepath = "C:\\\\Users\\pratekug\\Desktop\\CucumberDatasheet\\Scenario.xlsx";
				Connection con = f.getConnection(filepath + "\\" + Filename);
				String strQuery = "select  * from "+ sheetname +" where Scenario_Type ='"+ Scenario_Type +"'";
				//System.out.println(strQuery);
				Recordset rs = con.executeQuery(strQuery);
				//System.out.println("Record Count--getvalues --> " + rs.getCount());
				System.out.println("List of Columns in "+sheetname + rs.getFieldNames());
				while (rs.next())
				{
					ArrayList <String> Column_names = rs.getFieldNames();
					Iterator<String> dataIterator = Column_names.iterator();
					LinkedHashMap<String, String> row = new LinkedHashMap<String, String>();
					
					while(dataIterator.hasNext())
					{
						String Column_name = dataIterator.next();
						String Column_value = rs.getField(Column_name).toString();
						//System.out.println("Column_name:" + Column_name);
						//System.out.println("Column_value:" + Column_value );
						row.put(Column_name, Column_value);
					}
					//System.out.println("List of Columns in "+sheetname + Column_names);
					//System.out.println("Column_name : "+ rs.getField(Column_name));
					rows.add(row);
				}
				System.out.println("Map of Column and values:"+ rows);
				rs.close();
				con.close();
					
			} catch (FilloException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
		}else
		{
			System.out.println("Value does not exist in Datasheet");
			//value = "Value does not exist in Datasheet";
		}
		System.out.println("========================================================");
		return rows;

	}
	public static Boolean ValidateScenario(String Filename,String sheetname,String Scenario_Type)
	{
		Fillo f = new Fillo(); 
		Boolean value = true;
		try {  
			System.out.println("========================================================");
			//String filepath = "C:\\\\Users\\pratekug\\Desktop\\CucumberDatasheet\\Scenario.xlsx";
			Connection con = f.getConnection(filepath + "\\" + Filename);
			String strQuery = "select  Scenario_Type from "+ sheetname +" where Scenario_Type ='"+ Scenario_Type +"'";
			System.out.println(strQuery);
			Recordset rs = con.executeQuery(strQuery);
			System.out.println("Record Count --> " + rs.getCount());
			while (rs.next())
			{	
				//System.out.println("Column_name : "+ rs.getField(Scenario_Type));
			}

			rs.close();
			con.close();
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			System.err.println("No Record Found in :"+ Filename +"  "+"  Check the sheet OR Parameters");
			value = false;
			//e.printStackTrace();
		}

		return value;

	}	

	
	public static void WritePropertiesFile(String key,String value) {
		 FileInputStream fileIn = null;
			FileOutputStream fileOut=null;
		try {
			System.out.println("WriteProperty File Value: " + key + ": "+value );
			File file = new File("TextContext.properties");
			Properties properties = new Properties();
			fileIn = new FileInputStream(file);
			properties.load(fileIn);
			properties.setProperty(key, value);
		
			fileOut = new FileOutputStream(file);
			properties.store(fileOut, "ScenarioContext");
			fileOut.close();
			fileIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//properties.store(fileOut, "TexContext");
		
	}
	
	public static String ReadPropertiesFile(String Key) {
		String Value = null;
		
		try {
			
			File file = new File("TextContext.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			Value = properties.getProperty(Key);
			System.out.println("Value from Property file:" + Value);
			fileInput.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//properties.store(fileOut, "TexContext");
		return Value;
		
	}
	
	public static Boolean  UpdateValue (String filepath,String Filename,String sheetname,String Scenario_Type,String Column,String Column_Value)
	{
		Fillo f = new Fillo(); 
		if(ValidateScenario(Filename,sheetname,Scenario_Type))
		{
			try {  
				
				//String filepath = "C:\\\\Users\\pratekug\\Desktop\\CucumberDatasheet\\Scenario.xlsx";
				Connection con = f.getConnection(filepath + "\\" + Filename);
				System.out.println("Before:");
				ValidateUpdate(Filename, sheetname, Scenario_Type, Column,Column_Value);
				System.out.println("========================================================");
				String strQuery1="Update " + sheetname + " Set "+ Column +"='"+Column_Value+"' where Scenario_Type ='"+ Scenario_Type +"'";
				System.out.println(strQuery1);
				//System.out.println(strQuery);
				 con.executeUpdate(strQuery1);
				 System.out.println("========================================================");
				
				// Connection con1 = f.getConnection(filepath + "\\" + Filename);
				// Recordset rs = con1.executeQuery(strQuery);
				//System.out.println("Record Count--getvalues --> " + rs.getCount());
				 //String Column_value = rs.getField(Column).toString();
				 System.out.println("After:");
				 if(ValidateUpdate(Filename, sheetname, Scenario_Type, Column,Column_Value))
				 {
					 System.out.println("Insert Happened Successfully");
				 }else
				 {
					 System.out.println("Value Not Updated Successfully at: " +Column );
				 }
						
				//rs.close();
				 con.close();
					
			} catch (FilloException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.out.println("Exception : Insert Not Happened");
				//e.printStackTrace();
				return false;
			}
		}else
		{
			System.out.println("Value does not exist in Datasheet");
			//value = "Value does not exist in Datasheet";
		}
		System.out.println("========================================================");
		return true;

	}

	public static Boolean ValidateUpdate(String Filename,String sheetname,String Scenario_Type,String Column,String Column_value)
	{
		Fillo f = new Fillo(); 
		Boolean value = true;
		try {  
			System.out.println("========================================================");
			//String filepath = "C:\\\\Users\\pratekug\\Desktop\\CucumberDatasheet\\Scenario.xlsx";
			Connection con = f.getConnection(filepath + "\\" + Filename);
			String strQuery = "select  * from "+ sheetname +" where Scenario_Type ='"+ Scenario_Type +"'";
			System.out.println(strQuery);
			Recordset rs = con.executeQuery(strQuery);
			System.out.println("Record Count --> " + rs.getCount());
			while (rs.next())
			{	
				//System.out.println("Column_name : "+ rs.getField(Scenario_Type));
			}
			System.out.println("Column Name : " + Column);
			if(Column_value.contentEquals(rs.getField(Column).toString()))
			{
				System.out.println("Column Value : " +rs.getField(Column).toString());
			}else
			{
				System.out.println("Column Value : " +rs.getField(Column).toString());
				return false;
			}
			
			rs.close();
			con.close();
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			System.err.println("Value Not Updated in :"+ Filename +"  "+"  Check the sheet OR Parameters");
			value = false;
			//e.printStackTrace();
		}

		return value;

	}	

}
