Analysis:


Solutions:

1. 《剑指 Offer》答案
public class Solution {

    private int[] occurrence = new int[256];
    private int index = 0;

    public Solution() {
        for (int i = 0; i < 256; ++i)
            occurrence[i] = -1;
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (occurrence[ch] >= 0)
            occurrence[ch] = -2;
        else if (occurrence[ch] == -1)
            occurrence[ch] = index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; ++i) {
            if (occurrence[i] >= 0 && occurrence[i] < minIndex) {
                ch = (char) i;
                minIndex = occurrence[i];
            }
        }
        return ch;
    }
}

2. 牛客网 - 讨论区
public class Solution {
    private int[] cnt = new int[256];
    private Queue<Character> data = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        ++cnt[ch];
        if (cnt[ch] == 1)
            data.offer(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!data.isEmpty() && cnt[data.peek()] > 1) data.poll();
        if (data.isEmpty()) return '#';
        return data.peek();
    }
}