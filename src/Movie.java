package com.company;

public class Movie {
    private int movieId;
    private String movieName;
    private String ageLimit;
    private String description;
    private String movieGenre;

    public Movie(int movieId, String movieName, String ageLimit, String description, String movieGenre) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.ageLimit = ageLimit;
        this.description = description;
        this.movieGenre = movieGenre;
    }

    public Movie() {
        int movieId;
        String movieName;
        String ageLimit;
        String description;
        String movieGenre;
    }

    public String getDescription() {
        return description;
    }

    public String getMovieName() {
        return movieName;
    }
    public String getMovieGenre() {
        return movieGenre;
    }
    public int getMovieId() {
        return movieId;
    }

    public String toString() {
        return "Title: " + this.movieName +
                "\n" + "Genre: " + this.movieGenre +
                "\n" + "Description: " + this.description +
                "\n" + "Age limit: " + this.ageLimit + " and above" + "\n" +
                "--------------------------------------------";
    }
}
