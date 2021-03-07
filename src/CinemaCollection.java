package com.company;

import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CinemaCollection {
    private ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

    public CinemaCollection() throws SQLException {
        Database db = new Database();
        Connection conn = db.getConn();

        Statement stmt =conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cinemas");
        while(rs.next()) {
            cinemas.add(
                new Cinema(
                    rs.getInt(1),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(2)
                )
            );
        }
        rs.close();
        stmt.close();
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    public Cinema search(int cinemaId) {
        for(Cinema cinema: this.cinemas) {
            if(cinemaId == cinema.getCinemaId()) {
                return cinema;
            }
        }
        return null;
    }
}
