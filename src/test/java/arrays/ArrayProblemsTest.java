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
}