package quadratic_Lagrange_interpolation;

public class LagrangeInterpolation_Function {
    /**
     * 拉格朗日 2次 插值方法
     * @param x 已知点的x坐标数组
     * @param y 已知点的y坐标数组
     * @param value 要插值的x点
     * @return 插值后的y值
     */

    public static double interpolate(double[] x, double[] y, double value){
        // 第一个项
        double term1 = y[0] * ((value - x[1]) * (value - x[2])) / ((x[0] - x[1]) * (x[0] - x[2]));

        // 第二个项
        double term2 = y[1] * ((value - x[0]) * (value - x[2])) / ((x[1] - x[0]) * (x[1] - x[2]));

        // 第三个项
        double term3 = y[2] * ((value - x[0]) * (value - x[1])) / ((x[2] - x[0]) * (x[2] - x[1]));

        // 结果为三项相加
        return term1 + term2 + term3;
    }
}
