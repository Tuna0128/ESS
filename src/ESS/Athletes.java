package ESS;

public class Athletes extends Members{
	private String sportType;
	public Athletes(String Name, int ID, int Age, String Country) {
		super(Name, ID, Age, Country);
	}
	
	public Athletes(String Name, int ID, int Age, String Country,String sportType) {
		super(Name, ID, Age, Country);
		this.setSportType(sportType);
	}

	public String getSportType() {
		return sportType;
	}

	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
	
	
}
