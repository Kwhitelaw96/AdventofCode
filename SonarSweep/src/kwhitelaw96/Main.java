package kwhitelaw96;

public class Main {

	
	
	public static void main(String[] args) {
		DataController dc = new DataController();
		//read CSV and output readings
		dc.readSonarFromCSV("SonarData.csv");
		
		
	}

}
