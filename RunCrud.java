package src.connector;

import java.sql.*;
import java.util.Scanner;

public class RunCrud {
    public static Connection getConnection(){
        Connection con= null;
        try {
            String dbuser = "root";
            String dbPass = "Purplecandy01";
            //jdbc coonection string...
            String connString = "jdbc:mysql://localhost:3306/dbtest?useSSL=false&serverTimezone=UTC";

            con = DriverManager.getConnection(connString, dbuser, dbPass);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;

        }

    public static int getuserOption() {
        System.out.println("Please choose option");
        Scanner scan = new Scanner(System.in);
        int num;
        num = scan.nextInt();
        return num;
    }
    public static void ListEmployee() {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteEmployee(String name, String address) {
        Connection con= getConnection();
        try {
            String sql = "delete from employee where name= ? and address=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void showMenu() {
        System.out.println("\nChoose Option: \n 1= Delete \n 2=Quit\n");
    }
    public static void performOperation (int opt) {
        switch (opt) {
            case 1:
                System.out.println("Deleting Student");
                System.out.println("Enter name");
                String name = new Scanner(System.in).nextLine();
                System.out.println("Enter address");
                String address = new Scanner(System.in).nextLine();
                deleteEmployee(name, address);
                break;
            case 2:
                System.out.println("Quitting...");
                System.exit(0);
        }
    }
    public static void main(String[] args)  {
        while(true){
            ListEmployee();
            showMenu();
            int choice= getuserOption();
            performOperation(choice);


    }




        }






    }



