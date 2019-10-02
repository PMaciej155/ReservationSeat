package com.mpek.ReservationSeat.model;

import java.io.Serializable;

public enum ReservationType implements Serializable {
    ADULT(25),
    STUDENT(18),
    CHILD(12.5);
    double cost;

    ReservationType(double i) {
        this.cost = i;
    }

    public double getCost() {
        return this.cost;
    }
}
