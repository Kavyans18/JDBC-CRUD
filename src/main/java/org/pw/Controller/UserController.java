package org.pw.Controller;

import org.pw.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UserController {

    String path = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/JDBC-CRUD";
    String userName = "root";
    String password = "Alpha@123";
    Connection connection = null;

    public User insertUser(User u){
        String query = "INSERT INTO User VALUES(?,?,?,?,?)";
        try {
            Class.forName(path);
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getName());
            ps.setString(3, u.getGender());
            ps.setString(4, u.getEmail());
            ps.setLong(5, u.getPhone());
            int result = ps.executeUpdate();
            if(result == 1){
                System.out.println("Data Saved");
                return u;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
//        finally{
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return null;
    }

    public User updateUser(User u) {
        String query = "UPDATE User SET name = ?, gender = ?, email = ?, phone = ? where id = ?";
        try {
            Class.forName(path);
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(5, u.getId());
            ps.setString(1, u.getName());
            ps.setString(2, u.getGender());
            ps.setString(3, u.getEmail());
            ps.setLong(4, u.getPhone());
            int result = ps.executeUpdate();
            if(result == 1) {
                System.out.print("Data updated");
                return u;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public int deleteUser(int id){
        String query = "DELETE FROM User WHERE id = ?";
        try {
            Class.forName(path);
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if(result == 1) {
                System.out.print("Data Deleted");
                return 1;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }
    public User getUserById(int id) {
        String query = "SELECT * FROM User WHERE id=?";
        try {
            Class.forName(path);
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                User u = new User();
                while (rs.next()) {
                    u.setId(rs.getInt(1));
                    u.setName(rs.getString(2));
                    u.setGender(rs.getString(3));
                    u.setEmail(rs.getString(4));
                    u.setPhone(rs.getLong(5));
                }
                return u;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public List<User> getAllUser(){
        String query = "SELECT * FROM User";
        try {
            Class.forName(path);
            connection =DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setGender(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPhone(rs.getLong(5));
                list.add(u);
            }
            return list;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
