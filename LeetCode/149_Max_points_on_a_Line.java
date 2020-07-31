class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }
        int result = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slope = new HashMap<>();
            int max = 0, overlap = 0, vertical = 0;

            for (int j = i + 1; j < n; j++) {
                if (points[i][0] == points[j][0]) {
                    if (points[i][1] == points[j][1]) {
                        overlap++;
                    } else {
                        vertical++;
                    }
                    continue;
                }
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int temp = gcd(dx, dy);
                dx /= temp;
                dy /= temp;
                String key = dy + "/" + dx;
                if (!slope.containsKey(key)) {
                    slope.put(key, 0);
                }
                slope.put(key, slope.get(key) + 1);
                max = Math.max(max, slope.get(key));
            }
            max = Math.max(max, vertical);
            result = Math.max(result, max + overlap + 1);
        }

        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
