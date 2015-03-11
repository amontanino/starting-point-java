package it.xpug.fittizia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FittiziaApp {

	private List<Attendant> attendants;
	private Map<String, String> params = new HashMap<String, String>();

	public FittiziaApp(List<Attendant> attendants) {
		this.attendants = attendants;
	}

	public String get(String url) throws Exception {
		String json = "[";
		if (attendants != null && attendants.size() != 0) {
			for (Attendant attendant : attendants) {
				json += String.format(
						"{first_name: '%s', last_name: '%s', email: '%s'},",
						attendant.getFirstName(), attendant.getLastName(),
						attendant.getEmail());
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
		attendants.add(new Attendant(params.get(Attendant.FIRST_NAME), params
				.get(Attendant.LAST_NAME), params.get(Attendant.EMAIL)));
	}

	public List<Attendant> getAttendants() {
		return attendants;
	}

}
