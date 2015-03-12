package it.xpug.fittizia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FittiziaAppTest {

	private List<Attendant> attendants = new ArrayList<Attendant>();
	private FittiziaApp fittizia = new FittiziaApp(attendants);
	
	public static final String URL = "/api/attendants";

	@Test
	public void listWithNoAttendants() throws Exception {
		fittizia.addParameter("course_id", "123");
		assertEquals("[]", fittizia.get(URL));
	}

	@Test
	public void addOneAttendant() throws Exception {
		fittizia.addParameter("course_id", "123");
		fittizia.addParameter(Attendant.FIRST_NAME, "Mario");
		fittizia.addParameter(Attendant.LAST_NAME, "Rossi");
		fittizia.addParameter(Attendant.EMAIL, "mario@rossi.com");
		fittizia.addParameter(Attendant.NUM_ATTENDANTS, "1");
		fittizia.addParameter(Attendant.IS_COMPANY, "false");

		fittizia.post(URL);
		assertEquals(1, attendants.size());
		assertEquals("123", attendants.get(0).getCourseId());
		assertEquals("Mario", attendants.get(0).getFirstName());
		assertEquals("Rossi", attendants.get(0).getLastName());
		assertEquals("mario@rossi.com", attendants.get(0).getEmail());
		assertEquals(1, attendants.get(0).getNumOfAttendants());
		assertEquals(false, attendants.get(0).isCompany());

	}

	@Test
	public void listWithOneAttendant() throws Exception {
		Attendant attendant = new Attendant("Ciccio", "Pasticcio", 
				"ciccio@pasticcio.gmail","123", 1, false);
		fittizia.getAttendants().add(attendant);
		assertEquals(
				"[{\"course_id\": \"123\", \"first_name\": \"Ciccio\", \"last_name\":"
				+ " \"Pasticcio\", \"email\": \"ciccio@pasticcio.gmail\", \"num_attendants\": 1, \"is_company\": \"false\"}]",
				fittizia.get(URL));

	}

	@Test
	public void listWithTwoAttendants() throws Exception {
		Attendant attendant1 = new Attendant("Ciccio", "Pasticcio",
				"ciccio@pasticcio.gmail","124", 1, false);
		Attendant attendant2 = new Attendant("Ciccia", "Pasticcia",
				"ciccia@pasticcia.gmail", "124", 1, false);
		fittizia.getAttendants().add(attendant1);
		fittizia.getAttendants().add(attendant2);
		assertEquals(
				"[{\"course_id\": \"124\", \"first_name\": \"Ciccio\", \"last_name\": \"Pasticcio\", \"email\": \"ciccio@pasticcio.gmail\", \"num_attendants\": 1, \"is_company\": \"false\"},"
				+ "{\"course_id\": \"124\", \"first_name\": \"Ciccia\", \"last_name\": \"Pasticcia\", \"email\": \"ciccia@pasticcia.gmail\", \"num_attendants\": 1, \"is_company\": \"false\"}]",
				fittizia.get(URL));
		//
	}
	
	

	@Test
	public void addGroupAttendants() throws Exception {
		
		Attendant attendant1 = new Attendant("7pixel", "",
				"info@7pixel","124", 3, true);
		fittizia.getAttendants().add(attendant1);		
		assertEquals("[{\"course_id\": \"124\", \"first_name\": \"7pixel\", \"last_name\": \"\","
				+ " \"email\": \"info@7pixel\", \"num_attendants\": 3, \"is_company\": \"true\"}]",
				fittizia.get(URL));
	}
}
