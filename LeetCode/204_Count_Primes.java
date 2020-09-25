class Solution {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean[] notPrime = new boolean[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                result++;
            }
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }

        return result;
    }
}
