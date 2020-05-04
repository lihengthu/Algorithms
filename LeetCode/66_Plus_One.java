class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry > 0; i--){
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 0){
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++){
            result[i] = digits[i - 1];
        }
        return result;
    }
}