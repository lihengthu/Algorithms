// 1.
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getSquare(n);
        }

        return true;
    }

    public int getSquare(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }

        return result;
    }
}

// 2.
class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = getSquare(n);
        while (slow != fast) {
            slow = getSquare(slow);
            fast = getSquare(fast);
            fast = getSquare(fast);
            if (fast == 1) {
                return true;
            }
        }

        return slow == 1;
    }

    public int getSquare(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }

        return result;
    }
}
