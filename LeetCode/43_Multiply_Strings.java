class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        int len1 = num1.length(), len2 = num2.length();
        int len = len1 + len2;
        int i, j, product, carry;
        int[] result = new int[len];
        for (i = len1 - 1; i >= 0; --i) {
            carry = 0;
            for (j = len2 - 1; j >= 0; --j) {
                product = carry + result[i + j + 1] +
                        Character.getNumericValue(num1.charAt(i)) *
                                Character.getNumericValue(num2.charAt(j));
                result[i + j + 1] = product % 10;
                carry = product / 10;
            }
            // 此时出了内层for循环，j == -1，等价于把carry保存在了原先(i + j + 1)的上一位
            result[i + j + 1] = carry;
        }
        StringBuilder sb = new StringBuilder();
        i = 0;
        // corner case，num1/num2等于 “0”
        while (i < len - 1 && result[i] == 0) {
            ++i;
        }
        while (i < len) {
            sb.append(result[i++]);
        }
        return sb.toString();
    }
}