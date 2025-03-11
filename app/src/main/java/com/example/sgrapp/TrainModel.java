package com.example.sgrapp;

public class TrainModel {
    private String trainName;
    private String schedule;

    public TrainModel(String trainName, String schedule) {
        this.trainName = trainName;
        this.schedule = schedule;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSchedule() {
        return schedule;
    }
}
