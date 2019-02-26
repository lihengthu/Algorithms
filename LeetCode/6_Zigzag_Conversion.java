Personal:

1st version:
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < s.length(); ++j) {
                if (j % (2 * numRows - 2) == i || j % (2 * numRows - 2) == (2 * numRows - 2 - i)) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
