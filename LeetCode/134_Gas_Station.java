class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int index = -1, total = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }

        return total < 0 ? -1 : index + 1;
    }
}