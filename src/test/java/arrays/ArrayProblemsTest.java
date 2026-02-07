package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProblemsTest {

    @Test
    void isUniqueTests() {
        ArrayProblems problems = new ArrayProblems();

        // Test cases for unique strings
        assertTrue(problems.isUnique("abcdefg"));
        assertTrue(problems.isUnique("abcdeFg"));
        assertTrue(problems.isUnique("12345"));
        assertTrue(problems.isUnique("")); // Empty string is unique

        // Test cases for strings with duplicate characters
        assertFalse(problems.isUnique("hello"));
        assertFalse(problems.isUnique("apple"));
        assertFalse(problems.isUnique("programming"));
        assertFalse(problems.isUnique("aa"));
        assertFalse(problems.isUnique("abacaba"));

        // Test with special characters and spaces
        assertTrue(problems.isUnique("ab c"));
        assertFalse(problems.isUnique("a b c a"));
    }

    @Test
    void isPermutation() {
        ArrayProblems problems = new ArrayProblems();

        // Test cases for permutations
        assertTrue(problems.isPermutation("listen", "silent"));
        assertTrue(problems.isPermutation("triangle", "integral"));
        assertTrue(problems.isPermutation("aabb", "bbaa"));
        assertTrue(problems.isPermutation("abc", "bca"));
        assertTrue(problems.isPermutation("", "")); // Two empty strings are permutations

        // Test cases for non-permutations (different lengths)
        assertFalse(problems.isPermutation("hello", "helo"));
        assertFalse(problems.isPermutation("abc", "abcd"));

        // Test cases for non-permutations (same length, different characters)
        assertFalse(problems.isPermutation("abc", "abd"));
        assertFalse(problems.isPermutation("aabbc", "aabbd"));

        // Test cases with different character counts
        assertFalse(problems.isPermutation("aabb", "aaab"));
        assertFalse(problems.isPermutation("aabbc", "abcde"));

        // Test cases with spaces and special characters
        assertTrue(problems.isPermutation("a b c", "b c a"));
        assertFalse(problems.isPermutation("a b c", "a  b c")); // Extra space
        assertTrue(problems.isPermutation("123!@", "@!321"));

        // Test cases with case sensitivity (assuming case-sensitive permutation)
        assertFalse(problems.isPermutation("God", "dog"));
        assertTrue(problems.isPermutation("GoD", "DoG")); // Assuming ASCII comparison
    }

    @Test
    void urlify() {
        ArrayProblems problems = new ArrayProblems();

        // Test Case 1: Standard case with spaces
        char[] str1 = "Mr John Smith    ".toCharArray();
        problems.urlify(str1, 13);
        assertEquals("Mr%20John%20Smith", new String(str1).trim());

        // Test Case 2: No spaces
        char[] str2 = "Hello".toCharArray();
        problems.urlify(str2, 5);
        assertEquals("Hello", new String(str2));

        // Test Case 3: Only spaces
        char[] str3 = "      ".toCharArray();
        problems.urlify(str3, 2);
        assertEquals("%20%20", new String(str3));

        // Test Case 4: Spaces at the beginning and end
        char[] str4 = " a b       ".toCharArray();
        problems.urlify(str4, 5);
        assertEquals("%20a%20b%20", new String(str4));

        // Test Case 5: Single character (space)
        char[] str5 = "   ".toCharArray();
        problems.urlify(str5, 1);
        assertEquals("%20", new String(str5));

        // Test Case 6: Multiple consecutive spaces
        char[] str6 = "a  b    ".toCharArray();
        problems.urlify(str6, 4);
        assertEquals("a%20%20b", new String(str6));
    }

    @Test
    void isPalindromePermutation() {
        ArrayProblems problems = new ArrayProblems();

        // Test cases for palindrome permutations
        assertTrue(problems.isPalindromePermutation("tact coa")); // "taco cat"
        assertTrue(problems.isPalindromePermutation("atco cta")); // "atco eta"
        assertTrue(problems.isPalindromePermutation("aabb"));
        assertTrue(problems.isPalindromePermutation("aaa"));
        assertTrue(problems.isPalindromePermutation("a"));
        assertTrue(problems.isPalindromePermutation(""));

        // Test cases for non-palindrome permutations
        assertFalse(problems.isPalindromePermutation("abcde"));
        assertFalse(problems.isPalindromePermutation("aabbcd"));
        assertFalse(problems.isPalindromePermutation("code"));

        // Test cases with spaces (assuming spaces are treated as characters)
        assertTrue(problems.isPalindromePermutation("taco cat"));
        assertFalse(problems.isPalindromePermutation("taco catz"));
    }

    @Test
    void oneAway() {
        ArrayProblems problems = new ArrayProblems();

        // Test cases for zero edits (same strings)
        assertTrue(problems.oneAway("pale", "pale"));
        assertTrue(problems.oneAway("", ""));

        // Test cases for one replacement
        assertTrue(problems.oneAway("pale", "bale"));
        assertTrue(problems.oneAway("abcde", "abfde"));

        // Test cases for one insertion
        assertTrue(problems.oneAway("pale", "pales"));
        assertTrue(problems.oneAway("ple", "pale"));

        // Test cases for one removal
        assertTrue(problems.oneAway("pale", "ple"));
        assertTrue(problems.oneAway("pales", "pale"));

        // Test cases for more than one edit
        assertFalse(problems.oneAway("pale", "bake")); // two replacements
        assertFalse(problems.oneAway("pale", "plee")); // one removal + one replacement
        assertFalse(problems.oneAway("pale", "palesy")); // two insertions
        assertFalse(problems.oneAway("pale", "pa")); // two removals

        // Test cases with different lengths
        assertFalse(problems.oneAway("pale", "palestine"));
        assertTrue(problems.oneAway("p", ""));
        assertTrue(problems.oneAway("", "p"));
    }

    @Test
    void stringCompression() {
        ArrayProblems problems = new ArrayProblems();

        // Test cases for compression
        assertEquals("a2b1c5a3", problems.stringCompression("aabcccccaaa"));
        assertEquals("a5", problems.stringCompression("aaaaa"));

        // Test cases where original string is returned (compressed is not smaller)
        assertEquals("abc", problems.stringCompression("abc"));
        assertEquals("aa", problems.stringCompression("aa"));
        assertEquals("", problems.stringCompression(""));
    }

    @Test
    void rotate() {
        ArrayProblems problems = new ArrayProblems();

        // Test Case 1: 3x3 matrix
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected1 = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        problems.rotate(matrix1);
        assertArrayEquals(expected1, matrix1);

        // Test Case 2: 4x4 matrix
        int[][] matrix2 = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] expected2 = {
                {13, 9,  5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };
        problems.rotate(matrix2);
        assertArrayEquals(expected2, matrix2);

        // Test Case 3: 1x1 matrix
        int[][] matrix3 = {{1}};
        int[][] expected3 = {{1}};
        problems.rotate(matrix3);
        assertArrayEquals(expected3, matrix3);

        // Test Case 4: 2x2 matrix
        int[][] matrix4 = {
                {1, 2},
                {3, 4}
        };
        int[][] expected4 = {
                {3, 1},
                {4, 2}
        };
        problems.rotate(matrix4);
        assertArrayEquals(expected4, matrix4);
    }

    @Test
    void zero() {
        ArrayProblems problems = new ArrayProblems();

        // Test Case 1: Matrix with one zero
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        int[][] expected1 = {
                {1, 0, 3},
                {0, 0, 0},
                {7, 0, 9}
        };
        problems.zero(matrix1);
        assertArrayEquals(expected1, matrix1);

        // Test Case 2: Matrix with multiple zeros
        int[][] matrix2 = {
                {1, 0, 3},
                {4, 5, 6},
                {0, 8, 9}
        };
        int[][] expected2 = {
                {0, 0, 0},
                {0, 0, 6},
                {0, 0, 0}
        };
        problems.zero(matrix2);
        assertArrayEquals(expected2, matrix2);

        // Test Case 3: Matrix with no zeros
        int[][] matrix3 = {
                {1, 2},
                {3, 4}
        };
        int[][] expected3 = {
                {1, 2},
                {3, 4}
        };
        problems.zero(matrix3);
        assertArrayEquals(expected3, matrix3);

        // Test Case 4: Matrix with all zeros
        int[][] matrix4 = {
                {0, 0},
                {0, 0}
        };
        int[][] expected4 = {
                {0, 0},
                {0, 0}
        };
        problems.zero(matrix4);
        assertArrayEquals(expected4, matrix4);

        // Test Case 5: Rectangular matrix (M != N)
        int[][] matrix5 = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] expected5 = {
                {1, 0, 3, 4},
                {0, 0, 0, 0},
                {9, 0, 11, 12}
        };
        problems.zero(matrix5);
        assertArrayEquals(expected5, matrix5);
    }

    @Test
    void isRotation() {
        ArrayProblems problems = new ArrayProblems();

        // Test cases for rotations
        assertTrue(problems.isRotation("waterbottle", "erbottlewat"));
        assertTrue(problems.isRotation("abcde", "cdeab"));
        assertTrue(problems.isRotation("a", "a"));
        assertTrue(problems.isRotation("", ""));

        // Test cases for non-rotations
        assertFalse(problems.isRotation("waterbottle", "erbottlewaa"));
        assertFalse(problems.isRotation("abcde", "abced"));
        assertFalse(problems.isRotation("hello", "world"));

        // Test cases for different lengths
        assertFalse(problems.isRotation("abc", "abcd"));
        assertFalse(problems.isRotation("abcd", "abc"));
    }
}