import java.util.ArrayList;
import java.util.Map;

public class Usage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String filepath = "C:\\Users\\shima\\Desktop\\Mortgage\\";
		 String filename = "Datasheet.xlsx";
		 String sheetname = "Sheet1";
		 ArrayList<Map<String, String>> sheet1rows = new ArrayList<Map<String, String>>();
		 ArrayList<Map<String, String>> sheet2rows = new ArrayList<Map<String, String>>();
		 ArrayList<Map<String, String>> Scenario_Values = new ArrayList<Map<String, String>>();
		 
		 //Scenario_Values = GenericFunctions.getValues(filepath,"Scenario.xlsx", "FeatureSheet", "RPFTB");
		 //sheet1rows = GenericFunctions.getValues(filepath,filename, sheetname, "A");
		 //sheet2rows = GenericFunctions.getValues(filepath,filename, "Sheet2", "E");
		 //System.out.println(sheet1rows);
		 //System.out.println(sheet2rows);
		 //System.out.println(Scenario_Values);
		 GenericFunctions.UpdateValue(filepath, "Scenario.xlsx", "FeatureSheet", "RPFTBJ", "Status", "Awsome");
		// Scenario_Values = GenericFunctions.getValues(filepath,"Scenario.xlsx", "FeatureSheet", "RPFTB");
		 //System.out.println(Scenario_Values);
		 /*System.out.println(rows.get(0).get("Column1")); 
		 System.out.println(rows.get(1).get("Column1")); 
		 System.out.println(rows.get(2).get("Column1"));*/ 
		 
		// System.out.println(rows.get(5).get("Column2"));
	}

}
