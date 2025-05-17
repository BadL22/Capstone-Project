package dao;

import model.User;

import java.sql.*;

public class UserDAO {

    private static final UserDAO instance = new UserDAO();

    private Connection conn;

    private UserDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/localfarm", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserDAO getInstance() {
        return instance;
    }

    public User loginUser(String email, String password) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
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
}
