class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] tmpInterval = intervals[0];
        result.add(tmpInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= tmpInterval[1]) {
                tmpInterval[1] = Math.max(tmpInterval[1], interval[1]);
            } else {
                tmpInterval = interval;
                result.add(tmpInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}