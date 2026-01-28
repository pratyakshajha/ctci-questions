package arrays;

import java.util.Arrays;

public class ArrayProblems {

    /**
     * CTCI 1.1: Is Unique: Implement an algorithm to determine if a string has all unique characters.
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

    /**
     * CTCI 1.2: Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
     */
    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] s1Map = new int[128]; // ASCII
        int[] s2Map = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            s2Map[s2.charAt(i)]++;
        }
        for (int i = 0; i < s1Map.length; i++) {
            if (s1Map[i] != s2Map[i]) return false;
        }
        return true;
    }

    /**
     * CTCI 1.3: URLify: Write a method to replace all spaces in a string with '%20'.
     * You may assume that the string has sufficient space at the end to hold the additional
     * characters, and that you are given the "true" length of the string.
     */
    public void urlify(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') spaceCount++;
        }
        int idx = trueLength + spaceCount*2;
        for (int i=trueLength-1; i>=0; i--) {
            if (str[i] == ' ') {
                str[idx-1] = '0';
                str[idx-2] = '2';
                str[idx-3] = '%';
                idx -= 3;
            } else {
                str[idx-1] = str[i];
                idx--;
            }
        }
    }
}