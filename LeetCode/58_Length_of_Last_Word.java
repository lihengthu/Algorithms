1. Not recommended
class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }
}

2. Do not use standard library
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = 0, tail = chars.length - 1;
        while (tail >= 0 && chars[tail] == ' '){
            --tail;
        }
        while (tail >= 0 && chars[tail] != ' '){
            ++length;
            --tail;
        }
        return length;
    }
}