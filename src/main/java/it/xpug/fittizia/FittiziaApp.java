package it.xpug.fittizia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FittiziaApp {

	public static final String CMD = "CMD";

	private List<Attendant> attendants;
	private Map<String, String> params = new HashMap<String, String>();

	public FittiziaApp(List<Attendant> attendants) {
		this.attendants = attendants;
	}

	public String get(String url) throws Exception {
		String json = "[";
		if (attendants != null && attendants.size() != 0) {
			for (Attendant attendant : attendants) {
				json += String
						.format("{\"course_id\": \"%s\", \"first_name\": \"%s\", \"last_name\": \"%s\", \"email\": \"%s\", \"num_attendants\": %d, \"is_company\": \"%s\"},",
								attendant.getCourseId(),
								attendant.getFirstName(),
								attendant.getLastName(), attendant.getEmail(),
								attendant.getNumOfAttendants(),
								attendant.isCompany());
			}

			json = json.substring(0, json.length() - 1);
		}
		json += "]";
		return json;

	}

	public void addParameter(String key, String value) {
		params.put(key, value);
	}

	public void post(String string) {
		if ("edit".equals(params.get(CMD))) {
			for (Attendant attendant : attendants) {
				if (attendant.getFirstName().equals(
						params.get(Attendant.FIRST_NAME))
						&& attendant.getLastName().equals(
								params.get(Attendant.LAST_NAME))
						&& attendant.getEmail().equals(
								params.get(Attendant.EMAIL))
						&& attendant.getCourseId().equals(
								params.get(Attendant.COURSE_ID))) {
					System.out.println("***********"
							+ params.get("newCourseId"));
					attendant.setCourseId(params.get("newCourseId"));
				}
			}
		} else {

			String lastName = params.get(Attendant.LAST_NAME);
			boolean isCompany = false;

			for (int i = 0; i < Integer.parseInt(params
					.get(Attendant.NUM_ATTENDANTS)); i++) {
				isCompany = Boolean.parseBoolean(params
						.get(Attendant.IS_COMPANY));
				if (isCompany) {
					lastName = "Iscritto " + params.get(Attendant.FIRST_NAME)
							+ " #" + (i + 1);
				}
				attendants.add(new Attendant(params.get(Attendant.FIRST_NAME),
						lastName, params.get(Attendant.EMAIL), params
								.get(Attendant.COURSE_ID), 1, isCompany));
			}
		}
	}

	public List<Attendant> getAttendants() {
		return attendants;
	}

}
