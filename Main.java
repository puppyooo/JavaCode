import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //小红有n 个点，每个点的坐标为 (xi,yi)，小红可以从一个点出发，平行于坐标轴移动，直到到达另一个点。比如从 (1,1)出发，可以到达 (1,3),(5,1)，但无法直接到达(4,4)，如果需要到达(4,4)，需要增加一个点 (4,1)或者 (1,4)。
        //小红想知道，最少需要增加几个点，才能使得任意两个点之间可以互相到达。
        //输入描述:每行n个数用空格隔开。n(n <= 1000)，表示方阵阶数为n。接下来是n行的数字输入有多个测试用例，每个测试用例第一行为一个整数
        //n，表示方阵阶数，接下来n行，每行n个整数，表示方阵。
        //输出描述:输出一个整数表示答案。
        //示例1 输入 2 1 1 1 1 2 2 输出 1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[] x = new int[n];
        int[] y = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            x[i] = 0;
            y[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n) {
                arr[i][j] = sc.nextInt();
                x[i] += arr[i][j];
                y[j] += arr[i][j];
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (x[i] % 2 != 0) {
                count++;
            }
            if (y[i] % 2 != 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println(0);
        } else if (count == 2 || count == 4) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }
}