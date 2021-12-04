package kwhitelaw96;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DataController {
	
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
		return compareDistance(sonars);
	}//end readSonarFromCSV
	
	public static List<SonarReading> compareDistance(List<SonarReading> sonars2){
		List<SonarReading> sonars = sonars2;
		int largerCnt = 0;
		boolean stopLoop = false;
		//comparing
		for(int s =0; s<sonars.size();s++) {
			if(stopLoop) {
				break;
			}else {
				if(s != sonars.size()-1 && !stopLoop) {
					int windowA=0;
					int windowB=0;
					for(int i=0;i<3;i++) {
						try {
							windowA += sonars.get(s+i).getDistancceRead();
							windowB += sonars.get(s+(i+1)).getDistancceRead();
						}catch(Exception e) {
							System.out.println("Not enough to check");
							stopLoop =true;
							break;
						}//end try/catch
					}//end inner loop
					if(!stopLoop) {
						int status = (Integer.compare(windowB, windowA));
						switch (status) {
						case 0:
							System.out.printf("Sonar reading: %d  unchanged.\n",windowB);
							break;
						case 1:
							largerCnt++;
							System.out.printf("Sonar reading: %d  increased.\n",windowB);
							break;
						case -1:
							System.out.printf("Sonar reading: %d  decreased.\n",windowB);
						}//end switch	
					}//end if for comparing inner loop
				}//end if inner loop	
			}//end else outter loop
		}//end outter loop
		System.out.printf("Total measurments that were larger: %d", largerCnt);
		return sonars;
	}//end compareDistance
	
	private static SonarReading createSonar(String[] metadata) {
		int sonarDistance = Integer.parseInt(metadata[0]);
		
		//return 
		return new SonarReading(sonarDistance);
	}//end createSonar
	
	
	
}
