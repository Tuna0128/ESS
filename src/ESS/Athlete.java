package ESS;

public class Athlete extends Member{
	private String sportType;
	public Athlete(String Name, int ID, int Age, String Country) {
		super(Name, ID, Age, Country);
	}
	
	public Athlete(String Name, int ID, int Age, String Country,String sportType) {
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
