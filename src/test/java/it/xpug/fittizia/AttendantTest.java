package it.xpug.fittizia;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttendantTest {

	@Test
	public void numNoCompany() {
		Attendant attendant2 = new Attendant("Ciccia", "Pasticcia",
				"ciccia@pasticcia.gmail", "124", 6, false);
		
		assertEquals(1, attendant2.getNumOfAttendants());
	
	}

}
