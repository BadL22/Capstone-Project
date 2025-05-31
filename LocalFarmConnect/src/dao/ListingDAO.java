package dao;

import model.Listing;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListingDAO {
    
    public boolean addListing(Listing listing) {
        String sql = "INSERT INTO listings (user_id, name, category, description, price, availability_status) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, listing.getUserId());
            ps.setString(2, listing.getName());
            ps.setString(3, listing.getCategory());
            ps.setString(4, listing.getDescription());
            ps.setDouble(5, listing.getPrice());
            ps.setBoolean(6, listing.isAvailable());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Listing> getAllListings() {
        List<Listing> listings = new ArrayList<>();
        String sql = "SELECT * FROM listings";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Listing l = new Listing();
                l.setId(rs.getInt("id"));
                l.setUserId(rs.getInt("user_id"));
                l.setName(rs.getString("name"));
                l.setCategory(rs.getString("category"));
                l.setDescription(rs.getString("description"));
                l.setPrice(rs.getDouble("price"));
                l.setAvailable(rs.getBoolean("availability_status"));
                listings.add(l);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listings;
    }
}

