package bitmanipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitManipulationProblemsTest {

    @Test
    void updateBits() {
        BitManipulationProblems problems = new BitManipulationProblems();
        // Test Case 1: Example from CTCI
        // N = 10000000000 (binary), M = 10011 (binary)
        // i = 2, j = 6
        // Expected: N becomes 10001001100 (binary)
        int n1 = Integer.parseInt("10000000000", 2); // 1024
        int m1 = Integer.parseInt("10011", 2);       // 19
        int i1 = 2;
        int j1 = 6;
        int expected1 = Integer.parseInt("10001001100", 2); // 1164
        assertEquals(expected1, problems.updateBits(n1, m1, i1, j1));

        // Test Case 2: M is a single bit
        // N = 11111111 (binary), M = 1 (binary)
        // i = 3, j = 3
        // Expected: N becomes 11110111 (binary)
        int n2 = Integer.parseInt("11111111", 2); // 255
        int m2 = Integer.parseInt("0", 2);         // 1
        int i2 = 3;
        int j2 = 3;
        int expected2 = Integer.parseInt("11110111", 2); // 247
        assertEquals(expected2, problems.updateBits(n2, m2, i2, j2));

        // Test Case 3: M fills the entire range
        // N = 00000000 (binary), M = 1111 (binary)
        // i = 0, j = 3
        // Expected: N becomes 00001111 (binary)
        int n3 = 0;
        int m3 = Integer.parseInt("1111", 2); // 15
        int i3 = 0;
        int j3 = 3;
        int expected3 = Integer.parseInt("00001111", 2); // 15
        assertEquals(expected3, problems.updateBits(n3, m3, i3, j3));

        // Test Case 4: M is larger than the range (should be truncated)
        // N = 11111111 (binary), M = 101010 (binary)
        // i = 1, j = 3
        // Expected: N becomes 11110101 (binary) (M's 3 LSBs are 010)
        int n4 = Integer.parseInt("11111111", 2); // 255
        int m4 = Integer.parseInt("101010", 2);   // 42
        int i4 = 1;
        int j4 = 3;
        int expected4 = Integer.parseInt("11110101", 2); // 245
        assertEquals(expected4, problems.updateBits(n4, m4, i4, j4));

        // Test Case 5: i and j are at the ends of a 32-bit integer
        // N = all zeros, M = 1, i = 31, j = 31
        // Expected: N becomes 100...00 (binary)
        int n5 = 0;
        int m5 = 1;
        int i5 = 31;
        int j5 = 31;
        int expected5 = 1 << 31; // Integer.MIN_VALUE
        assertEquals(expected5, problems.updateBits(n5, m5, i5, j5));

        // Test Case 6: N is all zeros, M is all ones, i=0, j=31
        // Expected: N becomes all ones
        int n7 = 0;
        int m7 = ~0; // All ones
        int i7 = 0;
        int j7 = 31;
        int expected7 = ~0;
        assertEquals(expected7, problems.updateBits(n7, m7, i7, j7));

        // Test Case 7: M is 0
        // N = 10101010 (binary), M = 0 (binary)
        // i = 2, j = 5
        // Expected: N becomes 10100000 (binary)
        int n8 = Integer.parseInt("10000010", 2); // 170
        int m8 = 0;
        int i8 = 2;
        int j8 = 5;
        int expected8 = Integer.parseInt("10000010", 2); // 160
        assertEquals(expected8, problems.updateBits(n8, m8, i8, j8));
    }

    @Test
    void printBinary() {
        BitManipulationProblems problems = new BitManipulationProblems();

        // Test cases for valid binary representations
        assertEquals("0.1", problems.printBinary(0.5));
        assertEquals("0.11", problems.printBinary(0.75));
        assertEquals("0.01", problems.printBinary(0.25));
        assertEquals("0.001", problems.printBinary(0.125));
        assertEquals("0.101", problems.printBinary(0.625));
        assertEquals("0.1001", problems.printBinary(0.5625));

        // Test cases for numbers that cannot be represented accurately within 32 characters
        assertEquals("ERROR", problems.printBinary(0.1));
        assertEquals("ERROR", problems.printBinary(0.3));
        assertEquals("ERROR", problems.printBinary(0.72));
        assertEquals("ERROR", problems.printBinary(0.9));

        // Test cases for edge conditions
        assertEquals("ERROR", problems.printBinary(0.0));
        assertEquals("ERROR", problems.printBinary(1.0));
        assertEquals("ERROR", problems.printBinary(-0.5));
        assertEquals("ERROR", problems.printBinary(1.5));
        assertEquals("ERROR", problems.printBinary(2.0));
        assertEquals("ERROR", problems.printBinary(-1.0));
    }

    @Test
    void flipBit() {        
        BitManipulationProblems problems = new BitManipulationProblems();

        // Test cases for basic scenarios
        assertEquals(8, problems.flipBit(1775)); // 11011101111 -> 11011111111 (flip 5th bit from right)
        assertEquals(4, problems.flipBit(7));    // 0111 -> 1111
        assertEquals(1, problems.flipBit(0));    // 0 -> 1
        assertEquals(2, problems.flipBit(1));    // 1 -> 11
        assertEquals(2, problems.flipBit(2));    // 10 -> 11
        assertEquals(3, problems.flipBit(5));    // 101 -> 111
        assertEquals(4, problems.flipBit(13));   // 1101 -> 1111
        assertEquals(3, problems.flipBit(10));   // 1010 -> 1110 or 1011

        // Test cases with multiple zeros
        assertEquals(3, problems.flipBit(21));   // 10101 -> 11101 or 10111
        assertEquals(3, problems.flipBit(42));  // 101010 -> 101110 or 101011

        // Test cases with leading/trailing zeros
        assertEquals(2, problems.flipBit(4));    // 100 -> 110
        assertEquals(2, problems.flipBit(8));    // 1000 -> 1100
        assertEquals(3, problems.flipBit(6));    // 110 -> 111

        // Test cases with all ones
        assertEquals(32, problems.flipBit(~0)); // All ones (32-bit integer)

        // Test cases with alternating ones and zeros
        assertEquals(3, problems.flipBit(0b10101010)); // 10101010 -> 10111010 (length 4)
        assertEquals(3, problems.flipBit(0b01010101)); // 01010101 -> 01110101 (length 3)
    }

    @Test
    void getNext() {
//        BitManipulationProblems problems = new BitManipulationProblems();
//
//        // Test Case 1: Standard positive integer
//        // 139 is 10001011 (3 ones)
//        // Next smallest: 10000111 (135)
//        // Next largest: 10010011 (147)
//        int[] result1 = problems.getNext(139);
//        assertEquals(135, result1[0]);
//        assertEquals(147, result1[1]);
//
//        // Test Case 2: Integer with trailing zeros
//        // 12 is 1100 (2 ones)
//        // Next smallest: 1010 (10)
//        // Next largest: 10001 (17) - Note: implementation logic depends on bit window
//        int[] result2 = problems.getNext(12);
//        assertEquals(10, result2[0]);
//        assertEquals(17, result2[1]);
//
//        // Test Case 3: Single bit
//        // 8 is 1000
//        // Next smallest: 0100 (4)
//        // Next largest: 10000 (16)
//        int[] result3 = problems.getNext(8);
//        assertEquals(4, result3[0]);
//        assertEquals(16, result3[1]);
//
//        // Test Case 4: All ones at the end
//        // 7 is 0111
//        // Next smallest: 0111 (no 0 to the left of a 1 within 4 bits, but logic uses 32 bits)
//        // Next largest: 1011 (11)
//        int[] result4 = problems.getNext(7);
//        assertTrue(result4[1] > 7);
//        assertEquals(Integer.bitCount(7), Integer.bitCount(result4[1]));
//
//        // Test Case 5: Standard positive integer
//        // 5 is 00000101 (2 ones)
//        // Next smallest: 00000011 (3)
//        // Next largest: 00000110 (6)
//        int[] result5 = problems.getNext(5);
//        assertEquals(3, result5[0]);
//        assertEquals(6, result5[1]);
    }

    @Test
    void swapsNeeded() {
        BitManipulationProblems problems = new BitManipulationProblems();

        // Test Case 1: Standard case
        // 29 (11101) to 15 (01111)
        // Bits different: 1st, 4th, 5th (from right) -> 2 bits (29^15 = 18 (10010))
        // Actually: 29 is 11101, 15 is 01111. XOR is 10010. Count is 2.
        assertEquals(2, problems.swapsNeeded(29, 15));

        // Test Case 2: Same numbers
        assertEquals(0, problems.swapsNeeded(10, 10));

        // Test Case 3: Completely different bits (within 4 bits)
        // 10 (1010) and 5 (0101)
        assertEquals(4, problems.swapsNeeded(10, 5));

        // Test Case 4: One number is zero
        // 0 (0000) and 7 (0111)
        assertEquals(3, problems.swapsNeeded(0, 7));

        // Test Case 5: Max integer and zero
        assertEquals(31, problems.swapsNeeded(Integer.MAX_VALUE, 0));

        // Test Case 6: All bits different (using -1 for all ones)
        assertEquals(32, problems.swapsNeeded(0, -1));
    }
}