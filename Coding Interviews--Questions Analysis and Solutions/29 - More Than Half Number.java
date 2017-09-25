Analysis:


Solutions:
1. Offer 思路二
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int target = array[0], cnt = 1;
        for (int i = 1; i < array.length; ++i){
            if (array[i] == target)
                ++cnt;
            else --cnt;
            if (cnt == 0){
                target = array[i];
                cnt = 1;
            }
        }
        if (cnt >= 1 && validate(array,target))
            return target;
        else return 0;
    }
    
    private boolean validate(int[] array, int target){
        int cnt = 0;
        for (int i = 0; i < array.length; ++i){
            if (array[i] == target){
                ++cnt;
            }
        }
        if (cnt > array.length / 2)
            return true;
        return false;
    }
}
2. 交换
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> resutls = new ArrayList<>();
        if (str != null && str.length() != 0) {
            char[] strs = str.toCharArray();
            collect(strs, 0, resutls);
        }
        Collections.sort(resutls);
        return resutls;
    }

    private void collect(char[] strs, int start, ArrayList<String> resutls) {
        if (start == strs.length - 1) {
            resutls.add(String.valueOf(strs));
            return;
        }
        for (int i = start; i < strs.length; ++i) {
            if (strs[i] != strs[start] || i == start) {
                swap(strs, i, start);
                collect(strs, start + 1, resutls);
                swap(strs, start, i);
            } else continue;

        }
    }

    private void swap(char[] strs, int i, int j) {
        char tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}