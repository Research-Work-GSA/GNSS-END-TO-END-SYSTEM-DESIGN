package com.gsa.gps.core;

public class LeastSquaresSolver {

    // Solves: delta = (JᵀJ)^-1 Jᵀ r
    public static double[] solve(double[][] J, double[] r) {

        int m = J.length;      // equations
        int n = J[0].length;   // unknowns (4)

        double[][] JT = transpose(J);
        double[][] JTJ = multiply(JT, J);
        double[] JTr = multiply(JT, r);
        double[][] inverse = invert4x4(JTJ);

        return multiply(inverse, JTr);
    }

    /* ---------------- Linear Algebra Utilities ---------------- */

    private static double[][] transpose(double[][] a) {
        double[][] t = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                t[j][i] = a[i][j];
        return t;
    }

    private static double[][] multiply(double[][] a, double[][] b) {
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < b.length; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    private static double[] multiply(double[][] a, double[] x) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < x.length; j++)
                result[i] += a[i][j] * x[j];
        return result;
    }

    /* --------- 4x4 Matrix Inversion (Gaussian Elimination) -------- */

    private static double[][] invert4x4(double[][] m) {
        int n = 4;
        double[][] a = new double[n][2 * n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(m[i], 0, a[i], 0, n);
            a[i][i + n] = 1.0;
        }

        for (int i = 0; i < n; i++) {
            double pivot = a[i][i];
            for (int j = 0; j < 2 * n; j++)
                a[i][j] /= pivot;

            for (int k = 0; k < n; k++) {
                if (k == i) continue;
                double factor = a[k][i];
                for (int j = 0; j < 2 * n; j++)
                    a[k][j] -= factor * a[i][j];
            }
        }

        double[][] inv = new double[n][n];
        for (int i = 0; i < n; i++)
            System.arraycopy(a[i], n, inv[i], 0, n);

        return inv;
    }
}
