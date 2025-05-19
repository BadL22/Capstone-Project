package dao;

import model.User;
import util.DBConnection;

import java.sql.*;

public class UserDAO {
    // Singleton instance
    private static final UserDAO instance = new UserDAO();

    // Private constructor to enforce singleton
    private UserDAO() {}

    public static UserDAO getInstance() {
        return instance;
    }

    // Login method using DBConnection utility
    public User loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setLocation(rs.getString("location"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Register new user method
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (name, email, password, role, location) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getLocation());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage());
            return false;
        }
    }
}

