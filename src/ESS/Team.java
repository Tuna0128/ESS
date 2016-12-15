package ESS;

public class Team extends Athlete{

	public Team(String Name, int ID, int Age, String Country) {
		super(Name, ID, Age, Country);
	}
	public Team(String Name, int ID, int Age, String Country,String sportType) {
		super(Name, ID, Age, Country,sportType);
	}
}
