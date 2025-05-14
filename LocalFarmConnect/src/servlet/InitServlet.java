package servlet;

import util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet(urlPatterns = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    public void init() throws ServletException {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            InputStream is = getServletContext().getResourceAsStream("/WEB-INF/localfarm.sql");
            if (is == null) {
                throw new FileNotFoundException("localfarm.sql not found in WEB-INF");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }

            // Split by ";" in case multiple statements
            for (String query : sql.toString().split(";")) {
                if (!query.trim().isEmpty()) {
                    stmt.execute(query);
                }
            }

            System.out.println("Database initialized.");

        } catch (Exception e) {
            throw new ServletException("Failed to initialize database", e);
        }
    }
}
