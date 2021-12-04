package kwhitelaw96;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DataController {
	
	public static void main(String...args) {
		
		
	}
	
	public List<SonarReading> readSonarFromCSV(String fileName){
		List<SonarReading> sonars = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		//buffered reader
		try(BufferedReader br = Files.newBufferedReader(pathToFile)){
			String line = br.readLine();
			
			//loop until all lines read
			while (line !=null) {
				//split
				String[] att = line.split(" ");
				
				SonarReading sonar = createSonar(att);
				sonars.add(sonar);
				line = br.readLine();
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return outPutReading(sonars);
	}
	public static List<SonarReading> outPutReading(List<SonarReading> sonars2) {
		List<SonarReading> sonars = sonars2;
		
		//output
		for(SonarReading s: sonars) {
			System.out.println(s);
		}
		return sonars;
	}
	private static SonarReading createSonar(String[] metadata) {
		int sonarDistance = Integer.parseInt(metadata[0]);
		
		//return 
		return new SonarReading(sonarDistance);
	}
	
	
	
}
