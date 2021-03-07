package com.company;

public class Cinema {
    private int cinemaId;
    private String cinemaName;
    private String address;
    private int seatsNumber;

    public int getCinemaId() {
        return cinemaId;
    }

    public Cinema() {}

    public Cinema(int cinemaId, String cinemaName, String address, int seatsNumber) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
        this.seatsNumber = seatsNumber;
    }

    @Override
    public String toString() {
        return this.cinemaId + ". " +  "Cinema name: " + this.cinemaName +
                "\n" + "\t" + "The address: " + this.address + "\n" +
                "-----------------------------";
    }
}
