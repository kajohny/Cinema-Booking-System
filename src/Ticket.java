package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Ticket {
    private int ticketId;
    private Session session;
    private User user;
    private String paymentMethod;

    public Ticket() {
    }

    public Ticket(int ticketId, Session session, User user, String paymentMethod) {
        this.ticketId = ticketId;
        this.session = session;
        this.user = user;
        this.paymentMethod = paymentMethod;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void buyTicket(Ticket ticket) throws SQLException {
        String sql ="INSERT INTO tickets(ticket_id, session_id, user_id, payment_method) VALUES(?, ?, ?, ?)";
        Database db = new Database();
        Connection conn = db.getConn();
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, ticket.getTicketId());
        pstmt.setInt(2, session.getSessionId());
        pstmt.setInt(3, user.getUserId());
        pstmt.setString(4, ticket.getPaymentMethod());

        pstmt.executeUpdate();
        pstmt.close();
    }
}
