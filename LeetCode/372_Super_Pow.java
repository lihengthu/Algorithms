// (a * b) % k = ((a % k) * (b * k)) % k

class Solution {
    private int base = 1337;

    public int superPow(int a, int[] b) {
        a = a % base;
        int r = 1;
        for (int i = 0; i < b.length; i++) {
            r = pow10(r) * pow(a, b[i]) % base;
        }
        return r;
    }

    private int pow10(int n) {
        int origN = n;
        for (int i = 0; i < 3; i++) {
            n = (n * n) % base;
        }
        int pow2 = origN * origN % base;
        return pow2 * n % base;
    }

    private int pow(int n, int p) {
        int r = 1;
        for (int i = 0; i < p; i++) {
            r = r * n % base;
        }

        return r;
    }

}