package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("-----------------------------");
        System.out.println("MENU");
        System.out.println("1. Login to the System");
        System.out.println("2. Exit");
        System.out.println("-----------------------------");
        Scanner scan = new Scanner(System.in);
        try {
            int num = scan.nextInt();
            if(num == 1) {
                login();
            } else if(num == 2) {
                System.out.println("Leaving from the program......");
            } else {
                System.out.println("Enter the appropriate value!");
            }
        } catch(InputMismatchException ex) {
            System.out.println("You must enter an integer number which is ID! Try again...");
            main(new String[0]);
        }
    }

    public static void login() throws SQLException {
        Scanner scan = new Scanner(System.in);
        String email;
        String password;
        Cinema cinema = new Cinema();

        System.out.println("Enter your e-mail address: ");
        email = scan.next();

        System.out.println("Enter your password: ");
        password = scan.next();

        Database db = new Database();
        Connection conn = db.getConn();
        String sql = "SELECT * FROM users WHERE user_email = ? and user_password = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            System.out.println("List of all cinemas in your city: ");
            System.out.println("-----------------------------");
            App app = new App(user);
            app.cinemas();
            app.searchSessions();
            main(new String[0]);
        } else {
            System.out.println("Wrong e-mail or password! Try again...");
            main(new String[0]);
        }
    }
}
