package com.programapprentice.app;

/**
 * @author rjiang
 * @date 9/11/14
 */
/**
 * Divide two integers without using multiplication, division and mod operator.
 * */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == 0) {
            return 0;
        }
        if(dividend == divisor) {
            return 1;
        }
        if(dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        } else if (dividend != Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 0;
        } else if (dividend == Integer.MIN_VALUE) {
            if(divisor > 0) {
                return divide(dividend + divisor, divisor) - 1;
            } else {
                return divide(dividend - divisor, divisor) + 1;
            }
        }

        boolean isNegative = false;
        if(dividend > 0) {
            if(divisor < 0) {
                isNegative = true;
                divisor = 0 - divisor;
            }
        } else {
            dividend = 0 - dividend;
            if(divisor > 0) {
                isNegative = true;
            } else {
                divisor = 0 - divisor;
            }
        }
        if(isNegative) {
            return -1 * dividePositive(dividend, divisor);
        } else {
            return dividePositive(dividend, divisor);
        }
    }

    public int dividePositive(int dividend, int divisor) {
        if(dividend < divisor) {
            return 0;
        }
        if(divisor == 1) {
            return dividend;
        }
        if(divisor == 2) {
            return dividend >> 1;
        }
        int[] records = new int[128]; // save (divisor << i)
        int[] num = new int[128]; // save (2 ^ i)
        int tmp = divisor;
        int count = 0;
        int result = 0;
        num[0] = 1; // 2 ^ 0 = 1
        while(tmp <= dividend) {
            records[count] = tmp;
            dividend -= tmp;
            result += num[count];
            if(dividend < tmp) {
                break;
            }
            tmp = tmp << 1;
            count ++;
            num[count] = num[count-1] << 1;
        }

        for(int i = count-1; i >= 0; i--) {
            if(dividend >= records[i]) {
                result += num[i];
                dividend -= records[i];
            } else {
                continue;
            }
        }
        return result;
    }

//    public int dividePositive(int dividend, int divisor) {
//        if(dividend < divisor) {
//            return 0;
//        }
//        if(divisor == 1) {
//            return dividend;
//        }
//        int[] records = new int[128];
//        boolean[] isExist = new boolean[128];
//        int[] num = new int[128];
//        int tmp = divisor;
//        int count = 0;
//        int result = 0;
//        num[0] = 1;
//        while(tmp <= dividend) {
//            System.out.println(count);
//            records[count] = tmp;
//            tmp = tmp << 1;
//            if(count != 0) {
//                num[count] = num[count-1] << 1;
//            }
//            count ++;
//        }
//        for(int i = count; i >= 0; i--) {
//            if(dividend >= records[i]) {
//                result += num[i];
//                dividend -= records[i];
//            }
//        }
//        return result;
//    }
//
}
