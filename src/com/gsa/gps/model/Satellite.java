package com.gsa.gps.model;

public class Satellite {
    public final double x;
    public final double y;
    public final double z;
    public final double pseudorange;

    public Satellite(double x, double y, double z, double pseudorange) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pseudorange = pseudorange;
    }
}