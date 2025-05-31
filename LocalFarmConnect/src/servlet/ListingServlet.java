package servlet;

import model.Listing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listings")
public class ListingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static List<Listing> listingStore = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        boolean available = request.getParameter("available") != null;

        Listing listing = new Listing(name, category, description, price, available);
        listingStore.add(listing);

        HttpSession session = request.getSession();
        session.setAttribute("listings", listingStore);

        response.sendRedirect("views/listings.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("listings", listingStore);
        request.getRequestDispatcher("views/listings.jsp").forward(request, response);
    }
}
