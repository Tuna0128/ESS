package ESS;

public class Venues implements Comparable<Object> {
	
	private String Name;
	private String sportType;
	private String Address;
	private int Seat;
	
	public Venues(String Name, String sportType, String Address, int Seat) {
		this.setName(Name);
		this.setSportType(sportType);
		this.setAddress(Address);
		this.setSeat(Seat);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSportType() {
		return sportType;
	}

	public void setSportType(String sportType) {
		this.sportType = sportType;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getSeat() {
		return Seat;
	}

	public void setSeat(int seat) {
		this.Seat = seat;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
