package kwhitelaw96;

public class SonarReading {

	private int distanceRead;
	//constructor
	public SonarReading(int distanceRead) {
		this.distanceRead = distanceRead;
	}
	//getters and setters
	public int getDistancceRead() {
		return distanceRead;
	}//end get
	public void setDistanceRead(int distanceRead) {
		this.distanceRead = distanceRead;
	}//end set
	
	@Override
	public String toString() {
		return "Sonar reading: "+distanceRead;
	}
}
