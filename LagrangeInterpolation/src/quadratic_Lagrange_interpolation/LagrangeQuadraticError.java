package quadratic_Lagrange_interpolation;

public class LagrangeQuadraticError {

    /**
     * 计算拉格朗日二次插值的余项
     * @param x 已知点的 x 坐标数组
     * @param value 要插值的 x 值
     * @param thirdDerivative 三阶导数 f'''(ξ)
     * @return 插值余项 R(x)
     */
    public static double calculateError(double[] x, double value, double thirdDerivative) {
        // 计算余项公式 R(x) = f'''(ξ) * (x - x0)(x - x1)(x - x2) / 3!
        double error = thirdDerivative * (value - x[0]) * (value - x[1]) * (value - x[2]) / 6.0; // 3! = 6
        return error; // 返回余项
    }

    public static void main(String[] args) {
        // 示例：计算拉格朗日二次插值余项
        double[] x = {1.0, 2.0, 3.0}; // 三个已知点的 x 坐标
        double value = 2.5; // 要插值的 x 值
        double thirdDerivative = -0.5; // 假设已知的三阶导数

        double error = calculateError(x, value, thirdDerivative);
        System.out.println("在 x = " + value + " 处的插值余项 R(x) 为: " + error);
    }
}
