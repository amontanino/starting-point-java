package it.xpug.helloworld;

import static java.lang.String.format;
import it.xpug.toolkit.db.Database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	private Database database;

	public HelloWorldServlet(Database database) {
		this.database = database;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
		String json = "[{\"title\": \"test corso\", \"description\": \"corso che parla di JAVA\",\"teacher\": \"docente\", \"price\": \"120euro\", \"date\":\"23/11/2015\"}" +
				"{\"title\": \"test corso 2\", \"description\": \"corso che parla di C#\",\"teacher\": \"docente2\", \"price\": \"140euro\", \"date\":\"28/11/2015\"}" +
				"{\"title\": \"test corso 3\", \"description\": \"corso che parla di Ruby\",\"teacher\": \"docente3\", \"price\": \"540euro\", \"date\":\"28/12/2015\"}" +
				"{\"title\": \"test corso xp\", \"description\": \"corso che parla di XP\",\"teacher\": \"docente4\", \"price\": \"640euro\", \"date\":\"1/11/2015\"}" +
				"]";
		writer.write(format(json, seven()));
		writer.close();
	}

	private Object seven() {
		return database.selectOneValue("select 3+4");
	}
}
