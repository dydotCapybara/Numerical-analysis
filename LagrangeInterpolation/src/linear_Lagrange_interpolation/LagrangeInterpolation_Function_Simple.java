package linear_Lagrange_interpolation;

public class LagrangeInterpolation_Function_Simple {
    public static double interpolate(double[] x, double[] y, double value) {

        double term1 = y[0] * (value - x[1])/(x[0] - x[1]);
        double term2 = y[1] * (value - x[0])/(x[1] - x[0]);
        return term1 + term2;
    }
}
