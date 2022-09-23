import java.util.ArrayList;
import java.util.Scanner;

public class 面试题目 {


    public static void main(String[] args) throws Exception {
        System.out.println("请输入数字: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("请输入数量: ");
        int n = sc.nextInt();
        getResult(a, n);
    }

    static void getResult(int a, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(getNumber(a, i));
        }

        //以下是打印输出
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print("+");
            }
            sum += list.get(i);
        }
        System.out.print("=");
        System.out.println(sum);

    }

    static int getNumber(int a, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result * 10 + a;
        }
        return result;
    }
}
