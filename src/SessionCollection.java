package com.company;

import java.sql.*;
import java.util.ArrayList;

public class SessionCollection {
    private ArrayList<Session> sessions = new ArrayList<>();
    private Cinema cinema = new Cinema();
    private Movie movie = new Movie();

    public SessionCollection(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    public SessionCollection() throws SQLException {
        Database db = new Database();
        Connection conn = db.getConn();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM sessions"); //get data about sessions
        while(rs.next()) {
            sessions.add(
                    new Session(
                            rs.getInt(1),
                            cinema,
                            rs.getString(4),
                            movie
                    )
            );
        }
        rs.close();
        stmt.close();
    }

    public SessionCollection(Cinema cinema) throws SQLException {
        Database db = new Database();
        Connection conn = db.getConn();
        String sql = "SELECT s.*,m.movie_id, m.movie_name, m.age_limit, m.description, m.movie_genre" +
                " FROM sessions as s LEFT JOIN movies as m ON s.movie_id = m.movie_id" +
                " WHERE s.cinema_id = ? ORDER BY s.time";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, cinema.getCinemaId());
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            sessions.add(
                    new Session(
                            rs.getInt(1),
                            cinema,
                            rs.getString(4),
                            new Movie(
                                    rs.getInt(5),
                                    rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8),
                                    rs.getString(9)
                            )
                    )
            );
        }
        rs.close();
        pstmt.close();
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public Session search(int sessionId) {
        for(Session session: this.sessions) {
            if(sessionId == session.getSessionId()) {
                return session;
            }
        }
        return null;
    }
}
