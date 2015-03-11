package it.xpug.fittizia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FittiziaAppTest {

	private List<Attendant> attendants = new ArrayList<Attendant>();
	private FittiziaApp fittizia = new FittiziaApp(attendants);

	@Test
	public void listWithNoAttendants() throws Exception {
		fittizia.addParameter("course_id", "123");
		assertEquals("[]", fittizia.get("/api/attendants"));
	}

	@Test
	public void addOneAttendant() throws Exception {
		fittizia.addParameter("course_id", "123");
		fittizia.addParameter(Attendant.FIRST_NAME, "Mario");
		fittizia.addParameter(Attendant.LAST_NAME, "Rossi");
		fittizia.addParameter(Attendant.EMAIL, "mario@rossi.com");

		fittizia.post("/api/attendants");
		assertEquals(1, attendants.size());
		assertEquals("Mario", attendants.get(0).getFirstName());
		assertEquals("Rossi", attendants.get(0).getLastName());
		assertEquals("mario@rossi.com", attendants.get(0).getEmail());
	}

	@Test
	public void listWithOneAttendant() throws Exception {
		Attendant attendant = new Attendant("Ciccio", "Pasticcio",
				"ciccio@pasticcio.gmail");
		fittizia.getAttendants().add(attendant);
		assertEquals(
				"[{first_name: 'Ciccio', last_name: 'Pasticcio', email: 'ciccio@pasticcio.gmail'}]",
				fittizia.get("/api/attendants"));

	}

	@Test
	public void listWithTwoAttendants() throws Exception {
		Attendant attendant1 = new Attendant("Ciccio", "Pasticcio",
				"ciccio@pasticcio.gmail");
		Attendant attendant2 = new Attendant("Ciccia", "Pasticcia",
				"ciccia@pasticcia.gmail");
		fittizia.getAttendants().add(attendant1);
		fittizia.getAttendants().add(attendant2);
		assertEquals(
				"[{first_name: 'Ciccio', last_name: 'Pasticcio', email: 'ciccio@pasticcio.gmail'},{first_name: 'Ciccia', last_name: 'Pasticcia', email: 'ciccia@pasticcia.gmail'}]",
				fittizia.get("/api/attendants"));
//
	}

}
