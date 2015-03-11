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
		String json = "[{\"title\": \"test corso\", \"id\": \"1029\", \"description\": \"corso che parla di JAVA\",\"teacher\": \"docente\", \"price\": \"120euro\", \"startDate\":\"23/11/2015\", \"length\": \"5days\"}," +
				"{\"title\": \"test corso 2\", \"id\": \"1020\", \"description\": \"corso che parla di C#\",\"teacher\": \"docente2\", \"price\": \"140euro\", \"startDate\":\"28/11/2015\", \"length\": \"3days\"}," +
				"{\"title\": \"test corso 3\", \"id\": \"1019\", \"description\": \"corso che parla di Ruby\",\"teacher\": \"docente3\", \"price\": \"540euro\", \"startDate\":\"28/12/2015\", \"length\": \"1days\"}," +
				"{\"title\": \"test corso xp\", \"id\": \"1099\", \"description\": \"corso che parla di XP\",\"teacher\": \"docente4\", \"price\": \"640euro\", \"startDate\":\"1/11/2015\", \"length\": \"2days\"}" +
				"]";
		writer.write(format(json, seven())); //import statico per format
		writer.close();
	}

	private Object seven() {
		return database.selectOneValue("select 3+4");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				super.doPost(req, resp);
				database.execute("insert into course values ('1','agsjgos@gmail.com','alb','dg')", new String[0]);
				System.out.println("sgsg");
	}
}
