package it.xpug.fittizia;

import static java.lang.String.format;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FittiziaAppServlet extends HttpServlet {
	private List<Attendant> attendants = new ArrayList<Attendant>();
	private FittiziaApp fittizia = new FittiziaApp(attendants);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getRequestURI().equals("/api/attendants")) {
			try {
				resp.getWriter().write(fittizia.get("/api/attendants"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			resp.setContentType("application/json");
			PrintWriter writer = resp.getWriter();
			String json = "[{\"title\": \"test corso\", \"id\": \"1029\", \"description\": \"corso che parla di JAVA\",\"teacher\": \"docente\", \"price\": \"120euro\", \"startDate\":\"23/11/2015\", \"length\": \"5days\"},"
					+ "{\"title\": \"test corso 2\", \"id\": \"1020\", \"description\": \"corso che parla di C#\",\"teacher\": \"docente2\", \"price\": \"140euro\", \"startDate\":\"28/11/2015\", \"length\": \"3days\"},"
					+ "{\"title\": \"test corso 3\", \"id\": \"1019\", \"description\": \"corso che parla di Ruby\",\"teacher\": \"docente3\", \"price\": \"540euro\", \"startDate\":\"28/12/2015\", \"length\": \"1days\"},"
					+ "{\"title\": \"test corso xp\", \"id\": \"1099\", \"description\": \"corso che parla di XP\",\"teacher\": \"docente4\", \"price\": \"640euro\", \"startDate\":\"1/11/2015\", \"length\": \"2days\"}"
					+ "]";
			writer.write(json);
			writer.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getRequestURI().equals("/api/attendants")) {
			try {
				
//				System.out.println(req.getParameterMap().keySet());
				
				fittizia.addParameter(Attendant.COURSE_ID,
						req.getParameter(Attendant.COURSE_ID));
				fittizia.addParameter(Attendant.FIRST_NAME,
						req.getParameter(Attendant.FIRST_NAME));
				fittizia.addParameter(Attendant.LAST_NAME,
						req.getParameter(Attendant.LAST_NAME));
				fittizia.addParameter(Attendant.EMAIL,
						req.getParameter(Attendant.EMAIL));
				fittizia.post("/api/attendants");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// TODO aggiunta corso
		}

	}

}
