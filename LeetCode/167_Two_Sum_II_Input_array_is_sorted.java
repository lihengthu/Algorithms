class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
