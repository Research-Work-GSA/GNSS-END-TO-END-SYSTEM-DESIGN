package com.gsa.gps.core;

import com.gsa.gps.model.ReceiverState;
import com.gsa.gps.model.Satellite;

import java.util.List;

public class GnssPositionSolver {

    public static ReceiverState solve(List<Satellite> satellites) {

        ReceiverState state = new ReceiverState();
        state.x = 0;
        state.y = 0;
        state.z = 0;
        state.clockBias = 0;

        int maxIterations = 10;
        double threshold = 1e-3;

        for (int iter = 0; iter < maxIterations; iter++) {

            double[][] J = new double[satellites.size()][4];
            double[] r = new double[satellites.size()];

            for (int i = 0; i < satellites.size(); i++) {
                Satellite sat = satellites.get(i);

                double dx = state.x - sat.x;
                double dy = state.y - sat.y;
                double dz = state.z - sat.z;

                double range = Math.sqrt(dx*dx + dy*dy + dz*dz);
                double predicted = range + state.clockBias;

                r[i] = sat.pseudorange - predicted;

                J[i][0] = dx / range;
                J[i][1] = dy / range;
                J[i][2] = dz / range;
                J[i][3] = 1.0;
            }

            double[] delta = LeastSquaresSolver.solve(J, r);

            state.x += delta[0];
            state.y += delta[1];
            state.z += delta[2];
            state.clockBias += delta[3];

            double norm = Math.sqrt(
                    delta[0]*delta[0] +
                            delta[1]*delta[1] +
                            delta[2]*delta[2]
            );

            if (norm < threshold) break;
        }

        return state;
    }
}

