package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
    private int sessionId;
    private Cinema cinema;
    private Date time = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String stringDate = DateFor.format(time);
    private Movie movie;


    public Session(int sessionId) {
        this.sessionId = sessionId;
    }

    public Session(int sessionId, Cinema cinema, String stringDate, Movie movie) {
        this.sessionId = sessionId;
        this.cinema = cinema;
        this.stringDate = stringDate;
        this.movie = movie;
    }

    public int getSessionId() {
        return sessionId;
    }

    @Override
    public String toString() {
        return "ID: " + this.sessionId + "\n" +
                "Title: " + movie.getMovieName() + "\n" + "Datetime: " + this.stringDate + "\n" +
                "--------------------------------------------";
    }
}
