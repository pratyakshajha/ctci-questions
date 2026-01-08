package arrays;

import java.util.Arrays;

public class ArrayProblems {

    /**
     * CTCI 1.1: Is Unique: Implement an algorithm to determine if a string has all unique characters.
     * Time Complexity: O(n) where n is the length of the string.
     * Space Complexity: O(1) assuming a fixed character set (ASCII).
     */
    public boolean isUnique(String str) {
        boolean[] frequencyMap = new boolean[128]; // ASCII character set
        for (Character c: str.toCharArray()) {
            if (frequencyMap[c]) return false;
            else frequencyMap[c] = true;
        }
        return true;
    }

    // assume input is limited to lowercase 'a'-'z'
    public boolean isUniqueBitVector(String str) {
        // 32-bit integer used as a bitset (bit 0 = 'a', bit 1 = 'b', etc.)
        int checker = 0;

        for (char c : str.toCharArray()) {
            int val = c - 'a';

            // (1 << val) creates a mask with only the bit at the char's index set to 1
            // BITWISE AND: If result > 0, the bit was already set (char is a duplicate)
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            // BITWISE OR: Set the bit at the char's index to 1 to mark it as seen
            checker |= (1 << val);
        }

        return true;
    }

    public boolean isUniqueNoDs(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);

        for (int i = 0; i < charArr.length-1; i++) {
            if (charArr[i] == charArr[i+1]) return false;
        }
        return true;
    }
}