package com.example.booking.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Service")
public class Book {

    private String trainName;
    private String fare;
    private String from;

    public Book(String trainName, String fare, String from, String to, String depart, String back, String seats, String travelClass) {
        this.trainName = trainName;
        this.fare = fare;
        this.from = from;
        this.to = to;
        this.depart = depart;
        this.back = back;
        this.seats = seats;
        this.travelClass = travelClass;
    }

    private String to;
    private String depart;

    @Override
    public String toString() {
        return "Book{" +
                "trainName='" + trainName + '\'' + ", emailId='" + fare + '\'' + ", from='" + from + '\'' +
                ", to='" + to + '\'' + ", depart='" + depart + '\'' + ", back='" + back + '\'' +
                ", seats='" + seats + '\'' + ", travelClass='" + travelClass + '\'' + '}';
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    private String back;
    private String seats;
    private String travelClass;

}