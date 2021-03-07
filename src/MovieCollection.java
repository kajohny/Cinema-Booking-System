package com.company;

import java.sql.*;
import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieCollection() {

    }

    public MovieCollection(Session session) throws SQLException {
        Database db = new Database();
        Connection conn = db.getConn();
        String sql = "SELECT m.movie_id, m.movie_name, m.age_limit, m.description, m.movie_genre" +
                " FROM sessions as s INNER JOIN movies as m ON s.movie_id = m.movie_id" +
                " WHERE s.session_id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, session.getSessionId());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            movies.add(
                    new Movie(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)
                    )
            );
        }
        rs.close();
        pstmt.close();
    }

    public void getInfo() throws SQLException {
        Database db = new Database();
        Connection conn = db.getConn();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
        while (rs.next()) {
            movies.add(
                    new Movie(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)
                    )
            );
        }
        rs.close();
        stmt.close();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}

