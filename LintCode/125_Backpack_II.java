public class Solution {
    public int backPackII(int m, int[] A, int[] V) {
        int[] f = new int[m + 1];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
            }
        }
        return f[m];
    }
}