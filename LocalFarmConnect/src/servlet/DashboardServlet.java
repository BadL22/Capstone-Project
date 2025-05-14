package servlet;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        // Check if user is logged in
        if (session == null || session.getAttribute("currentUser") == null) {
            response.sendRedirect("views/login.jsp");
            return;
        }
        
        // Retrieve user
        User user = (User) session.getAttribute("currentUser");
        String role = user.getRole(); // 'farmer' or 'consumer'

        // Make user and role available in JSP
        request.setAttribute("user", user);
        request.setAttribute("role", role);

        // Forward to dashboard JSP
        request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
    }
}