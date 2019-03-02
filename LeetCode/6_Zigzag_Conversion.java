Best Solution:
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int cycle = 2 * numRows - 2;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j + i < n; j += cycle) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycle - i < n) {
                    sb.append(s.charAt(j + cycle - i));
                }
            }
        }
        return sb.toString();
    }
}

Personal version:
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
