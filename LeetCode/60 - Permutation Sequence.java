Analysis: 
    1. 理解题意

Solutions:

1. Discuss
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; ++i) {
            nums.add(i);
            fact *= i;
        }
        --k;
        for (int i = 0; i < n; ++i) {
            fact /= (n - i);
            int index = k / fact;
            sb.append(nums.remove(index));
            k -= index * fact;
        }
        return sb.toString();
    }
}