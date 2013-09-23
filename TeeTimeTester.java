package net.travisdazell.javaone;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeeTimeTester {

	@Test
	public void test() {
		String confirmation = new TeeTime.CreateTeeTime()
									.setFirstName("Travis")
									.setLastName("Dazell")
									.setNumberOfGuests(3)
									.setTime("24-Sep-2013 3:07 PM")
									.bookTeeTime();
		
		System.out.println(confirmation);
		
		assertTrue(confirmation.length() > 0);
	}

}
