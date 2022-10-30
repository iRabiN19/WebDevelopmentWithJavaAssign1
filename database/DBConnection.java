package database;

import java.sql.*;

public class DBConnection {
    Connection con;
    Statement st;
    ResultSet rows;
    int val;

    public DBConnection() {

        try {
            String username = "root";
            String password = "NV2AZ,Msdrm_$V)`";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankmanagementsystem",
                    username, password);

            // if (con != null) {
            //     System.out.println(
            //             "Connect to Bank Management System Database");
            // } else {
            //     System.out.print(
            //             "Error connecting Database");
            // }

            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(String query) {
        try {
            val = st.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return val;
    }
    public ResultSet select(String query) {
        try {
            rows = st.executeQuery(query);
            // con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    // public static void main(String[] args) {
    //     new DBConnection();
    // }
}
