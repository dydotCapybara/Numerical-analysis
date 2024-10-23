package newton_interpolation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入插值点的数量
        System.out.print("请输入插值点的数量: ");
        int n = scanner.nextInt();  // 插值点数量

        // 初始化 x 和 y 数组
        double[] x = new double[n];
        double[] y = new double[n];

        // 提示用户输入每个插值点的 x 和 y 值
        System.out.println("请输入每个插值点的 x 和 y 值:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }

        // 提示用户输入需要插值的 x 值
        System.out.print("请输入要插值的 x 值: ");
        double value = scanner.nextDouble();

        // 调用牛顿插值函数，计算插值结果
        double result = Newton_interpolation_Function.newtonInterpolate(x, y, value);

        // 输出插值结果
        System.out.println("在 x = " + value + " 处插值的 y 值为: " + result);

        // 关闭扫描器
        scanner.close();
    }
}
