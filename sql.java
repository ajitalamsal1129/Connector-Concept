package src.connector;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class sql {
    public static void main(String[] args) throws SQLException {
        String dbuser = "root";
        String dbPass = "Purplecandy01";
        //jdbc coonection string...
        String connString = "jdbc:mysql://localhost:3306/dbtest?useSSL=false&serverTimezone=UTC";
        Connection con = null;
        try {
            con = DriverManager.getConnection(connString, dbuser, dbPass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        con.close();

    }
}







