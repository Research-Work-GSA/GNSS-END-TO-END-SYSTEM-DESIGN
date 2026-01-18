package com.gsa.gps;

import com.gsa.gps.core.GnssPositionSolver;
import com.gsa.gps.model.ReceiverState;
import com.gsa.gps.model.Satellite;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Satellite> satellites = List.of(
                new Satellite(15_600_000, 7_540_000, 20_140_000, 21_204_000),
                new Satellite(18_760_000, 2_750_000, 18_610_000, 21_640_000),
                new Satellite(17_610_000, 14_630_000, 13_480_000, 23_050_000),
                new Satellite(19_170_000, 610_000, 18_390_000, 21_700_000)
        );

        ReceiverState result = GnssPositionSolver.solve(satellites);

        System.out.println(result);
    }
}

