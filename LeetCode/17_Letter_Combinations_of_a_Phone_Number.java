
Solutions: 

1. Personal
class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        buildString(map, digits, 0, sb, result);
        return result;
    }

    private void buildString(Map<Character, String> map, String digits, int index, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            buildString(map, digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

2. BFS
https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); ++i) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String t = result.remove();
                for (char s : map[x].toCharArray()) {
                    result.add(t + s);
                }
            }
        }
        return result;
    }
}