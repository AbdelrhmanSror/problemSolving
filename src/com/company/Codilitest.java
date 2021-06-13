package com.company;

import java.sql.Array;
import java.util.HashMap;
import java.util.HashSet;

/**
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

/*

public class Codilitest {
    public static void main(String[] args) {
        int[] x = new int[5];
        x[0] = 1;
        x[1] = 1;
        x[2] = 3;
        */
/* x[3]=3;
         x[4]=3;*//*

        // System.out.println(solution(x,2));
        System.out.println(minParentheses(")()("));


    }

    static int minParentheses(String S) {

        int balance = 0;
        int result = 0;

        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == '(')
                balance += 1;
            else balance += -1;

            if (balance == -1) {
                result += 1;
                balance += 1;
            }
        }

        return balance + result;
    }

    public static boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] != 1 && A[n - 1] != K)
            return false;
        else
            return true;
    }
}
*/

