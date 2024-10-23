package newton_interpolation;

public class Newton_interpolation_Function {
    /**
     * 牛顿插值法计算插值结果
     * @param x 插值点的 x 坐标数组
     * @param y 插值点的 y 坐标数组
     * @param value 要插值的 x 点
     * @return 插值后的 y 值
     */
    public static double newtonInterpolate(double[] x, double[] y, double value) {
        int n = x.length;
        double[] dividedDifferences = new double[n];

        // 初始化差商表（第一列就是 y 值）
        for (int i = 0; i < n; i++) {
            dividedDifferences[i] = y[i];
        }

        // 计算差商表
        for (int j = 1; j < n; j++) {
            for (int i = n - 1; i >= j; i--) {
                dividedDifferences[i] = (dividedDifferences[i] - dividedDifferences[i - 1]) / (x[i] - x[i - j]);
            }
        }

        // 使用差商表计算插值多项式的值
        double result = dividedDifferences[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            result = dividedDifferences[i] + (value - x[i]) * result;
        }

        return result;
    }
}
