package bitmanipulation;

public class BitManipulationProblems {

    /**
     * CTCI 5.1: Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and j.
     * Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N
     * located at i and ending at j)
     */
    public int updateBits(int n, int m, int i, int j) {
        // 1111 1111 << 5 = 1110 0000
        int left = ~0 << (j+1);
        // 0000 0001 << 2 = 0000 0100 - 1 = 0000 0011
        int right = (1 << i) - 1;
        // 1110 0011
        int mask = left | right;

        int nCleared = n & mask; // clear bits between i and j
        int mShifted = m << i; // shift m to starting bit at i postion
        return nCleared | mShifted; // combine both the bits
    }

    /**
     * CTCI 5.2: Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation. 
     * If the number cannot be represented accurately in binary with at most 32 characters (including the "."), print "ERROR".
     */
    public String printBinary(double number) {
        if (number >= 1 || number <= 0) return "ERROR";
        
        StringBuilder binary = new StringBuilder();
        binary.append("0.");

        while (number > 0) {
            if (binary.length() > 32) return "ERROR";

            double d = number * 2;
            if (d >= 1) {
                binary.append("1");
                number = d - 1;
            } else {
                binary.append(0);
                number = d;
            }
        }
        return binary.toString();
    }

    /**
     * CTCI 5.3: Flip bit: You have an integer, and you can flip exactly one bit from 0 to 1.
     * Write code to find the length of the longest sequence of 1s you could create. Example: 110 1110 1111 = 8
     */
    public int flipBit(int n) {
        if (~n == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;

        // iterate where the last bit is always the current bit
        while (n != 0) {
            // check if current bit is one
            if ((n & 1) == 1) currentLength++;
            // check if current bit is zero
            else if ((n & 1) == 0) {
                // if there are two zeros side by side, then previous length becomes zero
                previousLength = (n & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            // next iteration: move to the end
            n = n >>> 1;
        }
        return maxLength;
    }

}
