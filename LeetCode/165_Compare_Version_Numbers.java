class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }

        String[] ver1Arr = version1.split("\\.");
        String[] ver2Arr = version2.split("\\.");
        int index = 0;
        int n1 = ver1Arr.length, n2 = ver2Arr.length;
        while (index < n1 || index < n2) {
            Integer v1 = index < n1 ? Integer.valueOf(ver1Arr[index]) : 0;
            Integer v2 = index < n2 ? Integer.valueOf(ver2Arr[index]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
            index++;
        }

        return 0;
    }
}
