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
    void isUniqueBitVectorTests() {
        ArrayProblems problems = new ArrayProblems();

        // Test cases for unique strings
        assertTrue(problems.isUniqueBitVector("abcdefg"));
        assertTrue(problems.isUniqueBitVector("dhjeg"));
        assertTrue(problems.isUniqueBitVector("")); // Empty string is unique

        // Test cases for strings with duplicate characters
        assertFalse(problems.isUniqueBitVector("hello"));
        assertFalse(problems.isUniqueBitVector("apple"));
        assertFalse(problems.isUniqueBitVector("programming"));
        assertFalse(problems.isUniqueBitVector("aa"));
        assertFalse(problems.isUniqueBitVector("abacaba"));
    }

    @Test
    void isUniqueNoDsTests() {
        ArrayProblems problems = new ArrayProblems();

        // Test cases for unique strings
        assertTrue(problems.isUniqueNoDs("abcdefg"));
        assertTrue(problems.isUniqueNoDs("abcdeFg"));
        assertTrue(problems.isUniqueNoDs("12345"));
        assertTrue(problems.isUniqueNoDs("")); // Empty string is unique

        // Test cases for strings with duplicate characters
        assertFalse(problems.isUniqueNoDs("hello"));
        assertFalse(problems.isUniqueNoDs("apple"));
        assertFalse(problems.isUniqueNoDs("programming"));
        assertFalse(problems.isUniqueNoDs("aa"));
        assertFalse(problems.isUniqueNoDs("abacaba"));

        // Test with special characters and spaces
        assertTrue(problems.isUniqueNoDs("ab c"));
        assertFalse(problems.isUniqueNoDs("a b c a"));
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
}