package linear_Lagrange_interpolation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 创建 Scanner 对象，用于从键盘获取输入
        Scanner scanner = new Scanner(System.in);

        // 默认两点插值
        int n = 2; // 两点插值，n固定为2

        // 初始化 x 和 y 数组
        double[] x = new double[n];
        double[] y = new double[n];

        // 提示用户输入两个数据点的 x 和 y 值
        System.out.println("请输入两个数据点的 x 和 y 值:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble(); // 输入 x 值
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble(); // 输入 y 值
        }

        // 提示用户输入需要插值的 x 值
        System.out.print("请输入要插值的 x 值: ");
        double value = scanner.nextDouble(); // 获取插值点

        // 调用拉格朗日插值函数
        double result = LagrangeInterpolation_Function.interpolate(x, y, value);
//      double result = LagrangeInterpolation_Function_Simple.interpolate(x, y, value);

        // 输出插值结果
        System.out.println("在 x = " + value + " 处插值的 y 值为: " + result);


//        // 提示用户输入在区间上的二阶导数 f''(xi)
//        System.out.print("请输入在区间上的二阶导数 f''(xi): ");
//        double secondDerivative = scanner.nextDouble(); // 输入二阶导数

//        // 调用余项计算函数
//        double error = LagrangeInterpolation_Function.calculateError(x, value, secondDerivative);
//
//        // 输出插值余项
//        System.out.println("插值的余项为: " + error);

        // 关闭扫描器
        scanner.close();
    }
}
