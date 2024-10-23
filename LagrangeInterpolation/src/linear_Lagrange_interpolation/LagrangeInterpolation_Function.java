package linear_Lagrange_interpolation;

public class LagrangeInterpolation_Function {

    /**
     * 拉格朗日 1次 插值方法
     * @param x 已知点的x坐标数组
     * @param y 已知点的y坐标数组
     * @param value 要插值的x点
     * @return 插值后的y值
     */
    public static double interpolate(double[] x, double[] y, double value) {
        double result = 0.0; // 用于存储最后的插值结果
        int n = x.length; // 数据点的数量,即数组x的长度

        // 遍历每个已知点，计算插值多项式
        for (int i = 0; i < n; i++) {
            double term = y[i]; // 从y[i]开始计算拉格朗日基函数
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    // 计算拉格朗日基函数的乘积部分
                    term = term * (value - x[j]) / (x[i] - x[j]);
                }
            }
            result += term; // 将每一项的结果相加到result中
        }

        return result; // 返回插值结果
    }



    /**
     * 计算拉格朗日插值的余项
     * @param x 已知点的x坐标数组
     * @param value 要插值的x点
     * @param secondDerivative 二阶导数 f''(xi)
     * @return 插值余项 R(x)
     */
//    public static double calculateError(double[] x, double value, double secondDerivative) {
//        // 假设只处理两点插值
//        double x0 = x[0];
//        double x1 = x[1];
//
//        // 计算拉格朗日插值余项 R(x) = f''(xi) * (x - x0)(x - x1) / 2!
//        double error = secondDerivative * (value - x0) * (value - x1) / 2.0;
//
//        return error; // 返回余项结果
//    }
}
