Analysis:


Solutions:
1. // 自己写的 -- 时间复杂度：O(n), 空间复杂度：O(n)
public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) return;
        int[] copy = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; ++i){
            if (array[i] % 2 == 1)
                copy[index++] = array[i];
        }
        for (int i = 0; i < array.length; ++i){
            if (array[i] % 2 == 0)
                copy[index++] = array[i];
        }
        for (int i = 0; i < array.length; ++i)
            array[i] = copy[i];
    }
}

2. // Discuss (1) isEven 考虑可扩展性；（2）容易忽略的点，if-else block, 能写出bug-free代码需要功底；
public class Solution {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;
        int i = 0, j;
        while ( i < array.length) {
            while (i < array.length && !isEven(array[i])) ++i;
            j = i + 1;
            while (j < array.length && isEven(array[j])) ++j;
            if (j < array.length) {
                int tmp = array[j];
                for (int k = j - 1; k >= i; --k)
                    array[k + 1] = array[k];
                array[i++] = tmp;
            } else break;
        }
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }
}