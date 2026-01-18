package com.gsa.gps.model;

public class ReceiverState {
    public double x;
    public double y;
    public double z;
    public double clockBias; // meters

    @Override
    public String toString() {
        return String.format(
                "ReceiverState{x=%.3f, y=%.3f, z=%.3f, clockBias=%.6f m}",
                x, y, z, clockBias
        );
    }
}

