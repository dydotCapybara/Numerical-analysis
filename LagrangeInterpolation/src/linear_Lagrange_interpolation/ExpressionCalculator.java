package linear_Lagrange_interpolation;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎使用科学计算器！");
        System.out.println("支持的操作： + - * / ^ sqrt()");
        System.out.println("输入 'exit' 退出程序。");

        while (true) {
            System.out.print("\n请输入数学表达式: ");
            String expression = scanner.nextLine();

            // 如果输入 'exit' 则退出
            if (expression.equalsIgnoreCase("exit")) {
                System.out.println("退出计算器。");
                break;
            }

            try {
                // 解析并计算表达式
                double result = evaluateExpression(expression.replaceAll("\\s", ""));
                System.out.println("结果: " + result);
            } catch (Exception e) {
                System.out.println("表达式有误，请检查后重试。");
            }
        }

        scanner.close();
    }

    /**
     * 计算数学表达式
     * @param expression 输入的数学表达式
     * @return 计算结果
     */
    public static double evaluateExpression(String expression) {
        // 将表达式转换为后缀表达式（逆波兰表示法）
        String postfix = infixToPostfix(expression);
        // 使用后缀表达式计算结果
        return evaluatePostfix(postfix);
    }

    /**
     * 将中缀表达式转换为后缀表达式（逆波兰表示法）
     * @param expression 输入的中缀表达式
     * @return 后缀表达式
     */
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();

        String number = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                number += c; // 收集数字（包括小数点）
            } else if (c == 'x') {
                result.append("x").append(" ");
            } else {
                if (!number.isEmpty()) {
                    result.append(number).append(" ");
                    number = "";
                }

                if (c == '(') {
                    stack.push(String.valueOf(c));
                } else if (c == ')') {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.pop(); // 弹出 '('
                    if (!stack.isEmpty() && stack.peek().equals("sqrt")) {
                        result.append(stack.pop()).append(" ");
                    }
                } else if (c == 's' && i + 4 < expression.length() && expression.substring(i, i + 4).equals("sqrt")) {
                    stack.push("sqrt");
                    i += 3; // 跳过 'sqrt'
                } else {
                    while (!stack.isEmpty() && precedence(String.valueOf(c)) <= precedence(stack.peek())) {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.push(String.valueOf(c));
                }
            }
        }

        if (!number.isEmpty()) {
            result.append(number).append(" ");
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString();
    }

    /**
     * 计算后缀表达式
     * @param postfix 后缀表达式
     * @return 计算结果
     */
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (token.equals("sqrt")) {
                double num = stack.pop();
                stack.push(Math.sqrt(num));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    case "^":
                        stack.push(Math.pow(a, b));
                        break;
                }
            }
        }

        return stack.pop();
    }

    /**
     * 判断字符串是否为数字
     * @param str 字符串
     * @return true 如果是数字
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 返回操作符的优先级
     * @param operator 操作符
     * @return 优先级（数值越高，优先级越高）
     */
    public static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }
}
