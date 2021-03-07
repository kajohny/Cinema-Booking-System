package com.company;

public class Cinema {
    private int cinemaId;
    private String cinemaName;
    private String address;

    public int getCinemaId() {
        return cinemaId;
    }

    public Cinema() {}

    public Cinema(int cinemaId, String cinemaName, String address) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.cinemaId + ". " +  "Cinema name: " + this.cinemaName +
                "\n" + "\t" + "The address: " + this.address + "\n" +
                "-----------------------------";
    }
}
