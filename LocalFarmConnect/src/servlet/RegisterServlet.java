package servlet;

import dao.UserDAO;
import factory.UserFactory; //added import
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    //added for UserDAO singleton pattern
    private final UserDAO userDAO = UserDAO.getInstance();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get form values
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String location = request.getParameter("location");
        
        //Added for basic input validation
        if (name == null || email == null || password == null || role == null || location == null ||
            name.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty() || location.isEmpty()) {
            
            request.setAttribute("error", "All required fields must be filled out.");
            request.getRequestDispatcher("views/register-failure.jsp").forward(request, response);
            return;
        }

        // Create user object via factory
        User user = UserFactory.createUser(role);
        
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setLocation(location);
        
        System.out.println("Registering user with:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
        System.out.println("Location: " + location);


        // Insert into DB
        boolean success = userDAO.registerUser(user);

        if (success) {
            response.sendRedirect("views/register-success.jsp"); // Redirect to success page 
        } else {
            response.sendRedirect("views/register-failure.jsp"); // Redirect to failure page 
        }
    }
}
