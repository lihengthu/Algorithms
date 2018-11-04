1. Memo Dp
class Solution {
    private Map<String, Long> posHopCnt = new HashMap<>();
    private Map<Integer, Integer[]> neighMap = new HashMap<>();
    private int mod = (int) (Math.pow(10, 9) + 7);

    public int knightDialer(int N) {
        neighMap.put(0, new Integer[]{4, 6});
        neighMap.put(1, new Integer[]{6, 8});
        neighMap.put(2, new Integer[]{7, 9});
        neighMap.put(3, new Integer[]{4, 8});
        neighMap.put(4, new Integer[]{3, 9, 0});
        neighMap.put(5, null);
        neighMap.put(6, new Integer[]{1, 7, 0});
        neighMap.put(7, new Integer[]{2, 6});
        neighMap.put(8, new Integer[]{1, 3});
        neighMap.put(9, new Integer[]{2, 4});

        long sum = 0;
        for (int i = 0; i <= 9; ++i) {
            sum = (sum + getDistinctCount(i, N - 1)) % mod;
        }
        return (int) sum;
    }

    private long getDistinctCount(int pos, int cnt) {
        if (cnt == 0) {
            return 1;
        }
        String key = pos + "_" + cnt;
        if (posHopCnt.containsKey(key)) {
            return posHopCnt.get(key) % mod;
        }
        long c = 0;
        if (neighMap.get(pos) != null) {
            for (Integer ne : neighMap.get(pos)) {
                c = (c + getDistinctCount(ne, cnt - 1)) % mod;
            }
            posHopCnt.put(key, c);
        }
        return c;
    }
}

2. 