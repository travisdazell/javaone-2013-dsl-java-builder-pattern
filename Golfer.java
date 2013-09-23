package net.travisdazell.javaone;

public class Golfer {
	private String firstName;
	private String lastName;
	private int numberOfGuests;
	
	public Golfer() {
		// this is intentionally left blank for JAXB
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
}
