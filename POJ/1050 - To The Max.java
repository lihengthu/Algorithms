Analysis: 
    1. 

Solutions:

1. http://blog.csdn.net/hitwhylz/article/details/11848439
public class Main {

    private static final int MAXSIZE = 101;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[MAXSIZE][MAXSIZE];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }
        int max = maxMatrix(arr,n);
        System.out.println(max);
    }

    public static int maxArray(int[] nums, int n) {
        int curSum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (curSum <= 0)
                curSum = nums[i];
            else curSum += nums[i];
            if (curSum > max)
                max = curSum;
        }
        return max;
    }

    // 最大子矩阵和
    public static int maxMatrix(int[][] arr, int n) {
        int max = arr[1][1];
        int sum, i, j, k;
        int[] tempArr = new int[MAXSIZE];
        for (i = 1; i <= n; ++i) {
            for (j = 1; j <= n; ++j)
                tempArr[j] = 0;
            for (j = i; j <= n; ++j) {
                for (k = 1; k <= n; ++k)
                    tempArr[k] += arr[j][k];
                sum = maxArray(tempArr, n);
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
}