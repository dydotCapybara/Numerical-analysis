package quadratic_Lagrange_interpolation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 默认插值点的数量为3，二次插值
        int n = 3;

        // 初始化 x 和 y 数组
        double[] x = new double[n];
        double[] y = new double[n];

        // 提示用户输入三个数据点的 x 和 y 值
        System.out.println("请输入三个数据点的 x 和 y 值:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble(); // 输入 x 值
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble(); // 输入 y 值
        }

        // 提示用户输入需要插值的 x 值
        System.out.print("请输入要插值的 x 值: ");
        double value = scanner.nextDouble(); // 获取插值点

        // 调用拉格朗日二次插值函数
        double result = LagrangeInterpolation_Function.interpolate(x, y, value);

        // 输出插值结果
        System.out.println("在 x = " + value + " 处插值的 y 值为: " + result);

        // 关闭扫描器
        scanner.close();
    }
}
