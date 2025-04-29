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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a hardcoded list of listings
        List<Listing> listings = new ArrayList<>();

        listings.add(new Listing("Organic Tomatoes", 2.99, "Vegetable", "John's Farm"));
        listings.add(new Listing("Free-Range Eggs", 5.00, "Dairy", "Green Hills Farm"));
        listings.add(new Listing("Fresh Strawberries", 3.50, "Fruit", "Sunny Orchard"));

        // Set listings into request
        request.setAttribute("listings", listings);

        // Forward to listings.jsp
        request.getRequestDispatcher("/views/listings.jsp").forward(request, response);
    }
}
