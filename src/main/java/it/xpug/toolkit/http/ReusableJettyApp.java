package it.xpug.toolkit.http;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.mortbay.jetty.*;
import org.mortbay.jetty.handler.*;
import org.mortbay.jetty.servlet.*;

public class ReusableJettyApp {

	private Server server;
	private final HttpServlet servlet;

	public ReusableJettyApp(Class<? extends HttpServlet> servletClass) {
		try {
			this.servlet = servletClass.newInstance();
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}

	public ReusableJettyApp(HttpServlet servlet) {
		this.servlet = servlet;
	}

	public void start(int port, String resourceBase) {
		server = new Server(port);
		try {
			HandlerList handlers = new HandlerList();
			handlers.setHandlers(new Handler[] {
				new StaticFilesHandler(resourceBase),
				servletHandler(),
				new DefaultHandler()
			});
			server.setHandler(handlers);
			server.doStart();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void shutdown() {
		try {
			server.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ServletHandler servletHandler() {
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(new ServletHolder(servlet), "/");
		return servletHandler;
	}

	private final class StaticFilesHandler extends ResourceHandler {
		private StaticFilesHandler(String resourceBase) {
			setResourceBase(resourceBase);
	        setWelcomeFiles(new String[]{ "index.html" });
		}

		@Override
		public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
			if (request.getPathInfo().equals("/") && !welcomeExists()) {
				((Request) request).setHandled(false);
			} else {
				super.handle(target, request, response, dispatch);
			}
		}

		private boolean welcomeExists() throws IOException {
			return this.getBaseResource().addPath("/index.html").exists();
		}
	}
}
