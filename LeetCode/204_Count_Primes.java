// 类似100盏灯按倍数开关灯剩余的亮灯数目--约数个数奇偶问题

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                result++;
            }
        }

        return result;
    }
}