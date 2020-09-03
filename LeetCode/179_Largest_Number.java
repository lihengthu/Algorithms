// 1.
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        if (strArr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}

// 2.
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String result = String.join("", Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((b, a) -> (a + b).compareTo(b + a))
                .toArray(String[]::new));

        return result.charAt(0) == '0' ? "0" : result;
    }
}
