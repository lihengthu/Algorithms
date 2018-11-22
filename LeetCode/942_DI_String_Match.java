1. 
class Solution {
    public int[] diStringMatch(String S) {
        int[] arr = new int[S.length() + 1];
        int left = 0, right = S.length();
        for (int i = 0; i < S.length(); ++i) {
            arr[i] = S.charAt(i) == 'I' ? left++ : right--;
        }
        arr[S.length()] = left;
        return arr;
    }
}