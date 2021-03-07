package com.company;

import org.postgresql.util.PSQLException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App { //my application
    private User user;

    public App(User user) {
        this.user = user;
    }

    public void cinemas() throws SQLException { //cinemas() method searches all cinemas
        int cinemaId;
        Scanner scan = new Scanner(System.in);

        CinemaCollection cc = new CinemaCollection();
        for(Cinema cinema: cc.getCinemas()) {
            System.out.println(cinema.toString());
        }
        System.out.println("Choose the cinema: ");
        try {
            cinemaId = scan.nextInt();
            if(cc.search(cinemaId) != null) {
                sessions(cc.search(cinemaId));
            } else {
                System.out.println("There is no cinema with such ID. Try again");
                cinemas();
            }
        } catch(InputMismatchException ex) {
            System.out.println("You need to enter an ID! Try again.");
            cinemas();
        }
    }

    public void sessions(Cinema cinema) throws SQLException {
        SessionCollection se = new SessionCollection(cinema);
        for(Session session: se.getSessions()) {
            System.out.println(session);
        }
    }

    public void searchSessions() throws SQLException {
        int sessionId;
        Scanner scan = new Scanner(System.in);
        SessionCollection se = new SessionCollection();
        System.out.println("Choose the session: ");
        sessionId = scan.nextInt();
        Session session = new Session(sessionId);
        if(se.search(sessionId) != null) {
            movies(se.search(sessionId));
            System.out.println("---------------------------");
            System.out.println("1. Buy Ticket");
            System.out.println("2. More information");
            System.out.println("---------------------------");
            int num = scan.nextInt();
            if(num == 1) {
                try {
                    System.out.println("Enter the ticket ID you want to buy: ");
                    int ticketId = scan.nextInt();
                    System.out.println("Choose the payment method: 1-CARD; 2-CASH");
                    num = scan.nextInt();
                    String ticketType;
                    if(num == 1) {
                        System.out.println("Enter your card number: ");
                        num = scan.nextInt();
                        ticketType = "Card";
                        Ticket ticket = new Ticket(ticketId, session, user, ticketType);
                        ticket.buyTicket(ticket);
                        System.out.println("The payment was completed successfully. Thanks for using our system!");
                    } else if(num == 2) {
                        ticketType = "Cash";
                        Ticket ticket = new Ticket(ticketId, session, user, ticketType);
                        ticket.buyTicket(ticket);
                        System.out.println("The payment was completed successfully. Thanks for using our system!");
                    }
                    //throws the message if user wants to buy ticket which is already bought
                } catch(PSQLException ex) {
                    System.out.println("This ticket is already reserved! Choose another one: ");
                    searchSessions();
                }
            } else if(num == 2) {
                MovieCollection me = new MovieCollection(session);
                for(Movie movie: me.getMovies()) {
                    System.out.println(movie.toString());
            }
        } else {
            System.out.println("There is no session with such ID. Try again");
            }
        }
    }

    public void movies(Session session) throws SQLException {
        MovieCollection me = new MovieCollection(session);
        for(Movie movie: me.getMovies()) {
            System.out.println(session);
        }
    }
}
