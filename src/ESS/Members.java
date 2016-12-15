package ESS;

public class Members implements Comparable<Object> {
	private String Name;
	private int ID;
	private int Age;
	private String Country;
	// private String sportType;

	public Members(String Name, int ID, int Age, String Country) {
		this.setName(Name);
		this.setID(ID);
		this.setAge(Age);
		this.setCountry(Country);
		// this.setSportType(sportType);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
