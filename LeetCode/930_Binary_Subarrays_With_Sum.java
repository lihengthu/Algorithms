1. Discussioin
public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> c = new HashMap<>();
        c.put(0, 1);
        int psum = 0, res = 0;
        for (int i : A) {
            psum += i;
            res += c.getOrDefault(psum - S, 0);
            c.put(psum, c.getOrDefault(psum, 0)+1);
        }
        return res;
    }
2. Like in Problem 560 O(n^2), O(n)
public int numSubarraysWithSum(int[] A, int S) {
        int count = 0;
        int[] sum = new int[A.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= A.length; i++)
            sum[i] = sum[i - 1] + A[i - 1];
        for (int start = 0; start < A.length; start++) {
            for (int end = start + 1; end <= A.length; end++) {
                if (sum[end] - sum[start] == S)
                    count++;
            }
        }
        return count;
    }