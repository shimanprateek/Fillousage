import java.util.ArrayList;
import java.util.Map;

public class Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String filepath = "C:\\Users\\shima\\Desktop\\Mortgage\\";
		ArrayList<Map<String, String>> Scenario_Values = GenericFunctions.getValues(filepath,"Scenario.xlsx", "FeatureSheet", "RPFTBJ");
		
		String Scenario_Type = Scenario_Values.get(0).get("Scenario_Type");
		GenericFunctions.WritePropertiesFile("Scenario_Type", Scenario_Type);
		
		String Application_Type = Scenario_Values.get(0).get("Application_Type");
		GenericFunctions.WritePropertiesFile("Application_type", Application_Type);
		
		String Applicant_type= Scenario_Values.get(0).get("Please choose an application type");
		GenericFunctions.WritePropertiesFile("Applicant_type", Applicant_type);
		
		String Mortgage_type= Scenario_Values.get(0).get("Mortgage type");
		GenericFunctions.WritePropertiesFile("Mortgage_type", Mortgage_type);
		
		String App_Mortgage_selection= Scenario_Values.get(0).get("Have you had or do you have a mortgage ?");
		GenericFunctions.WritePropertiesFile("App_Mortgage_selection", App_Mortgage_selection);
		
		String property_Mortgage_free= Scenario_Values.get(0).get("Is the property currently owned or mortgage free?");
		GenericFunctions.WritePropertiesFile("property_Mortgage_free", property_Mortgage_free);
		
		String App_remortgaged_selection= Scenario_Values.get(0).get("Who owns the property to be remortgaged?");
		GenericFunctions.WritePropertiesFile("App_remortgaged_selection", App_remortgaged_selection);
		
		String App_Mortgage_now= Scenario_Values.get(0).get("Select employment type-1");
		GenericFunctions.WritePropertiesFile("App_Mortgage_now", App_Mortgage_now);
		
		String BothJoint_Lender= Scenario_Values.get(0).get("Name of the Lender");
		GenericFunctions.WritePropertiesFile("BothJoint_Lender", BothJoint_Lender);
		
		String App1_Employment_type= Scenario_Values.get(0).get("Select employment type-1");
		GenericFunctions.WritePropertiesFile("App1_Employment_type", App1_Employment_type);
		
		String App1_Mortgage_now= Scenario_Values.get(0).get("Do you have a mortgage now?-1");
		GenericFunctions.WritePropertiesFile("App1_Mortgage_now", App1_Mortgage_now);
		
		String App1_Property_now= Scenario_Values.get(0).get("Do you own a property now?-1");
		GenericFunctions.WritePropertiesFile("App1_Property_now", App1_Property_now);
		
		String App1_Lender= Scenario_Values.get(0).get("Name of the Lender-1");
		GenericFunctions.WritePropertiesFile("App1_Lender", App1_Lender);
		
		String App2_Employment_type= Scenario_Values.get(0).get("Select employment type-2");
		GenericFunctions.WritePropertiesFile("App2_Employment_type", App2_Employment_type);
		
		String App2_Mortgage_now= Scenario_Values.get(0).get("Do you have a mortgage now?-2");
		GenericFunctions.WritePropertiesFile("App2_Mortgage_now", App2_Mortgage_now);
		
		String App2_Property_now= Scenario_Values.get(0).get("Do you own a property now?-2");
		GenericFunctions.WritePropertiesFile("App2_Property_now", App2_Property_now);
		
		String App2_Lender= Scenario_Values.get(0).get("Name of the Lender-2");
		GenericFunctions.WritePropertiesFile("App2_Lender", App2_Lender);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(GenericFunctions.ReadPropertiesFile("App2_Employment_type"));

	}

}
