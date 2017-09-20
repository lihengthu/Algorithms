Analysis:


Solutions:
1. 
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> results = new ArrayList<>();
        if (str == null || str.length() == 0) return results;
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        dfs(arr, used, new ArrayList<>(), results);
        return results;
    }

    private void dfs(char[] arr,
                     boolean[] used,
                     ArrayList<Character> list,
                     ArrayList<String> results) {
        if (list.size() == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : list)
                sb.append(c);
            results.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; ++i) {
            if (used[i]) continue;
            if (i > 0 && arr[i - 1] == arr[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(arr[i]);
            dfs(arr, used, list, results);
            used[i] = false;
            list.remove(list.size() - 1);
        }
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