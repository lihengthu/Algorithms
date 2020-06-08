// 1. 递归版本
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++) {
                result.add(i);
            }
            return result;
        }
        result = grayCode(n - 1);
        List<Integer> rev = reverse(result);
        int x = 1 << (n - 1);
        for (int i = 0; i < rev.size(); i++) {
            rev.set(i, rev.get(i) + x);
        }
        result.addAll(rev);
        return result;
    }

    private List<Integer> reverse(List<Integer> list) {
        List<Integer> rev = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            rev.add(list.get(i));
        }
        return rev;
    }

}

// 2. 迭代版本
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) | (1 << i));
            }
        }
        return result;
    }
}

// 3. 计组版本
// 一个数字对应的格雷编码的计算方式是:
// 将其二进制第一位(从高位数)与0异或, 得到的结果为格雷码的第一位
// 之后依次将原数的第i位与生成的格雷码第i-1位做异或运算, 即可得到格雷码的第i位.
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}